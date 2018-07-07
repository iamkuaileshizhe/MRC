package com.neocom.mobilerefueling.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class KeyBoardUtil {

    private static final String TAG = KeyBoardUtil.class.getSimpleName();

    private KeyBoardUtil() {
    }

    /**
     * 强制显示输入法
     */
    @SuppressWarnings("unused")
    public static void show(Activity activity) {
        try {
            show(activity.getWindow().getCurrentFocus());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static void show(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    /**
     * 强制关闭输入法
     */
    public static void hide(Activity activity) {
        if (null==activity) {
            Log.e(TAG, "Exception:~~~~~~~~~~~~~~~~ activity is null");
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        hide(activity.getWindow().getCurrentFocus());
    }

    private static void hide(View view) {
        try {
            InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (NullPointerException e) {
            e.printStackTrace();

        }
    }

    /**
     * 如果输入法已经显示，那么就隐藏它；如果输入法现在没显示，那么就显示它
     */
    @SuppressWarnings("unused")
    public static void toggle(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 切换为英文输入模式
     */
    @SuppressWarnings("unused")
    public static void changeToEnglishInputType(EditText editText) {
        editText.setInputType(EditorInfo.TYPE_TEXT_VARIATION_URI);
    }

    /**
     * 切换为中文输入模式
     */
    @SuppressWarnings("unused")
    public static void changeToChineseInputType(EditText editText) {
        editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
    }

    /**
     * 监听输入法的回车按键
     */
    @SuppressWarnings("unused")
    public static void setEnterKeyListener(EditText editText, final View.OnClickListener listener) {
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    listener.onClick(v);
                    return true;
                }
                return false;
            }
        });
    }
}
