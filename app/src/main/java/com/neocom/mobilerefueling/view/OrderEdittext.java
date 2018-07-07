package com.neocom.mobilerefueling.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;

/**
 * Created by admin on 2017/8/29.
 */

public class OrderEdittext extends RelativeLayout {

    private TextView editTitle;
    private EditText editContent;
    private TextView danwei;

    public OrderEdittext(Context context) {
        super(context);
        initView(context);
    }

    public OrderEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public OrderEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {

        LayoutInflater.from(context).inflate(R.layout.order_add_com_edittext, this);

        editTitle = findViewById(R.id.com_edit_title);

        editContent = findViewById(R.id.com_edit_content);
        danwei = findViewById(R.id.danwei);
        editContent.setBackgroundDrawable(getResources().getDrawable(R.drawable.et_bg));
//        editContent.setHint("请输入");
    }

    public void setEditTitle(String title) {

        if (TextUtils.isEmpty(title)) {
            editTitle.setText("");
        } else {
            editTitle.setText(title);
        }

    }

    public void setEditBacgroungNull() {

        editContent.setBackgroundDrawable(null);

    }


    public void setEditContent(String content) {

        if (TextUtils.isEmpty(content)) {
            editContent.setText("");
        } else {
            editContent.setText(content);
        }
    }

    public void setEditable(boolean edit) {
//        editContent.setFocusable(edit);

        if (edit) {
            // android:background="@drawable/et_bg"
            editContent.setBackgroundDrawable(getResources().getDrawable(R.drawable.et_bg));
        } else {
            editContent.setBackgroundDrawable(null);
        }

        editContent.setFocusable(edit);
        editContent.setFocusableInTouchMode(edit);
        editContent.setClickable(edit);
    }

    public String getEditContent() {
        return editContent.getText().toString().trim();
    }

    public void setDanweiVisibility(boolean show) {
        danwei.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void setDanweiContent(String danweiStr) {
        if (TextUtils.isEmpty(danweiStr)) {

            danwei.setText("");

        } else {
            danwei.setText(danweiStr);
        }


    }

}
