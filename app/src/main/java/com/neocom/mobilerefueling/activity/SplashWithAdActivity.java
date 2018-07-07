package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.UIUtils;

import butterknife.BindView;

/**
 * Created by admin on 2017/12/22.
 */

public class SplashWithAdActivity extends AppCompatActivity {
    private static final String TAG = "SplashWithAdActivity";

    private MyCountDownTimer mCountDownTimer;

    private TextView startSkipCountDown;
    private FrameLayout startSkip;


    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);

            if (msg.what == 0) {
                Log.i(TAG, "handleMessage: 00000 ");
                startActivity(new Intent(UIUtils.getContext(), APPLoginActivity.class));
                finish();
            }


        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init();
//        ImmersionBar.with(this).fitsSystemWindows(true).fullScreen(true).statusBarColor(R.color.col_login_immersion).init();
        setContentView(R.layout.sp_ads_layout);

        startSkipCountDown = (TextView) findViewById(R.id.start_skip_count_down);
        startSkip = (FrameLayout) findViewById(R.id.start_skip);

        initView();

    }


    public void initView() {

        startSkipCountDown.setText("3s 跳过");
        //创建倒计时类
        mCountDownTimer = new MyCountDownTimer(3000, 1000);
        mCountDownTimer.start();
        //这是一个 Handler 里面的逻辑是从 Splash 界面跳转到 Main 界面，这里的逻辑每个公司基本上一致
//        handler.postDelayed(runnable, 3000);
//        handler.sendEmptyMessageDelayed(0, 3000);


        startSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(UIUtils.getContext(), APPLoginActivity.class));

                if (mCountDownTimer != null) {
                    mCountDownTimer.cancel();
                }

                finish();
            }
        });

    }

    class MyCountDownTimer extends CountDownTimer {
        /**
         * @param millisInFuture    表示以「 毫秒 」为单位倒计时的总数
         *                          例如 millisInFuture = 1000 表示1秒
         * @param countDownInterval 表示 间隔 多少微秒 调用一次 onTick()
         *                          例如: countDownInterval = 1000 ; 表示每 1000 毫秒调用一次 onTick()
         */

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }


        public void onFinish() {
            startSkipCountDown.setText("0s 跳过");
            handler.sendEmptyMessage(0);
        }

        public void onTick(long millisUntilFinished) {
            startSkipCountDown.setText(millisUntilFinished / 1000 + "s 跳过");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
        ImmersionBar.with(this).destroy();
    }
}
