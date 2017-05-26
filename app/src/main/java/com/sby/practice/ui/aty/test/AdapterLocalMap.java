package com.sby.practice.ui.aty.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baidu.mapapi.map.offline.MKOLSearchRecord;
import com.sby.practice.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kowal on 2017/4/25.
 */

public class AdapterLocalMap extends RecyclerView.Adapter<AdapterLocalMap.MyViewHolder>
{

    private ArrayList<MKOLSearchRecord> list;
    private Context mContext;

    public AdapterLocalMap(Context context, ArrayList<MKOLSearchRecord> list)
    {
        this.list = list;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.text_local_item_complete, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.tv_name.setText(list.get(position).cityName);
        int status = list.get(position).cityID;
        holder.tv_status.setText(status + "");
        holder.tv_size.setText(list.get(position).size + "");
//        holder.iv_pic.set
//        holder.bt_seemap
//                holder.bt_start
//                holder.bt_del
//                holder.ll_bottom
        holder.pb_bar.setIndeterminate(true);
        holder.pb_bar.setProgress(100);
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.tv_city_name)
        TextView tv_name;
        @BindView(R.id.tv_status)
        TextView tv_status;
        @BindView(R.id.tv_size)
        TextView tv_size;
        @BindView(R.id.iv_pic)
        ImageView iv_pic;
        @BindView(R.id.bt_seemap)
        Button bt_seemap;
        @BindView(R.id.bt_start)
        Button bt_start;
        @BindView(R.id.bt_del)
        Button bt_del;
        @BindView(R.id.ll_bottom)
        LinearLayout ll_bottom;
        @BindView(R.id.pb_bar)
        ProgressBar pb_bar;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
