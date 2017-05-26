package com.sby.bean.other;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kowal on 2016/10/28.
 */

public class ChooseFlightModel implements Serializable
{
    private List<String> cList;

    public List<String> getcList()
    {
        return cList;
    }

    public void setcList(List<String> cList)
    {
        this.cList = cList;
    }

    @Override
    public String toString()
    {
        return "ChooseFlight{" +
                "cList=" + cList +
                '}';
    }
}
