package com.sby.practice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sby.practice.R;

import java.util.List;

/**
 * 搜索结果适配器
 * Created by kowal on 2016/10/14.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MyViewHolder>
{
    private List<String> list;
    private Context context;
    private LayoutInflater mInflater;
    private SearchResultClick listener = null;

    public interface SearchResultClick
    {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(SearchResultClick mOnItemClickLitener)
    {
        this.listener = mOnItemClickLitener;
    }

    public SearchResultAdapter(Context context, List<String> list)
    {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.item_search_result_activity_adapter, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        holder.tv_result.setText(list.get(position));//为控件绑定数据

        if ( null != listener)
        {
            final int pos = holder.getLayoutPosition();

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    listener.onItemClick(holder.itemView , pos);
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

        TextView tv_result;

        public MyViewHolder(final View itemView)
        {
            super(itemView);
            tv_result = (TextView) itemView.findViewById(R.id.item_search_result_adapter_tv_result);
        }
    }
}
