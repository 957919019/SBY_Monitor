package com.sby.practice.ui.aty.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.sby.bean.user.Company;
import com.sby.practice.R;
import com.sby.practice.adapter.ChooseCoAdapter;
import com.sby.practice.persenter.ChooseCompanyPersenter;
import com.sby.practice.persenter.persenterImpl.ChooseCompanyPersenterImpl;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.practice.ui.view.ChooseCompanyView;
import com.sby.widget.divider.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择公司
 * Created by kowal on 2016/11/2.
 */

public class ChooseCompany extends BaseActivity implements AdapterView.OnItemClickListener, ChooseCoAdapter.ChooseCoAdapterClick, ChooseCompanyView
{
    private Activity activity = ChooseCompany.this;

    private Toolbar mToolbar;
    private AutoCompleteTextView actv_coName;
    private RecyclerView rv_coList;
    private ChooseCoAdapter cAdapter;
    private ArrayAdapter aAdapter;

    private ChooseCompanyPersenter mPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_company);
        initWidget();
        mPersenter.getCompanyList(activity);
    }

    private void initWidget()
    {
        //toolbar的控件
        mToolbar = (Toolbar) findViewById(R.id.activity_choose_company_tb_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPersenter = new ChooseCompanyPersenterImpl(this);

        actv_coName = (AutoCompleteTextView) findViewById(R.id.activity_choose_company_actv_coName);
        rv_coList = (RecyclerView) findViewById(R.id.activity_choose_company_rv_coList);
        rv_coList.setLayoutManager(new LinearLayoutManager(activity));
        rv_coList.setHasFixedSize(true);
        rv_coList.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.HORIZONTAL_LIST));
        rv_coList.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * 下拉列表选中事件
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        String coName = parent.getItemAtPosition(position).toString();
        setResult(RESULT_OK, new Intent().putExtra("resultName", coName));
        ActivityCollector.removeActivity(activity);
    }

    /**
     * RecyclerView的列表点击事件
     *
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position)
    {
        String coName = cAdapter.getItem(position);
        setResult(RESULT_OK, new Intent().putExtra("resultName", coName ));
        ActivityCollector.removeActivity(activity);
    }

    /**
     * 标题栏动作
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                ActivityCollector.removeActivity(activity);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 按下返回键
     */
    @Override
    public void onBackPressed()
    {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }

    /**
     * 赋值
     */
    @Override
    public void setCompany( List<Company> companyList)
    {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < companyList.size(); i++)
        {
            list.add(companyList.get(i).getCompanyName());
        }
        // 下拉菜单的适配器
        aAdapter = new ArrayAdapter(activity, R.layout.item_actv_company_adapter, list);
        actv_coName.setAdapter(aAdapter);
        actv_coName.setOnItemClickListener(this);

        // ListView的适配器
        cAdapter = new ChooseCoAdapter(activity, companyList);
        rv_coList.setAdapter(cAdapter);
        cAdapter.setOnItemClickLitener(this);
    }

    @Override
    public void showTip(String str)
    {
        showToast(str);
    }

    @Override
    public void showPro()
    {
        showProgress(activity, "请稍后...");
    }

    @Override
    public void disPro()
    {
        disProgress();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (mPersenter != null)
        {
            mPersenter = null;
        }
    }
}
