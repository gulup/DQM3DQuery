package com.gulup.dqm3dquery.adapter;

import org.gulup.annotation.GView;
import org.gulup.utils.ViewUtil;

import com.gulu.dqm3dquery.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {
    private Context context;
    private String[] items;
    
    public MainAdapter(Context context) {
	this.context = context;
	items = context.getResources().getStringArray(R.array.items);
    }

    @Override
    public int getCount() {
	return items.length;
    }

    @Override
    public Object getItem(int position) {
	return null;
    }

    @Override
    public long getItemId(int position) {
	return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
	ViewHolder holder;
	if(convertView==null){
	    holder = new ViewHolder();
	    convertView = View.inflate(context, R.layout.main_item, null);
	    ViewUtil.inject(holder, convertView, context);
	    convertView.setTag(holder);
	}else{
	    holder = (ViewHolder) convertView.getTag();
	}
	holder.item_img.setBackgroundResource(R.drawable.m1);
	holder.item_name.setText(items[position]);
	return convertView;
    }

    class ViewHolder{
	@GView(value=R.id.item_img,width=120,height=120)
	ImageView item_img;
	@GView(value=R.id.item_name)
	TextView item_name;
    }

}
