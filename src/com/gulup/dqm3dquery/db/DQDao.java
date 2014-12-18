package com.gulup.dqm3dquery.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gulup.dqm3dquery.bean.Monster;

public class DQDao {
    private DBHelper helper;
    
    public DQDao(Context context) {
	helper = new DBHelper(context);
    }
    
    public List<Monster> getMonsters(int type){
	String sql = "select * from monster where type = ?";
	SQLiteDatabase db = helper.getReadableDatabase();
	List<Monster> monsters = new ArrayList<Monster>();
	Cursor c = db.rawQuery(sql, new String[]{type+""});
	while(c.moveToNext()){
	    Monster monster = new Monster();
	    monster.setMid(c.getInt(c.getColumnIndex("mid")));
	    monster.setName(c.getString(c.getColumnIndex("name")));
	    monster.setLevel(c.getInt(c.getColumnIndex("level")));
	    monster.setSize(c.getInt(c.getColumnIndex("size")));
	    monster.setType(c.getInt(c.getColumnIndex("type")));
	    monster.setAtt(c.getString(c.getColumnIndex("att")));
	    monster.setFeature(c.getString(c.getColumnIndex("feature")));
	    monster.setFeaturecn(c.getString(c.getColumnIndex("featurecn")));
	    monster.setParents(c.getString(c.getColumnIndex("parents")));
	    monster.setGet(c.getString(c.getColumnIndex("get")));
	    monsters.add(monster);
	}
	return monsters;
    }
    
    public List<Monster[]> getParents(String[] parents){
	String sql = "select * from monster where name = ?";
	SQLiteDatabase db = helper.getReadableDatabase();
	List<Monster[]> ps = new ArrayList<Monster[]>();
	for(String str:parents){
	    String[] strs = str.split(",");
	    Monster[] monsters = new Monster[strs.length];
	    for(int i = 0; i < monsters.length; i++){
		Cursor c = db.rawQuery(sql, new String[]{strs[i]+""});
		while(c.moveToNext()){
		    Monster monster = new Monster();
		    monster.setMid(c.getInt(c.getColumnIndex("mid")));
		    monster.setName(c.getString(c.getColumnIndex("name")));
		    monster.setLevel(c.getInt(c.getColumnIndex("level")));
		    monster.setSize(c.getInt(c.getColumnIndex("size")));
		    monster.setType(c.getInt(c.getColumnIndex("type")));
		    monster.setAtt(c.getString(c.getColumnIndex("att")));
		    monster.setFeature(c.getString(c.getColumnIndex("feature")));
		    monster.setFeaturecn(c.getString(c.getColumnIndex("featurecn")));
		    monster.setParents(c.getString(c.getColumnIndex("parents")));
		    monster.setGet(c.getString(c.getColumnIndex("get")));
		    monsters[i] = monster;
		}
	    }
	    ps.add(monsters);
	}
	return ps;
    }
}
