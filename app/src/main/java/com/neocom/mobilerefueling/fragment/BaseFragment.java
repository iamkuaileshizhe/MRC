package com.neocom.mobilerefueling.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by admin on 2017/7/17.
 */

public abstract class BaseFragment extends Fragment {

    protected String TAG = getClass().getSimpleName();
    protected ProgressDialog baseDialog;
    private View view;
    Unbinder unbinder;


    /**
     * @return 返回的是 子Fragment的 布局
     * 初始化 子Fragment 的 布局
     */
    public abstract View initContentView(LayoutInflater inflater, ViewGroup container,
                                         Bundle savedInstanceState);

//    TODO 加载 显示 进度条

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化 数据
     */
    public abstract void initData();

//    /**
//     * 初始化控制中心
//     */
//    public abstract void initPresenter();
//
//    public abstract void initListener();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView textView = new TextView(UIUtils.getContext());
//        textView.setText(getClass().getSimpleName()); //暂时 先显示当前类名
//        textView.setGravity(Gravity.CENTER);

        view = initContentView(inflater, container,
                savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        initData();
        initView();
//        initPresenter();

        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


//    @Override
//    protected void immersionInit() {
//        ImmersionBar.with(this)
//                .init();
//    }

    /**
     * 进入activity显示加载进度
     */
    protected void showBaseDialog() {
        if (null == baseDialog || !baseDialog.isShowing()) {
            baseDialog = new ProgressDialog(getActivity());
            baseDialog.setCanceledOnTouchOutside(false);
            baseDialog.show();
        }
    }

    protected void showBaseDialog(String message) {
        if (null == baseDialog || !baseDialog.isShowing()) {
            baseDialog = new ProgressDialog(getActivity());
            baseDialog.setMessage(message);
            baseDialog.setCanceledOnTouchOutside(false);
            baseDialog.show();
        }
    }

    /**
     * 消除baseDialog
     */
    protected void cancelBaseDialog() {
        if (baseDialog != null) {
            if (baseDialog.isShowing()) {
                baseDialog.dismiss();
            }
        }
    }



}
