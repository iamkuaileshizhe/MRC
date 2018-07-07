package com.neocom.mobilerefueling.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.UpPwdReqBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/12/19.
 */

public class UpdatePwd extends BaseActivity implements TextWatcher, View.OnClickListener {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.old_pwd_et)
    EditText et_orgin;
    @BindView(R.id.new_pwd)
    EditText et_new;
    @BindView(R.id.et_forget_comfirm)
    EditText et_confirm;
    @BindView(R.id.id_confirm_bt)
    Button bt_confirm;


    @Override
    public void initContentView() {
        setContentView(R.layout.update_pwd_layout);
    }

    @Override
    public void initView() {

        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        et_orgin.addTextChangedListener(this);
        et_new.addTextChangedListener(this);
        et_confirm.addTextChangedListener(this);
        bt_confirm.setSelected(false);
        bt_confirm.setOnClickListener(this);


//        et_orgin.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                clearAll();
//                return false;
//            }
//        });
//        et_new.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                clearAll();
//                return false;
//            }
//        });
//        et_confirm.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                clearAll();
//                return false;
//            }
//        });


    }

    @Override
    public void initData() {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        /**
         * 当三个EditText的内容都不为空的时候，
         * Button为蓝色，否则为灰色通过
         * bt_confirm.setSelected(true)实现蓝色，
         *  bt_confirm.setSelected(false);实现灰色
         */
//        if (!TextUtils.isEmpty(et_confirm.getText().toString()) && !TextUtils.isEmpty(et_orgin.getText().toString())
//                && !TextUtils.isEmpty(et_new.getText().toString())) {
//            bt_confirm.setSelected(true);
//        } else {
//            bt_confirm.setSelected(false);
//        }

    }

    @Override
    public void afterTextChanged(Editable s) {


    }

//    private ProgressDialog dialog;

    @Override
    public void onClick(View v) {
//        if (checkNull()) {
//            return;
//        }

        String orginPwd = et_orgin.getText().toString().trim();

        if (TextUtils.isEmpty(orginPwd)) {
            Toasty.info(UpdatePwd.this, "请输入旧密码", Toast.LENGTH_SHORT, true).show();
            return;
        }

        String newPwd = et_new.getText().toString().trim();
        if (TextUtils.isEmpty(newPwd)) {
            Toasty.info(UpdatePwd.this, "请输入新密码", Toast.LENGTH_SHORT, true).show();
            return;
        }
        String confirmPwd = et_confirm.getText().toString().trim();
        if (TextUtils.isEmpty(confirmPwd)) {
            Toasty.info(UpdatePwd.this, "请输入确认密码", Toast.LENGTH_SHORT, true).show();
            return;
        }

        if (newPwd.equals(confirmPwd)) {

            //            dialog = ProgressDialog.show(this, "", "修改中,请稍后...", true);
            showLoadingDialog("修改中,请稍后...");
            UpPwdReqBean reqBean = new UpPwdReqBean();
            reqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
            reqBean.setOldPassword(orginPwd);
            reqBean.setPassword(newPwd);
            reqBean.setRePassword(confirmPwd);
            RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(reqBean);

            HttpManger.getHttpMangerInstance().getServices().changePassword(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
                @Override
                public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
                    disDialog();
                    EmptyBringGetOilBean body = response.body();
                    if (body != null) {
                        String message = body.getMessage();

                        if (message == null) {
                            Toasty.info(UpdatePwd.this, "修改失败", Toast.LENGTH_SHORT, true).show();
                            finish();
                            return;
                        } else {
                            Toasty.info(UpdatePwd.this, message, Toast.LENGTH_SHORT, true).show();
//                            finish();
                            return;

                        }


                    }


                }

                @Override
                public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                    disDialog();
                    Toasty.info(UpdatePwd.this, "更新密码异常", Toast.LENGTH_SHORT, true).show();
                    return;
                }
            });

        } else {
            Toasty.info(UpdatePwd.this, "两次密码输入不一致", Toast.LENGTH_SHORT, true).show();
            return;
        }

    }


//    private boolean checkNull() {
//        if (TextUtils.isEmpty(et_orgin.getText().toString())) {
//            requstFocus(et_orgin, null, Color.GRAY, true);
//            return true;
//        }
//        if (et_orgin.getText().toString().length() < 6) {
//            et_orgin.setText("");
//            requstFocus(et_orgin, "原密码格式错误", Color.RED, true);
//            return true;
//        }
//        if (TextUtils.isEmpty(et_new.getText().toString())) {
//            requstFocus(et_new, null, Color.GRAY, true);
//            return true;
//        }
//        if (et_new.getText().toString().length() < 6) {
//            et_new.setText("");
//            requstFocus(et_new, "新密码格式错误", Color.RED, true);
//            return true;
//        }
//        if (TextUtils.isEmpty(et_confirm.getText().toString())) {
//            requstFocus(et_confirm, null, Color.GRAY, true);
//            return true;
//        }
//        return false;
//    }

//    public void clearAll() {
//        requstFocus(et_orgin, null, Color.GRAY, false);
//        requstFocus(et_new, null, Color.GRAY, false);
//        requstFocus(et_confirm, null, Color.GRAY, false);
//    }

//    public void requstFocus(EditText et, String hint, int hintColor, boolean needFocus) {
//        if (hint == null) {
//            hint = "请输入六位密码";
//        }
//        et.setHint(hint);
//        et.setHintTextColor(hintColor);
//        if (needFocus) {
//            et.requestFocus();
//        }
//    }
}
