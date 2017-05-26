package com.sby.widget.popupWindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.sby.bean.area.ChooseFlt;
import com.sby.practice.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择飞机
 * Created by kowal on 2017/5/17.
 */

public class PopChooseFlt implements View.OnTouchListener
{
    private Context context;
    private PopupWindow popupWindow;

    private ChooseFltListener itemListener;
    private RecyclerView rv_catalog;
    private RecyclerView rv_type;

    private List<ChooseFlt> chooseFltList;
    private AdapterCatFltPop catAdapter;
    private AdapterTypeFltPop typeAdapter;


    public interface ChooseFltListener
    {
        void catClick(View v, AdapterCatFltPop catAdapter);

        void typeClick(View v, AdapterTypeFltPop typeAdapter);
    }

    public void onSetCatClickListener(ChooseFltListener listener)
    {
        this.itemListener = listener;
    }

    public PopChooseFlt(Context context, ChooseFltListener callback)
    {
        this.context = context;
        this.itemListener = callback;
    }

    private void setData()
    {
        catAdapter = new AdapterCatFltPop(context, chooseFltList);
        rv_catalog.setAdapter(catAdapter);
        typeAdapter = new AdapterTypeFltPop(context, chooseFltList, 0);
        rv_type.setAdapter(typeAdapter);
    }

    /**
     * 显示Pop
     */
    public PopChooseFlt showPop(View v)
    {
        if (null != popupWindow)
        {
            popupWindow.dismiss();
        } else
        {
            initWidget(v);
            getDatas();
            setData();
        }
        return this;
    }

    /**
     * 初始化控件
     *
     * @param v
     */
    private void initWidget(View v)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.popup_window_choose_flt, null);
        rv_catalog = (RecyclerView) view.findViewById(R.id.rv_catalog);
        rv_type = (RecyclerView) view.findViewById(R.id.rv_type);

        rv_catalog.setHasFixedSize(true);
        rv_catalog.setLayoutManager(new LinearLayoutManager(context));
        rv_catalog.setItemAnimator(new DefaultItemAnimator());// 设置item动画
        rv_type.setHasFixedSize(true);
        rv_type.setLayoutManager(new LinearLayoutManager(context));
        rv_type.setItemAnimator(new DefaultItemAnimator());// 设置item动画

        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        // 设置背景主要作用就是能够在返回键和点击其他区域时候能够隐藏PopupWindow
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        //设置可点击
        popupWindow.setTouchable(true);
        // 设置点击空白区域取消PopupWindow，还要必须设置透明的背景才会生效
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        // 设置popWindow的显示和消失动画
        popupWindow.setAnimationStyle(R.style.pop_calendar_anim_style);
        popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);//在底部显示popupwindow.
    }

    private void getDatas()
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
        ch5.setCatelogList(leixing);
        chooseFltList.add(ch5);
    }

    /**
     * 触摸关闭
     */
    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if (null != popupWindow && popupWindow.isShowing())
        {
            popupWindow.dismiss();
            popupWindow = null;
        }
        return false;
    }

    /**
     * 关闭Pop
     */
    public boolean disMissPop()
    {
        boolean isshowing = false;
        if (null != popupWindow)
        {
            isshowing = popupWindow.isShowing();
            popupWindow.dismiss();
        }
        return isshowing;
    }


}
