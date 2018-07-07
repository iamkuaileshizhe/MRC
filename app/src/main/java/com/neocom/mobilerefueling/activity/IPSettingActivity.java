package com.neocom.mobilerefueling.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.view.IPEditText;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/5.
 */

public class IPSettingActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.setting_webservice_ipe)
    IPEditText settingWebserviceIpe;
    @BindView(R.id.setting_webservice_port_et)
    EditText settingWebservicePortEt;
    @BindView(R.id.ip_setting_ok)
    Button ipSettingOk;
    @BindView(R.id.ip_setting_default)
    Button ipSettingDefault;

    public static void ipSeetingStart(Context context) {
        Intent intent = new Intent(context, IPSettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initContentView() {

        setContentView(R.layout.activity_ipsetting);

    }

    @Override
    public void initView() {
        ipSettingOk.setOnClickListener(this);
        ipSettingDefault.setOnClickListener(this);
    }

    @Override
    public void initData() {

        String defaultIp = SPUtils.getContent(Constant.DEFAULT_IP);

        String useIp = SPUtils.getContent(Constant.DEFAULT_IP_INUSE);

        if (TextUtils.isEmpty(useIp)) {
            processHttpIP(defaultIp);
        } else {
            processHttpIP(useIp);
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.ip_setting_ok:

                String ip = settingWebserviceIpe.getText();
                Editable port = settingWebservicePortEt.getText();

                if (TextUtils.isEmpty(ip)) {
                    showInfoTip("请输入IP");
                    return;
                }
                if (TextUtils.isEmpty(port)) {
                    showInfoTip("请输入端口");
                    return;
                }

                Constant.BASE_URL = "http://" + ip + ":" + port;

                LogUtils.i("--地址--" + Constant.BASE_URL);

//                SPUtils.getContent(Constant.DEFAULT_IP_INUSE);

                SPUtils.saveContent(Constant.DEFAULT_IP_INUSE, Constant.BASE_URL);
                showShortToast("IP设置成功");
                finish();

                break;

            case R.id.ip_setting_default:
                String defaultIp = SPUtils.getContent(Constant.DEFAULT_IP);
                LogUtils.i("默认IP" + defaultIp);
                processHttpIP(defaultIp);
//                processHttpIP("http://192.168.1.208:8080");
                break;

        }

    }


    public IPBean processHttpIP(String baseUrl) {

        IPBean ipBean = new IPBean();

//        String baseUrl = Constant.BASE_URL;

        if (!TextUtils.isEmpty(baseUrl)) {

            String replaceUrl = baseUrl.replace("http://", "").trim();

            String[] splitUrl = replaceUrl.split(":");

            if (splitUrl != null && splitUrl.length > 0) {

                ipBean.setUrl(splitUrl[0]);
                ipBean.setPort(splitUrl[1]);
                LogUtils.i("--显示IP-" + splitUrl[0]);
                settingWebserviceIpe.setDefaultIp(splitUrl[0]);
                settingWebservicePortEt.setText(splitUrl[1]);

            }


        }

        return ipBean;
    }


    private class IPBean {

        private String url;
        private String port;


        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }
    }

}
