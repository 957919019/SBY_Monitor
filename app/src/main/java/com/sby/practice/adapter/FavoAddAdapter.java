package com.sby.practice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sby.practice.R;

import java.util.List;

/**
 * Created by kowal on 2016/11/25.
 */

public class FavoAddAdapter extends RecyclerView.Adapter<FavoAddAdapter.MyViewHolder>
{
    private List<String> list;
    private Context context;
    private LayoutInflater mInflater;
    private FavoAddClick listener = null;

    public interface FavoAddClick
    {
        void onItemClick(View view, int position);

        void onDelClick(View view, int position);
    }

    public void setOnItemClickListener(FavoAddClick mOnItemClickListener)
    {
        this.listener = mOnItemClickListener;
    }

    // 删除一条
    public void removeData(int position)
    {
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    // 清空
    public void remoceAll()
    {
        list.clear();
    }

    // 添加一条数据
    public void add(String item, int position)
    {
        list.add(position, item);
        notifyItemInserted(position);
    }

    public FavoAddAdapter(Context context, List<String> list)
    {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.item_favo_add, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        holder.tv_title.setText(list.get(position).toString());//为控件绑定数据

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
                    listener.onDelClick(v, position);
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
            tv_title = (TextView) itemView.findViewById(R.id.item_favo_add_tv_history);
            iv_del = (ImageView) itemView.findViewById(R.id.item_favo_add_iv_del);
        }
    }
}
