package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.PeopleDetailRespBean;
import com.neocom.mobilerefueling.bean.UserIdReqBean;
import com.neocom.mobilerefueling.fragment.ChangedWorkFrament;
import com.neocom.mobilerefueling.fragment.DaiJieBanFragment;
import com.neocom.mobilerefueling.fragment.JiaoBanFragment;
import com.neocom.mobilerefueling.fragment.ToChangeWorkFragment;
import com.neocom.mobilerefueling.fragment.UnChangeWorkFrament;
import com.neocom.mobilerefueling.fragment.YiJieBanFragment;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.AddFragmentUtils;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/10/26.
 */

public class ChangeWkActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ChangeWkActivity";
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitle;
    private List<Fragment> mFragment;
//    LinearLayout addWorkLl;

    TextView workOn;
    TextView workOff;
    TextView addWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.change_wk_layout);
        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
//        addWorkLl = (LinearLayout) findViewById(R.id.add_work_ll);
        workOn = (TextView) findViewById(R.id.work_on);
        workOff = (TextView) findViewById(R.id.work_off);
        addWork = (TextView) findViewById(R.id.add_work);


        findViewById(R.id.top_bar_finish_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        addWork.setOnClickListener(this);
        workOn.setOnClickListener(this);
        workOff.setOnClickListener(this);
        mTitle = new ArrayList<>();
        mTitle.add("待确认");
        mTitle.add("已确认");
        mTitle.add("交班");


        mFragment = new ArrayList<>();
//        mFragment.add(new UnChangeWorkFrament());
        mFragment.add(new DaiJieBanFragment());
//        mFragment.add(new ChangedWorkFrament());
        mFragment.add(new YiJieBanFragment());
//        mFragment.add(new ToChangeWorkFragment());
        mFragment.add(new JiaoBanFragment());

        AddFragmentUtils.addTab(mTabLayout, mViewPager, mFragment, mTitle, getSupportFragmentManager());

        findPeopleDetail();
    }


    private void findPeopleDetail() {

        UserIdReqBean userIdReqBean = new UserIdReqBean();
        userIdReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(userIdReqBean);
        HttpManger.getHttpMangerInstance().getServices().findPeopleDetail(requestBody).enqueue(new Callback<PeopleDetailRespBean>() {
            @Override
            public void onResponse(Call<PeopleDetailRespBean> call, Response<PeopleDetailRespBean> response) {

                PeopleDetailRespBean body = response.body();

                if (body != null) {

                    PeopleDetailRespBean.BringBean bring = body.getBring();

                    if (bring != null) {

//                        joinStatus.setRightString(GetOrderStateUtil.getJoinTypeState(bring.getJoinType()));
//                        joinType.setRightString(GetOrderStateUtil.getJoinStatus(bring.getJoinType()));

//                        userStatus 上班0  或者是 下班 1

                        String userStatus = bring.getUserStatus();


                        if (TextUtils.isEmpty(userStatus)) {

                            SPUtils.saveContent(Constant.WORK_STATE, "");
                            switchUserStatus("");

                        } else {

                            SPUtils.saveContent(Constant.WORK_STATE, userStatus);

                            switchUserStatus(userStatus);


                        }

                        SPUtils.setSaveCar(bring.getCarNum());


//                        if (body.isRes()) {
//
//                            String carNum = bring.getCarNum();
//
//                            if (TextUtils.isEmpty(carNum)) {
//
//                                SPUtils.saveContent(Constant.CAR_NUM, "");
//                            } else {
//
//                                SPUtils.saveContent(Constant.CAR_NUM, carNum);
//                            }
//
//                        } else {
//                            SPUtils.saveContent(Constant.CAR_NUM, "");
//                        }


                    }

                }


            }

            @Override
            public void onFailure(Call<PeopleDetailRespBean> call, Throwable t) {

                Log.i(TAG, "onFailure: " + t.getMessage());

            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();


        String carryStatus = SPUtils.getContent(Constant.WORK_STATE);
        Log.i("ChangeWkActivity", "initWorkState: " + carryStatus);


        switchUserStatus(carryStatus);
//        switchUserStatus("");

    }

    private synchronized void switchUserStatus(String carryStatus) {
        Log.i(TAG, "switchUserStatus: =====>" + carryStatus);

        if (TextUtils.isEmpty(carryStatus)) {
            workOn.setVisibility(View.VISIBLE);
            workOff.setVisibility(View.GONE);
            addWork.setVisibility(View.GONE);

        } else {
//            meFgSinatureTv.setText(GetOrderStateUtil.getWorkState(carryStatus));

            if (carryStatus.equals(Constant.IN_WORK)) {
//                signOut.setVisibility(View.VISIBLE);
                workOff.setVisibility(View.VISIBLE);
                addWork.setVisibility(View.VISIBLE);
                workOn.setVisibility(View.GONE);
            } else if (carryStatus.equals(Constant.UN_WORK)) {
                workOn.setVisibility(View.VISIBLE);
                workOff.setVisibility(View.GONE);
                addWork.setVisibility(View.GONE);

            } else {
                workOn.setVisibility(View.GONE);
                workOff.setVisibility(View.GONE);
                addWork.setVisibility(View.GONE);
            }

        }


    }


    @Override
    public void onClick(View view) {

//        addWorkLl.setOnClickListener(this);
//        workOn.setOnClickListener(this);
//        workOff.setOnClickListener(this);

        switch (view.getId()) {

            case R.id.add_work:

                Intent intentCreate = new Intent(UIUtils.getContext(), AddChangeWorkActivity.class);
                intentCreate.putExtra("workState", "");
                startActivity(new Intent(UIUtils.getContext(), AddChangeWorkActivity.class));

                break;
            case R.id.work_on:


                Intent intent = new Intent(UIUtils.getContext(), AddChangeWorkActivity.class);
                intent.putExtra("workState", "on");
                startActivity(intent);

                break;
            case R.id.work_off:
                Intent intent1 = new Intent(UIUtils.getContext(), AddChangeWorkActivity.class);
                intent1.putExtra("workState", "off");
                startActivity(intent1);
                break;


        }


    }
}
