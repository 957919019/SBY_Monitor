package com.sby.widget.popupWindow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sby.bean.area.ChooseFlt;
import com.sby.practice.R;

import java.util.List;

/**
 * Created by kowal on 2017/5/17.
 */

public class AdapterCatFltPop extends RecyclerView.Adapter<AdapterCatFltPop.MyViewHolder>
{
    private List<ChooseFlt> mList;
    private Context context;
    private CatFltPopListener itemListener;
    private int catPosition = 0;

    public interface CatFltPopListener
    {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(CatFltPopListener mOnItemClickLitener)
    {
        this.itemListener = mOnItemClickLitener;
    }

    public AdapterCatFltPop(Context context, List<ChooseFlt> list)
    {
        this.context = context;
        this.mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pop_choose_cat, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        holder.tv_catelog.setText(mList.get(position).getCatelog());
        if (catPosition == position)
        {
            holder.tv_catelog.setTextColor(context.getResources().getColor(R.color.black));
            holder.tv_catelog.setBackgroundResource(R.color.white);
        } else
        {
            holder.tv_catelog.setTextColor(context.getResources().getColor(R.color.light_gray));
            holder.tv_catelog.setBackgroundResource(R.color.gray);
        }

        holder.itemView.setClickable(true);
        if (itemListener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    itemListener.onItemClick(holder.tv_catelog, position);
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return mList == null ? 0 : mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_catelog;

        public MyViewHolder(final View itemView)
        {
            super(itemView);
            tv_catelog = (TextView) itemView.findViewById(R.id.tv_catelog);
        }
    }

    public void setPosition(int position)
    {
        this.catPosition = position;
    }
}
