package com.sby.utils;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by kowal on 2017/5/16.
 */
public class AnimUtils
{
    /**
     * 从下往上动画
     */
    public static TranslateAnimation showAnim()
    {
        TranslateAnimation mShowAction = new TranslateAnimation
                (Animation.RELATIVE_TO_SELF, 0.0f,
                        Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                        1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(500);
        return mShowAction;
    }

    /**
     * 从上往下动画
     */
    public static TranslateAnimation goneAnim()
    {
        TranslateAnimation mHiddenAction = new TranslateAnimation
                (Animation.RELATIVE_TO_SELF,
                        0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                        Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                        1.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;
    }
}
