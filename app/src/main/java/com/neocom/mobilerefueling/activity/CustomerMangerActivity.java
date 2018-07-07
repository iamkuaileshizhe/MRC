package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/14.
 */

public class CustomerMangerActivity extends BaseActivity implements SuperTextView.OnSuperTextViewClickListener {
    @BindView(R.id.customer_manger_topbar)
    TopTitleBar customerMangerTopbar;
    @BindView(R.id.qianzai_kehu)
    SuperTextView qianzaiKehu;
    @BindView(R.id.qianzai_kehu_list)
    SuperTextView qianzaiKehuList;
    @BindView(R.id.zs_kehu_list)
    SuperTextView zsKehuList;
    @BindView(R.id.dpf_list)
    SuperTextView dpfList;
    @BindView(R.id.dsh_list)
    SuperTextView dshList;
    @BindView(R.id.jgsh_list)
    SuperTextView jgshList;

    @Override
    public void initContentView() {

        setContentView(R.layout.customer_manger_layout);


    }

    @Override
    public void initView() {

        customerMangerTopbar.setTitleText("客户管理");
        customerMangerTopbar.getFinishLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        qianzaiKehu.setOnSuperTextViewClickListener(this);
        qianzaiKehuList.setOnSuperTextViewClickListener(this);
        zsKehuList.setOnSuperTextViewClickListener(this);
        dpfList.setOnSuperTextViewClickListener(this);
        dshList.setOnSuperTextViewClickListener(this);
        jgshList.setOnSuperTextViewClickListener(this);

    }

    @Override
    public void initData() {

    }


    @Override
    public void onClickListener(SuperTextView superTextView) {

        switch (superTextView.getId()) {


            case R.id.qianzai_kehu:

                startActivity(new Intent(UIUtils.getContext(), AddQianZaiKeHuActivity.class));
                break;
            case R.id.qianzai_kehu_list:

                startActivity(new Intent(UIUtils.getContext(), GetQianZaiKeHuListUI.class));
                break;
            case R.id.zs_kehu_list:

                startActivity(new Intent(UIUtils.getContext(), ZSKHListActivity.class));
                break;
            case R.id.dpf_list:
                startActivity(new Intent(UIUtils.getContext(), DPFListActivity.class));
                break;

            case R.id.dsh_list:
                startActivity(new Intent(UIUtils.getContext(), DSHKeHuAllActivity.class));
                break;
            case R.id.jgsh_list:
                startActivity(new Intent(UIUtils.getContext(), JGSHListActivity.class));
                break;


        }


    }
}
