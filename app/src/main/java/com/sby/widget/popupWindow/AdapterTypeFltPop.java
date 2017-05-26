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

public class AdapterTypeFltPop extends RecyclerView.Adapter<AdapterTypeFltPop.MyViewHolder>
{
    private List<ChooseFlt> mList;
    private Context context;
    private TypeFltPopListener itemListener;

    private int catPosition = 0;

    public void setPosition(int position) {
        this.catPosition = position;
    }

    public AdapterTypeFltPop(Context context, List<ChooseFlt> list, int catNum)
    {
        this.context = context;
        this.mList = list;
        this.catPosition = catNum;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pop_choose_type, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        holder.tv_type.setText(mList.get(catPosition).getCatelogList().get(position) );

        holder.itemView.setClickable(true);
        if (itemListener != null)
        {
            final int pos = holder.getLayoutPosition();

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    itemListener.onItemClick(holder.tv_type, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return mList == null ? 0 : mList.get(catPosition).getCatelogList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_type;

        public MyViewHolder(final View itemView)
        {
            super(itemView);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);
        }
    }

    public interface TypeFltPopListener
    {
        void onItemClick(View view, int position);
    }


    public void setOnItemClickLitener(TypeFltPopListener mOnItemClickLitener)
    {
        this.itemListener = mOnItemClickLitener;
    }


}
