package com.neocom.mobilerefueling.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by admin on 2017/8/9.
 */

public abstract class BaseOrderFragment extends Fragment {


    protected String TAG = getClass().getSimpleName();

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

        View view = initContentView(inflater, container,
                savedInstanceState);

        ButterKnife.bind(this, view);
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
    }

    @Override
    public void onStart() {
        super.onStart();

//        initListener();
    }


//    @Override
//    protected void immersionInit() {
//        ImmersionBar.with(this)
//                .init();
//    }

}
