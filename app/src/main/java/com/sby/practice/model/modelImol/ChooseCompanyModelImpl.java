package com.sby.practice.model.modelImol;

import android.content.Context;

import com.sby.constant.API;
import com.sby.http.HttpRequestCallback;
import com.sby.http.OkHttpUtils;
import com.sby.practice.model.ChooseCompanyModel;
import com.sby.utils.ACache;

/**
 * 获取公司列表
 * Created by kowal on 2016/12/14.
 */

public class ChooseCompanyModelImpl implements ChooseCompanyModel
{
    ACache mCache;

    /**
     * 获取公司列表
     *
     * @param context
     */
    @Override
    public void getCompanyList(Context context, HttpRequestCallback callBack)
    {
        mCache = ACache.get(context);
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        okHttpUtils.get(context, API.GETCOMNAME, callBack);
    }
}
