package com.neocom.mobilerefueling.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.ListSettingBean;
import com.neocom.mobilerefueling.bean.ListSettingUpdateBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/6/21.
 */

public class UserSettingActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    @BindView(R.id.setting_topbar)
    TopTitleBar settingTopbar;
    @BindView(R.id.setting_danwei_choose_kg)
    RadioButton settingDanweiChooseKg;
    @BindView(R.id.setting_danwei_choose_t)
    RadioButton settingDanweiChooseT;
    @BindView(R.id.setting_danwei_choose)
    RadioGroup settingDanweiChoose;
    @BindView(R.id.setting_save_btn)
    Button settingSaveBtn;

    ListSettingBean listSettingBean;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_user_setting);
    }

    @Override
    public void initView() {
        settingDanweiChoose.setOnCheckedChangeListener(this);
        settingSaveBtn.setOnClickListener(this);
        listSettingBean = new ListSettingBean();
        settingTopbar.setOnleftFinishOnclickListener(new TopTitleBar.leftFinishOnclickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }
        });

        initSettingItem();

    }

    private void initSettingItem() {

        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        ListSettingBean listSetting = userInfo.getListSetting();

        if (listSetting == null) {
            settingDanweiChooseKg.setChecked(true);
        } else {

            String item_quality = listSetting.getItem_quality();

            if (!TextUtils.isEmpty(item_quality) && item_quality.equals(Constant.DANWEI_KG_L)) {
                settingDanweiChooseKg.setChecked(true);
                settingDanweiChooseT.setChecked(false);
            } else {
                settingDanweiChooseKg.setChecked(false);
                settingDanweiChooseT.setChecked(true);
            }

        }


    }


    @Override
    public void initData() {

    }


    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {

            case R.id.setting_danwei_choose_kg:

                listSettingBean.setItem_quality("0");

                break;

            case R.id.setting_danwei_choose_t:
                listSettingBean.setItem_quality("1");

                break;

        }


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.setting_save_btn:

                updateUserCustomize();
                break;


        }

    }

    private void updateUserCustomize() {
        showLoadingDialog("设置保存中...");
        ListSettingUpdateBean listSettingUpdateBean = new ListSettingUpdateBean();
        listSettingUpdateBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        listSettingUpdateBean.setListSetting(listSettingBean);
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(listSettingUpdateBean);
        Call<EmptyBringGetOilBean> userCustomizeCall = HttpManger.getHttpMangerInstance().getServices().updateUserCustomize(requestBody);

        userCustomizeCall.enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
                disDialog();
                EmptyBringGetOilBean body = response.body();

                if (body != null) {

                    String message = body.getMessage();
                    boolean res = body.isRes();
                    if (res) {

                        if (TextUtils.isEmpty(message)) {
                            showShortToast("更新成功");
                        } else {
                            showShortToast(message);
                        }

                        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

                        userInfo.setListSetting(listSettingBean);
                        SPUtils.saveLoginConten(Constant.SP_LOGIN_CONTENT, new Gson().toJson(userInfo));

                        finish();
                    } else {

                        if (TextUtils.isEmpty(message)) {
                            showWarnTip("更新成功");
                        } else {
                            showWarnTip(message);
                        }

                    }


                }

            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                showFailTip();
                LogUtils.e(t.getMessage());
            }
        });

    }
}
