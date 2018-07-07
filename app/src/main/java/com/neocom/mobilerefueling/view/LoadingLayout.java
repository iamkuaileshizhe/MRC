package com.neocom.mobilerefueling.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;


/**
 * Created by admin on 2017/9/8.
 * 加载中 加载失败 加载成功 加载错误的 界面
 *
 */


public class LoadingLayout extends FrameLayout {
    private Context mContext;

    private View mMainPage;
    private View loadingPage;
    private View errorPage;
    private View emptyPage;

    private TextView loadingText;

    private ImageView errorImg;
    private TextView errorText;

    private ImageView emptyImg;
    private TextView emptyText;

    private int mErrorResId;
    private int mEmptyResId;
    private String mErrorStr;
    private String mEmptyStr;
    private String mLoadingStr;

    public LoadingLayout(Context context) {
        this(context, null);
    }

    public LoadingLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initAttrs(attrs);
    }

    private void initAttrs(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.LoadingLayout, 0, 0);
            mErrorResId = a.getResourceId(R.styleable.LoadingLayout_loading_layout_error_img, android.R.drawable.ic_delete);
            mErrorStr = a.getString(R.styleable.LoadingLayout_loading_layout_error_text);
            mEmptyResId = a.getResourceId(R.styleable.LoadingLayout_loading_layout_empty_img, R.drawable.ic_empty_page);
            mEmptyStr = a.getString(R.styleable.LoadingLayout_loading_layout_empty_text);
            mLoadingStr = a.getString(R.styleable.LoadingLayout_loading_layout_loading_text);
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        int childCount = getChildCount();
        if (childCount == 0) {
            throw new IllegalStateException("LoadingLayout can host only one direct child");
        }

        if (childCount > 1) {
            throw new IllegalStateException("LoadingLayout can host only one direct child");
        }

        mMainPage = getChildAt(0);
        mMainPage.setVisibility(GONE);

        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        loadingPage = inflater.inflate(R.layout.layout_loading, null);
        errorPage = inflater.inflate(R.layout.layout_error, null);
        emptyPage = inflater.inflate(R.layout.layout_empty, null);

        loadingText = (TextView) loadingPage.findViewById(R.id.loading_text);

        errorImg = (ImageView) errorPage.findViewById(R.id.imageView1);
        errorText = (TextView) errorPage.findViewById(R.id.error_text);

        emptyImg = (ImageView) emptyPage.findViewById(R.id.imageView1);
        emptyText = (TextView) emptyPage.findViewById(R.id.empty_text);

        if (mLoadingStr != null) {
            loadingText.setText(mLoadingStr);
        }

        if (mErrorResId != 0) {
            errorImg.setImageResource(mErrorResId);
        }

        if (mErrorStr != null) {
            errorText.setText(mErrorStr);
        }

        if (mEmptyResId != 0) {
            emptyImg.setImageResource(mEmptyResId);
        }

        if (mEmptyStr != null) {
            emptyText.setText(mEmptyStr);
        }

        this.addView(loadingPage);
        this.addView(errorPage);
        this.addView(emptyPage);

        loadingPage.setVisibility(GONE);
        errorPage.setVisibility(GONE);
        emptyPage.setVisibility(GONE);
    }

    public void setErrorImg(int errorResId) {
        if (errorResId != 0) {
            errorImg.setImageResource(errorResId);
            this.mErrorResId = errorResId;
        }
    }

    public void setEmptyImg(int emptyResId) {
        if (emptyResId != 0) {
            emptyImg.setImageResource(emptyResId);
            this.mEmptyResId = emptyResId;
        }
    }

    public void setErrorText(String errorStr) {
        if (!TextUtils.isEmpty(errorStr)) {
            errorText.setText(errorStr);
            this.mErrorStr = errorStr;
        }
    }

    public void setEmptyText(String emptyStr) {
        if (!TextUtils.isEmpty(emptyStr)) {
            emptyText.setText(emptyStr);
            this.mEmptyStr = emptyStr;
        }
    }

    public void setLoadingText(String loadingStr) {
        if (!TextUtils.isEmpty(loadingStr)) {
            loadingText.setText(loadingStr);
            this.mLoadingStr = loadingStr;
        }
    }

    public void showLoading() {
        loadingPage.setVisibility(VISIBLE);
        errorPage.setVisibility(GONE);
        emptyPage.setVisibility(GONE);
        mMainPage.setVisibility(GONE);
    }

    public void showError() {
        loadingPage.setVisibility(GONE);
        errorPage.setVisibility(VISIBLE);
        emptyPage.setVisibility(GONE);
        mMainPage.setVisibility(GONE);
    }

    public void showEmpty() {
        loadingPage.setVisibility(GONE);
        errorPage.setVisibility(GONE);
        emptyPage.setVisibility(VISIBLE);
        mMainPage.setVisibility(GONE);
    }

    public void showMain() {
        loadingPage.setVisibility(GONE);
        errorPage.setVisibility(GONE);
        emptyPage.setVisibility(GONE);
        mMainPage.setVisibility(VISIBLE);
    }

    /**
     * 设置Error点击事件
     *
     * @param listener
     */
    public void setErrorClickListener(OnClickListener listener) {
        if (listener != null) {
            findViewById(R.id.btn_retry).setOnClickListener(listener);
        }
    }

}
