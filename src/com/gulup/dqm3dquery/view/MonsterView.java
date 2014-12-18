package com.gulup.dqm3dquery.view;

import java.util.ArrayList;
import java.util.List;

import org.gulup.annotation.GAction;
import org.gulup.annotation.GContentView;
import org.gulup.annotation.GView;
import org.gulup.core.GData;
import org.gulup.view.GBaseView;

import android.os.Bundle;
import android.util.MonthDisplayHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gulu.dqm3dquery.R;
import com.gulup.dqm3dquery.action.MonsterAction;
import com.gulup.dqm3dquery.adapter.ParentsAdapter;
import com.gulup.dqm3dquery.bean.Monster;
import com.gulup.dqm3dquery.db.DQDao;

@GContentView(value = R.layout.monster)
public class MonsterView extends GBaseView {

    private Monster monster;

    private ParentsAdapter adapter;
    
    @GAction
    private MonsterAction action;

    @GView(value = R.id.monster_img, width = 220, height = 220)
    private ImageView monster_img;
    @GView(value = R.id.monster_name)
    private TextView monster_name;
    @GView(value = R.id.monster_level)
    private TextView monster_level;
    @GView(value = R.id.monster_size)
    private TextView monster_size;
    @GView(value = R.id.parents, height = 300)
    private ListView parents;
    @GView(value = R.id.parents_null)
    private TextView parents_null;
    @GView(value = R.id.monster_get)
    private TextView monster_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState, false);
    }

    @Override
    public void init() {
	monster = (Monster) getIntent().getSerializableExtra("monster");
	adapter = new ParentsAdapter(this, action);
	action.updateMonsterDetail(monster);
    }

    public void getParentsMonster(Monster monster) {
    }

    @Override
    public void requestSuccess(GData data) {
	this.monster = (Monster) data.getData().get("monster");
	switch (data.getRequestType()) {
	case 1:
	    parents_null.setVisibility(View.VISIBLE);
	    adapter.setParents(new ArrayList<Monster[]>());
	    this.parents.setAdapter(adapter);
	    adapter.notifyDataSetChanged();
	    break;
	case 2:
	    parents_null.setVisibility(View.GONE);
	    adapter.setParents((List<Monster[]>)data.getData().get("ps"));
	    adapter.setMonsters((List<String[]>)data.getData().get("strs"));
	    this.parents.setAdapter(adapter);
	    adapter.notifyDataSetChanged();
	    break;
	default:
	    break;
	}
	monster_img.setBackgroundResource((Integer)data.getData().get("imgid"));
	monster_level.setText(String.format(getString(R.string.monster_levle),
		data.getData().get("level")));
	monster_name.setText(String.format(getString(R.string.monster_name),
		monster.getName()));
	monster_size.setText(String.format(getString(R.string.monster_size),
		monster.getSize()));
	monster_get.setText(String.format(getString(R.string.monster_get),
		monster.getGet().replaceAll(",", "\n")));
    }

    @Override
    public void requestFail(GData data) {

    }

}
