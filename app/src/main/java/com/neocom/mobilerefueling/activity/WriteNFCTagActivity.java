package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.ShowDirAdapter;
import com.neocom.mobilerefueling.bean.WriteNFCTagBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.LicenseKeyboardUtil;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.Arrays;

/**
 * Created by admin on 2017/11/3.
 */

public class WriteNFCTagActivity extends BaseActivity implements View.OnClickListener {

    TextView inputbox1;

    TextView inputbox2;

    TextView inputbox3;

    TextView inputbox4;

    TextView inputbox5;

    TextView inputbox6;

    TextView inputbox7;


    LinearLayout boxesContainer;

    LicenseKeyboardUtil keyboardUtil;

    KeyboardView keyboard_view;

    private TextView carType;
    private TextView writeContent;


    WriteNFCTagBean writeNFCTagBean = new WriteNFCTagBean();

    @Override
    public void initContentView() {
        setContentView(R.layout.write_nfc_layout);
    }

    @Override
    public void initView() {
        inputbox1 = (TextView) findViewById(R.id.et_car_license_inputbox1);
        inputbox2 = (TextView) findViewById(R.id.et_car_license_inputbox2);
        inputbox3 = (TextView) findViewById(R.id.et_car_license_inputbox3);
        inputbox4 = (TextView) findViewById(R.id.et_car_license_inputbox4);
        inputbox5 = (TextView) findViewById(R.id.et_car_license_inputbox5);
        inputbox6 = (TextView) findViewById(R.id.et_car_license_inputbox6);
        inputbox7 = (TextView) findViewById(R.id.et_car_license_inputbox7);

        carType = (TextView) findViewById(R.id.car_type);
        writeContent = (TextView) findViewById(R.id.write_content);
        carType.setOnClickListener(this);
        boxesContainer = (LinearLayout) findViewById(R.id.ll_car_license_inputbox_content);
        keyboard_view = (KeyboardView) findViewById(R.id.keyboard_view);
//        boxesContainer.setVisibility(View.VISIBLE);
        keyboardUtil = new LicenseKeyboardUtil(keyboard_view, boxesContainer, this, new TextView[]{inputbox1, inputbox2, inputbox3,
                inputbox4, inputbox5, inputbox6, inputbox7});
        keyboardUtil.showKeyboard();

        keyboardUtil.setOnGetCarNumListener(new LicenseKeyboardUtil.OnGetCarNumListener() {
            @Override
            public void getCarNum(String carNum) {
//                Toast.makeText(WriteNFCTagActivity.this, "车牌号==>:" + carNum, Toast.LENGTH_SHORT).show();
                writeNFCTagBean.setCarnum(carNum);

                writeToNFCTag();

            }
        });

        findViewById(R.id.top_bar_finish_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void writeToNFCTag() {

        if (TextUtils.isEmpty(writeNFCTagBean.getCartype())) {
            Toast.makeText(this, "请选择车辆类型", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(writeNFCTagBean.getCarnum())) {
            Toast.makeText(this, "请输入车牌号", Toast.LENGTH_SHORT).show();
            return;
        }
        writeNFCTagBean.setWriter(GetUserInfoUtils.getUserInfo().getUserId());

        Gson gson = new Gson();
        String content = gson.toJson(writeNFCTagBean);

        Intent intent = new Intent(UIUtils.getContext(), WriteInNFCActivity.class);
        intent.putExtra("nfcdata", content);
        startActivity(intent);

////获取Tag对象
//        Tag detectedTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
//        NdefMessage ndefMessage = new NdefMessage(
//                new NdefRecord[]{createTextRecord(content)});
//        boolean result = writeTag(ndefMessage, detectedTag);
//        if (result) {
//            Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "写入失败", Toast.LENGTH_SHORT).show();
//        }

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.car_type:
                showPopItem();
                break;

        }

    }

    private String constellations[] = {"普通用户", "加油车", "补给车"};
    private PopupWindow popLeft;
    private View layoutLeft;
    private ListView menulistLeft;

    private void showPopItem() {

        if (popLeft != null && popLeft.isShowing()) {
            popLeft.dismiss();
        } else {


            layoutLeft = View.inflate(WriteNFCTagActivity.this, R.layout.pop_menulist, null);

            menulistLeft = (ListView) layoutLeft
                    .findViewById(R.id.menulist);

            final ShowDirAdapter dirAdapter = new ShowDirAdapter(WriteNFCTagActivity.this, Arrays.asList(constellations));

            menulistLeft.setAdapter(dirAdapter);

            menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String item = dirAdapter.getItem(i);

                    carType.setText(item.toString());
                    writeNFCTagBean.setCartype(item.toString());
                    popLeft.dismiss();

                }
            });


            // 创建弹出窗口
            // 窗口内容为layoutLeft，里面包含一个ListView
            // 窗口宽度跟tvLeft一样
            popLeft = new PopupWindow(layoutLeft, carType.getWidth(),
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            ColorDrawable cd = new ColorDrawable(Color.BLACK);
            popLeft.setBackgroundDrawable(cd);
            popLeft.setAnimationStyle(R.style.PopupAnimation);
            popLeft.update();
            popLeft.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
            popLeft.setTouchable(true); // 设置popupwindow可点击
            popLeft.setOutsideTouchable(true); // 设置popupwindow外部可点击
            popLeft.setFocusable(true); // 获取焦点

            // 设置popupwindow的位置（相对tvLeft的位置）
            int topBarHeight = carType.getBottom();
            popLeft.showAsDropDown(carType, 0,
                    (topBarHeight - carType.getHeight()) / 2);

            popLeft.setTouchInterceptor(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // 如果点击了popupwindow的外部，popupwindow也会消失
                    if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                        popLeft.dismiss();
                        return true;
                    }
                    return false;
                }
            });


        }

    }

//    /**
//     * 创建NDEF文本数据
//     *
//     * @param text
//     * @return
//     */
//    public static NdefRecord createTextRecord(String text) {
//        byte[] langBytes = Locale.CHINA.getLanguage().getBytes(Charset.forName("US-ASCII"));
//        Charset utfEncoding = Charset.forName("UTF-8");
//        //将文本转换为UTF-8格式
//        byte[] textBytes = text.getBytes(utfEncoding);
//        //设置状态字节编码最高位数为0
//        int utfBit = 0;
//        //定义状态字节
//        char status = (char) (utfBit + langBytes.length);
//        byte[] data = new byte[1 + langBytes.length + textBytes.length];
//        //设置第一个状态字节，先将状态码转换成字节
//        data[0] = (byte) status;
//        //设置语言编码，使用数组拷贝方法，从0开始拷贝到data中，拷贝到data的1到langBytes.length的位置
//        System.arraycopy(langBytes, 0, data, 1, langBytes.length);
//        //设置文本字节，使用数组拷贝方法，从0开始拷贝到data中，拷贝到data的1 + langBytes.length
//        //到textBytes.length的位置
//        System.arraycopy(textBytes, 0, data, 1 + langBytes.length, textBytes.length);
//        //通过字节传入NdefRecord对象
//        //NdefRecord.RTD_TEXT：传入类型 读写
//        NdefRecord ndefRecord = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,
//                NdefRecord.RTD_TEXT, new byte[0], data);
//        return ndefRecord;
//    }
//
//    /**
//     * 写数据
//     *
//     * @param ndefMessage 创建好的NDEF文本数据
//     * @param tag         标签
//     * @return
//     */
//    public static boolean writeTag(NdefMessage ndefMessage, Tag tag) {
//        try {
//            Ndef ndef = Ndef.get(tag);
//            ndef.connect();
//            ndef.writeNdefMessage(ndefMessage);
//            return true;
//        } catch (Exception e) {
//        }
//        return false;
//    }


}
