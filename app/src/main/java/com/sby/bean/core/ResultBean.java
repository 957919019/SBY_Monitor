package com.sby.bean.core;

/**
 * 返回的对象
 * Created by kowal on 2016/12/16.
 */

public class ResultBean<T>
{
    private String state;
    private Object receipt;
    private T data;

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public Object getReceipt()
    {
        return receipt;
    }

    public void setReceipt(Object receipt)
    {
        this.receipt = receipt;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ResultBean{" +
                "state='" + state + '\'' +
                ", receipt=" + receipt +
                ", data=" + data +
                '}';
    }
}
