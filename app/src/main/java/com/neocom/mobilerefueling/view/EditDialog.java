package com.neocom.mobilerefueling.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;


public class EditDialog extends Dialog implements View.OnClickListener {

    private View mView;
    private Context mContext;

    private LinearLayout mBgLl;
    private TextView mTitleTv;
    private EditText mMsgEt;
    private Button mNegBtn;
    private Button mPosBtn;
    private TextView remainText;

    public EditDialog(Context context) {
        this(context, 0, null);
    }

    public EditDialog(Context context, int theme, View contentView) {
        super(context, theme == 0 ? R.style.MyDialogStyle : theme);

        this.mView = contentView;
        this.mContext = context;

        if (mView == null) {
            mView = View.inflate(mContext, R.layout.view_enter_edit, null);
        }

        init();
        initView();
        initData();
        initListener();

    }

    private void init() {
        this.setContentView(mView);
    }

    private void initView() {
        mBgLl = (LinearLayout) mView.findViewById(R.id.lLayout_bg);
        mTitleTv = (TextView) mView.findViewById(R.id.txt_title);
        mMsgEt = (EditText) mView.findViewById(R.id.note_info);
        mNegBtn = (Button) mView.findViewById(R.id.btn_neg);
        mPosBtn = (Button) mView.findViewById(R.id.btn_pos);

        remainText = mView.findViewById(R.id.remain_text);

        mMsgEt.addTextChangedListener(textWatcher);
        remainText.setText("剩余" + 100 + "字");

    }

    private void initData() {
        //设置背景是屏幕的0.85
        mBgLl.setLayoutParams(new FrameLayout.LayoutParams((int) (getMobileWidth(mContext) * 0.85), LayoutParams.WRAP_CONTENT));
        //设置默认为10000
        mMsgEt.setHint("请输入调度原因");
    }

    private void initListener() {
        mNegBtn.setOnClickListener(this);
        mPosBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_neg:    //取消,
                if (onPosNegClickListener != null) {
                    String mEtValue = mMsgEt.getHint().toString().trim();
                    if (!mEtValue.isEmpty()) {
                        onPosNegClickListener.negCliclListener(mEtValue);
                    }
                }

                this.dismiss();
                break;

            case R.id.btn_pos:    //确认

                String mEtValue = mMsgEt.getText().toString();
                if (mEtValue.isEmpty()) {
//					if (mEtValue.length() > 8 || mEtValue.length() < 4 || Integer.parseInt(mEtValue) <= 0) {
//						//TODO 这里处理条件
//					}

                    Toast.makeText(mContext, "请输入调度原因", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (onPosNegClickListener != null) {
                        onPosNegClickListener.posClickListener(mEtValue);
                    }
                    this.dismiss();
                }

                break;
        }
    }


    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            remainText.setText("剩余" + (100 - s.length()) + "字");
        }
    };


    private OnPosNegClickListener onPosNegClickListener;

    public void setOnPosNegClickListener(OnPosNegClickListener onPosNegClickListener) {
        this.onPosNegClickListener = onPosNegClickListener;
    }

    public interface OnPosNegClickListener {
        void posClickListener(String value);

        void negCliclListener(String value);
    }


    /**
     * 工具类
     *
     * @param context
     * @return
     */
    public static int getMobileWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels; // 得到宽度
        return width;
    }
}
