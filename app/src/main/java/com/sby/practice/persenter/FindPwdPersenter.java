package com.sby.practice.persenter;

import android.content.Context;

/**
 * Created by kowal on 2016/12/4.
 */

public interface FindPwdPersenter
{
    /**
     * 获取验证码
     */
    void getVCode(Context context , String phone);

    /**
     * 找回密码
     */
    void onFindPwd(Context context , String phone, String code, String pwd);
}
