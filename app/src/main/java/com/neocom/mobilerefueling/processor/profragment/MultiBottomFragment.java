package com.neocom.mobilerefueling.processor.profragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.ChildItemBean;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/7/2.
 */


public class MultiBottomFragment extends BottomSheetDialogFragment implements View.OnClickListener {


    private View view;

//    private List<String> datas;

    public List<ChildItemBean> selectDatas = new ArrayList<>();
    private MultiAdapter mAdapter;
    private SuperTextView multiTitle;
    private RecyclerView mRecyclerView;

    List<ChildItemBean> childItemBeen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.fragment_multichoose);
        Bundle bundle = getArguments();
        String multi = bundle.getString("multiChoose");

        childItemBeen = GsonUtil.getObjectList(multi, ChildItemBean.class);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();


    }

    private void initData() {
//        datas = new ArrayList<>();
//
//        for (int i = 0; i < 20; i++) {
//            datas.add("测试" + i);
//        }
    }

    private void initView() {


        multiTitle = view.findViewById(R.id.multi_title);
        mRecyclerView = view.findViewById(R.id.multi_list);
        Button multiOkBtn = view.findViewById(R.id.multi_ok_btn);
        Button multiCancleBtn = view.findViewById(R.id.multi_cancle_btn);

        multiOkBtn.setOnClickListener(this);
        multiCancleBtn.setOnClickListener(this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new MultiAdapter(childItemBeen);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                if (!mAdapter.isSelected.get(position)) {
                    mAdapter.isSelected.put(position, true); // 修改map的值保存状态
                    mAdapter.notifyItemChanged(position);
                    selectDatas.add(childItemBeen.get(position));

                } else {
                    mAdapter.isSelected.put(position, false); // 修改map的值保存状态
                    mAdapter.notifyItemChanged(position);
                    selectDatas.remove(childItemBeen.get(position));
                }

                LogUtils.i("已选中" + selectDatas.size() + "项");
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        multiTitle.setLeftImageViewClickListener(new SuperTextView.OnLeftImageViewClickListener() {
            @Override
            public void onClickListener(ImageView imageView) {

                dismiss();
            }
        });

        multiTitle.setRightTvClickListener(new SuperTextView.OnRightTvClickListener() {
            @Override
            public void onClickListener() {
                if (notifyDataChange != null) {
                    notifyDataChange.DataChange(selectDatas);
                }
                dismiss();
            }
        });

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.multi_ok_btn:

                LogUtils.i("确定");
                break;
            case R.id.multi_cancle_btn:

                dismiss();
                break;

        }


    }

    public List<ChildItemBean> onGetSelectData() {

        return selectDatas;
    }

    onNotifyDataChange notifyDataChange;

    public void setOnDataChange(onNotifyDataChange notifyDataChange) {
        this.notifyDataChange = notifyDataChange;
    }

    public interface onNotifyDataChange {

        void DataChange(List<ChildItemBean> selectDatas);
    }

//    private View.OnKeyListener backlistener = new View.OnKeyListener() {
//        @Override
//        public boolean onKey(View view, int i, KeyEvent keyEvent) {
//            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
//                //这边判断,如果是back的按键被点击了   就自己拦截实现掉
//                if (i == KeyEvent.KEYCODE_BACK) {
//                    Toast.makeText(UIUtils.getContext(), "BACK拦截", Toast.LENGTH_SHORT).show();
//                    return true;//表示处理了
//                }
//            }
//            return false;
//        }
//    }

}
