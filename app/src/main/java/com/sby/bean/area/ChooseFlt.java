package com.sby.bean.area;

import java.util.List;

/**
 * Created by kowal on 2017/5/17.
 */

public class ChooseFlt
{
    private String catelog;
    private List<String> catelogList;
    private List<ChooseFlt> chooseFltList;

    public String getCatelog()
    {
        return catelog;
    }

    public void setCatelog(String catelog)
    {
        this.catelog = catelog;
    }

    public List<String> getCatelogList()
    {
        return catelogList;
    }

    public void setCatelogList(List<String> catelogList)
    {
        this.catelogList = catelogList;
    }

    public List<ChooseFlt> getChooseFltList()
    {
        return chooseFltList;
    }

    public void setChooseFltList(List<ChooseFlt> chooseFltList)
    {
        this.chooseFltList = chooseFltList;
    }
}
