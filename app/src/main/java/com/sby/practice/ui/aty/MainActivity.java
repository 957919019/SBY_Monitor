package com.sby.practice.ui.aty;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.favorite.FavoriteManager;
import com.baidu.mapapi.favorite.FavoritePoiInfo;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;
import com.sby.bean.area.AreaReport;
import com.sby.bean.area.ChooseFlt;
import com.sby.bean.area.FixedAirSpace;
import com.sby.bean.flt.MovFlt;
import com.sby.bean.flt.POINTS;
import com.sby.bean.monitor.Data;
import com.sby.bean.other.FlightInfo;
import com.sby.constant.Constant;
import com.sby.constant.GlobalVariable;
import com.sby.practice.R;
import com.sby.practice.persenter.MainPersenter;
import com.sby.practice.persenter.persenterImpl.MainPersenterImpl;
import com.sby.practice.ui.aty.favorite.FavoActivity;
import com.sby.practice.ui.aty.mapFunction.TrackPlayBackActivity;
import com.sby.practice.ui.aty.me.MeActivity;
import com.sby.practice.ui.aty.options.Feedback;
import com.sby.practice.ui.aty.options.Help;
import com.sby.practice.ui.aty.options.SettingActivity;
import com.sby.practice.ui.aty.options.StatisticsData;
import com.sby.practice.ui.aty.otherservice.ChaXunActivity;
import com.sby.practice.ui.aty.otherservice.HuLinActivity;
import com.sby.practice.ui.aty.otherservice.QingBao;
import com.sby.practice.ui.aty.otherservice.WeatherActivity;
import com.sby.practice.ui.aty.search.SearchActivity;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.practice.ui.view.MainView;
import com.sby.utils.AnimUtils;
import com.sby.utils.BaiduMapUtils;
import com.sby.utils.ButtonStyleUtils;
import com.sby.utils.FormatUtils;
import com.sby.utils.Logger;
import com.sby.utils.ScreenUtils;
import com.sby.utils.ScreenshotsUtil;
import com.sby.widget.OrientationSensor;
import com.sby.widget.popupWindow.AdapterCatFltPop;
import com.sby.widget.popupWindow.AdapterTypeFltPop;
import com.sby.widget.popupWindow.PopHomeMune;
import com.zcw.togglebutton.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static com.sby.application.MyMapApplication.mOrientationSensor;
import static com.sby.bean.other.FlightInfo.flightInfos;
import static com.sby.constant.Constant.ZOOM_LEVEL;
import static com.sby.practice.R.id.tg_track;
import static com.sby.utils.BaiduMapUtils.moveToLatlng;
import static com.sby.utils.BitmapTransView.getBitmapFromView;
import static com.sby.utils.FormatUtils.strToDouble;

/**
 * 地图主页
 */
public class MainActivity extends BaseActivity implements MainView, ButtonEventListener, OnGetGeoCoderResultListener, NavigationView.OnNavigationItemSelectedListener
{
    @BindView(R.id.tb_toolbar)
    Toolbar tb_toolbar;
    @BindView(R.id.mv_mapview)
    MapView mv_mapview;
    @BindView(R.id.bt_quyu)
    Button bt_quyu;
    @BindView(R.id.bt_choose)
    Button bt_choose;
    @BindView(R.id.bt_my)
    Button bt_my;
    @BindView(R.id.iv_munu)
    ImageView iv_munu;
    @BindView(R.id.aeb_mune)
    AllAngleExpandableButton aeb_mune;
    @BindView(R.id.llc_fltInfo)
    LinearLayoutCompat llc_fltInfo;
    @BindView(R.id.et_coordinate)
    EditText et_coordinate;
    @BindView(R.id.tv_flt_longitude)
    TextView tv_flt_longitude;
    @BindView(R.id.tv_flt_latitude)
    TextView tv_flt_latitude;
    @BindView(R.id.tv_share)
    TextView tv_share;
    @BindView(R.id.tv_favorite)
    TextView tv_favorite;
    @BindView(R.id.llc_collectionsView)
    LinearLayoutCompat llc_collectionsView;
    @BindView(R.id.llc_playback)
    LinearLayoutCompat llc_playback;
    @BindView(R.id.tv_chooseTime)
    TextView tv_chooseTime;
    @BindView(R.id.bt_playback)
    Button bt_playback;
    @BindView(R.id.cb_baogaodian)
    CheckBox cb_baogaodian;
    @BindView(R.id.cb_gudiankongyu)
    CheckBox cb_gudiankongyu;
    @BindView(R.id.cb_hulinAirLine)
    CheckBox cb_hulinAirLine;
    @BindView(R.id.cb_nonghuaAirport)
    CheckBox cb_nonghuaAirport;
    @BindView(R.id.cb_hulinAirPort)
    CheckBox cb_hulinAirPort;
    @BindView(R.id.cb_minhangAirport)
    CheckBox cb_minhangAirport;
    @BindView(R.id.cb_jinfei)
    CheckBox cb_jinfei;
    @BindView(R.id.cb_jiayou)
    CheckBox cb_jiayou;
    @BindView(R.id.cb_minhangAirLine)
    CheckBox cb_minhangAirLine;
    @BindView(R.id.llc_quyu)
    LinearLayoutCompat llc_quyu;
    @BindView(R.id.llc_choose)
    LinearLayoutCompat llc_choose;
    @BindView(R.id.rv_catalog)
    RecyclerView rv_catalog;
    @BindView(R.id.rv_type)
    RecyclerView rv_type;
    @BindView(R.id.nv_view)
    NavigationView nv_view;
    @BindView(R.id.dl_layout)
    DrawerLayout dl_layout;
    private LinearLayout ll_tb_all;

    private Activity activity = MainActivity.this;
    private MainPersenter mainPersenter;
    private BaiduMap mBaiduMap;
    private UiSettings mUiSettings; // 控制地图UI
    private Integer first = 0; // 第一次动态请求飞机数据

    private View movingView;
    private TextView tv_movingRemarks;
    private ImageView iv_movingPhoto;
    // 地图定位
    private LocationClient mLocClient;
    public MyLocationListenner myListener = new MyLocationListenner();
    private boolean isFirst = true; // 第一次定位

    GeoCoder mSearch = null; // 搜索模块，也可去掉地图模块独立使用
    private InfoWindow mInfoWindow;
    private boolean press = true; // 根据按下的状态切换地图模式

    private List<ChooseFlt> chooseFltList;
    private AdapterCatFltPop catAdapter;
    private AdapterTypeFltPop typeAdapter;

    /******************************飞机图标********************************/
    private Marker mFltMarker;
    private BitmapDescriptor ic_fltBlue = BitmapDescriptorFactory
            .fromResource(R.mipmap.nic_flt_bule);
    private BitmapDescriptor ic_fltylw = BitmapDescriptorFactory
            .fromResource(R.mipmap.nic_flt_yellow);
    Polyline movingPolyline = null;// 飞机运行的航线
    /******************************长按的点********************************/
    private Marker mLongPressMarker; // 长按的点
    private MarkerOptions mOptions;
    private BitmapDescriptor ic_position = BitmapDescriptorFactory
            .fromResource(R.mipmap.nic_position);
    /******************************收藏的点********************************/
    private LatLng mFavoLatlng;

    private boolean isFirstFlt = false;
    private boolean isRunning = true;
    private String start = "2010-01-01 00:00:00";
    private String end = "2080-01-01 00:00:00";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mv_mapview = new MapView(activity, new BaiduMapOptions());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initWidght();
        initListener();
        new Thread()
        {
            @Override
            public void run()
            {
                super.run();

                while (isRunning)
                {
                    Message msg = Message.obtain(mHandler);
                    msg.what = 11;
                    msg.sendToTarget();
                    try
                    {
                        Thread.sleep(10 * 1000);
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            if (msg.what == 11)
            {
//                mainPersenter.getRelTimeFlt(activity);
                mainPersenter.getMovingFlt(activity, start, end);
            }
        }
    };

    /**
     * 初始化控件
     */
    private void initWidght()
    {
        mBaiduMap = mv_mapview.getMap();
        mUiSettings = mBaiduMap.getUiSettings();
        mv_mapview.setLogoPosition(LogoPosition.logoPostionleftTop); // 设置Logo方位
        mBaiduMap.setViewPadding(0, 20, 20, 0); // LOGO边距
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.zoomTo(ZOOM_LEVEL));// 设置地图默认缩放级别
        mBaiduMap.showMapPoi(true);// 显示底图标注
        mUiSettings.setOverlookingGesturesEnabled(false);// 启用俯视手势
        mv_mapview.getChildAt(2).setPadding(100, 0, ScreenUtils.getScreenWidth(activity) - 250, 100);
        mSearch = GeoCoder.newInstance();// 初始化搜索模块，注册事件监听
        mSearch.setOnGetGeoCodeResultListener(this);
        FavoriteManager.getInstance().init(); // 初始化收藏夹
        mLocClient = new LocationClient(getApplicationContext());// 定位初始化
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        mLocClient.setLocOption(option);
        // 控件初始化
        mainPersenter = new MainPersenterImpl(this);
        nv_view.setNavigationItemSelectedListener(this);
        tb_toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dl_layout.openDrawer(GravityCompat.START);
            }
        });
        setSupportActionBar(tb_toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, dl_layout, tb_toolbar, R.string.drawer_open, R.string.drawer_close);
        dl_layout.addDrawerListener(toggle);
        toggle.syncState();
        ll_tb_all = (LinearLayout) tb_toolbar.findViewById(R.id.ll_tb_all);
        final List<ButtonData> buttonDatas = new ArrayList<>();
        int[] drawable = {R.mipmap.nic_mune_plus, R.mipmap.nic_mune_viewswitched, R.mipmap.nic_mune_locationed, R.mipmap.nic_mune_collected, R.mipmap.nic_mune_shared};
        int[] color = {R.color.blue, R.color.blue, R.color.blue, R.color.blue, R.color.blue};
        for (int i = 0; i < 5; i++)
        {
            ButtonData buttonData;
            if (i == 0)
            {
                buttonData = ButtonData.buildIconButton(this, drawable[i], 0);
                buttonData.setBackgroundColorId(this, color[i]);
            } else
            {
                buttonData = ButtonData.buildIconButton(this, drawable[i], 0);
            }
            buttonDatas.add(buttonData);
        }
        aeb_mune.setButtonDatas(buttonDatas);

        rv_catalog.setHasFixedSize(true);
        rv_catalog.setLayoutManager(new LinearLayoutManager(activity));
        rv_catalog.setItemAnimator(new DefaultItemAnimator());// 设置item动画
        rv_type.setHasFixedSize(true);
        rv_type.setLayoutManager(new LinearLayoutManager(activity));
        rv_type.setItemAnimator(new DefaultItemAnimator());// 设置item动画

        movingView = LayoutInflater.from(activity).inflate(R.layout.item_main_flight_remark, null);
        tv_movingRemarks = (TextView) movingView.findViewById(R.id.item_tv_remarks);
        iv_movingPhoto = (ImageView) movingView.findViewById(R.id.item_iv_image);
    }

    private void initListener()
    {
        ll_tb_all.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(activity, SearchActivity.class));
            }
        });
        aeb_mune.setButtonEventListener(this);
        //地图触摸事件
        mBaiduMap.setOnMapTouchListener(new BaiduMap.OnMapTouchListener()
        {

            @Override
            public void onTouch(MotionEvent event)
            {
                mBaiduMap.hideInfoWindow();
                goneView();
                ButtonStyleUtils.resetButtonStyle(activity, bt_quyu, bt_choose, bt_my);
            }
        });
        // 地图长按事件
        mBaiduMap.setOnMapLongClickListener(new BaiduMap.OnMapLongClickListener()
        {
            public void onMapLongClick(LatLng point)
            {
                if (mLongPressMarker != null)
                {
                    mLongPressMarker.remove();
                }
                mOptions = new MarkerOptions()
                        .position(point)  //设置marker的位置
                        .icon(ic_position) //设置marker图标
                        .zIndex(1)  //设置marker所在层级
                        .draggable(true);  //设置手势拖拽
                Bundle b = new Bundle();
                b.putString("favo", "favo");
                mOptions.extraInfo(b);
                // 将marker添加到地图上
                mLongPressMarker = (Marker) (mBaiduMap.addOverlay(mOptions));
            }
        });
        // marker事件监听
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener()
        {
            @Override
            public boolean onMarkerClick(Marker marker)
            {
                goneView();
                TextView tv = new TextView(getApplicationContext());
                tv.setBackgroundResource(R.mipmap.location_tips);
                tv.setPadding(80, 30, 80, 80);
                tv.setTextColor(getResources().getColor(R.color.white));
                InfoWindow.OnInfoWindowClickListener listener = null;
                if (marker == null)
                {
                    return false;
                } else if (marker.getExtraInfo().getString("id") != null) // 收藏的点的信息
                {
                    InfoWindow mInfoWindow = new InfoWindow(tv, marker.getPosition(), -47);
                    mBaiduMap.showInfoWindow(mInfoWindow);
                    moveToLatlng(mBaiduMap, marker.getPosition(), 15);
                    tv.setText(FavoriteManager.getInstance().getFavPoi(marker.getExtraInfo().getString("id")).getPoiName());
                    return true;
                } else if (marker.getExtraInfo().get("favo") != null) // 长按的点
                {
                    tv.setText("移除");
                    tv.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            mLongPressMarker.remove();
                            mLongPressMarker = null;
                            mBaiduMap.hideInfoWindow();
                            llc_collectionsView.startAnimation(AnimUtils.goneAnim());
                            llc_collectionsView.setVisibility(View.GONE);
                        }
                    });
                    // 反Geo搜索，根据经纬度获取地标名
                    mFavoLatlng = new LatLng(marker.getPosition().latitude, marker.getPosition().longitude);
                    mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(mFavoLatlng));
                    mInfoWindow = new InfoWindow(tv, marker.getPosition(), -50);
                    tv_flt_longitude.setText("东经：" + FormatUtils.latLng(marker, "longitude"));
                    tv_flt_latitude.setText("北纬： " + FormatUtils.latLng(marker, "latitude"));
                    // 设置详细信息到布局
                    showPro();
                    llc_collectionsView.startAnimation(AnimUtils.showAnim());
                    llc_collectionsView.setVisibility(View.VISIBLE); // 显示收藏布局
                    mBaiduMap.showInfoWindow(mInfoWindow); // 显示弹窗
                    return true;
                } else if (marker.getExtraInfo().get("info") != null) // 显示飞机详情
                {
                    Data data = (Data) marker.getExtraInfo().get("info");
                    setInfoToLayout(llc_fltInfo, data);
                    llc_fltInfo.startAnimation(AnimUtils.showAnim());
                    llc_fltInfo.setVisibility(View.VISIBLE); // 显示飞机详情布局

//                    FlightInfo info = (FlightInfo) marker.getExtraInfo().get("info");
//                    // 设置详细信息到布局
//                    setInfoToLayout(llc_fltInfo, info);
//                    llc_fltInfo.startAnimation(AnimUtils.showAnim());
//                    llc_fltInfo.setVisibility(View.VISIBLE); // 显示飞机详情布局
                    return true;
                } else if (marker.getExtraInfo().get("al_favo") != null) // 已收藏的点
                {
                    marker.remove();
                } else if (marker.getExtraInfo().get("search") != null)
                {
                    Logger.w("search", "search");
                    marker.remove();
                }
                return false;
            }
        });
    }

    /**
     * 地图选项菜单
     */
    @Override
    public void onButtonClicked(int i)
    {
        switch (i)
        {
            case 1:
                if (press) // 当press为true， 按下1切换为卫星，
                {
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                    press = false;
                    GlobalVariable.setMapMode(Constant.MAP_TYPE_SATELLITE);

                } else
                {
                    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                    GlobalVariable.setMapMode(Constant.MAP_TYPE_NORMAL);
                    press = true;
                }
                break;
            case 2: // 定位
                if (!mLocClient.isStarted())// 开启方向传感器
                {
                    isFirst = true;
                    mOrientationSensor = new OrientationSensor(activity);
                    mLocClient.start();
                } else // 关闭图层定位
                {
                    mBaiduMap.setMyLocationEnabled(false);
                    mLocClient.stop();
                }
                break;
            case 3: // 显示所有收藏的点
                startActivity(new Intent(activity, FavoActivity.class).setFlags(FLAG_ACTIVITY_NEW_TASK),
                        ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                break;
            case 4:
                screenShotAndShare(); // 截图并分享
                break;
        }
    }

    @Override
    public void onExpand()
    {

    }

    @Override
    public void onCollapse()
    {

    }

    /**
     * 按钮点击事件
     */
    @OnClick({R.id.bt_quyu, R.id.bt_choose, R.id.bt_my, R.id.tv_share, R.id.tv_favorite, R.id.tv_chooseTime, R.id.bt_playback, R.id.iv_munu})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.tv_share:
                screenShotAndShare();
                break;
            case R.id.tv_favorite:
                String favoResult = BaiduMapUtils.favoMarker(activity, getAddress(), mFavoLatlng.latitude, mFavoLatlng.longitude);
                showTopToast(activity, favoResult);
                et_coordinate.setText("");
                tv_flt_longitude.setText("");
                tv_flt_longitude.setText("");
                mBaiduMap.hideInfoWindow();
                if (mLongPressMarker != null) //收藏后将marker点移除
                {
                    mLongPressMarker.remove();
                }
                goneView();
                break;
            case R.id.tv_chooseTime:
                break;
            case R.id.bt_playback:
                // 拿到当前选中的坐标集合      这里是后台取的
                startActivity(new Intent(activity, TrackPlayBackActivity.class).setFlags(FLAG_ACTIVITY_NEW_TASK),
                        ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                break;
            case R.id.bt_quyu:
                goneView();
                ButtonStyleUtils.resetButtonStyle(activity, null, bt_choose, bt_my);
                ButtonStyleUtils.changeButtonStyle(activity, bt_quyu, null, null);
                llc_quyu.startAnimation(AnimUtils.showAnim());
                llc_quyu.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_choose:
                goneView();
                ButtonStyleUtils.resetButtonStyle(activity, bt_quyu, null, bt_my);
                ButtonStyleUtils.changeButtonStyle(activity, null, bt_choose, null);
                llc_choose.startAnimation(AnimUtils.showAnim());
                llc_choose.setVisibility(View.VISIBLE);
//                mainPersenter.getFlightChoose(activity); // 获取飞机选择
                setFlightChoose();
                break;
            case R.id.bt_my:
                goneView();
                startActivity(new Intent(activity, MeActivity.class).setFlags(FLAG_ACTIVITY_NEW_TASK),
                        ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                break;
            case R.id.iv_munu:
                final PopHomeMune pop = new PopHomeMune(activity);
                pop.showPopup(iv_munu);
                pop.setOnClickFlagListener(new PopHomeMune.OnClickFlagListener()
                {
                    @Override
                    public void getFlag(int flag)
                    {
                        pop.dismiss();
                        switch (flag)
                        {
                            case 0:
                                startActivity(new Intent(activity, HuLinActivity.class));
                                break;
                            case 1:
                                startActivity(new Intent(activity, ChaXunActivity.class));
                                break;
                            case 2:
                                startActivity(new Intent(activity, WeatherActivity.class));
                                break;
                            case 3:
                                startActivity(new Intent(activity, QingBao.class));
                                break;
                        }
                    }
                });
                break;
        }
    }

    /**
     * 导航菜单选择事件
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.im_setting:
                startActivity(new Intent(activity, SettingActivity.class).setFlags(FLAG_ACTIVITY_NEW_TASK),
                        ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                break;
            case R.id.im_statistics:
                startActivity(new Intent(activity, StatisticsData.class).setFlags(FLAG_ACTIVITY_NEW_TASK),
                        ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                break;
            case R.id.im_feedback:
                startActivity(new Intent(activity, Feedback.class).setFlags(FLAG_ACTIVITY_NEW_TASK),
                        ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                break;
            case R.id.im_help:
                startActivity(new Intent(activity, Help.class).setFlags(FLAG_ACTIVITY_NEW_TASK),
                        ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                break;
        }
        return true;
    }

    /**
     * 截图和分享
     */
    private void screenShotAndShare()
    {
        showToast(getString(R.string.wait_please));
        mBaiduMap.snapshot(new BaiduMap.SnapshotReadyCallback()
        {
            public void onSnapshotReady(Bitmap snapshot)
            {
                Bitmap shot = ScreenshotsUtil.getScreenshots(activity, snapshot); // 获取截图的bitmap对象
                if (shot != null)
                {
                    ScreenshotsUtil.share(activity, GlobalVariable.getSharePicname());
                } else
                {
                    showTopToast(activity, getString(R.string.save_failed_and_can_not_find_reason));
                }
                showTopToast(activity, getString(R.string.screenshot_have_already_save_at) + Constant.PATH + Constant.PICNAME);
            }
        });
    }

    public String getAddress()
    {
        return et_coordinate.getText().toString().trim();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        switch (item.getItemId())
//        {
//            case R.id.im_plan_apply:
//                startActivity(new Intent(activity, HuLinActivity.class));
//                return true;
//            case R.id.im_plan_select:
//                startActivity(new Intent(activity, ChaXunActivity.class));
//                return true;
//            case R.id.im_weather:
//                startActivity(new Intent(activity, WeatherActivity.class));
//                return true;
//            case R.id.im_qingbao:
//                startActivity(new Intent(activity, QingBao.class));
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    /**
     * 为布局添加飞机详情信息
     */
    private void setInfoToLayout(final LinearLayoutCompat ll_info, Data info)
    {
        ViewHolder viewHolder = null;
        if (ll_info.getTag() == null)
        {
            viewHolder = new ViewHolder();
            viewHolder.tv_fltNo = (TextView) ll_info.findViewById(R.id.tv_fltNo);
            viewHolder.tv_model = (TextView) ll_info.findViewById(R.id.tv_model);
            viewHolder.tv_startAddress = (TextView) ll_info.findViewById(R.id.tv_startAddress);
            viewHolder.tv_endAddress = (TextView) ll_info.findViewById(R.id.tv_endAddress);
            viewHolder.tv_quyuWork = (TextView) ll_info.findViewById(R.id.tv_quyuWork);
            viewHolder.tv_longitude = (TextView) ll_info.findViewById(R.id.tv_longitude);
            viewHolder.tv_latitude = (TextView) ll_info.findViewById(R.id.tv_latitude);
            viewHolder.tv_height = (TextView) ll_info.findViewById(R.id.tv_height);
            viewHolder.tv_speed = (TextView) ll_info.findViewById(R.id.tv_speed);
            viewHolder.tv_startTime = (TextView) ll_info.findViewById(R.id.tv_startTime);
            viewHolder.tv_endTime = (TextView) ll_info.findViewById(R.id.tv_endTime);
            viewHolder.tv_pilot = (TextView) ll_info.findViewById(R.id.tv_pilot);
            viewHolder.tv_company = (TextView) ll_info.findViewById(R.id.tv_company);

            viewHolder.iv_fltImg = (ImageView) ll_info.findViewById(R.id.iv_fltImg);
            viewHolder.tg_track = (ToggleButton) ll_info.findViewById(tg_track);
            viewHolder.tg_playback = (ToggleButton) ll_info.findViewById(R.id.tg_playback);
            ll_info.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) ll_info.getTag();
        int size = info.getPOINTS().size();
        viewHolder.tv_fltNo.setText("编号：" + info.getAIRCRAFT_CODE());
        viewHolder.tv_model.setText("型号：" + info.getAIRCRAFT_TYPE());
        viewHolder.tv_startAddress.setText("出发地：" + info.getLANDING_AIRPORT());
        viewHolder.tv_endAddress.setText("抵达地：" + info.getTAKEOFF_AIRPORT());
        viewHolder.tv_quyuWork.setText("作业区域：" + info.getLANDING_AIRPORT());
        viewHolder.tv_longitude.setText("东经：" + FormatUtils.sub0_6(info.getPOINTS().get(size - 1).getLATITUDE()));
        viewHolder.tv_latitude.setText("北纬：" + FormatUtils.sub0_6(info.getPOINTS().get(size - 1).getLONGITUDE()));
        viewHolder.tv_height.setText("高度：" + info.getPOINTS().get(size - 1).getHIGHT());
        viewHolder.tv_speed.setText("速度：" + info.getPOINTS().get(size - 1).getSPEED());
        viewHolder.tv_startTime.setText("出发时间：" + info.getTAKEOFF_TIME());
        viewHolder.tv_endTime.setText("抵达时间：" + info.getLANDING_TIME());
        viewHolder.tv_pilot.setText("飞行员：" + info.getPLAN_ID());
        viewHolder.tv_company.setText("所属公司：" + info.getCOMPANY());

        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.tg_track.setOnToggleChanged(new ToggleButton.OnToggleChanged() // 跟踪
        {
            @Override
            public void onToggle(boolean on)
            {
                showTopToast(activity, "跟踪功能暂未开放");
                finalViewHolder.tg_track.setToggleOff();
            }
        });
        viewHolder.tg_playback.setOnToggleChanged(new ToggleButton.OnToggleChanged()
        {
            @Override
            public void onToggle(boolean on)
            {
                goneView();
                llc_playback.startAnimation(AnimUtils.showAnim());
                llc_playback.setVisibility(View.VISIBLE);
                finalViewHolder.tg_playback.setToggleOff();
            }
        });
    }

    private class ViewHolder
    {
        TextView tv_fltNo, tv_model, tv_startAddress, tv_endAddress, tv_quyuWork, tv_longitude, tv_latitude, tv_height, tv_startTime, tv_speed, tv_endTime, tv_pilot, tv_company;
        ImageView iv_fltImg;
        ToggleButton tg_track, tg_playback;
    }

    /**
     * ---------------------------SET值-----------------------
     */
    public List<Data> dataList;
    Overlay fltTitle = null;

    @Override
    public void setMovingFlt(List<Data> data)
    {
        try
        {
            List<LatLng> latLngs = new ArrayList<>();
            Data data1;
            List<com.sby.bean.monitor.POINTS> points;
            LatLng lastLatlng = null;
            float rotate = 0;
            if (isFirstFlt == false) // 第一次拿到数据
            {
                for (int i = 0; i < data.size(); i++)
                {
                    tv_movingRemarks.setText("机号：" + data.get(i).getAIRCRAFT_CODE());
                    data1 = data.get(i);
                    points = data1.getPOINTS();
                    if (points == null)
                    {
                        continue;
                    }
                    for (int j = 0; j < points.size(); j++)
                    {
                        LatLng latLng = new LatLng(FormatUtils.strToDouble(points.get(j).getLATITUDE()), FormatUtils.strToDouble(points.get(j).getLONGITUDE()));
                        // 坐标转换
                        CoordinateConverter converter = new CoordinateConverter();
                        converter.from(CoordinateConverter.CoordType.COMMON);
                        // sourceLatLng待转换坐标
                        converter.coord(latLng);
                        LatLng desLatLng = converter.convert();
                        latLngs.add(desLatLng);

                        if (j == (points.size() - 1))
                        {
                            rotate = points.get(j).getDIRECTION();
                            lastLatlng = desLatLng;
                        }
                    }
                    // 描点
                    OverlayOptions ooPolyline = new PolylineOptions().width(5).color(0xAAFF0000).points(latLngs);
                    movingPolyline = (Polyline) mBaiduMap.addOverlay(ooPolyline);
                    // 在最后一个点加标签
                    MarkerOptions mo = new MarkerOptions().position(lastLatlng).icon(ic_fltylw).zIndex(1).anchor(20f, 0f).draggable(false).rotate(rotate);
                    mFltMarker = (Marker) (mBaiduMap.addOverlay(mo));
                    // 加标签
                    TextOptions ooText = new TextOptions().bgColor(0xFF0000FF)
                            .fontSize(30).fontColor(0xFFFFFFFF).text("机号：" + data1.getAIRCRAFT_CODE())
                            .position(lastLatlng);
                    fltTitle = mBaiduMap.addOverlay(ooText);

                    Bundle bundle = new Bundle(); // 添加marker内容
                    bundle.putSerializable("info", data1);
                    mFltMarker.setExtraInfo(bundle);
                    end = data1.getMAX_CREATED_TIME();
                    latLngs.clear();
                    isFirstFlt = true;
                    dataList = data; // 保存上次的飞行记录
                }
            } else // 非第一次拿到的数据
            {
                for (int i = 0; i < data.size(); i++)
                {
                    if (dataList != null)
                    {
                        data1 = data.get(i);
                        if (null != dataList.get(i) && dataList.get(i).getID() == data1.getID())
                        {
                            points = data1.getPOINTS();
                            if (points == null)
                            {
                                continue;
                            }
                            for (int j = 0; j < points.size(); j++)
                            {
                                LatLng latLng = new LatLng(strToDouble(points.get(j).getLATITUDE()), strToDouble(points.get(j).getLONGITUDE()));
                                CoordinateConverter converter = new CoordinateConverter();
                                converter.from(CoordinateConverter.CoordType.COMMON);
                                // sourceLatLng待转换坐标
                                converter.coord(latLng);
                                LatLng desLatLng = converter.convert();
                                latLngs.add(desLatLng);
                                if (j == (points.size() - 1))
                                {
                                    lastLatlng = desLatLng;
                                }
                            }
                            try
                            {
                                // 描点
                                OverlayOptions ooPolyline = new PolylineOptions().width(5).color(0xAAFF0000).points(latLngs);
                                movingPolyline = (Polyline) mBaiduMap.addOverlay(ooPolyline);
                                latLngs.clear();
                            } catch (Exception e)
                            {
//                                Logger.e("点少于2个", "");
                            }
                            // 在最后一个点加标签
                            mFltMarker.setTitle("机号：" + data1.getAIRCRAFT_CODE());
                            mFltMarker.setRotate(rotate);
                            mFltMarker.setPosition(lastLatlng);
                            // 加标签
                            fltTitle.remove();
                            TextOptions ooText = new TextOptions().bgColor(0xFF0000FF)
                                    .fontSize(30).fontColor(0xFFFFFFFF).text("机号：" + data1.getAIRCRAFT_CODE())
                                    .position(lastLatlng);
                            fltTitle = mBaiduMap.addOverlay(ooText);

                            Bundle bundle = new Bundle(); // 添加marker内容
                            bundle.putSerializable("info", data1);
                            mFltMarker.setExtraInfo(bundle);
                            end = data1.getMAX_CREATED_TIME();
                            latLngs.clear();
                            isFirstFlt = true;
                            dataList = data; // 保存上次的飞行记录
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void setMovieFlights(List<MovFlt> flts)
    {
        List<LatLng> latLngs = new ArrayList<>();
        List<POINTS> points;
        MovFlt movingFlt;
        LatLng lastLatlng = null;
        if (mFltMarker != null)
        {
            mFltMarker.remove();
        }
        if (movingPolyline != null)
        {
            movingPolyline.remove();
        }
        for (int i = 0; i < flts.size(); i++)
        {
            movingFlt = flts.get(i);
            points = movingFlt.getPOINTS();
            if (points == null)
            {
                continue;
            }
            tv_movingRemarks.setText("机尾号：" + flts.get(i).getAIRCRAFT_CODE());
            latLngs.clear();
            for (int j = 0; j < points.size(); j++)
            {
                LatLng latLng = new LatLng(strToDouble(points.get(j).getLATITUDE()), strToDouble(points.get(j).getLONGITUDE()));
                latLngs.add(latLng);
                if (j == (points.size() - 1))
                {
                    lastLatlng = latLng;
                }
            }
            // 描点
            OverlayOptions ooPolyline = new PolylineOptions().width(5).color(0xAAFF0000).points(latLngs);
            movingPolyline = (Polyline) mBaiduMap.addOverlay(ooPolyline);
            // 在最后一个点加标签
            BitmapDescriptor ic_flt = BitmapDescriptorFactory.fromBitmap(getBitmapFromView(movingView));
            MarkerOptions mo = new MarkerOptions().position(lastLatlng).icon(ic_flt).zIndex(3).draggable(false);
            mFltMarker = (Marker) (mBaiduMap.addOverlay(mo));
            Bundle bundle = new Bundle(); // 添加marker内容
            bundle.putSerializable("info", movingFlt);
            mFltMarker.setExtraInfo(bundle);
        }
    }

    @Override
    public void setFlights(List<FlightInfo> flightsList)
    {
        LatLng latLng = null;
        View view = LayoutInflater.from(activity).inflate(R.layout.item_main_flight_remark, null);
        TextView tv_remarks = (TextView) view.findViewById(R.id.item_tv_remarks);

        for (int i = 0; i < flightInfos.size(); i++)
        {
            if (GlobalVariable.isMapMode()) // 普通视图
            {
//            iv_image.setImageResource(R.mipmap.ic_del_all);
            }
            tv_remarks.setText(String.format("型号：%1$s\n单位：%2$s\n速度：%3$s\n", flightInfos.get(i).getModel(), flightInfos.get(i).getNum(), flightInfos.get(i).getSpeed()));
            latLng = new LatLng(flightInfos.get(i).getLatitude(), flightInfos.get(i).getLongitude());
            ic_fltylw = BitmapDescriptorFactory.fromBitmap(getBitmapFromView(view));
            MarkerOptions mo = new MarkerOptions().position(latLng).icon(ic_fltylw).zIndex(i).draggable(true);
            mFltMarker = (Marker) (mBaiduMap.addOverlay(mo));

            Bundle bundle = new Bundle(); // 添加marker内容
            bundle.putSerializable("info", flightInfos.get(i));
            mFltMarker.setExtraInfo(bundle);
        }
        moveToLatlng(mBaiduMap, latLng, 14);
    }

    @Override
    public void setReportPoint(List<AreaReport> reportPoints)
    {
//        LatLng latLng = null;
//        for (int i = 0; i < reportPoints.size(); i++)
//        {
//            latLng = new LatLng(Double.parseDouble(reportPoints.get(i).getLaTitude()), Double.parseDouble(reportPoints.get(i).getLongTitude()));
//            MarkerOptions mo = new MarkerOptions().position(latLng).icon(ic_report).zIndex(i).draggable(false);
//            mBGMarker = (Marker) (mBaiduMap.addOverlay(mo));
//            reportList.add(mBGMarker);
//        }
//        moveToLatlng(mBaiduMap, latLng, 10);
    }

    /**
     * 生成固定空域
     */
    @Override
    public void setFixedAirspace(List<FixedAirSpace> fixedAirspaceList)
    {
//        List<Radius> radiusList = new ArrayList<>(); // 圆形
//        List<Polygon> polygonList = new ArrayList<>(); // 一个多边形
//        List<List<Polygon>> allPolList = new ArrayList<>(); // 所有多边形
//        LatLng llCircle = null;
//        for (int i = 0; i < fixedAirspaceList.size(); i++)
//        {
//            String a = fixedAirspaceList.get(i).getPointCollection();
//            // 根据返回的数据判断是圆还是多边形，圆形为对象，以{开头，多边形为数组，以[开头
//            if (a.startsWith("{"))  // 圆形
//            {
//                Radius radiusResult = com.alibaba.fastjson.JSON.parseObject(a, Radius.class);
//                radiusList.add(radiusResult); // 将圆形对象放入数组
//
//            } else // 多边形
//            {
//                polygonList = com.alibaba.fastjson.JSON.parseArray(a, Polygon.class);
//            }
//            allPolList.add(polygonList);
//        }
//        // 开始描点
//        for (int i = 0; i < radiusList.size(); i++) // 添加圆
//        {
//            llCircle = new LatLng(Double.parseDouble(radiusList.get(i).getLaTitude()), Double.parseDouble(radiusList.get(i).getLongTitude()));
//            OverlayOptions ooCircle = new CircleOptions().fillColor(0x880000FF)
//                    .center(llCircle).stroke(new Stroke(5, 0x880000FF))
//                    .radius(Integer.parseInt(radiusList.get(i).getRadius()));
//            Circle c = (Circle) mBaiduMap.addOverlay(ooCircle);
//            circleList.add(c);
//        }
////        for (int i = 0; i < allPolList.size(); i++)
////        {
////            for (int j = 0; j < allPolList.get(i).size(); j++)
////            {
//        // TODO 描多边形
////                Logger.e("现在有：" , allPolList.get(i).get(j).getLaTitude() );
////            }
////        }
//        moveToLatlng(mBaiduMap, llCircle, 12);
    }

    /**
     * 生成护林航线
     */
    @Override
    public void setRangerRoute()
    {
//        LatLng p1 = new LatLng(39.97923, 116.357428);
//        LatLng p2 = new LatLng(39.94923, 116.397428);
//        LatLng p3 = new LatLng(39.97923, 116.437428);
//        LatLng p4 = new LatLng(39.97923, 116.437206);
//
//        List<LatLng> points = new ArrayList<>();
//        points.add(p1);
//        points.add(p2);
//        points.add(p3);
//        points.add(p4);
//        OverlayOptions ooPolyline = new PolylineOptions().width(10)
//                .color(0xAAFF0000).points(points);
//        rangerRouteLine = (Polyline) mBaiduMap.addOverlay(ooPolyline);
    }

    /**
     * 生成农化机场
     */
    @Override
    public void setAirportConversion()
    {
//        if (airConversionList == null)
//            return;
//        for (int i = 0; i < airConversionList.size(); i++)
//        {
//            LatLng latLng = new LatLng(airConversionList.get(i).getPosition().latitude, airConversionList.get(i).getPosition().longitude);
//            MarkerOptions mo = new MarkerOptions().position(latLng).icon(ic_airConversion).zIndex(i).draggable(true);
//            mAirportConversionMarker = (Marker) (mBaiduMap.addOverlay(mo));
//        }
    }

    /**
     * 生成护林机场
     */
    @Override
    public void setRangerAirport()
    {
//        if (mRangerairportList == null)
//            return;
//        for (int i = 0; i < mRangerairportList.size(); i++)
//        {
//            LatLng latLng = new LatLng(mRangerairportList.get(i).getPosition().latitude, mRangerairportList.get(i).getPosition().longitude);
//            MarkerOptions mo = new MarkerOptions().position(latLng).icon(ic_ranger).zIndex(i).draggable(true);
//            mRangerairportMarker = (Marker) (mBaiduMap.addOverlay(mo));
//        }
    }

    /**
     * 生成民航机场
     */
    @Override
    public void setCivilAviationAirport()
    {
//        if (mCivilaviationList == null)
//            return;
//        for (int i = 0; i < mCivilaviationList.size(); i++)
//        {
//            LatLng latLng = new LatLng(mCivilaviationList.get(i).getPosition().latitude, mCivilaviationList.get(i).getPosition().longitude);
//            MarkerOptions mo = new MarkerOptions().position(latLng).icon(ic_civil).zIndex(i).draggable(true);
//            mCivilaviationMarker = (Marker) (mBaiduMap.addOverlay(mo));
//        }
    }

    /**
     * 生成禁飞区
     */
    @Override
    public void setNoFlyZone()
    {
// 文字坐标
//        LatLng text = new LatLng(39.920293, 116.353677);
//        // 几何覆盖物图形
//        LatLng pt1 = new LatLng(39.93923, 116.357428);
//        LatLng pt2 = new LatLng(39.91923, 116.327428);
//        LatLng pt3 = new LatLng(39.89923, 116.347428);
//        LatLng pt4 = new LatLng(39.89923, 116.367428);
//        LatLng pt5 = new LatLng(39.91923, 116.387428);
//        List<LatLng> pts = new ArrayList<>();
//        pts.add(pt1);
//        pts.add(pt2);
//        pts.add(pt3);
//        pts.add(pt4);
//        pts.add(pt5);
//        //构建用户绘制多边形的Option对象
//        OverlayOptions polygonOption = new PolygonOptions()
//                .points(pts)
//                .stroke(new Stroke(5, 0xAA00FF00))
//                .fillColor(0xAAFFFF00);
//        OverlayOptions textOption = new TextOptions().bgColor(Color.RED).fontSize(30)
//                .text("禁飞区").rotate(-45).position(text);
//        //在地图上添加多边形Option，用于显示
//        myOverlay2 = mBaiduMap.addOverlay(polygonOption);
//        myOverlay3 = mBaiduMap.addOverlay(textOption);
    }

    /**
     * 生成加油点
     */
    @Override
    public void setRefuelingPoint()
    {
//        if (mRefurlingList == null)
//            return;
//        for (int i = 0; i < mRefurlingList.size(); i++)
//        {
//            LatLng latLng = new LatLng(mRefurlingList.get(i).getPosition().latitude, mRefurlingList.get(i).getPosition().longitude);
//            MarkerOptions mo = new MarkerOptions().position(latLng).icon(ic_refueling).zIndex(i).draggable(true);
//            mRefurlingMarker = (Marker) (mBaiduMap.addOverlay(mo));
//        }
    }

    /**
     * 生成民航航线
     */
    @Override
    public void setCivilAviationRoute()
    {
//        LatLng p1 = new LatLng(39.97954, 116.357428);
//        LatLng p2 = new LatLng(39.94945, 116.397428);
//        LatLng p3 = new LatLng(39.97954, 116.437428);
//        LatLng p4 = new LatLng(39.97955, 116.437206);
//
//        List<LatLng> points = new ArrayList<>();
//        points.add(p1);
//        points.add(p2);
//        points.add(p3);
//        points.add(p4);
//        OverlayOptions ooPolyline = new PolylineOptions().width(10)
//                .color(R.color.civilaviation).points(points);
//        mCivilAviationRouteLine = (Polyline) mBaiduMap.addOverlay(ooPolyline);
    }

    /**
     * 生成飞机筛选结果
     */
    @Override
    public void setFlightChoose()
    {
        chooseFltList = new ArrayList<>();

        List<String> tongHang = new ArrayList<>();
        ChooseFlt ch1 = new ChooseFlt();
        ch1.setCatelog("通航公司");
        tongHang.add("北大荒通航公司");
        tongHang.add("星空公司");
        tongHang.add("圣博赢公司");
        ch1.setCatelogList(tongHang);
        chooseFltList.add(ch1);

        List<String> bianHao = new ArrayList<>();
        ChooseFlt ch2 = new ChooseFlt();
        ch2.setCatelog("飞机编号");
        bianHao.add("PK1115");
        bianHao.add("HK1255");
        bianHao.add("PK1484");
        bianHao.add("UH1856");
        ch2.setCatelogList(bianHao);
        chooseFltList.add(ch2);

        List<String> jichang = new ArrayList<>();
        ChooseFlt ch3 = new ChooseFlt();
        ch3.setCatelog("起降机场");
        jichang.add("首都机场");
        jichang.add("虹桥机场");
        jichang.add("丹阳机场");
        ch3.setCatelogList(jichang);
        chooseFltList.add(ch3);

        List<String> xinghao = new ArrayList<>();
        ChooseFlt ch4 = new ChooseFlt();
        ch4.setCatelog("飞机编号");
        xinghao.add("P1111");
        xinghao.add("H222255");
        xinghao.add("PK4434");
        xinghao.add("UH53436");
        ch4.setCatelogList(xinghao);
        chooseFltList.add(ch4);

        List<String> leixing = new ArrayList<>();
        ChooseFlt ch5 = new ChooseFlt();
        ch5.setCatelog("作业类型");
        leixing.add("农化");
        leixing.add("护林");
        leixing.add("防火");
        leixing.add("演示");
        leixing.add("救灾");
        leixing.add("战斗");
        leixing.add("禁飞");
        leixing.add("降雨");
        ch5.setCatelogList(leixing);
        chooseFltList.add(ch5);

        catAdapter = new AdapterCatFltPop(activity, chooseFltList);
        rv_catalog.setAdapter(catAdapter);
        typeAdapter = new AdapterTypeFltPop(activity, chooseFltList, 0);
        rv_type.setAdapter(typeAdapter);

        catAdapter.setOnItemClickLitener(new AdapterCatFltPop.CatFltPopListener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                catAdapter.setPosition(position);
                catAdapter.notifyDataSetChanged();
                typeAdapter.setPosition(position);
                typeAdapter.notifyDataSetChanged();
            }
        });
        typeAdapter.setOnItemClickLitener(new AdapterTypeFltPop.TypeFltPopListener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                showTopToast(activity, "点击了" + position);
            }
        });
//        if (mflightResultList == null)
//            return;
//        for (int i = 0; i < mflightResultList.size(); i++)
//        {
//            LatLng latLng = new LatLng(mflightResultList.get(i).getPosition().latitude, mflightResultList.get(i).getPosition().longitude);
//            MarkerOptions mo = new MarkerOptions().position(latLng).icon(ic_flightResult).zIndex(i).draggable(true);
//            mflightResultMarker = (Marker) (mBaiduMap.addOverlay(mo));
//        }
    }

    @Override
    public void showTip(String str)
    {
        showTopToast(activity, str);
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

/**
 * -----------------------------------------------------------------
 */

    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener
    {

        @Override
        public void onReceiveLocation(BDLocation location)
        {
            if (location == null || mBaiduMap == null)
            {
                showToast(getString(R.string.location_failed));
                return;
            }
//            getLocationInfo(location);
            // 开启定位图层
            mBaiduMap.setMyLocationEnabled(true);
            // 构造定位数据
            mOrientationSensor.setOrientationListener(new OrientationSensor.OrientationSensorListener()
            {
                @Override
                public void getOrientation(float x)
                {
                    Constant.DRIECTION = x;
                }
            });
            final MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(Constant.DRIECTION)
                    .latitude(location.getLatitude())
                    .longitude(location.getLongitude())
                    .build();
            // 设置定位数据
            mBaiduMap.setMyLocationData(locData);
            mBaiduMap.setMyLocationConfigeration(new MyLocationConfiguration(
                    MyLocationConfiguration.LocationMode.NORMAL, true, null));// 跟随状态
            // 保存当前城市名称
            GlobalVariable.setLOCATION(location.getCity());
            if (isFirst)
            {
                isFirst = false;
                // 获取经纬度
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                // 设置地图中心点以及缩放级别
                moveToLatlng(mBaiduMap, latLng, 19);
            }
        }

        public void onReceivePoi(BDLocation poiLocation)
        {
        }

    }

    /**
     * 根据经纬度获取地名
     */
    @Override
    public void onGetGeoCodeResult(GeoCodeResult result)
    {
    }

    @Override
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result)
    {
        if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR)
        {
            showTopToast(activity, getString(R.string.sorry_can_not_find_location));
            return;
        }
        et_coordinate.setText(result.getAddress());
        et_coordinate.requestFocus();//获取焦点 光标出现
        et_coordinate.setSelection(et_coordinate.getText().length());// 移动光标到最后一个字符串
        disPro();
    }

    /**
     * 将布局Gone掉
     */
    private void goneView()
    {
        if (llc_quyu.getVisibility() == View.VISIBLE)
        {
            llc_quyu.startAnimation(AnimUtils.goneAnim());
            llc_quyu.setVisibility(View.GONE);
        }
        if (llc_fltInfo.getVisibility() == View.VISIBLE)
        {
            llc_fltInfo.startAnimation(AnimUtils.goneAnim());
            llc_fltInfo.setVisibility(View.GONE);
        }
        if (llc_collectionsView.getVisibility() == View.VISIBLE)
        {
            llc_collectionsView.startAnimation(AnimUtils.goneAnim());
            llc_collectionsView.setVisibility(View.GONE);
        }
        if (llc_playback.getVisibility() == View.VISIBLE)
        {
            llc_playback.startAnimation(AnimUtils.goneAnim());
            llc_playback.setVisibility(View.GONE);
        }
        if (llc_choose.getVisibility() == View.VISIBLE)
        {
            llc_choose.startAnimation(AnimUtils.goneAnim());
            llc_choose.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mv_mapview.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mv_mapview.onResume();
        goneView();
        ButtonStyleUtils.resetButtonStyle(activity, bt_quyu, bt_choose, bt_my);
//        mainPersenter.getFlights(activity); // 获取飞机
    }

    @Override
    protected void onDestroy()
    {
        // 退出时销毁定位
        mLocClient.stop();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        // 关闭方向传感器
        FavoriteManager.getInstance().destroy();// 释放收藏夹功能资源
        mv_mapview.onDestroy();
        mv_mapview = null;
        ic_fltBlue.recycle();
        ic_fltylw.recycle();
        ic_position.recycle();
        mFltMarker.remove();
        isRunning = false;
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        mBaiduMap.clear();
        mLocClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        if (intent.getStringExtra("locationInfo") != null) // 显示所有收藏的点
        {
            List<FavoritePoiInfo> list = FavoriteManager.getInstance().getAllFavPois();
            String id = intent.getStringExtra("locationInfo");
            LatLng latLng = null;
            for (int i = 0; i < list.size(); i++)
            {
                if (list.get(i).getID().equals(id) || id == list.get(i).getID())
                {
                    MarkerOptions option = new MarkerOptions().icon(ic_position).position(list.get(i).getPt());
                    Bundle b = new Bundle();
                    b.putString("al_favo", "al_favo");
                    option.extraInfo(b);
                    mLongPressMarker = ((Marker) mBaiduMap.addOverlay(option));
                    // 获取经纬度
                    latLng = new LatLng(list.get(i).getPt().latitude, list.get(i).getPt().longitude);
                }
            }
            moveToLatlng(mBaiduMap, latLng, 15);
        } else if (intent.getParcelableExtra("location") != null) // 搜索地点并显示
        {
            // 搜索结果跳转
            LatLng latLng = intent.getParcelableExtra("location");

            if (mLongPressMarker != null)
            {
                mLongPressMarker.remove();
            }
            MarkerOptions option = new MarkerOptions().icon(ic_position).position(latLng);
            Bundle b = new Bundle();
            b.putString("favo", "favo");
            option.extraInfo(b);
            mLongPressMarker = ((Marker) mBaiduMap.addOverlay(option));

            moveToLatlng(mBaiduMap, latLng, 15);
        }
    }

    /**
     * 返回键的监听事件
     *
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if ((System.currentTimeMillis() - Constant.exitTime) > 2000)
            {
                showTopToast(activity, getString(R.string.press_again_to_exit));
                Constant.exitTime = System.currentTimeMillis();
                return false;
            } else
            {
                finish();
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
