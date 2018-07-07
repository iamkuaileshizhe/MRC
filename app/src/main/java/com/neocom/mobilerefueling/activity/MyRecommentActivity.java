package com.neocom.mobilerefueling.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.RCodeResp;
import com.neocom.mobilerefueling.bean.UserIdReqBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/4/11.
 */

public class MyRecommentActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.my_recment_topbar)
    TopTitleBar myRecmentTopbar;
    @BindView(R.id.my_recomandor)
    SuperTextView myRecomandor;
    //    @BindView(R.id.address_manger)
//    SuperTextView addressManger;
    @BindView(R.id.menu)
    LinearLayout menu;
    @BindView(R.id.share_to_friends)
    Button shareToFriends;
    @BindView(R.id.my_rec_no)
    SuperTextView myRecNo;

    private UMShareListener mShareListener;
    private ShareAction mShareAction;
    private String sharUrl;


    @Override
    public void initContentView() {
        setContentView(R.layout.my_recmend_layout);
    }

    @Override
    public void initView() {

        myRecmentTopbar.setTitleText("我的推荐");
        myRecmentTopbar.getFinishLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        shareToFriends.setOnClickListener(this);
        initShare();
    }

    @Override
    public void initData() {


    }


    public void setMyRecomendor(String name) {

        if (TextUtils.isEmpty(name)) {
            myRecomandor.setLeftString("我的推荐人:  ");
        } else {
            myRecomandor.setLeftString("我的推荐人:  " + name);
        }

    }


    public void setMyRecNo(String recNo) {

        if (TextUtils.isEmpty(recNo)) {
            myRecNo.setRightString("0人");
        } else {
            myRecNo.setRightString("成功邀请" + recNo + "人");

        }


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.share_to_friends:

                getUrlAndRcodeByUerId();

                break;


        }


    }

//TODO 分享功能更新



    private void getUrlAndRcodeByUerId() {

        showLoadingDialog("邀请码获取中...");

        UserIdReqBean userIdReqBean = new UserIdReqBean();
        userIdReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(userIdReqBean);
        HttpManger.getHttpMangerInstance().getServices().getUrlAndRcodeByUerId(requestBody).enqueue(new Callback<RCodeResp>() {
            @Override
            public void onResponse(Call<RCodeResp> call, Response<RCodeResp> response) {
                disDialog();

                RCodeResp body = response.body();

                if (body != null) {

                    boolean res = body.isRes();

                    if (res) {
                        RCodeResp.BringBean bring = body.getBring();

                        String recommCode = bring.getRecommCode();

                        if (TextUtils.isEmpty(recommCode)) {
                            String message = body.getMessage();
                            Toast.makeText(MyRecommentActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                        } else {
                            showToShare(recommCode, bring.getDURL());
                        }

                    }


                }


            }

            @Override
            public void onFailure(Call<RCodeResp> call, Throwable t) {
               disDialog();

                Log.i(TAG, "onFailure: " + t.getMessage());
                Toast.makeText(MyRecommentActivity.this, "获取邀请码失败", Toast.LENGTH_SHORT).show();
            }
        });


    }


    private void showToShare(String code, String inviteUrl) {

        ShareBoardConfig config = new ShareBoardConfig();
        config.setTitleText("推荐给好友，邀请码" + code);
        config.setShareboardPostion(ShareBoardConfig.SHAREBOARD_POSITION_CENTER);
        sharUrl = inviteUrl + "?recommCode=" + code;
        Log.i(TAG, "showToShare: ===》" + sharUrl);
        mShareAction.open(config);

    }


    private void initShare() {
        mShareListener = new CustomShareListener();
         /*增加自定义按钮的分享面板*/

//          SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,

        mShareAction = new ShareAction(MyRecommentActivity.this).setDisplayList(

                SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QZONE)
                .addButton("二维码", "专属二维码", "qr_code", "qr_code")
                .setShareboardclickCallback(new ShareBoardlistener() {
                    @Override
                    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
//                Toast.makeText(getContext(), "点击"+snsPlatform.mShowWord, Toast.LENGTH_SHORT).show();

                        if (snsPlatform.mShowWord.equals("二维码")) {
//                    Toast.makeText(getContext(), "二维码", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UIUtils.getContext(), QrCodeActivity.class);
                            intent.putExtra("sharUrl", sharUrl);

                            startActivity(intent);

//                            sharUrl

                        } else {

//                            UMWeb umWeb = new UMWeb("http://gyxz.exmmw.cn/a3/rj_sp1/xndwdk.apk");

                            if (TextUtils.isEmpty(sharUrl)) {
                                return;
                            }

                            UMWeb umWeb = new UMWeb(sharUrl);
                            umWeb.setTitle("来自哥们加油的分享");
                            umWeb.setDescription("北京哥们加油网络科技有限公司是集油品销售与运输为一体，率先在国内提供移动式现场加油的服务商。");
                            umWeb.setThumb(new UMImage(MyRecommentActivity.this, R.drawable.appicon));
                            new ShareAction(MyRecommentActivity.this).withMedia(umWeb)
                                    .setPlatform(share_media)
                                    .setCallback(mShareListener).share();

                        }


                    }
                });


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /** attention to this below ,must add this**/
        UMShareAPI.get(MyRecommentActivity.this).onActivityResult(requestCode, resultCode, data);
    }



    private class CustomShareListener implements UMShareListener {

//        private WeakReference<ShareMenuActivity> mActivity;
//
//        private CustomShareListener(ShareMenuActivity activity) {
//            mActivity = new WeakReference(activity);
//        }

        @Override
        public void onStart(SHARE_MEDIA platform) {
//            Toast.makeText(UIUtils.getContext(), "onStart："+platform, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
//            Toast.makeText(UIUtils.getContext(), "onResult："+platform, Toast.LENGTH_SHORT).show();
            if (platform.name().equals("WEIXIN_FAVORITE")) {
                Toast.makeText(UIUtils.getContext(), platform + " 收藏成功啦", Toast.LENGTH_SHORT).show();
            } else {
                if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
                        && platform != SHARE_MEDIA.EMAIL
                        && platform != SHARE_MEDIA.FLICKR
                        && platform != SHARE_MEDIA.FOURSQUARE
                        && platform != SHARE_MEDIA.TUMBLR
                        && platform != SHARE_MEDIA.POCKET
                        && platform != SHARE_MEDIA.PINTEREST

                        && platform != SHARE_MEDIA.INSTAGRAM
                        && platform != SHARE_MEDIA.GOOGLEPLUS
                        && platform != SHARE_MEDIA.YNOTE
                        && platform != SHARE_MEDIA.EVERNOTE) {
                    Toast.makeText(UIUtils.getContext(), platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
                }

            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(UIUtils.getContext(), "onResult：" + platform + ";;" + t.getMessage(), Toast.LENGTH_SHORT).show();
            if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
                    && platform != SHARE_MEDIA.EMAIL
                    && platform != SHARE_MEDIA.FLICKR
                    && platform != SHARE_MEDIA.FOURSQUARE
                    && platform != SHARE_MEDIA.TUMBLR
                    && platform != SHARE_MEDIA.POCKET
                    && platform != SHARE_MEDIA.PINTEREST

                    && platform != SHARE_MEDIA.INSTAGRAM
                    && platform != SHARE_MEDIA.GOOGLEPLUS
                    && platform != SHARE_MEDIA.YNOTE
                    && platform != SHARE_MEDIA.EVERNOTE) {
                Toast.makeText(UIUtils.getContext(), platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                if (t != null) {
                    com.umeng.socialize.utils.Log.d("throw", "throw:" + t.getMessage());
                }
            }

        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {

            Toast.makeText(UIUtils.getContext(), platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    }


}
