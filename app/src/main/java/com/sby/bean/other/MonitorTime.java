package com.sby.bean.other;

import java.io.Serializable;

/**
 * Created by kowal on 2017/5/22.
 */

public class MonitorTime implements Serializable
{
    private String startDate;
    private String endDate;

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }
}
