package com.sby.practice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sby.bean.other.FlightBean;
import com.sby.practice.R;

import java.util.List;

/**
 * 飞机型号适配器
 * Created by kowal on 2016/10/26.
 */
public class FlightModelAdapter extends RecyclerView.Adapter<FlightModelAdapter.MyViewHolder>
{

    private List<FlightBean> list;
    private Context context;

    public FlightModelAdapter(Context context, List<FlightBean> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public FlightModelAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_flight_model_adapter, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final FlightModelAdapter.MyViewHolder holder, final int position)
    {
        holder.tv_model.setText(list.get(position).getFltModel());
        holder.tv_num.setText(list.get(position).getFlightNum() + "");
    }

    @Override
    public int getItemCount()
    {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv_model, tv_num;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            tv_model = (TextView) itemView.findViewById(R.id.tv_model);
            tv_num = (TextView) itemView.findViewById(R.id.tv_num);
        }
    }
}
