package com.neocom.mobilerefueling.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;


/**
 * Created by Administrator on 2018/4/21.
 */

public class TopTitleBar extends RelativeLayout implements View.OnClickListener {

    private int leftImageRes;
    private String middleTitle;
    private String rightTitle;
    private int rightImageRes;
    private LinearLayout leftFinishLl;
    private ImageView backIv;
    private TextView middleTitleTv;
    private LinearLayout rightOkLl;
    private ImageView rightIv;
    private TextView rightTv;

    public TopTitleBar(Context context) {
        this(context, null);
    }

    public TopTitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopTitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initTypeArrayView(context, attrs, defStyleAttr);

    }

    private void initTypeArrayView(Context context, AttributeSet attrs, int defStyleAttr) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopTitleBar, defStyleAttr, 0);

        leftImageRes = typedArray.getResourceId(R.styleable.TopTitleBar_lefeImage, 0);
        middleTitle = typedArray.getString(R.styleable.TopTitleBar_middleTitle);
        rightTitle = typedArray.getString(R.styleable.TopTitleBar_rightTitle);
        rightImageRes = typedArray.getResourceId(R.styleable.TopTitleBar_rightImageView, 0);

        typedArray.recycle();
        initView(context);

    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.top_bar_layout, this);
        leftFinishLl = view.findViewById(R.id.left_finish_ll);
        backIv = view.findViewById(R.id.back_iv);
        middleTitleTv = view.findViewById(R.id.middle_title_tv);
        rightOkLl = view.findViewById(R.id.right_ok_ll);

        rightIv = view.findViewById(R.id.right_iv);
        rightTv = view.findViewById(R.id.right_tv);


        leftFinishLl.setOnClickListener(this);
        rightOkLl.setOnClickListener(this);

        setValueToView();


    }

    private void setValueToView() {

        if (TextUtils.isEmpty(middleTitle)) {
            middleTitleTv.setText("");

        } else {
            middleTitleTv.setText(middleTitle);

        }

        if (leftImageRes != 0) {

            backIv.setBackground(getResources().getDrawable(leftImageRes));
        }

        if (rightImageRes != 0) {
            rightIv.setVisibility(VISIBLE);
            rightIv.setBackground(getResources().getDrawable(rightImageRes));
            rightTv.setVisibility(GONE);

        }

        if (!TextUtils.isEmpty(rightTitle)) {
            rightIv.setVisibility(GONE);
            rightTv.setText(rightTitle);
            rightTv.setVisibility(VISIBLE);
        }

        if (!TextUtils.isEmpty(middleTitle)) {
            middleTitleTv.setText(middleTitle);
        }

    }

    public ImageView getRightIv() {

        return rightIv;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_finish_ll:

                if (leftFinishOnclickListener != null) {

                    leftFinishOnclickListener.onLeftClick();

                }

                break;

            case R.id.right_ok_ll:

//                Toast.makeText(getContext(), "111111", Toast.LENGTH_SHORT).show();
                if (rightOnClickListener != null) {

                    rightOnClickListener.onRoghtClick();

                }
                break;


        }
    }

    leftFinishOnclickListener leftFinishOnclickListener;

    public void setOnleftFinishOnclickListener(leftFinishOnclickListener leftFinishOnclickListener) {
        this.leftFinishOnclickListener = leftFinishOnclickListener;
    }

    public interface leftFinishOnclickListener {

        void onLeftClick();
    }

    rightOnClickListener rightOnClickListener;

    public void setOnrightOkClickListener(rightOnClickListener rightOnClickListener) {
        this.rightOnClickListener = rightOnClickListener;
    }

    public interface rightOnClickListener {

        void onRoghtClick();
    }

    public void setTitleText(String title) {

        if (!TextUtils.isEmpty(title)) {
            middleTitleTv.setText(title);
        } else {
            Log.e("头部文件", "传入的标题为空");

        }
    }


    public LinearLayout getFinishLayout() {

        return leftFinishLl;

    }

    public int getOkId() {

        return R.id.top_bar_ok_ll;

    }

    public LinearLayout getOKLayout() {

        return rightOkLl;

    }
}
