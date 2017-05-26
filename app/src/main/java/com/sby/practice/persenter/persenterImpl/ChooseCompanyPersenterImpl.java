package com.sby.practice.persenter.persenterImpl;

import android.content.Context;

import com.sby.bean.user.Company;
import com.sby.bean.core.ResultBean;
import com.sby.http.HttpException;
import com.sby.http.HttpRequestCallback;
import com.sby.practice.model.ChooseCompanyModel;
import com.sby.practice.model.modelImol.ChooseCompanyModelImpl;
import com.sby.practice.persenter.ChooseCompanyPersenter;
import com.sby.practice.ui.view.ChooseCompanyView;

import java.util.List;

import okhttp3.Call;

/**
 * Created by kowal on 2016/12/14.
 */

public class ChooseCompanyPersenterImpl implements ChooseCompanyPersenter
{
    private ChooseCompanyView mView;
    private ChooseCompanyModel mModel;

    public ChooseCompanyPersenterImpl(ChooseCompanyView mView)
    {
        this.mView = mView;
        this.mModel = new ChooseCompanyModelImpl();
    }

    // 获取公司列表
    @Override
    public void getCompanyList(Context context)
    {
        mModel.getCompanyList(context, new HttpRequestCallback<ResultBean<List<Company>>>()
        {
            @Override
            public void onStart()
            {
                mView.showPro();
            }

            @Override
            public void onFinish()
            {
                mView.disPro();
            }

            @Override
            public void onResponse(ResultBean<List<Company>> listResultBean)
            {
                mView.disPro();
                mView.setCompany(listResultBean.getData());
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                mView.showTip(e.getMessage());
                mView.disPro();
            }
        });

    }
}
