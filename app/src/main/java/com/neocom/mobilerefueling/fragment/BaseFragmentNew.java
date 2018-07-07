package com.neocom.mobilerefueling.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.LoadingPage;

/**
 * Created by admin on 2017/9/7.
 */

public abstract class BaseFragmentNew extends Fragment {
    private LoadingPage mLoadingPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLoadingPage = new LoadingPage(UIUtils.getContext()) {

            @Override
            public View onCreateSuccessView() {
                return BaseFragmentNew.this.onCreateSuccessView();
            }

//            @Override
//            public ResultState onLoad() {
//                return BaseFragmentNew.this.onLoad();
//            }

        };
        return mLoadingPage;
    }

    // 由子类实现创建布局的方法
    public abstract View onCreateSuccessView();

//    // 由子类实现加载网络数据的逻辑, 该方法运行在子线程
//    public abstract LoadingPage.ResultState onLoad();


    // 开始加载网络数据
    public void loadDataStatus(LoadingPage.ResultState state) {
        Log.i("BaseFragmentNew", "loadDataStatus: state++:"+state);
        Toast.makeText(UIUtils.getContext(), "loadDataStatus"+state, Toast.LENGTH_SHORT).show();
        if (mLoadingPage != null) {
            mLoadingPage.loadData(state);
        }
    }

//    /**
//     * 校验数据的合法性,返回相应的状态
//     *
//     * @param
//     * @return
//     */
//    public LoadingPage.ResultState check(LoadingPage.ResultState state) {
////        if (data != null) {
////            if (data instanceof List) {//判断当前对象是否是一个集合
////                List list = (List) data;
////                if (!list.isEmpty()) {//数据不为空,访问成功
////                    return ResultState.STATE_SUCCESS;
////                } else {//空集合
////                    return ResultState.STATE_EMPTY;
////                }
////            }
////        }
//        return state;
//    }


}
