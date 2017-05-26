package com.sby.practice.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sby.bean.flt.JiChang;
import com.sby.practice.R;

import java.util.List;

public class JiChangAdapter extends BaseAdapter {

	private List<JiChang> sList;
	private LayoutInflater mInflater;

	public JiChangAdapter(Context context, List<JiChang> values) {
		sList = values;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return sList.size();
	}

	@Override
	public JiChang getItem(int position) {
		return sList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(
					R.layout.hulin_spinner, null);
			holder.tv_supplier = (TextView) convertView
					.findViewById(R.id.tv_hulin);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_supplier.setText(sList.get(position).getjCName());
		return convertView;
	}

	class ViewHolder {
		private TextView tv_supplier;
	}

	/**
	 * 下拉布局
	 * 
	 * @param resource
	 */
	private int mDropDownResource;
	private int mFieldId = 0;

	public void setDropDownViewResource(int resource) {
		this.mDropDownResource = resource;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return createViewFromResource(position, convertView, parent,
				mDropDownResource);
	}

	private View createViewFromResource(int position, View convertView,
			ViewGroup parent, int resource) {
		View view;
		TextView text;

		if (convertView == null) {
			view = mInflater.inflate(resource, parent, false);
		} else {
			view = convertView;
		}

		try {
			if (mFieldId == 0) {
				text = (TextView) view;
			} else {
				text = (TextView) view.findViewById(mFieldId);
			}
		} catch (ClassCastException e) {
			Log.e("ArrayAdapter",
					"You must supply a resource ID for a TextView");
			throw new IllegalStateException(
					"ArrayAdapter requires the resource ID to be a TextView", e);
		}

		JiChang item = getItem(position);
		if (item instanceof CharSequence) {
			text.setText(item.getjCName());
		} else {
			text.setText(item.getjCName());
		}

		return view;
	}
}
