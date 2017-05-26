package com.sby.utils;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;

import com.baidu.mapapi.favorite.FavoriteManager;
import com.baidu.mapapi.favorite.FavoritePoiInfo;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Circle;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.model.LatLng;
import com.sby.practice.R;

import java.util.List;

import static com.sby.constant.Constant.RANGE;
import static com.sby.constant.Constant.TIME_INTERVAL;

/**
 * 百度地图工具类
 * Created by kowal on 2016/12/8.
 */

public class BaiduMapUtils
{
    /**
     * 将地图移动到一个经纬度位置
     * @param mBaiduMap 地图对象
     * @param latlng 给定的经纬度
     * @param ZOOM_LEVEL 放大级别
     */
    public static void moveToLatlng(BaiduMap mBaiduMap, LatLng latlng, float ZOOM_LEVEL)
    {
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.target(latlng).zoom(ZOOM_LEVEL);
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
    }

    /**
     * 将坐标收藏到收藏夹
     *
     * @param poiName   收藏点的名
     * @param latitude  坐标
     * @param longitude
     * @return 成功返回成功，失败返回失败
     */
    public static String favoMarker(Context context, String poiName, double latitude, double longitude)
    {
        FavoritePoiInfo info = new FavoritePoiInfo();
        info.poiName(poiName);
        LatLng pt = new LatLng(latitude, longitude);
        info.pt(pt);
        if (FavoriteManager.getInstance().add(info) == 1)
        {
            return context.getString(R.string.favo_succ);
        } else
        {
            return context.getString(R.string.favo_failed);
        }
    }

    /**
     * 根据点获取图标转的角度
     */
    public static double getAngle(int startIndex, Polyline mVirtureRoad)
    {
        if ((startIndex + 1) >= mVirtureRoad.getPoints().size())
        {
            throw new RuntimeException("index out of bonds");
        }
        LatLng startPoint = mVirtureRoad.getPoints().get(startIndex);
        LatLng endPoint = mVirtureRoad.getPoints().get(startIndex + 1);
        return getAngle(startPoint, endPoint);
    }

    /**
     * 根据两点算取图标转的角度
     */
    public static double getAngle(LatLng fromPoint, LatLng toPoint)
    {
        double slope = getSlope(fromPoint, toPoint);
        if (slope == Double.MAX_VALUE)
        {
            if (toPoint.latitude > fromPoint.latitude)
            {
                return 0;
            } else
            {
                return 180;
            }
        }
        float deltAngle = 0;
        if ((toPoint.latitude - fromPoint.latitude) * slope < 0)
        {
            deltAngle = 180;
        }
        double radio = Math.atan(slope);
        double angle = 180 * (radio / Math.PI) + deltAngle - 90;
        return angle;
    }

    /**
     * 根据点和斜率算取截距
     */
    public static double getInterception(double slope, LatLng point)
    {

        double interception = point.latitude - slope * point.longitude;
        return interception;
    }

    /**
     * 算取斜率
     */
    public static double getSlope(int startIndex, Polyline mVirtureRoad)
    {
        if ((startIndex + 1) >= mVirtureRoad.getPoints().size())
        {
            throw new RuntimeException("index out of bonds");
        }
        LatLng startPoint = mVirtureRoad.getPoints().get(startIndex);
        LatLng endPoint = mVirtureRoad.getPoints().get(startIndex + 1);
        return getSlope(startPoint, endPoint);
    }

    /**
     * 算斜率
     */
    public static double getSlope(LatLng fromPoint, LatLng toPoint)
    {
        if (toPoint.longitude == fromPoint.longitude)
        {
            return Double.MAX_VALUE;
        }
        double slope = ((toPoint.latitude - fromPoint.latitude) / (toPoint.longitude - fromPoint.longitude));
        return slope;
    }

    /**
     * 计算x方向每次移动的距离
     */
    public static double getXMoveDistance(double slope)
    {
        if (slope == Double.MAX_VALUE)
        {
            return RANGE;
        }
        return Math.abs((RANGE * slope) / Math.sqrt(1 + slope * slope));
    }

    /**
     * 清空Marker点
     * @param list
     */
    public static void clearMarkerList(List<Marker> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).remove();
        }
        list = null;
    }

    /**
     * 清空覆盖物
     * @param list
     */
    public static void clearOverlayList(List<Overlay> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).remove();
        }
        list = null;
    }

    /**
     * 清空覆盖物
     * @param list
     */
    public static void clearCircleList(List<Circle> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).remove();
        }
        list = null;
    }

    /**
     * 清空折线
     * @param list
     */
    public static void clearPolylineList(List<Polyline> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).remove();
        }
        list = null;
    }

    public static void clearList(List<List<Overlay>> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).remove(i).remove();
        }
        list = null;
    }

    /**
     * 进行轨迹移动
     *
     * @param mMoveMarker 指定的marker
     * @param mv_mapview  当前使用的mapview控件
     * @param mHandler    执行的线程，使用mHandler = new Handler(Looper.getMainLooper());初始化
     * @param latlngs     从服务器获取的数组，例如：
     *                    private static final LatLng[] latlngs = new LatLng[]
     *                    {
     *                    new LatLng(39.95853, 116.103013),
     *                    new LatLng(39.938506, 116.139808),
     *                    new LatLng(39.931425, 116.167978),
     *                    };
     */
    public static void moveLooper(final Marker mMoveMarker,
                                  final MapView mv_mapview, final Handler mHandler, final LatLng[] latlngs)
    {
        new Thread()
        {

            public void run()
            {
                SystemClock.sleep(2000);
                for (int i = 0; i < latlngs.length - 1; i++)
                {
                    final LatLng startPoint = latlngs[i];
                    final LatLng endPoint = latlngs[i + 1];
                    mMoveMarker
                            .setPosition(startPoint);

                    mHandler.post(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            // refresh marker's rotate
                            if (mv_mapview == null)
                            {
                                return;
                            }
                            mMoveMarker.setRotate((float) getAngle(startPoint,
                                    endPoint));
                        }
                    });
                    double slope = getSlope(startPoint, endPoint);
                    // 是不是正向的标示
                    boolean isReverse = (startPoint.latitude > endPoint.latitude);

                    double intercept = getInterception(slope, startPoint);

                    double xMoveDistance = isReverse ? getXMoveDistance(slope) :
                            -1 * getXMoveDistance(slope);
                    for (double j = startPoint.latitude; !((j > endPoint.latitude) ^ isReverse);
                         j = j - xMoveDistance)
                    {
                        LatLng latLng = null;
                        if (slope == Double.MAX_VALUE)
                        {
                            latLng = new LatLng(j, startPoint.longitude);
                        } else
                        {
                            latLng = new LatLng(j, (j - intercept) / slope);
                        }
                        final LatLng finalLatLng = latLng;
                        mHandler.post(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                if (mv_mapview == null)
                                {
                                    return;
                                }
                                mMoveMarker.setPosition(finalLatLng);
                            }
                        });
                        try
                        {
                            Thread.sleep(TIME_INTERVAL);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }.start();
    }
}
