package com.gulup.dqm3dquery.adapter;

import java.util.List;

import org.gulup.annotation.GView;
import org.gulup.utils.ViewUtil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gulu.dqm3dquery.R;
import com.gulup.dqm3dquery.bean.Monster;

public class MonstersAdapter extends BaseAdapter {
    
    private Context context;
    private List<Monster> monsters;
    
    public MonstersAdapter(Context context,List<Monster> monsters) {
	this.context = context;
	this.monsters = monsters;
    }

    @Override
    public int getCount() {
	return monsters.size();
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
	Monster monster = monsters.get(position);
	if(convertView==null){
	    holder = new ViewHolder();
	    convertView = View.inflate(context, R.layout.monsters_item, null);
	    ViewUtil.inject(holder, convertView, context);
	    convertView.setTag(holder);
	}else{
	    holder = (ViewHolder) convertView.getTag();
	}
	int imgId = context.getResources().getIdentifier("m"+monster.getMid(), "drawable", context.getPackageName());
	holder.monster_img.setBackgroundResource(imgId);
	holder.monster_number.setText("NO."+monster.getMid());
	holder.monster_name.setText(monster.getName());
	return convertView;
    }
    
    class ViewHolder{
	@GView(value=R.id.monster_img,width=150,height=150)
	ImageView monster_img;
	@GView(value=R.id.monster_number)
	TextView monster_number;
	@GView(value=R.id.monster_name)
	TextView monster_name;
    }

}
