package com.neocom.mobilerefueling.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin_xyz on 2017/7/31.
 * 创建人：xyz
 * 创建日期:2017/7/31
 * 描述: IP 输入控件
 */

public class IPEditText extends LinearLayout {

    private EditText mFirstIP;
    private EditText mSecondIP;
    private EditText mThirdIP;
    private EditText mFourthIP;

    private boolean secondFlag = true;
    private boolean thirdFlag = true;
    private boolean fourthFlag = true;
    private SharedPreferences mPreferences;
    private final String regular = "^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])"
            + "\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])"
            + "\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$";

    public IPEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        /**
         * 初始化控件
         */
        View view = LayoutInflater.from(context).inflate(
                R.layout.custom_my_edittext, this);
        mFirstIP = (EditText) findViewById(R.id.ip_first);
        mSecondIP = (EditText) findViewById(R.id.ip_second);
        mThirdIP = (EditText) findViewById(R.id.ip_third);
        mFourthIP = (EditText) findViewById(R.id.ip_fourth);

        mPreferences = context.getSharedPreferences("config_IP",
                Context.MODE_PRIVATE);

        OperatingEditText(context);
    }

    /**
     * 获得EditText中的内容,当每个Edittext的字符达到三位时,自动跳转到下一个EditText,当用户点击.时,
     * 下一个EditText获得焦点
     */
    private void OperatingEditText(final Context context) {
        mFirstIP.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                /**
                 * 获得EditTe输入内容,做判断,如果大于255,提示不合法,当数字为合法的三位数下一个EditText获得焦点,
                 * 用户点击时,下一个EditText获得焦点
                 */

                if (!TextUtils.isEmpty(s.toString())) {
                    if (s.length() == 1 && s.toString().equals("0")) {// 不能以0开头
                        mFirstIP.setText("");
                    } else {
                        if (s.length() >= 3) {
//                            if (Integer.parseInt(s.toString()) > 255) {
                            if (Integer.parseInt(s.toString()) > 255) {
                                mFirstIP.setText("255");
                            }
                            mSecondIP.setFocusable(true);
                            mSecondIP.requestFocus();
                        }
                    }
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSecondIP.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (!TextUtils.isEmpty(s.toString())) {
                    if (s.length() > 1 && s.toString().startsWith("0")) {// 不能以0开头
                        secondFlag = false;
                        mSecondIP.setText(s.toString().substring(1));
                        mSecondIP.setSelection(mSecondIP.getText().toString()
                                .length());
                    } else {
                        if (s.length() >= 3) {
                            if (Integer.parseInt(s.toString()) > 255) {
                                mSecondIP.setText("255");
                            }
                            mThirdIP.setFocusable(true);
                            mThirdIP.requestFocus();
                        }
                    }
                } else {
                    if (secondFlag) {
                        mFirstIP.setFocusable(true);
                        mFirstIP.requestFocus();
                        mFirstIP.setSelection(mFirstIP.getText().toString()
                                .length());
                    } else {
                        secondFlag = true;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mThirdIP.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (!TextUtils.isEmpty(s.toString())) {
                    if (s.length() > 1 && s.toString().startsWith("0")) {// 不能以0开头
                        thirdFlag = false;
                        mThirdIP.setText(s.toString().substring(1));
                        mThirdIP.setSelection(mThirdIP.getText().toString()
                                .length());
                    } else {
                        if (s.length() >= 3) {
                            if (Integer.parseInt(s.toString()) > 255) {
                                mThirdIP.setText("255");
                            }
                            mFourthIP.setFocusable(true);
                            mFourthIP.requestFocus();
                        }
                    }
                } else {
                    if (thirdFlag) {
                        mSecondIP.setFocusable(true);
                        mSecondIP.requestFocus();
                        mSecondIP.setSelection(mSecondIP.getText().toString()
                                .length());
                    } else {
                        thirdFlag = true;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mFourthIP.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                if (!TextUtils.isEmpty(s.toString())) {
                    if (s.length() == 1 && s.toString().equals("0")) {// 不能以0开头
                        fourthFlag = false;
                        mFourthIP.setText("");
                    } else {
                        if (s.length() >= 3) {
                            if (Integer.parseInt(s.toString()) > 255) {
                                mFourthIP.setText("255");
                                mFourthIP.setSelection(mFourthIP.getText()
                                        .toString().length());
                            }
                        }
                    }
                } else {
                    if (fourthFlag) {
                        mThirdIP.setFocusable(true);
                        mThirdIP.requestFocus();
                        mThirdIP.setSelection(mThirdIP.getText().toString()
                                .length());
                    } else {
                        fourthFlag = true;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public String getText() {
        String mText1 = mFirstIP.getText().toString().trim();
        String mText2 = mSecondIP.getText().toString().trim();
        String mText3 = mThirdIP.getText().toString().trim();
        String mText4 = mFourthIP.getText().toString().trim();
        if (TextUtils.isEmpty(mText1) || TextUtils.isEmpty(mText2)
                || TextUtils.isEmpty(mText3) || TextUtils.isEmpty(mText4)) {
            Toast.makeText(UIUtils.getContext(), "请输入合法的ip地址", Toast.LENGTH_SHORT).show();
            return "";
        }
        return mText1 + "." + mText2 + "." + mText3 + "." + mText4;
    }

    public String getFirstIP() {
        return mFirstIP.getText().toString();
    }

    public String getSecondIP() {
        return mSecondIP.getText().toString();
    }

    public String getThird() {
        return mThirdIP.getText().toString();
    }

    public String getFourthIP() {
        return mFourthIP.getText().toString();
    }

    public void setText(String ip) {
        LogUtils.i("传入IP"+ip);
        Pattern pa = Pattern.compile(regular);
        Matcher ma = pa.matcher(ip);
        if (!TextUtils.isEmpty(ip) && ma.matches()) {
            String[] ipInfo = ip.split("\\.");
            mFirstIP.setText(ipInfo[0]);
            mSecondIP.setText(ipInfo[1]);
            mThirdIP.setText(ipInfo[2]);
            mFourthIP.setText(ipInfo[3]);
        }
    }

    public void setDefaultIp(String ip) {
        String[] mIp = ip.split("\\.");
        mFirstIP.setText(mIp[0].toString());
        mSecondIP.setText(mIp[1].toString());
        mThirdIP.setText(mIp[2].toString());
        mFourthIP.setText(mIp[3].toString());
    }

    public void copyIP(IPEditText copy) {
        String mText1 = copy.getFirstIP();
        String mText2 = copy.getSecondIP();
        String mText3 = copy.getThird();
        String mText4 = copy.getFourthIP();

        mFirstIP.setText(mText1);
        mSecondIP.setText(mText2);
        mThirdIP.setText(mText3);
        mFourthIP.setText(mText4);
    }

}
