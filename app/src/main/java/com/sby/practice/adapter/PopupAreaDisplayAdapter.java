package com.sby.practice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.sby.practice.R;

import java.util.List;

/**区域选择适配器
 * Created by kowal on 2016/10/24.
 */

public class PopupAreaDisplayAdapter extends RecyclerView.Adapter<PopupAreaDisplayAdapter.MyViewHolder>
{

    private Context mContext;
    private List<String> mData;
    private onChangedListener mListener;
    private List<Boolean> isSelect;


    public PopupAreaDisplayAdapter(Context context, List<String> list, List<Boolean> mSelect)
    {
        this.mContext = context;
        this.mData = list;
        this.isSelect = mSelect;
    }

    public interface onChangedListener
    {
        void onChanged(View view, int position, boolean isSelectd);
    }

    public void onCheckedChangedListener(onChangedListener listener)
    {
        this.mListener = listener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        CheckBox cb_box;

        public MyViewHolder(View view)
        {
            super(view);
            cb_box = (CheckBox) view.findViewById(R.id.pop_exp_layout_area_display_content_cb_box);

            cb_box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    mListener.onChanged(buttonView, getAdapterPosition(), isChecked);
                }
            });
        }
    }

    @Override
    public PopupAreaDisplayAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_pop_area_display, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(PopupAreaDisplayAdapter.MyViewHolder holder, final int position)
    {
        holder.cb_box.setText(mData.get(position).toString());
        holder.cb_box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                mListener.onChanged(buttonView, position, isChecked);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }
}
