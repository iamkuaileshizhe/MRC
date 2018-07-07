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

import com.gyf.barlibrary.ImmersionBar;
import com.lzy.widget.AlphaIndicator;
import com.neocom.mobilerefueling.activity.AddgetOilActivity;
import com.neocom.mobilerefueling.activity.BaseActivity;
import com.neocom.mobilerefueling.activity.BaseWithoutMapActivity;
import com.neocom.mobilerefueling.fragment.HomeBujiUIFragment;
import com.neocom.mobilerefueling.fragment.MeViFragment;
import com.neocom.mobilerefueling.fragment.TiYouListFragmen;
import com.neocom.mobilerefueling.fragment.YunYouCheListFragment;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.jpush.android.api.JPushInterface;


//BaseWithoutMapActivity  补给车 主界面
public class MainTransActivity extends BaseActivity implements View.OnClickListener {

    //    private List<ChangeColorIconWithText> mTabIndicators = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();


    private ViewPager viewPagerContent;

    private ContentFragmentAdapter mAdapter;
    private LinearLayout mTtitleBar;
    private TextView mainTitle;

    /**
     * 初始化所有事件
     */
    private void initEvent() {

//        viewPagerContent.setOnPageChangeListener(this);

    }

    @Override
    public void initContentView() {
        setContentView(R.layout.activity__trans_main);
        Constant.MAINTRANS_GROUND = true;
        tempUI();

    }

    private void tempUI() {

        AppCompatButton ordinaryUserBtn = (AppCompatButton) findViewById(R.id.ordinary_user);
        AppCompatButton trasferUserBtn = (AppCompatButton) findViewById(R.id.transfer_user);
        AppCompatButton trasOilUserBtn = (AppCompatButton) findViewById(R.id.trans_oil_user);
        AppCompatButton addGetOil = (AppCompatButton) findViewById(R.id.add_get_oil);

        ordinaryUserBtn.setOnClickListener(this);
        trasferUserBtn.setClickable(false);
//        trasferUserBtn.setOnClickListener(this);
        trasOilUserBtn.setOnClickListener(this);
        addGetOil.setOnClickListener(this);
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


        initEvent();
//        requestAPPUpdate();
    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        super.onAttachFragment(fragment);

        Log.d(TAG, "onAttachFragment");
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.ordinary_user:

                startActivity(new Intent(UIUtils.getContext(), MainActivity.class));
                finish();
                break;


            case R.id.add_get_oil:

                Intent intent = new Intent(UIUtils.getContext(), AddgetOilActivity.class);
                startActivity(intent);

                break;


        }


    }


    public class ContentFragmentAdapter extends FragmentPagerAdapter {


        public ContentFragmentAdapter(FragmentManager fm) {
            super(fm);

            mFragments.add(new HomeBujiUIFragment());
//            mFragments.add(new GetOilListFragmen());
            mFragments.add(new TiYouListFragmen());

//            mFragments.add(new DriverReceiveListFragment());
//            补给记录列表
            mFragments.add(new YunYouCheListFragment());
//            mFragments.add(new GetOilListFragmen());
//            mFragments.add(new WorkSignFragment());
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


    public void setOnShowAddressListener(OnShowAddressListener addressListener) {

        this.addressListener = addressListener;
    }


    public interface OnShowAddressListener {

        public boolean showAddress();

    }

    private OnShowAddressListener addressListener;


    //声明一个long类型变量：用于存放上一点击“返回键”的时刻
    private long mExitTime;

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
                JPushInterface.setAlias(UIUtils.getContext(), Constant.JPUSH_SEQUENCE, "");
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
                android.os.Process.killProcess(android.os.Process.myPid());
//                System.exit(0);
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
    protected void onStart() {
        super.onStart();
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
    protected void onDestroy() {
        super.onDestroy();
        Constant.MAINTRANS_GROUND = false;
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

                        if (Constant.MAINTRANS_GROUND) {
                            Intent intetJump = new Intent(UIUtils.getContext(), AddgetOilActivity.class);
                            intetJump.putExtra("nfcdata", textRecord);
                            startActivity(intetJump);
                        } else {
                            Log.i(TAG, "readNfcTag: 不是 maintrans 不 跳转");
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
