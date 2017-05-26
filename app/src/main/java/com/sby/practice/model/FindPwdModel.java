package com.sby.practice.model;

import android.content.Context;

import com.sby.http.HttpRequestCallback;

/**
 * Created by kowal on 2016/12/4.
 */

public interface FindPwdModel
{
    /**
     * 获取验证码
     * @param context
     * @param phone
     * @param callback
     */
    void ongetVCode(Context context, String phone,HttpRequestCallback callback);

    /**
     * 找回密码
     * @param context
     * @param phone
     * @param vCode
     * @param pwd
     * @param callback
     */
    void onFindPwd(Context context, String phone, String vCode, String pwd, HttpRequestCallback callback);
}
