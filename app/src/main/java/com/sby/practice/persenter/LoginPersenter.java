package com.sby.practice.persenter;

import android.content.Context;

/**
 * 登录persenter接口接口
 * Created by kowal on 2016/11/21.
 */

public interface LoginPersenter
{
    /**
     * 登录
     */
    void signIn(Context context, String coName, String pwd);
}
