package com.sby.practice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.sby.practice.R;

import java.util.List;

/**
 * 飞机选择适配器
 * Created by kowal on 2016/10/28.
 */

public class ChooseFlightAdapter extends BaseAdapter implements SpinnerAdapter
{
    private List<String> mList;
    private Context mContext;
    private LayoutInflater mInflater;

    public ChooseFlightAdapter(Context context, List<String> list)
    {
        super();
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount()
    {
        return mList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = mInflater.from(mContext).inflate(R.layout.item_choose_flight, parent, false);
        TextView tv = (TextView) convertView.findViewById(R.id.item_choose_flight_tv_text);
        tv.setText(mList.get(position));
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        convertView = mInflater.from(mContext).inflate(R.layout.item_choose_flight, parent, false);
        TextView tv = (TextView) convertView.findViewById(R.id.item_choose_flight_tv_text);
        tv.setCompoundDrawables(null, null, null, null);
        tv.setText(mList.get(position));
        return convertView;
    }

}
