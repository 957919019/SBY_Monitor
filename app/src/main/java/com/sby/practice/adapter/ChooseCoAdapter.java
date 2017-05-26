package com.sby.practice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sby.bean.user.Company;
import com.sby.practice.R;

import java.util.List;


/**
 * 选择公司的RecyclerView适配器
 * Created by kowal on 2016/11/3.
 */
public class ChooseCoAdapter extends RecyclerView.Adapter<ChooseCoAdapter.MyViewHolder>
{
    private List<Company> mList;
    private Context context;
    private ChooseCoAdapterClick itemClickListener;

    public ChooseCoAdapter(Context context, List<Company> list)
    {
        this.context = context;
        this.mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_choose_co_recycler_adapter, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        holder.textView.setText(mList.get(position).getCompanyName() );

        holder.itemView.setClickable(true);
        if (itemClickListener != null)
        {
            final int pos = holder.getLayoutPosition();

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    itemClickListener.onItemClick(holder.textView, pos);
                }
            });
        }
    }

    public String getItem(int position)
    {
        return mList.get(position).getCompanyName() ;
    }

    @Override
    public int getItemCount()
    {
        return mList == null ? 0 : mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public MyViewHolder(final View itemView)
        {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_choose_co_rvlist_tv_coName);
        }
    }

    public interface ChooseCoAdapterClick
    {
        void onItemClick(View view, int position);
    }


    public void setOnItemClickLitener(ChooseCoAdapterClick mOnItemClickLitener)
    {
        this.itemClickListener = mOnItemClickLitener;
    }
}
