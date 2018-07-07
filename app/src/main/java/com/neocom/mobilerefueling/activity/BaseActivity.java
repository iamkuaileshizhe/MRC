package com.neocom.mobilerefueling.activity;

import android.Manifest;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.sunflower.FlowerCollector;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.TipsInfo;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.WeiboDialogUtils;
import com.neocom.mobilerefueling.xunfei.TtsDemo;
import com.neocom.mobilerefueling.xunfei.TtsSettings;

import butterknife.ButterKnife;
import me.leefeng.promptlibrary.OnAdClickListener;
import me.leefeng.promptlibrary.PromptDialog;

/**
 * Created by admin_xyz on 2017/7/20.
 * 创建人：xyz
 * 创建日期:2017/7/20
 * 描述: Activity 基类
 */

/**
 * 1.子类需要在onCreate方法中做Activity初始化。
 * 2.子类需要在onNewIntent方法中进行NFC标签相关操作。
 * 当launchMode设置为singleTop时，第一次运行调用onCreate方法，
 * 第二次运行将不会创建新的Activity实例，将调用onNewIntent方法
 * 所以我们获取intent传递过来的Tag数据操作放在onNewIntent方法中执行
 * 如果在栈中已经有该Activity的实例，就重用该实例(会调用实例的onNewIntent())
 * 只要NFC标签靠近就执行
 */

public abstract class BaseActivity extends AppCompatActivity {
    //    private boolean flag = false;

//    protected ProgressDialog baseDialog;

//    private long exitTime = 0;
//

    private NfcAdapter mNfcAdapter;
    private PendingIntent mPendingIntent;
    private Dialog loadingDialog;
    public static Handler mHandler;

    /***********************语音合成***************************************/
    // 语音合成对象
    private SpeechSynthesizer mTts;
    // 默认发音人
    private String voicer = "xiaoyan";

    // 缓冲进度
    private int mPercentForBuffering = 0;
    // 播放进度
    private int mPercentForPlaying = 0;
    private SharedPreferences mSharedPreferences;
    // 引擎类型
    private String mEngineType;


    /**************************************************************/

    /**
     * 初始化布局
     */
    public abstract void initContentView();
//

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    protected static final String TAG = BaseActivity.class.getSimpleName();


    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(android.R.color.white).statusBarDarkFont(true, 0.2f).init();
        initContentView();
        ButterKnife.bind(this);
        initData();
        initView();
        requestPermissions();

        initTTS();
        initHandler();
    }

    protected void showShortToast(String message) {
        if (!TextUtils.isEmpty(message))
            Toast.makeText(this,
                    message, Toast.LENGTH_SHORT).show();
    }

    private void initTTS() {
        // 初始化合成对象
        mTts = SpeechSynthesizer.createSynthesizer(BaseActivity.this, mTtsInitListener);
        mSharedPreferences = getSharedPreferences(TtsSettings.PREFER_NAME, MODE_PRIVATE);
        mEngineType = SpeechConstant.TYPE_CLOUD;
    }


    private void initHandler() {

        mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    String dataText = (String) msg.obj;
                    Log.i(TAG, "handleMessage: data传值==" + dataText);

                    boolean ttsState = SPUtils.getTTSState();

                    if (ttsState) {
                        TextToSpeach(dataText);
                    }

                }

            }
        };


    }

    private void TextToSpeach(String dataText) {

// 移动数据分析，收集开始合成事件
        FlowerCollector.onEvent(BaseActivity.this, "tts_play");
        setParam();
        mTts.startSpeaking(dataText, mTtsListener);


    }


    /**
     * 合成回调监听。
     */
    private SynthesizerListener mTtsListener = new SynthesizerListener() {

        @Override
        public void onSpeakBegin() {
            Log.i(TAG, "onSpeakBegin: 开始播放");
        }

        @Override
        public void onSpeakPaused() {
            Log.i(TAG, "onSpeakPaused: 暂停播放");
        }

        @Override
        public void onSpeakResumed() {
            Log.i(TAG, "onSpeakResumed: 继续播放");
        }

        @Override
        public void onBufferProgress(int percent, int beginPos, int endPos,
                                     String info) {
            // 合成进度
            mPercentForBuffering = percent;
            Log.i(TAG, "onBufferProgress: " + String.format(getString(R.string.tts_toast_format),
                    mPercentForBuffering, mPercentForPlaying));
        }

        @Override
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
            // 播放进度
            mPercentForPlaying = percent;
            Log.i(TAG, "onSpeakProgress: " + String.format(getString(R.string.tts_toast_format),
                    mPercentForBuffering, mPercentForPlaying));
        }

        @Override
        public void onCompleted(SpeechError error) {
            if (error == null) {
                Log.i(TAG, "onCompleted: 播放完成");
            } else if (error != null) {
                Log.i(TAG, "onCompleted: " + error.getPlainDescription(true));
            }
        }

        @Override
        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
            // 若使用本地能力，会话id为null
            //	if (SpeechEvent.EVENT_SESSION_ID == eventType) {
            //		String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
            //		Log.d(TAG, "session id =" + sid);
            //	}
        }
    };


    /**
     * 初始化监听。
     */
    private InitListener mTtsInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            Log.d(TAG, "InitListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                Log.i(TAG, "初始化失败,错误码：" + code);
            } else {
                // 初始化成功，之后可以调用startSpeaking方法
                // 注：有的开发者在onCreate方法中创建完合成对象之后马上就调用startSpeaking进行合成，
                // 正确的做法是将onCreate中的startSpeaking调用移至这里
            }
        }
    };


    /**
     * 参数设置
     *
     * @return
     */
    private void setParam() {
        // 清空参数
        mTts.setParameter(SpeechConstant.PARAMS, null);
        // 根据合成引擎设置相应参数
        if (mEngineType.equals(SpeechConstant.TYPE_CLOUD)) {
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
            // 设置在线合成发音人
            mTts.setParameter(SpeechConstant.VOICE_NAME, voicer);
            //设置合成语速
            mTts.setParameter(SpeechConstant.SPEED, mSharedPreferences.getString("speed_preference", "50"));
            //设置合成音调
            mTts.setParameter(SpeechConstant.PITCH, mSharedPreferences.getString("pitch_preference", "50"));
            //设置合成音量
            mTts.setParameter(SpeechConstant.VOLUME, mSharedPreferences.getString("volume_preference", "50"));
        } else {
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
            // 设置本地合成发音人 voicer为空，默认通过语记界面指定发音人。
            mTts.setParameter(SpeechConstant.VOICE_NAME, "");
            /**
             * TODO 本地合成不设置语速、音调、音量，默认使用语记设置
             * 开发者如需自定义参数，请参考在线合成参数设置
             */
        }
        //设置播放器音频流类型
        mTts.setParameter(SpeechConstant.STREAM_TYPE, mSharedPreferences.getString("stream_preference", "3"));
        // 设置播放合成音频打断音乐播放，默认为true
        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/msc/tts.wav");
    }

    /**
     * 启动Activity，界面可见时
     */
    @Override
    protected void onStart() {
        super.onStart();
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        //一旦截获NFC消息，就会通过PendingIntent调用窗口
        Log.i(TAG, "onStart: 一旦截获NFC消息，就会通过PendingIntent调用窗口");
        mPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()), 0);

    }

    /**
     * 获得焦点，按钮可以点击
     */
    @Override
    public void onResume() {
        super.onResume();
        //设置处理优于所有其他NFC的处理
        Log.i(TAG, "onResume: 设置处理优于所有其他NFC的处理");
        if (mNfcAdapter != null)
            mNfcAdapter.enableForegroundDispatch(this, mPendingIntent, null, null);
    }

    /**
     * 暂停Activity，界面获取焦点，按钮可以点击
     */
    @Override
    public void onPause() {
        super.onPause();
        //恢复默认状态
        Log.i(TAG, "onPause: 恢复默认状态");
        if (mNfcAdapter != null)
            mNfcAdapter.disableForegroundDispatch(this);
    }

    public void showLoadingDialog(String msg) {

        if (TextUtils.isEmpty(msg)) {
            msg = "";
        }
        loadingDialog = WeiboDialogUtils.createLoadingDialog(this, msg);
    }

    public void disDialog() {

        if (loadingDialog != null) {
            WeiboDialogUtils.closeDialog(loadingDialog);
        }
    }

    public void showInfoTip(String msg) {

        TipsInfo.getInstance(this).showInfoTip(msg);

    }

    public void showWarnTip(String msg) {

        TipsInfo.getInstance(this).showWarnTip(msg);

    }


    public void showFailTip() {
        TipsInfo.getInstance(this).showErrorTip("网络异常或数据");
    }


    private PromptDialog promptDialog;

    public void showPopTip() {

        if (promptDialog == null) {
            //创建对象
            promptDialog = new PromptDialog(this);
            //设置自定义属性
            promptDialog.getDefaultBuilder().touchAble(true).round(3).loadingDuration(3000);
        }

        promptDialog.getDefaultBuilder().backAlpha(150);
        Glide.with(UIUtils.getContext()).load("https://timgsa.baidu.com/timg?image&quality=80&" +
                "size=b9999_10000&sec=1495518782659&di=25b120262114749ae8543652d2de5715&" +
                "imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2Fallimg%2F160316%2F9-160316152R5.jpg")
//                        .placeholder(getResources().getDrawable(R.drawable.ic_prompt_holder))
                .into(promptDialog.showAd(true, new OnAdClickListener() {
                    @Override
                    public void onAdClick() {
                        Toast.makeText(UIUtils.getContext(), "点击了广告", Toast.LENGTH_SHORT).show();
                    }
                }));


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(mReceiver);
        //取消注册事件
        ImmersionBar.with(this).destroy();
    }


    private void requestPermissions() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                int permission = ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.LOCATION_HARDWARE, Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.WRITE_SETTINGS, Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_CONTACTS}, 0x0010);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
