package com.sby.practice.ui.aty.favorite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.baidu.mapapi.favorite.FavoriteManager;
import com.baidu.mapapi.favorite.FavoritePoiInfo;
import com.sby.practice.R;
import com.sby.practice.adapter.FavoriteAdapter;
import com.sby.practice.ui.aty.MainActivity;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.widget.divider.DividerGridItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的收藏
 */
public class FavoActivity extends BaseActivity
{

    @BindView(R.id.activity_favo_address_tb_toolbar) // 标题栏
            Toolbar mToolbar;
    @BindView(R.id.activity_favo_address_rv_list)
    RecyclerView rv_list;
//    @BindView(R.id.activity_favo_address_bt_add) // 新增
//            Button bt_add;
    @BindView(R.id.activity_favo_address_tv_delAll) // 删除全部
            TextView tv_delAll;

    private Activity activity = FavoActivity.this;
    private FavoriteAdapter mAdapter;

    private List<FavoritePoiInfo> list; // 收藏list

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favo);
        ButterKnife.bind(this);

        FavoriteManager.getInstance().init(); // 初始化收藏夹
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
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setItemAnimator(new DefaultItemAnimator());// 设置item动画
        rv_list.addItemDecoration(new DividerGridItemDecoration(this));
    }

    /**
     * 加载数据
     */
    private void loadData()
    {
        list = FavoriteManager.getInstance().getAllFavPois();
        mAdapter = new FavoriteAdapter(activity, list);
        rv_list.setAdapter(mAdapter);
    }

    private void setAction()
    {
        mAdapter.setOnItemClickLitener(new FavoriteAdapter.FavoAdapterClick()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                startActivity(new Intent(activity, MainActivity.class)
                        .putExtra("locationInfo", list.get(position).getID()));
            }

            @Override
            public void onDelClick(View view, String currentId)
            {
                deleteOneClick(currentId);
            }
        });
    }

    /**
     * 点击事件
     */
    @OnClick({
//            R.id.activity_favo_address_bt_add,
            R.id.activity_favo_address_tv_delAll})
    public void onClick(View v)
    {
        switch (v.getId())
        {
//            case R.id.activity_favo_address_bt_add:
//                startActivity(new Intent(this, FavoAddActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                break;
            case R.id.activity_favo_address_tv_delAll:
                delFavo();
                break;
        }

    }

    /**
     * 删除一个指定点
     */
    private void deleteOneClick(String currentId)
    {
        if (FavoriteManager.getInstance().deleteFavPoi(currentId))
        {
            showToast("删除点成功");
            mAdapter.notifyDataSetChanged();
        } else
        {
            showToast("删除点失败");
        }
    }

    /**
     * 删除所有收藏的点
     */
    private void delFavo()
    {
        if (FavoriteManager.getInstance().clearAllFavPois())
        {
            showToast("全部删除成功");
            list = FavoriteManager.getInstance().getAllFavPois();
            mAdapter = new FavoriteAdapter(activity, list);
            rv_list.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        } else
        {
            showToast("删除失败，请稍后再试");
        }
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
                ActivityCollector.removeActivity(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
