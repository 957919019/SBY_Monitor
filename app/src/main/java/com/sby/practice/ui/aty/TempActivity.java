package com.sby.practice.ui.aty;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sby.bean.area.ChooseFlt;
import com.sby.practice.R;
import com.sby.widget.popupWindow.AdapterCatFltPop;
import com.sby.widget.popupWindow.AdapterTypeFltPop;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TempActivity extends AppCompatActivity
{

    @BindView(R.id.rv_catalog)
    RecyclerView rv_catalog;
    @BindView(R.id.rv_type)
    RecyclerView rv_type;

    Activity activity = TempActivity.this;

    private List<ChooseFlt> chooseFltList;
    private AdapterCatFltPop catAdapter;
    private AdapterTypeFltPop typeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        ButterKnife.bind(this);

        rv_catalog.setHasFixedSize(true);
        rv_catalog.setLayoutManager(new LinearLayoutManager(activity));
        rv_catalog.setItemAnimator(new DefaultItemAnimator());// 设置item动画
        rv_type.setHasFixedSize(true);
        rv_type.setLayoutManager(new LinearLayoutManager(activity));
        rv_type.setItemAnimator(new DefaultItemAnimator());// 设置item动画

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
            public void onItemClick(View view, int position )
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

            }
        });
    }

}
