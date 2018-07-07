package com.neocom.mobilerefueling.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;

/**
 * Created by Administrator on 2018/1/30.
 */

public class isEditeTextView extends LinearLayout {


    private String mTitle;
    private String mText;
    private boolean isEdit;
//    private TextView titleText;
    private EditText titleText;
    private String mHint;
    private TextView titleTv;
    private int inputType = 0;
    private int maxLength;
    private Context context;

    public isEditeTextView(Context context) {
//        super(context);
        this(context, null);
    }

    public isEditeTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public isEditeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initIsEditeTextView(context, attrs, defStyleAttr);
    }

    private void initIsEditeTextView(Context context, AttributeSet attrs, int defStyleAttr) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.isEditeTextView, defStyleAttr, 0);
        mTitle = typedArray.getString(R.styleable.isEditeTextView_mTitle);
        mText = typedArray.getString(R.styleable.isEditeTextView_mText);
        isEdit = typedArray.getBoolean(R.styleable.isEditeTextView_isEdit, false);
        mHint = typedArray.getString(R.styleable.isEditeTextView_mHint);

        //输入最大字符属性
        maxLength = typedArray.getInt(R.styleable.isEditeTextView_textMaxLength, -1);

        //输入类型属性
//        inputType = array.getInt(R.styleable.LineEditText_textInputType, TYPE_DEFAUT);
        inputType = typedArray.getInt(R.styleable.isEditeTextView_mInputType, inputType);


//        获取资源后 及时回收
        typedArray.recycle();
        initView(context);
    }

    private void initView(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.isedite_textview_view, this, true);
        titleTv = view.findViewById(R.id.item_mtitle);
        titleText = view.findViewById(R.id.item_text);

        if (TextUtils.isEmpty(mTitle)) {
            titleTv.setText("");
        } else {
            titleTv.setText(mTitle);
        }

        if (TextUtils.isEmpty(mText)) {
            titleText.setText("");
            titleText.setBackgroundDrawable(getResources().getDrawable(R.drawable.et_bg));
        } else {
            titleText.setText(mText);
            titleText.setBackgroundDrawable(null);
        }

//        https://blog.csdn.net/zcn596785154/article/details/78941574

        if (maxLength >= 0) {
            titleText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        } else {
            titleText.setFilters(new InputFilter[0]);
        }


        changeEdit();

        switchInputType();

    }


//    @Override
//    protected void onLayout(final boolean changed, final int l, final int t, final int r, final int b) {
//        //XXX：经过初步测试，只有在Android 7.0平台以上的系统才会出现软键盘自动切换的问题。
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && changed)
//            super.onLayout(changed, l, t, r, b);
//        else
//            super.onLayout(changed, l, t, r, b);
//    }


    private void switchInputType() {

        switch (inputType) {

            case 0:

                titleText.setInputType(InputType.TYPE_CLASS_TEXT);  //多行文本

//要使多行文本属性生效要加上下面两句才行
                titleText.setSingleLine(false);
                titleText.setHorizontallyScrolling(false);

                break;

            case 1:
//                titleText.setInputType(InputType.TYPE_CLASS_NUMBER);      //数字
                titleText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                break;


        }


    }

    private void changeEdit() {

        mText = titleText.getText().toString().trim();

        if (TextUtils.isEmpty(mText)) {
            titleText.setText("");
        } else {
            titleText.setText(mText);
        }
        if (isEdit) {
            titleText.setFocusableInTouchMode(true);
            titleText.setFocusable(true);
            titleText.requestFocus();
//            titleText.setBackgroundDrawable(getResources().getDrawable(R.drawable.et_bg));
            if (TextUtils.isEmpty(mText)) {
                titleText.setHint(mHint);
            }
        } else {
            titleText.setBackgroundDrawable(null);
            titleText.clearFocus();
            titleText.setFocusable(false);
            titleText.setFocusableInTouchMode(false);
            titleText.setHint("");
        }

    }

    public String getContent() {

        String mContent = titleText.getText().toString().trim();
        if (!TextUtils.isEmpty(mContent)) {
            return mContent;
        }
        return "";
    }


    public void setContent(String content) {
        if (TextUtils.isEmpty(content)) {
            titleText.setText("");
        } else {
            titleText.setText(content);
        }

    }


    public String getisEtvHint() {

        if (TextUtils.isEmpty(mHint)) {
            return "";
        }

        return mHint;

    }

    public TextView getInoutLayout() {

        return titleText;
    }

    public void setTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            titleTv.setText("");
        } else {
            titleTv.setText(title);
        }

    }
    public void getFocus() {
        titleText.requestFocus();
    }

    public void isEdit(boolean isEdit) {

        this.isEdit = isEdit;
        changeEdit();

    }

    public EditText getEdittext() {

        return titleText;
    }

}
