package com.sby.practice.ui.aty.test;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.baidu.mapapi.map.offline.MKOLSearchRecord;
import com.baidu.mapapi.map.offline.MKOLUpdateElement;
import com.baidu.mapapi.map.offline.MKOfflineMap;
import com.baidu.mapapi.map.offline.MKOfflineMapListener;
import com.sby.practice.R;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.utils.Logger;
import com.sby.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kowal on 2017/4/28.
 */

public class TestActivity2 extends BaseActivity implements MKOfflineMapListener
{
    @BindView(R.id.bt_download)
    Button bt_download;
    @BindView(R.id.bt_city)
    Button bt_city;
    @BindView(R.id.ll_top)
    LinearLayout ll_top;
    @BindView(R.id.ll_loading)
    LinearLayout ll_loading;
    @BindView(R.id.ll_list)
    LinearLayout ll_list;
    @BindView(R.id.rv_downloading)
    RecyclerView rv_downloading;
    @BindView(R.id.rv_complate)
    RecyclerView rv_complate;
    @BindView(R.id.rv_zhixia)
    RecyclerView rv_zhixia;
    @BindView(R.id.rv_cites)
    CustomExpandableListView rv_cites;

    Activity activity = TestActivity2.this;
    private MKOfflineMap mOffline = null;
    AdapterZhiXia zXAdapter;
    AdapterAllMapELV allAdapter;
    private ArrayList<MKOLSearchRecord> citys; // 小城市
    private ArrayList<MKOLSearchRecord> zhiXiaCitys; // 直辖市

    private AdapterLocalMap localAdapter;
    private AdapterDownloading loadingAdapter;
    private ArrayList<MKOLUpdateElement> localMapList; //已下载的离线地图信息列表
    private MKOLUpdateElement update;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);
        initWidget();
        setLoading();
        setAction();
    }

    private void initWidget()
    {
        mOffline = new MKOfflineMap();
        mOffline.init(this);
        // 下载管理列表
        rv_downloading.setLayoutManager(new LinearLayoutManager(activity));
        rv_downloading.setNestedScrollingEnabled(false);
        rv_complate.setLayoutManager(new LinearLayoutManager(activity));
        rv_complate.setNestedScrollingEnabled(false);

        // 城市列表
        ArrayList<MKOLSearchRecord> allCitys = mOffline.getOfflineCityList(); // 所有城市
        zhiXiaCitys = new ArrayList<>(); // 直辖市
        citys = new ArrayList<>(); // 省
        if (allCitys != null)
        {
            for (MKOLSearchRecord mr : allCitys)
            {
                if (mr.cityType == 1) // 0:全国；1：省份；2：城市,如果是省份，可以通过childCities得到子城市列表
                {
                    citys.add(mr);
                } else
                {
                    zhiXiaCitys.add(mr);
                }
            }
            rv_cites.setGroupIndicator(null);
            allAdapter = new AdapterAllMapELV(activity, citys);
            rv_cites.setAdapter(allAdapter);
            Drawable drawable = getResources().getDrawable(R.color.gray);
            rv_cites.setChildDivider(drawable);

            rv_zhixia.setLayoutManager(new LinearLayoutManager(activity));
            rv_zhixia.setNestedScrollingEnabled(false);
            zXAdapter = new AdapterZhiXia(activity, zhiXiaCitys);
            rv_zhixia.setAdapter(zXAdapter);
        } else
        {
            ToastUtil.toast("网络错误");
        }

        // 已下载
//        ArrayList<MKOLSearchRecord> list = mOffline.getOfflineCityList();
//        localAdapter = new AdapterLocalMap(activity, list);
//        rv_complate.setAdapter(localAdapter);
//        setComplete();
    }

    private void setAction()
    {
        // 直辖市下载
        zXAdapter.setOnItemClickLitener(new AdapterZhiXia.OnClickListener()
        {
            @Override
            public void onClickDownload(View view, MKOLSearchRecord msr)
            {
                mOffline.start(msr.cityID);
                ToastUtil.toast("已添加到下载任务" + msr.cityName);
                setLoading();
            }
        });
        // 父节点下载全部
        allAdapter.setOnGroupDown(new AdapterAllMapELV.OnGroupDown()
        {
            @Override
            public void groupDown(View view, int groupPosition, MKOLSearchRecord msr)
            {
                mOffline.start(msr.cityID);
                ToastUtil.toast("已添加到下载任务" + msr.cityName);
                setLoading();
//                allAdapter.onGroupExpanded();
            }
        });
        // 子节点下载
        allAdapter.setOnClildDown(new AdapterAllMapELV.OnChildDown()
        {
            @Override
            public void childDown(View view, int groupPosition, int childPosition, MKOLSearchRecord msr)
            {
                mOffline.start(msr.cityID);
                ToastUtil.toast("已添加到下载任务" + msr.cityName);
                setLoading();
            }
        });
        // 删除
        loadingAdapter.onDelClick(new AdapterDownloading.DelDownload()
        {
            @Override
            public void del(int cityId, int position)
            {
                Logger.e("在Activity里点击的是" , cityId + "");
                mOffline.remove(cityId);
                setLoading();
            }
        });
        // 开始
        loadingAdapter.onStartClick(new AdapterDownloading.StartDownload()
        {
            @Override
            public void start(int position, int cityId)
            {
                mOffline.start(cityId);
                loadingAdapter.notifyItemChanged(position);
//                setLoading();
            }
        });
        // 暂停
        loadingAdapter.onStopClick(new AdapterDownloading.StopDownload()
        {
            @Override
            public void stop(int position, int cityId)
            {
                mOffline.pause(cityId);
                loadingAdapter.notifyItemChanged(position);
            }
        });
    }

    public void setLoading()
    {
        localMapList = mOffline.getAllUpdateInfo();
        if (localMapList == null)
        {
            localMapList = new ArrayList<>();
        }
        loadingAdapter = new AdapterDownloading(activity, localMapList);
        rv_downloading.setAdapter(loadingAdapter);
        loadingAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.bt_download, R.id.bt_city})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_download:
                ll_list.setVisibility(View.GONE);
                ll_loading.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_city:
                ll_loading.setVisibility(View.GONE);
                ll_list.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onGetOfflineMapState(int type, int state)
    {
        switch (type)
        {
            case MKOfflineMap.TYPE_DOWNLOAD_UPDATE:
            {
                loadingAdapter.notifyDataSetChanged();
                update = mOffline.getUpdateInfo(state);
                // 处理下载进度更新提示
                if (update.status == 10 || update.status == 4 || update.ratio ==100 || update.serversize == update.size) // 安装完成
                {
                    loadingAdapter.removeData(type);
                } else
                {
                    loadingAdapter.onUpdateUi(type, update);
                }
            }
            break;
            case MKOfflineMap.TYPE_NEW_OFFLINE:
                // 有新离线地图安装
                Log.d("OfflineDemo", String.format("add offlinemap num:%d", state));
                break;
            case MKOfflineMap.TYPE_VER_UPDATE:
                // 版本更新提示
                // MKOLUpdateElement e = mOffline.getUpdateInfo(state);
                Logger.e("A", "A");
                break;
            default:
                break;
        }
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mOffline.destroy();
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }


}
