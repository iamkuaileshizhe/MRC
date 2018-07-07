package com.neocom.mobilerefueling.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

//import com.huanyu.itsms.R;
//import com.huanyu.itsms.adapter.MeFunctionMenuAdapter;
//import com.huanyu.itsms.bean.ExpandListViewChild;
//import com.huanyu.itsms.utils.UIUtils;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.ChangeWkActivity;
import com.neocom.mobilerefueling.adapter.MeFunctionMenuAdapter;
import com.neocom.mobilerefueling.bean.ExpandListViewChild;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;

/**
 * Created by admin on 2017/7/17.
 */

public class MeFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private View view;
    private List<ExpandListViewChild> menuChild;

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.me_fragment);

        return view;
    }

    @Override
    public void initView() {
//        TextView textView = view.findViewById(R.id.tv_home_fg);
//        textView.setText(getClass().getSimpleName());

//        CircleImageView userAvatar = view.findViewById(R.id.me_fg_user_avatar);
//        TextView userNickName = view.findViewById(R.id.me_fg_nick_name);
//        TextView userSinature = view.findViewById(R.id.me_fg_sinature_tv);
//        LinearLayout userCardOption = view.findViewById(R.id.me_fg_card_ll);
//        LinearLayout userDraftOption = view.findViewById(R.id.me_fg_draft_ll);
//        LinearLayout userSettingOption = view.findViewById(R.id.me_fg_setting_ll);

        ListView listView = view.findViewById(R.id.me_fg_menu_lv);


        listView.setAdapter(new MeFunctionMenuAdapter(menuChild));

        listView.setOnItemClickListener(this);

    }

    @Override
    public void initData() {
        menuChild = new ArrayList<>();
        ExpandListViewChild menuCardChild = new ExpandListViewChild(R.mipmap.me_info, "个人信息");
        ExpandListViewChild menuDraftChild = new ExpandListViewChild(R.mipmap.com_info, "公司信息");
        ExpandListViewChild menuSettingChild = new ExpandListViewChild(R.mipmap.car_in, "名下车辆");
        ExpandListViewChild menuChangeWorkChild = new ExpandListViewChild(R.mipmap.me_info, "交接班记录");
        ExpandListViewChild menuAboutChild = new ExpandListViewChild(R.mipmap.about, "关于");
        menuChild.add(menuCardChild);
        menuChild.add(menuDraftChild);
        menuChild.add(menuSettingChild);
        menuChild.add(menuChangeWorkChild);
        menuChild.add(menuAboutChild);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(UIUtils.getContext(), "点击了："+i, Toast.LENGTH_SHORT).show();
        if (i == 3) {
//            startActivity(new Intent(UIUtils.getContext(), ChangeWorkACtivity.class));
            startActivity(new Intent(UIUtils.getContext(), ChangeWkActivity.class));
        }


    }

//    @Override
//    protected void immersionInit() {
//        ImmersionBar.with(this).init();
//    }

}
