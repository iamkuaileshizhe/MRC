package com.neocom.mobilerefueling.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by admin on 2017/8/16.
 */


public class ListViewWithScroll extends ListView {
//    public boolean isOnMeasure = false;
    public ListViewWithScroll(Context context) {
        super(context);
    }

    public ListViewWithScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        isOnMeasure = true;
        //测量的大小由一个32位的数字表示，前两位表示测量模式，后30位表示大小，这里需要右移两位才能拿到测量的大小
        int heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightSpec);
    }

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        isOnMeasure = false;
//        super.onLayout(changed, l, t, r, b);
//    }
}





