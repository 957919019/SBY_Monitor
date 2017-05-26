package com.sby.practice.ui.aty.search;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.sby.practice.R;
import com.sby.practice.adapter.SearchResultAdapter;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.widget.divider.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 搜索结果
 */
public class SearchResultActivity extends BaseActivity
//        implements SearchResultAdapter.SearchResultClick
{
    @BindView(R.id.activity_search_result_tr_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_search_result_tr_toolbar_rv_list)
    RecyclerView rv_list;
    @BindView(R.id.activity_search_result_tr_toolbar_sr_refreshLayout)
    SwipeRefreshLayout sr_refreshLayout;

    private Activity activity = SearchResultActivity.this;
    private SearchResultAdapter mAdapter;
    private String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_result);
        ButterKnife.bind(this);

        keyword = getIntent().getStringExtra("keywords");
        initWidget();
        initData();
    }

    /**
     * 初始化控件
     */
    private void initWidget()
    {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.HORIZONTAL_LIST));
        rv_list.setItemAnimator(new DefaultItemAnimator());// 设置item动画
    }

    /**
     * 初始化数据
     */
    private void initData()
    {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            list.add("第" + i + "架飞机");
        }
        mAdapter = new SearchResultAdapter(activity, list);
        rv_list.setAdapter(mAdapter);

        mAdapter.setOnItemClickLitener(new SearchResultAdapter.SearchResultClick()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                showToast("当前点击了第---" + position + "架") ;
//                startActivity(new Intent(activity, MainActivity.class).putExtra("latutd", "asda").addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
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
                activity.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
