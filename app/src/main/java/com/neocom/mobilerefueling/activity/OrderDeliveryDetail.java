package com.neocom.mobilerefueling.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.TimeAdapter;
import com.neocom.mobilerefueling.bean.TimeBean;
import com.neocom.mobilerefueling.utils.TimeComparator;
import com.neocom.mobilerefueling.view.TopTitleBar;
import com.wrbug.timeline.TimeLineView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by admin on 2017/8/15.
 */

public class OrderDeliveryDetail extends BaseActivity {

    private List<TimeBean> list;
    private TimeAdapter adapter;
    private ListView lv_list;

    @Override
    public void initContentView() {
        setContentView(R.layout.order_delivery_layout);
    }

    @Override
    public void initView() {
        TopTitleBar topTitleBar = (TopTitleBar) findViewById(R.id.order_delivery_tb);
        topTitleBar.setTitleText("详情");

        ImmersionBar.with(this).statusBarColor(R.color.colorPrimary).fitsSystemWindows(true).init();
        final TimeLineView mView3 = (TimeLineView) findViewById(R.id.timeLineView3);


        topTitleBar.getFinishLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        topTitleBar.getOKLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderDeliveryDetail.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });

        List<String> data = new ArrayList<>();
        data.add("第一步");
        data.add("第二步");
        data.add("第三步");
        data.add("第四步");
        data.add("第五步");
        data.add("第六步");
        data.add("第七步");
        mView3.builder().pointStrings(data, 1).load();
        mView3.setOnStepChangedListener(new TimeLineView.OnStepChangedListener() {
            @Override
            public void onchanged(TimeLineView view, int step, String stepStr) {
                Toast.makeText(OrderDeliveryDetail.this, "step=" + step + ",str=" + stepStr, Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView3.nextStep();
            }
        });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView3.setStep(1);
            }
        });
    }


    @Override
    public void initData() {
        lv_list = (ListView) findViewById(R.id.time_line_lv);
        list = new ArrayList<TimeBean>();
        TimeBean date1 = new TimeBean("20170815", "一切都很完美！！！");
        TimeBean date2 = new TimeBean("20170816", "无所事事");
        TimeBean date3 = new TimeBean("20170817", "闲着玩呗？");
        TimeBean date4 = new TimeBean("20170818", "撒很有意思吗");
        TimeBean date5 = new TimeBean("20170819", "很好啊还不错啊");
        TimeBean date6 = new TimeBean("201708110", "不知道怎么办啊");
        TimeBean date7 = new TimeBean("201708111", "现在还行吧");
        TimeBean date8 = new TimeBean("201708112", "你现在很需要这个功能吧");
        list.add(date1);
        list.add(date2);
        list.add(date3);
        list.add(date4);
        list.add(date5);
        list.add(date6);
        list.add(date7);
        list.add(date8);


        // 将数据按照时间排序
        TimeComparator comparator = new TimeComparator();
        Collections.sort(list, comparator);


        adapter = new TimeAdapter(this, list);
        lv_list.setAdapter(adapter);

    }
}
