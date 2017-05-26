package com.sby.practice.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.mapapi.search.core.PoiInfo;
import com.sby.practice.R;

import java.util.List;

/** 搜索结果适配器
 * Created by kowal on 2016/11/30.
 */

public class FavoSearchResultAdapter extends RecyclerView.Adapter<FavoSearchResultAdapter.MyViewHolder>
{
    private List<PoiInfo> list;
    private Context context;
    private LayoutInflater mInflater;
    private OnSearchResultItemCL listener = null;

    public interface OnSearchResultItemCL
    {
        void onItemClick(View view, int position );
    }

    public void setOnItemClickListener(OnSearchResultItemCL mOnItemClickListener)
    {
        this.listener = mOnItemClickListener;
    }

    public FavoSearchResultAdapter (Context context , List<PoiInfo> list)
    {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.item_favo_search_result, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        holder.tv_title.setText(list.get(position).name);//为控件绑定数据
        holder.tv_address.setText(list.get(position).address);//为控件绑定数据
        holder.tv_city.setText(list.get(position).city );//为控件绑定数据

        if (null != listener)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    listener.onItemClick(holder.itemView, position );
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_title;
        TextView tv_address;
        TextView tv_city;

        public MyViewHolder(final View itemView)
        {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.item_favo_search_result_tv_title);
            tv_address = (TextView) itemView.findViewById(R.id.item_favo_search_result_tv_address);
            tv_city = (TextView) itemView.findViewById(R.id.item_favo_search_result_tv_city);
        }
    }
}
