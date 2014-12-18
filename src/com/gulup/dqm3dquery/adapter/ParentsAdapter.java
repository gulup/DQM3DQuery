package com.gulup.dqm3dquery.adapter;

import java.util.List;

import org.gulup.annotation.GView;
import org.gulup.utils.ViewUtil;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.gulu.dqm3dquery.R;
import com.gulup.dqm3dquery.action.MonsterAction;
import com.gulup.dqm3dquery.bean.Monster;
import com.gulup.dqm3dquery.view.MonsterView;

public class ParentsAdapter extends BaseAdapter {

    private Context context;
    private List<Monster[]> parents;
    private List<String[]> monsters;
    private MonsterAction action;

    public ParentsAdapter(Context context, MonsterAction action) {
	this.context = context;
	this.action = action;
    }

    @Override
    public int getCount() {
	return parents.size();
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
	Monster[] monsters = parents.get(position);
	String[] monsterArray = this.monsters.get(position);
	switch (monsters.length) {
	case 2:
	    convertView = View.inflate(context, R.layout.monster_parents_item, null);
	    ViewHolder holder = new ViewHolder();
	    ViewUtil.inject(holder, convertView, context);
	    initHolder2(monsters,monsterArray,holder);
	    break;
	case 4:
	    convertView = View.inflate(context, R.layout.monster_parents_item4, null);
	    ViewHolder4 holder4 = new ViewHolder4();
	    ViewUtil.inject(holder4, convertView, context);
	    initHolder4(monsters,monsterArray,holder4);
	    break;
	default:
	    break;
	}
	return convertView;
    }

    public void initHolder2(Monster[] monsters,String[] monsterArray,ViewHolder holder){
	if (monsters[0] != null) {
	    int bImgId = context.getResources().getIdentifier(
		    "m" + monsters[0].getMid(), "drawable",
		    context.getPackageName());
	    holder.monster_b.setBackgroundResource(bImgId);
	    holder.monster_b.setOnClickListener(new MyOnClick(monsters[0]));
	} else {
	    holder.monster_b.setBackgroundResource(getNullImg(monsterArray[0]));
	}
	if (monsters[1] != null) {
	    int mImgId = context.getResources().getIdentifier(
		    "m" + monsters[1].getMid(), "drawable",
		    context.getPackageName());
	    holder.monster_m.setBackgroundResource(mImgId);
	    holder.monster_m.setOnClickListener(new MyOnClick(monsters[1]));
	} else {
	    holder.monster_m.setBackgroundResource(getNullImg(monsterArray[1]));
	}
    }
    
    public void initHolder4(Monster[] monsters,String[] monsterArray,ViewHolder4 holder){
	if (monsters[0] != null) {
	    int bImgId = context.getResources().getIdentifier(
		    "m" + monsters[0].getMid(), "drawable",
		    context.getPackageName());
	    holder.monster_b.setBackgroundResource(bImgId);
	    holder.monster_b.setOnClickListener(new MyOnClick(monsters[0]));
	} else {
	    holder.monster_b.setBackgroundResource(getNullImg(monsterArray[0]));
	}
	if (monsters[1] != null) {
	    int mImgId = context.getResources().getIdentifier(
		    "m" + monsters[1].getMid(), "drawable",
		    context.getPackageName());
	    holder.monster_m.setBackgroundResource(mImgId);
	    holder.monster_m.setOnClickListener(new MyOnClick(monsters[1]));
	} else {
	    holder.monster_m.setBackgroundResource(getNullImg(monsterArray[1]));
	}
	if (monsters[2] != null) {
	    int mImgId = context.getResources().getIdentifier(
		    "m" + monsters[2].getMid(), "drawable",
		    context.getPackageName());
	    holder.monster_3.setBackgroundResource(mImgId);
	    holder.monster_3.setOnClickListener(new MyOnClick(monsters[2]));
	} else {
	    holder.monster_3.setBackgroundResource(getNullImg(monsterArray[2]));
	}
	if (monsters[3] != null) {
	    int mImgId = context.getResources().getIdentifier(
		    "m" + monsters[3].getMid(), "drawable",
		    context.getPackageName());
	    holder.monster_4.setBackgroundResource(mImgId);
	    holder.monster_4.setOnClickListener(new MyOnClick(monsters[3]));
	} else {
	    holder.monster_4.setBackgroundResource(getNullImg(monsterArray[3]));
	}
    }
    
    public int getNullImg(String monsterName){
	int imgId = 0;
	if(monsterName.equals(context.getString(R.string.slm_x))){
	    imgId = R.drawable.slm_x;
	}else if(monsterName.equals(context.getString(R.string.long_x))){
	    imgId = R.drawable.long_x;
	}else if(monsterName.equals(context.getString(R.string.ms_x))){
	    imgId = R.drawable.ms_x;
	}else if(monsterName.equals(context.getString(R.string.js_x))){
	    imgId = R.drawable.js_x;
	}else if(monsterName.equals(context.getString(R.string.zr_x))){
	    imgId = R.drawable.zr_x;
	}else if(monsterName.equals(context.getString(R.string.wz_x))){
	    imgId = R.drawable.wz_x;
	}else if(monsterName.equals(context.getString(R.string.em_x))){
	    imgId = R.drawable.em_x;
	}
	return imgId;
    }
    
    class ViewHolder {
	@GView(value = R.id.monster_b, width = 180, height = 180)
	ImageView monster_b;
	@GView(value = R.id.monster_m, width = 180, height = 180)
	ImageView monster_m;
    }
    
    class ViewHolder4 {
	@GView(value = R.id.monster_b, width = 120, height = 120)
	ImageView monster_b;
	@GView(value = R.id.monster_m, width = 120, height = 120)
	ImageView monster_m;
	@GView(value = R.id.monster_3, width = 120, height = 120)
	ImageView monster_3;
	@GView(value = R.id.monster_4, width = 120, height = 120)
	ImageView monster_4;
    }

    private class MyOnClick implements OnClickListener {

	private Monster monster;

	public MyOnClick(Monster monster) {
	    this.monster = monster;
	}

	@Override
	public void onClick(View v) {
	    action.updateMonsterDetail(monster);
	}
    }

    public List<Monster[]> getParents() {
	return parents;
    }

    public void setParents(List<Monster[]> parents) {
	this.parents = parents;
    }

    public List<String[]> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<String[]> monsters) {
        this.monsters = monsters;
    }
    
}
