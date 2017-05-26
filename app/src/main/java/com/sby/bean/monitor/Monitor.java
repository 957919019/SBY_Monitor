package com.sby.bean.monitor;

import java.util.List;

public class Monitor
{
    private String state;

    private String receipt;

    private List<Data> data;


    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return this.state;
    }

    public void setReceipt(String receipt)
    {
        this.receipt = receipt;
    }

    public String getReceipt()
    {
        return this.receipt;
    }

    public void setData(List<Data> data)
    {
        this.data = data;
    }

    public List<Data> getData()
    {
        return this.data;
    }

}