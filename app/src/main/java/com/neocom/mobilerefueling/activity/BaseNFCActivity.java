package com.neocom.mobilerefueling.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.util.Log;

/**
 * Created by admin on 2017/9/20.
 */

public abstract class BaseNFCActivity extends BaseActivity {

    private NfcAdapter mNfcAdapter;
    private PendingIntent mPendingIntent;

    @Override
    public void initContentView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

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

}
