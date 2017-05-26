package com.sby.practice.ui.aty.mapFunction;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.sby.practice.R;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.utils.BaiduMapUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sby.constant.Constant.latlngs;
import static com.sby.utils.BaiduMapUtils.getAngle;

/**
 * 回放
 */
public class TrackPlayBackActivity extends BaseActivity
{

    @BindView(R.id.activity_track_play_back_tb_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_track_play_back_mv_mapview)
    MapView mv_mapview;

    private BaiduMap mBaiduMap;
    private Polyline mPolyline;
    private Marker mMoveMarker;

    private Activity activity = TrackPlayBackActivity.this;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_play_back);
        ButterKnife.bind(this);

        mBaiduMap = mv_mapview.getMap();
        initWidget(savedInstanceState);
    }

    /**
     * 初始化控件
     */
    private void initWidget(Bundle savedInstanceState)
    {
        mv_mapview.onCreate(this, savedInstanceState);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BaiduMapUtils.moveToLatlng(mBaiduMap, latlngs[0], 15f);
        drawPolyLine();
        mHandler = new Handler(Looper.getMainLooper());
    }

    private void drawPolyLine()
    {

        // 根据点，定义地图折线覆盖物
        List<LatLng> polylines = new ArrayList<>();
        for (int index = 0; index < latlngs.length; index++)
        {
            polylines.add(latlngs[index]);
        }
        PolylineOptions polylineOptions = new PolylineOptions().points(polylines).width(10).color(Color.RED);

        mPolyline = (Polyline) mBaiduMap.addOverlay(polylineOptions);
        OverlayOptions markerOptions;
        markerOptions = new MarkerOptions().flat(true).anchor(0.5f, 0.5f)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_arrow)).position(polylines.get(0))
                .rotate((float) getAngle(0, mPolyline));
        mMoveMarker = (Marker) mBaiduMap.addOverlay(markerOptions);
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

    @Override
    protected void onResume()
    {
        super.onResume();
        BaiduMapUtils.moveLooper(mMoveMarker, mv_mapview, mHandler, latlngs);
        mv_mapview.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mv_mapview.onPause();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        mv_mapview.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mv_mapview.onDestroy();
        mBaiduMap.clear();
    }
}
