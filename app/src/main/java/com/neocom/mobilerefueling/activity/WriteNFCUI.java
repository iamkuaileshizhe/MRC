package com.neocom.mobilerefueling.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.ShowDirAdapter;
import com.neocom.mobilerefueling.bean.WriteNFCTagBean;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.parkingwang.vehiclekeyboard.core.KeyboardType;
import com.parkingwang.vehiclekeyboard.support.PopupKeyboard;
import com.parkingwang.vehiclekeyboard.view.InputView;

import java.util.Arrays;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;


/**
 * Created by admin on 2018/1/5.
 */

public class WriteNFCUI extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
    @BindView(R.id.input_view)
    InputView mInputView;
    @BindView(R.id.car_type)
    TextView carType;
    @BindView(R.id.start_write)
    Button startWrite;
    @BindView(R.id.activity_pre_order)
    LinearLayout activityPreOrder;
    private PopupKeyboard mPopupKeyboard;

    WriteNFCTagBean writeNFCTagBean;
    private String constellations[] = {"普通用户", "加油车", "补给车"};
    private PopupWindow popLeft;
    private View layoutLeft;
    private ListView menulistLeft;

    @Override
    public void initContentView() {
        setContentView(R.layout.write_nfc_new_layout);


    }

    @Override
    public void initView() {

        // 创建弹出键盘
        mPopupKeyboard = new PopupKeyboard(this);
        // 弹出键盘内部包含一个KeyboardView，在此绑定输入两者关联。
        mPopupKeyboard.attach(mInputView, this);
        mPopupKeyboard.getKeyboardView()
                .setKeyboardType(KeyboardType.FULL);

        writeNFCTagBean = new WriteNFCTagBean();

        topBarFinishLl.setOnClickListener(this);
        startWrite.setOnClickListener(this);
        carType.setOnClickListener(this);


    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.top_bar_finish_ll:
                shoeAndHideKetBoard();
                finish();
                break;

            case R.id.car_type:
                showPopItem();
                break;

            case R.id.start_write:
                NfcManager manager = (NfcManager) WriteNFCUI.this.getSystemService(Context.NFC_SERVICE);
                NfcAdapter defaultAdapter = manager.getDefaultAdapter();

                if (defaultAdapter != null && defaultAdapter.isEnabled()) {

                    String carNum = mInputView.getNumber();
                    boolean completed = mInputView.isCompleted();

                    if (completed) {

                        writeToNFCTag(carNum);
                        shoeAndHideKetBoard();
                    } else {
                        Toasty.info(WriteNFCUI.this, "请输入正确车牌号", Toast.LENGTH_SHORT, true).show();
                        return;
                    }

                } else {

                    Toast.makeText(this, "请先开启NFC功能", Toast.LENGTH_SHORT).show();
                }


                break;
        }


    }


    public void shoeAndHideKetBoard() {

        if (mPopupKeyboard.isShown()) {
            mPopupKeyboard.dismiss(WriteNFCUI.this);
        } else {
            mPopupKeyboard.show(WriteNFCUI.this);
        }

    }


    private void showPopItem() {

        if (popLeft != null && popLeft.isShowing()) {
            popLeft.dismiss();
        } else {


            layoutLeft = View.inflate(WriteNFCUI.this, R.layout.pop_menulist, null);

            menulistLeft = (ListView) layoutLeft
                    .findViewById(R.id.menulist);

            final ShowDirAdapter dirAdapter = new ShowDirAdapter(WriteNFCUI.this, Arrays.asList(constellations));

            menulistLeft.setAdapter(dirAdapter);

            menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String item = dirAdapter.getItem(i);

                    carType.setText(item.toString());
                    writeNFCTagBean.setCartype(String.valueOf(i));
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


    private void writeToNFCTag(String carNum) {

        if (TextUtils.isEmpty(carNum)) {
            Toast.makeText(this, "请输入车牌号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(writeNFCTagBean.getCartype())) {
            Toast.makeText(this, "请选择车辆类型", Toast.LENGTH_SHORT).show();
            return;
        }

        writeNFCTagBean.setCarnum(carNum);

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


}
