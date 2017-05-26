package com.sby.practice.persenter.persenterImpl;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.alibaba.fastjson.JSON;
import com.sby.bean.area.AreaReport;
import com.sby.bean.area.FixedAirSpace;
import com.sby.bean.core.ResultBean;
import com.sby.bean.flt.MovFlt;
import com.sby.bean.monitor.Monitor;
import com.sby.bean.other.FlightInfo;
import com.sby.http.HttpException;
import com.sby.http.HttpRequestCallback;
import com.sby.practice.model.MainModel;
import com.sby.practice.model.modelImol.MainModelImpl;
import com.sby.practice.persenter.MainPersenter;
import com.sby.practice.ui.view.MainView;
import com.sby.utils.Logger;
import com.sby.utils.XMLUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import okhttp3.Call;

/**
 * 主界面persenter实现类
 * Created by kowal on 2016/12/13.
 */

public class MainPersenterImpl implements MainPersenter
{
    private MainView mainView;
    private MainModel mainModel;
    private List<MovFlt> movFltList;

    public MainPersenterImpl(MainView mainView)
    {
        this.mainView = mainView;
        mainModel = new MainModelImpl();
    }

    /**
     * 获取所有飞机点
     *
     * @param context
     */
    @Override
    public void getFlights(Context context)
    {
        mainModel.getFlights(context, "token", new HttpRequestCallback<ResultBean<List<FlightInfo>>>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
                mainView.setFlights(FlightInfo.flightInfos);
                mainView.disPro();
            }

            @Override
            public void onFinish()
            {
                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean<List<FlightInfo>> listResultBean)
            {
                mainView.disPro();
//                mainView.setFlights(FlightInfo.flightInfos);
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                mainView.disPro();
//                mainView.setFlights(FlightInfo.flightInfos);
            }
        });
    }

    /**
     * 报告点
     *
     * @param context
     */
    @Override
    public void getReportPoint(Context context)
    {
        mainModel.getReportPoint(context, "token", new HttpRequestCallback<ResultBean<List<AreaReport>>>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
            }

            @Override
            public void onFinish()
            {
                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean<List<AreaReport>> listResultBean)
            {
                mainView.setReportPoint(listResultBean.getData());
                mainView.disPro();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                mainView.disPro();
                mainView.showTip(e.getMessage());
            }
        });
    }

    /**
     * 固定空域
     *
     * @param context
     */
    @Override
    public void getFixedAirspace(Context context)
    {
        mainModel.getFixedAirspace(context, "token", new HttpRequestCallback<ResultBean<List<FixedAirSpace>>>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
            }

            @Override
            public void onFinish()
            {
                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean<List<FixedAirSpace>> listResultBean)
            {
                mainView.disPro();
                mainView.setFixedAirspace(listResultBean.getData());
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                mainView.disPro();
                mainView.showTip(e.getMessage());
            }
        });
    }

    /**
     * 护林航线
     *
     * @param context
     */
    @Override
    public void getRangerRoute(Context context)
    {
        mainModel.getRangerRoute(context, "token", new HttpRequestCallback<ResultBean>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
            }

            @Override
            public void onFinish()
            {
                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean resultBean)
            {
                mainView.setRangerRoute();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                mainView.setRangerRoute();
            }
        });
    }

    /**
     * 农化机场
     *
     * @param context
     */
    @Override
    public void getAirportConversion(Context context)
    {
        mainModel.getAirportConversion(context, "token", new HttpRequestCallback<ResultBean>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
            }

            @Override
            public void onFinish()
            {
                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean resultBean)
            {
                mainView.setAirportConversion();
            }


            @Override
            public void onFailure(Call call, HttpException e)
            {
                mainView.setAirportConversion();
            }
        });
    }

    /**
     * 护林机场
     *
     * @param context
     */
    @Override
    public void getRangerAirport(Context context)
    {
        mainModel.getRangerAirport(context, "token", new HttpRequestCallback<ResultBean>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
            }

            @Override
            public void onFinish()
            {
                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean resultBean)
            {
                mainView.setRangerAirport();
            }


            @Override
            public void onFailure(Call call, HttpException e)
            {
                mainView.setRangerAirport();
            }
        });
    }

    /**
     * 民航机场
     *
     * @param context
     */
    @Override
    public void getCivilAviationAirport(Context context)
    {
        mainModel.getCivilAviationAirport(context, "token", new HttpRequestCallback<ResultBean>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
            }

            @Override
            public void onFinish()
            {
                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean resultBean)
            {
                mainView.disPro();
                mainView.setCivilAviationAirport();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                mainView.disPro();
                mainView.setCivilAviationAirport();
            }
        });
    }

    /**
     * 禁飞区
     *
     * @param context
     */
    @Override
    public void getNoFlyZone(Context context)
    {
        mainModel.getNoFlyZone(context, "token", new HttpRequestCallback<ResultBean>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
            }

            @Override
            public void onFinish()
            {
                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean resultBean)
            {
                mainView.disPro();
                mainView.setNoFlyZone();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                mainView.disPro();
                mainView.setNoFlyZone();
            }
        });
    }

    /**
     * 加油点
     *
     * @param context
     */
    @Override
    public void getRefuelingPoint(Context context)
    {
        mainModel.getRefuelingPoint(context, "token", new HttpRequestCallback<ResultBean>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
            }

            @Override
            public void onFinish()
            {
                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean resultBean)
            {
                mainView.disPro();
                mainView.setRefuelingPoint();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                mainView.disPro();
                mainView.setRefuelingPoint();
            }
        });
    }

    /**
     * 民航航线
     *
     * @param context
     */
    @Override
    public void getCivilAviationRoute(Context context)
    {
        mainModel.getCivilAviationRoute(context, "token", new HttpRequestCallback<ResultBean>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
            }

            @Override
            public void onFinish()
            {
                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean resultBean)
            {
                mainView.disPro();
                mainView.setCivilAviationRoute();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                mainView.disPro();
                mainView.setCivilAviationRoute();
            }
        });
    }

    /**
     * 获取飞机筛选结果
     *
     * @param context
     */
    @Override
    public void getFlightChoose(Context context)
    {
        mainModel.getFlightChoose(context, "token", new HttpRequestCallback<ResultBean>()
        {
            @Override
            public void onStart()
            {
                mainView.showPro();
                mainView.setFlightChoose();
                mainView.disPro();
            }

            @Override
            public void onFinish()
            {
//                mainView.setFlightChoose();
//                mainView.disPro();
            }

            @Override
            public void onResponse(ResultBean resultBean)
            {
//                mainView.disPro();
//                mainView.setFlightChoose();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
//                mainView.setFlightChoose();
//                mainView.disPro();
            }
        });
    }

    @Override
    public void getRelTimeFlt(Activity activity)
    {
        mainModel.getRelTimeFlt(activity, "token", new HttpRequestCallback<String>()
        {
            @Override
            public void onStart()
            {
            }

            @Override
            public void onFinish()
            {
            }

            @Override
            public void onResponse(final String str)
            {

                new Thread()
                {
                    @Override
                    public void run()
                    {
                        super.run();
                        try
                        {
                            InputStream is = new ByteArrayInputStream(str.getBytes());
                            String xmlStr = XMLUtil.parseXmlByPull(is);
                            movFltList = JSON.parseArray(xmlStr, MovFlt.class);

                            Message msg = Message.obtain(mHandler);
                            msg.what = 100;
                            msg.sendToTarget();
                        } catch (Exception e)
                        {
                            Logger.e("类型转换异常", e.getMessage());
                            e.printStackTrace();
                        }

                        try
                        {
                            Thread.sleep(10 * 1000);
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                Logger.e("错误日志", e.getMessage());
            }
        });
    }

    @Override
    public void getMovingFlt(Activity activity, String start, String end)
    {
        mainModel.getMovingFlt(activity, start, end, new HttpRequestCallback<String>()
        {
            @Override
            public void onStart()
            {
            }

            @Override
            public void onFinish()
            {
            }

            @Override
            public void onResponse(final String str)
            {
                new Thread()
                {
                    @Override
                    public void run()
                    {
                        super.run();
                        try
                        {
                            Monitor aa = JSON.parseObject(str, Monitor.class);
                            Message msg = Message.obtain(mHandler);
                            msg.obj = aa;
                            msg.what = 100;
                            msg.sendToTarget();

                        } catch (Exception e)
                        {
                            Logger.e("类型转换异常", e.getMessage());
                            e.printStackTrace();
                        }

                    }
                }.start();
            }

            @Override
            public void onFailure(Call call, HttpException e)
            {
                Logger.e("错误日志", e.getMessage());
            }
        });
    }

    Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            if (msg.what == 100)
            {
//                mainView.setMovieFlights(movFltList);
                Monitor monitor = (Monitor) msg.obj;
                if (monitor.getData() != null)
                {
                    mainView.setMovingFlt(monitor.getData());
                }
            }
        }
    };


//    /**
//     * 起降机场
//     * @param context
//     */
//    @Override
//    public void getQjJiang(Context context)
//    {
//
//    }
//
//    /**
//     * 飞机编号
//     * @param context
//     */
//    @Override
//    public void getFltNo(Context context)
//    {
//
//    }
//
//    /**
//     * 飞机型号
//     * @param context
//     */
//    @Override
//    public void getFltType(Context context)
//    {
//
//    }
//
//    /**
//     * 飞行员
//     * @param context
//     */
//    @Override
//    public void getFlter(Context context)
//    {
//
//    }
//
//    /**
//     * 作业类型
//     * @param context
//     */
//    @Override
//    public void getWorkType(Context context)
//    {
//
//    }
}
