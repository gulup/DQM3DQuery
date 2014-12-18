package com.gulup.dqm3dquery.view;

import java.util.List;

import org.gulup.annotation.GContentView;
import org.gulup.annotation.GView;
import org.gulup.core.GData;
import org.gulup.view.GBaseView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.gulu.dqm3dquery.R;
import com.gulup.dqm3dquery.adapter.MonstersAdapter;
import com.gulup.dqm3dquery.bean.Monster;

@GContentView(value=R.layout.monsters_view)
public class MonsterListView extends GBaseView implements OnItemClickListener{
    
    @GView(value=R.id.monster_list)
    private ListView monster_list;
    
    private List<Monster> monsters;
    
    private MonstersAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, false);
        monsters = (List<Monster>) getIntent().getSerializableExtra("monsters");
        adapter = new MonstersAdapter(this, monsters);
        monster_list.setAdapter(adapter);
    }
    
    @Override
    public void init() {
	monster_list.setOnItemClickListener(this);
    }

    @Override
    public void requestSuccess(GData data) {

    }

    @Override
    public void requestFail(GData data) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
	    long id) {
	Intent intent = new Intent();
	intent.setClass(this, MonsterView.class);
	intent.putExtra("monster", monsters.get(position));
	startActivity(intent);
    }

}
