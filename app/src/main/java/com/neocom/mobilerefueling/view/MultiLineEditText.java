package com.neocom.mobilerefueling.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.LogUtils;


/**
 * Created by Administrator on 2018/4/25.
 */

public class MultiLineEditText extends LinearLayout {

    Context context;
    private String multyTitle;
    private boolean muityEdit;
    private TextView titleTv;
    private EditText noteInfo;
    private String muityHint;
    private String muityContent;

    public MultiLineEditText(Context context) {
        this(context, null);
    }

    public MultiLineEditText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiLineEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

        initMultiLineEditText(context, attrs, defStyleAttr);

    }

    private void initMultiLineEditText(Context context, AttributeSet attrs, int defStyleAttr) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MultiLineEditText, defStyleAttr, 0);
        multyTitle = typedArray.getString(R.styleable.MultiLineEditText_title);
        muityEdit = typedArray.getBoolean(R.styleable.MultiLineEditText_multiEdit, false);
        muityHint = typedArray.getString(R.styleable.MultiLineEditText_hint);
        muityContent = typedArray.getString(R.styleable.MultiLineEditText_content);
        //        获取资源后 及时回收
        typedArray.recycle();
        initView(context);

    }

    private void initView(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.multi_textarea_layout, this, true);
        titleTv = view.findViewById(R.id.title);
        noteInfo = view.findViewById(R.id.note_info);
        changeEdit();
    }


    private void changeEdit() {

//        muityContent = noteInfo.getText().toString().trim();

        if (TextUtils.isEmpty(muityContent)) {
            noteInfo.setText("");
        } else {
            noteInfo.setText(muityContent);
        }
        changeNoteInfoEdit();

        if (!TextUtils.isEmpty(multyTitle)) {
            titleTv.setText(multyTitle);
        }

//        else {
//            titleTv.setText(multyTitle);
//        }


    }


    public void changeNoteInfoEdit() {

        if (muityEdit) {
            noteInfo.setFocusableInTouchMode(true);
            noteInfo.setFocusable(true);
            noteInfo.requestFocus();
//            noteInfo.setBackgroundDrawable(getResources().getDrawable(R.drawable.et_bg));
            if (TextUtils.isEmpty(muityContent)) {
                noteInfo.setHint(muityHint);
            }
        } else {
            noteInfo.setBackgroundDrawable(null);
            noteInfo.clearFocus();
            noteInfo.setFocusable(false);
            noteInfo.setFocusableInTouchMode(false);
            noteInfo.setHint("");
        }

    }


    public String getContent() {

        String mContent = noteInfo.getText().toString().trim();
        if (!TextUtils.isEmpty(mContent)) {
            return mContent;
        }
        return "";
    }


    public void setContent(String content) {

        LogUtils.i("--多布局--" + content);

        if (TextUtils.isEmpty(content)) {
            noteInfo.setText("");
        } else {
            noteInfo.setText(content);
        }

    }

    public void setTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            titleTv.setText("");
        } else {
            titleTv.setText(title);
        }

    }


    public EditText getNoteInfoEdittext() {
        return noteInfo;
    }

    public void isEdit(boolean isEdit) {

        this.muityEdit = isEdit;
//        changeEdit();

        changeNoteInfoEdit();
    }

}
