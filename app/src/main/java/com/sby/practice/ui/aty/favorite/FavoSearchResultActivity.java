package com.sby.practice.ui.aty.favorite;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.baidu.mapapi.search.core.PoiInfo;
import com.sby.practice.R;
import com.sby.practice.adapter.FavoSearchResultAdapter;
import com.sby.practice.ui.aty.MainActivity;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.widget.divider.DividerGridItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoSearchResultActivity extends BaseActivity
{

    @BindView(R.id.activity_favo_search_result_tb_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_favo_search_result_rv_list)
    RecyclerView rv_list;

    private FavoSearchResultAdapter mAdapter;
    private Activity activity = FavoSearchResultActivity.this;
    private List<PoiInfo> infoList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favo_search_result);
        ButterKnife.bind(this);

        initWidget();
        loadData();
        setAction();
    }

    /**
     * 初始化控件
     */
    private void initWidget()
    {
        //toolbar的控件
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Toolbar掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setItemAnimator(new DefaultItemAnimator());// 设置item动画
        rv_list.addItemDecoration(new DividerGridItemDecoration(this));
    }

    /**
     * 赋值
     */
    private void loadData()
    {
        // 接受查询的结果
        infoList = (List<PoiInfo>) getIntent().getSerializableExtra("result");
        mAdapter = new FavoSearchResultAdapter(activity, infoList);
        rv_list.setAdapter(mAdapter);
    }

    /**y
     * 点击事件
     */
    public void setAction()
    {
        mAdapter.setOnItemClickListener(new FavoSearchResultAdapter.OnSearchResultItemCL()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                // 跳转地图对应的点
                startActivity(new Intent(activity, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                .putExtra("location", (Parcelable) infoList.get(position).location ),
                        ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
            }
        });
    }

    /**
     * 标题栏动作
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                ActivityCollector.removeActivity(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}