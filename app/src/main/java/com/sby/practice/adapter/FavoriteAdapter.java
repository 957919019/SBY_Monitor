package com.sby.practice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.mapapi.favorite.FavoritePoiInfo;
import com.sby.practice.R;

import java.util.List;

/**
 * 我的收藏适配器
 * Created by kowal on 2016/11/23.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>
{
    private List<FavoritePoiInfo> list;
    private Context context;
    private LayoutInflater mInflater;
    private FavoAdapterClick listener = null;


    public interface FavoAdapterClick
    {
        void onItemClick(View view, int position );
        void onDelClick(View view, String currentId);
    }

    public void setOnItemClickLitener(FavoAdapterClick mOnItemClickLitener )
    {
        this.listener = mOnItemClickLitener;
    }

    public void removeData(int position)
    {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public FavoriteAdapter(Context context, List<FavoritePoiInfo> list )
    {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.item_favo_adapter, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        holder.tv_title.setText(list.get(position).getPoiName());//为控件绑定数据

        if (null != listener)
        {
            final int pos = holder.getLayoutPosition();
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    listener.onItemClick(holder.itemView, pos);
                }
            });
            holder.iv_del.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    listener.onDelClick(v, list.get(pos).getID());
                    removeData(pos);
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
        ImageView iv_del;

        public MyViewHolder(final View itemView)
        {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.item_favo_tv_title);
            iv_del = (ImageView) itemView.findViewById(R.id.item_favo_iv_del);
        }
    }

}
