package com.sby.practice.ui.aty.otherservice;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.alibaba.fastjson.JSON;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.sby.bean.other.QingBaoBean;
import com.sby.constant.API;
import com.sby.constant.Constant;
import com.sby.practice.R;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.utils.FormatUtils;
import com.sby.utils.ScreenUtils;
import com.sby.utils.ToastUtil;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.sby.constant.Constant.ZOOM_LEVEL;

public class QingBao extends AppCompatActivity
{

    @BindView(R.id.mv_mapview)
    MapView mv_mapview;
    @BindView(R.id.tb_toolbar)
    Toolbar tb_toolbar;

    private BaiduMap mBaiduMap;
    private UiSettings mUiSettings;
    private Activity activity = QingBao.this;
    private Marker mFltMarker;
    private BitmapDescriptor ic_flt = BitmapDescriptorFactory.fromResource(R.mipmap.nic_flt_park);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qing_bao);
        ButterKnife.bind(this);

        initWidget();
        getData();
    }

    private void initWidget()
    {
        setSupportActionBar(tb_toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mBaiduMap = mv_mapview.getMap();
        mUiSettings = mBaiduMap.getUiSettings();
        mv_mapview.setLogoPosition(LogoPosition.logoPostionleftTop); // 设置Logo方位
        mBaiduMap.setViewPadding(0, 20, 20, 0); // LOGO边距
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.zoomTo(ZOOM_LEVEL));// 设置地图默认缩放级别
        mBaiduMap.showMapPoi(true);// 显示底图标注
        mUiSettings.setOverlookingGesturesEnabled(false);// 启用俯视手势
        mv_mapview.getChildAt(2).setPadding(100, 0, ScreenUtils.getScreenWidth(activity) - 250, 100);
    }

    private void getData()
    {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), "");
        Request requestPostFile = new Request.Builder().url(Constant.uri + API.AIR_PORT).post(body).build();
        client.newCall(requestPostFile).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException
            {
                String str = response.body().string();
                final QingBaoBean qbBean = JSON.parseObject(str, QingBaoBean.class);
                if ("success".equals(qbBean.getState()))
                {
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                if (qbBean.getData() != null)
                                {
                                    setQingBao(qbBean.getData());
                                }

                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    });
                } else
                {
                    ToastUtil.topToast(activity, "查询数据失败\n请稍后重试");
                }

            }
        });
    }

    private void setQingBao(List<QingBaoBean.DataBean> data)
    {
        LatLng latlng = null;
        for (int i = 0; i < data.size(); i++)
        {
            double lat = FormatUtils.strToDouble(data.get(i).getLaTitude());
            double lon = FormatUtils.strToDouble(data.get(i).getLongTitude());

            latlng = new LatLng(lat, lon);
            MarkerOptions mo = new MarkerOptions().position(latlng).icon(ic_flt).zIndex(3).draggable(false);
            mFltMarker = (Marker) (mBaiduMap.addOverlay(mo));
        }
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        mv_mapview.onResume();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mv_mapview.onDestroy();
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
