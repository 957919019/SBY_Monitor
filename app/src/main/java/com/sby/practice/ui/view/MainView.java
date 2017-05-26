package com.sby.practice.ui.view;

import com.sby.bean.area.AreaReport;
import com.sby.bean.area.FixedAirSpace;
import com.sby.bean.flt.MovFlt;
import com.sby.bean.monitor.Data;
import com.sby.bean.other.FlightInfo;

import java.util.List;

/**
 * 主界面View
 * Created by kowal on 2016/12/13.
 */

public interface MainView
{
    void setMovieFlights(List<MovFlt> flts); // 获取所有飞机点

    void setFlights(List<FlightInfo> flightsList); // 获取所有飞机点

    void setReportPoint(List<AreaReport> reportPoints); // 报告点

    void setFixedAirspace(List<FixedAirSpace> fixedAirspaceList);  // 固定空域

    void setRangerRoute(); // 护林航线

    void setAirportConversion(); // 农化机场

    void setRangerAirport(); // 护林机场

    void setCivilAviationAirport(); // 民航机场

    void setNoFlyZone(); // 禁飞区

    void setRefuelingPoint(); // 加油点

    void setCivilAviationRoute(); // 民航航线

    void setFlightChoose(); // 获取飞机筛选结果

    void showTip(String str);

    void showPro();

    void disPro();

    void setMovingFlt(List<Data> data);


//    void getFltChoose(Context context);// 起降机场,飞机编号，飞机型号，飞行员，作业类型

//    void setQjJiang(Context context);
//
//    void setFltNo(Context context);
//
//    void setFltType(Context context);
//
//    void setFlter(Context context);
//
//    void setWorkType(Context context);
}
