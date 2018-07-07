package com.neocom.mobilerefueling;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lzy.widget.AlphaIndicator;
import com.neocom.mobilerefueling.activity.AddgetOilActivity;
import com.neocom.mobilerefueling.activity.BaseActivity;
import com.neocom.mobilerefueling.activity.BaseWithoutMapActivity;
import com.neocom.mobilerefueling.activity.ExampleActivity;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.MenuBean;
import com.neocom.mobilerefueling.fragment.DriverReceiveListFragment;
import com.neocom.mobilerefueling.fragment.HomeBujiUIFragment;
import com.neocom.mobilerefueling.fragment.HomeUIFragment;
import com.neocom.mobilerefueling.fragment.MeViFragment;
import com.neocom.mobilerefueling.fragment.MessageFragment;
import com.neocom.mobilerefueling.fragment.TiYouListFragmen;
import com.neocom.mobilerefueling.fragment.YunYouCheListFragment;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.services.ServiceUtil;
import com.neocom.mobilerefueling.services.UploadService;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.jpush.android.api.JPushInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 运油车
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    //    private List<ChangeColorIconWithText> mTabIndicators = new ArrayList<>();
    private List<Fragment> mFragments;
    private ViewPager viewPagerContent;

    private ContentFragmentAdapter mAdapter;
    private LinearLayout mTtitleBar;
    private TextView mainTitle;

    //声明一个long类型变量：用于存放上一点击“返回键”的时刻
    private long mExitTime;


    @Override
    public void initContentView() {
        setContentView(R.layout.activity_main);

        tempUI();
        Constant.MAIN_GROUND = true;

        startUpLocationServices();

    }

    private void startUpLocationServices() {
        ServiceUtil.startUpLocServices(MainActivity.this);
    }

    private void stopUpLocationServices() {

        ServiceUtil.stopUpLocServices(MainActivity.this);

    }

    private void tempUI() {


        if (mFragments == null || mFragments.size() == 0) {
            mFragments = new ArrayList<>();
        }

        AppCompatButton ordinaryUserBtn = (AppCompatButton) findViewById(R.id.ordinary_user);
//        AppCompatButton trasferUserBtn = (AppCompatButton) findViewById(R.id.transfer_user);
        AppCompatButton trasOilUserBtn = (AppCompatButton) findViewById(R.id.trans_oil_user);

        ordinaryUserBtn.setOnClickListener(this);
        ordinaryUserBtn.setClickable(false);
//        trasferUserBtn.setOnClickListener(this);
        trasOilUserBtn.setOnClickListener(this);


    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    public void initView() {
        viewPagerContent = (ViewPager) findViewById(R.id.viewpager_content);
        mAdapter = new ContentFragmentAdapter(getSupportFragmentManager());

        viewPagerContent.setAdapter(mAdapter);
        AlphaIndicator alphaIndicator = (AlphaIndicator) findViewById(R.id.alphaIndicator);
        alphaIndicator.setViewPager(viewPagerContent);
//        AlphaView one= (AlphaView) findViewById(R.id.indicator_one);
//        AlphaView two= (AlphaView) findViewById(R.id.indicator_two);
//        AlphaView three= (AlphaView) findViewById(R.id.indicator_three);
//        AlphaView four= (AlphaView) findViewById(R.id.indicator_four);
        mTtitleBar = (LinearLayout) findViewById(R.id.main_title_bar);
        mainTitle = mTtitleBar.findViewById(R.id.main_title);
//        ImmersionBar.with(this).titleBar(mTtitleBar).init();
        viewPagerContent.setOffscreenPageLimit(3);


//        ChangeColorIconWithText one = (ChangeColorIconWithText) findViewById(R.id.id_indicator_one);
//        mTabIndicators.add(one);
//        ChangeColorIconWithText two = (ChangeColorIconWithText) findViewById(R.id.id_indicator_two);
//        mTabIndicators.add(two);
//        ChangeColorIconWithText three = (ChangeColorIconWithText) findViewById(R.id.id_indicator_three);
//        mTabIndicators.add(three);
//        ChangeColorIconWithText four = (ChangeColorIconWithText) findViewById(R.id.id_indicator_four);
//        mTabIndicators.add(four);

//        mTabIndicators.add(one);
//        mTabIndicators.add(two);
//        mTabIndicators.add(three);
//        mTabIndicators.add(four);


//        one.setOnClickListener(this);
//        two.setOnClickListener(this);
//        three.setOnClickListener(this);
//        four.setOnClickListener(this);
        mTtitleBar.findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExampleActivity.class);

                startActivity(intent);


            }
        });

//
//        one.setIconAlpha(1.0f);

//        setMainTitle(0);

    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        super.onAttachFragment(fragment);

        Log.d(TAG, "onAttachFragment");
    }


    @Override
    public void initData() {

        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPush
        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
        if (userInfo != null) {
            JPushInterface.setAlias(UIUtils.getContext(), Constant.JPUSH_SEQUENCE, userInfo.getUserId());
        }

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.ordinary_user:

                break;

            case R.id.trans_oil_user:


                break;

        }
    }

    public class ContentFragmentAdapter extends FragmentPagerAdapter {


        public ContentFragmentAdapter(FragmentManager fm) {
            super(fm);

//            SPUtils.saveContent(Constant.CAR_TYPE,Constant.CAR_TYPE_BUJI);
            String content = SPUtils.getContent(Constant.CAR_TYPE);
            Log.i(TAG, "ContentFragmentAdapter: ==>" + content);
            if (TextUtils.isEmpty(content)) {
//                mFragments.add(new HomeUIFragment());
//                mFragments.add(new MessageFragment());
////                mFragments.add(new DriverReceiveListFragment());
////                mFragments.add(new YunYouCheListFragment());
//                mFragments.add(new MeViFragment());

                showJiaYouCheUI();

            } else {

                if (content.equals(Constant.CAR_TYPE_BUJI)) {

//                    mFragments.add(new HomeBujiUIFragment());
//                    mFragments.add(new MessageFragment());
////            mFragments.add(new GetOilListFragmen());
//                    mFragments.add(new TiYouListFragmen());
//
////            mFragments.add(new DriverReceiveListFragment());
////            补给记录列表
//                    mFragments.add(new YunYouCheListFragment());
////            mFragments.add(new GetOilListFragmen());
////            mFragments.add(new WorkSignFragment());
//                    mFragments.add(new MeViFragment());
//                    showBuJiCheUI();

                    showJiaYouCheUI();

                } else if (content.equals(Constant.CAR_TYPE_JIAYOU)) {

//                    mFragments.add(new HomeUIFragment());
//                    mFragments.add(new MessageFragment());
////                    mFragments.add(new DriverReceiveListFragment());
////                    mFragments.add(new YunYouCheListFragment());
//                    mFragments.add(new MeViFragment());

                    showJiaYouCheUI();

                }

            }

        }

        /**
         * 加油车 布局
         */
        public void showJiaYouCheUI() {

            mFragments.add(new HomeUIFragment());
            mFragments.add(new MessageFragment());
//                mFragments.add(new DriverReceiveListFragment());
//                mFragments.add(new YunYouCheListFragment());
            mFragments.add(new MeViFragment());

        }

        public void showBuJiCheUI() {

            mFragments.add(new HomeBujiUIFragment());
//            mFragments.add(new MessageFragment());
//          mFragments.add(new GetOilListFragmen());
//            mFragments.add(new TiYouListFragmen());
//            mFragments.add(new YunYouCheListFragment());
            mFragments.add(new MeViFragment());

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return String.valueOf(position);
        }

        @Override
        public Fragment getItem(int position) {
//            return FragmentFactory.createFragment(position);
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击了“返回键”
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //大于2000ms则认为是误操作，使用Toast进行提示
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
//                System.exit(0);
                JPushInterface.setAlias(UIUtils.getContext(), Constant.JPUSH_SEQUENCE, "");
                android.os.Process.killProcess(android.os.Process.myPid());
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //如果用以下这种做法则不保存状态，再次进来的话会显示默认的tab
        // super.onSaveInstanceState(outState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        JPushInterface.deleteAlias(UIUtils.getContext(), Constant.JPUSH_SEQUENCE);

        Constant.MAIN_GROUND = false;
        stopUpLocationServices();

    }

    boolean isFirstOpen = true;

    @Override
    public void onResume() {
        super.onResume();

        if (isFirstOpen) {
            readNfcTag(getIntent());
            isFirstOpen = false;
        }

    }

    @Override
    public void onNewIntent(Intent intent) {
        //1.获取Tag对象
        Tag detectedTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        //2.获取Ndef的实例

        if (detectedTag != null) {
            Ndef ndef = Ndef.get(detectedTag);
//        mTagText = ndef.getType() + "\nmaxsize:" + ndef.getMaxSize() + "bytes\n\n";

//            Toast.makeText(this, "==onNewIntent>>" + ndef.getType() + "\nmaxsize:" + ndef.getMaxSize() + "bytes\n\n", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "onNewIntent: ==>>>" + ndef.getType() + "\nmaxsize:" + ndef.getMaxSize() + "bytes\n\n");
            readNfcTag(intent);
//        mNfcText.setText(mTagText);
        }
    }

    /**
     * 读取NFC标签文本数据
     */
    private void readNfcTag(Intent intent) {
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
                    NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage msgs[] = null;
            int contentSize = 0;
            if (rawMsgs != null) {
                msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                    contentSize += msgs[i].toByteArray().length;
                }
            }
            try {
                if (msgs != null) {
                    NdefRecord record = msgs[0].getRecords()[0];
                    String textRecord = parseTextRecord(record);
//                    mTagText += textRecord + "\n\ntext\n" + contentSize + " bytes";
//                    Toast.makeText(this, "==>" + textRecord + "\n\ntext\n" + contentSize + " bytes", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "readNfcTag: " + textRecord + "\n\ntext\n" + contentSize + " bytes");

                    if (TextUtils.isEmpty(textRecord)) {
                        Toast.makeText(this, "读取数据错误，请重新扫描标签", Toast.LENGTH_SHORT).show();
                    } else {

                        if (Constant.MAIN_GROUND) {
                            Intent intetJump = new Intent(UIUtils.getContext(), AddgetOilActivity.class);
                            intetJump.putExtra("nfcdata", textRecord);
                            startActivity(intetJump);

                        }

                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * 解析NDEF文本数据，从第三个字节开始，后面的文本数据
     *
     * @param ndefRecord
     * @return
     */
    public static String parseTextRecord(NdefRecord ndefRecord) {
        /**
         * 判断数据是否为NDEF格式
         */
        //判断TNF
        if (ndefRecord.getTnf() != NdefRecord.TNF_WELL_KNOWN) {
            return null;
        }
        //判断可变的长度的类型
        if (!Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
            return null;
        }
        try {
            //获得字节数组，然后进行分析
            byte[] payload = ndefRecord.getPayload();
            //下面开始NDEF文本数据第一个字节，状态字节
            //判断文本是基于UTF-8还是UTF-16的，取第一个字节"位与"上16进制的80，16进制的80也就是最高位是1，
            //其他位都是0，所以进行"位与"运算后就会保留最高位
            String textEncoding = ((payload[0] & 0x80) == 0) ? "UTF-8" : "UTF-16";
            //3f最高两位是0，第六位是1，所以进行"位与"运算后获得第六位
            int languageCodeLength = payload[0] & 0x3f;
            //下面开始NDEF文本数据第二个字节，语言编码
            //获得语言编码
            String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
            //下面开始NDEF文本数据后面的字节，解析出文本
            String textRecord = new String(payload, languageCodeLength + 1,
                    payload.length - languageCodeLength - 1, textEncoding);
            return textRecord;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }


}
