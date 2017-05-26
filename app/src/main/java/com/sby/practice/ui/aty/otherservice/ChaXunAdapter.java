package com.sby.practice.ui.aty.otherservice;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sby.bean.other.ChaXun;
import com.sby.practice.R;
import com.sby.utils.StringUtil;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ChaXunAdapter extends RecyclerView.Adapter<ChaXunAdapter.ViewHolder>
{


    public int selectPosition = -1;// TODO: 2017/5/21 在其他界面更新adapter时，将它设为-1

    private Context mContext;
    private List<ChaXun.DataBean> list;
    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    static class ViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.item_cx_bianhao)
        TextView itemCxBianhao;
        @BindView(R.id.item_cx_leixing)
        TextView itemCxLeixing;
        @BindView(R.id.item_cx_jihao)
        TextView itemCxJihao;
        @BindView(R.id.item_cx_yujitime)
        TextView itemCxYujitime;
        @BindView(R.id.item_cx_qifeijc)
        TextView itemCxQifeijc;
        @BindView(R.id.item_cx_jiangluojc)
        TextView itemCxJiangluojc;
        @BindView(R.id.item_cx_feixingdate)
        TextView itemCxFeixingdate;
        @BindView(R.id.item_cx_zt1)
        TextView itemCxZt1;
        @BindView(R.id.item_cx_zt2)
        TextView itemCxZt2;
        @BindView(R.id.item_cx_zt3)
        TextView itemCxZt3;
        @BindView(R.id.item_cx_zt4)
        TextView itemCxZt4;
        @BindView(R.id.item_cx_cardview)
        CardView itemCxCardview;
        @BindView(R.id.item_cx_visb)
        LinearLayout layoutVisb;

        public ViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public ChaXunAdapter(Context mContext, List<ChaXun.DataBean> data)
    {
        list = data;
        this.mContext = mContext;
        initHashMap();
    }

    private void initHashMap()
    {
        for (int i = 0; i < list.size(); i++)
        {
            hashMap.put(i, 0);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (mContext == null)
        {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_chaxun, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemCxCardview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int position = holder.getAdapterPosition();
                initHashMap();
                hashMap.put(position, 1);
                selectPosition = position;
                notifyDataSetChanged();

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        ChaXun.DataBean dataBean = list.get(position);
        if (dataBean != null)
        {
            holder.itemCxBianhao.setText(dataBean.getId());
            holder.itemCxLeixing.setText("护林计划");
            holder.itemCxJihao.setText(dataBean.getAllPilots() ==null ? "" : dataBean.getAllPilots());
            holder.itemCxYujitime.setText(dataBean.getDepartureDate() == 0 ? "" : StringUtil.getDateDate(dataBean.getDepartureDate()));
            holder.itemCxQifeijc.setText(dataBean.getTakeOffAirportName() ==null ? "" : dataBean.getTakeOffAirportName());
            holder.itemCxJiangluojc.setText(dataBean.getLandingAirportName() ==null ? "" : dataBean.getLandingAirportName());
            holder.itemCxFeixingdate.setText("");

            Integer submit = dataBean.getIsSubmit();

            holder.itemCxZt1.setText("未提交");
            holder.itemCxZt1.setEnabled(false);

            if (submit!= null)
            {
                if ("1".equals(String.valueOf(submit)))

                {
                    holder.itemCxZt1.setText("已提交");
                    holder.itemCxZt1.setEnabled(true);

                }
            }
        }

        for (int i = 0; i < list.size(); i++)
        {
            hashMap.put(i, 0);
        }
        hashMap.put(selectPosition, 1);
        int v = hashMap.get(position) == 0 ? View.GONE : View.VISIBLE;
        holder.layoutVisb.setVisibility(v);
        // TODO: 2017/5/21 去设置空间的显示
        if (v == View.VISIBLE)
        {
            // TODO: 2017/5/21 设置显示四个状态

        }

    }


    @Override
    public int getItemCount()
    {
        return list.size();
    }

}























