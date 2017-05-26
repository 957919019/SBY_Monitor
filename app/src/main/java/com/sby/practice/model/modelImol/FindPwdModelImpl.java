package com.sby.practice.model.modelImol;

import android.content.Context;

import com.sby.constant.API;
import com.sby.http.HttpRequestCallback;
import com.sby.http.OkHttpUtils;
import com.sby.http.RequestParams;
import com.sby.practice.model.FindPwdModel;
import com.sby.utils.ACache;

/**
 * 找回密码实现类
 * Created by kowal on 2016/12/4.
 */

public class FindPwdModelImpl implements FindPwdModel
{
    ACache mCache;

    /**
     * 获取验证码
     *
     * @param context
     * @param phone
     * @param callBack
     */
    @Override
    public void ongetVCode(Context context, String phone, HttpRequestCallback callBack)
    {
        RequestParams params = new RequestParams();
        params.put("phone", phone);

        mCache = ACache.get(context);
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        okHttpUtils.post(context, API.VALIDATION_CODE, params, callBack);
    }

    /**
     * 找回密码
     *
     * @param context
     * @param phone
     * @param vCode
     * @param pwd
     * @param callBack
     */
    @Override
    public void onFindPwd(Context context, String phone, String vCode, String pwd, HttpRequestCallback callBack)
    {
        RequestParams params = new RequestParams();
        params.put("phone", phone);
        params.put("vCode", vCode);
        params.put("pwd", pwd);

        mCache = ACache.get(context);
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        okHttpUtils.post(context, API.FINDPWD, params, callBack);
    }
}
