package com.neocom.mobilerefueling.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;

/**
 * Created by admin on 2017/8/22.
 */

public class OrderConbindView extends RelativeLayout {

    private TextView titleTv;
    private TextView contentTv;

    public OrderConbindView(Context context) {
        super(context);
        initUI(context);
    }

    public OrderConbindView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUI(context);
    }

    public OrderConbindView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUI(context);
    }

    private void initUI(Context context) {

        View.inflate(context, R.layout.order_detail_combind_layout, this);
        titleTv = findViewById(R.id.com_title);
        contentTv = findViewById(R.id.com_content);
    }

    public void setTitle(String title) {

        if (TextUtils.isEmpty(title)) {

            titleTv.setText("");
        } else {
            titleTv.setText(title);
        }

    }

    public void setContet(String conten) {

        if (TextUtils.isEmpty(conten)) {

            contentTv.setText("");
        } else {
            contentTv.setText(conten);
        }

    }

    public String  getContent() {
      return  contentTv.getText().toString().trim();
    }

}
