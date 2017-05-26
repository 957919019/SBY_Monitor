package com.sby.utils.keyboardCtr;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 键盘工具类
 * Created by kowal on 2016/11/25.
 */

public class KeyboardUtils
{
    /**
     * 打开
     */
    public static void openKeyboard(Context context, View editText)
    {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(editText, 0);
    }

    public static void closeKeyboard(Context context, View editText)
    {
        InputMethodManager inputMethodManager
                = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static void openKey(Activity activity)
    {
        InputMethodManager m=(InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);


    }
}
