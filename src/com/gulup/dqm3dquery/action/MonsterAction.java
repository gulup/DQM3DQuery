package com.gulup.dqm3dquery.action;

import java.util.ArrayList;
import java.util.List;

import org.gulup.core.ext.NativeHandleAction;

import com.gulup.dqm3dquery.bean.Monster;
import com.gulup.dqm3dquery.db.DQDao;

import android.content.Context;

public class MonsterAction extends NativeHandleAction {

    private DQDao dao;

    public MonsterAction(Context context) {
	super(context);
    }

    public void updateMonsterDetail(Monster monster) {
	if (dao == null) {
	    dao = new DQDao(context);
	}
	int requstType = 0;
	if (monster.getParents().isEmpty()) {
	    requstType = 1;
	} else {
	    String[] parents = monster.getParents().split(";");
	    List<String[]> strs = new ArrayList<String[]>();
	    for (int i = 0; i < parents.length; i++) {
		strs.add(parents[i].split(","));
	    }
	    List<Monster[]> ps = dao.getParents(parents);
	    requstType = 2;
	    map.put("strs", strs);
	    map.put("ps", ps);
	}
	int imgId = context.getResources().getIdentifier(
		"m" + monster.getMid(), "drawable", context.getPackageName());
	String level = "";
	switch (monster.getLevel()) {
	case 1:
	    level = "F";
	    break;
	case 2:
	    level = "E";
	    break;
	case 3:
	    level = "D";
	    break;
	case 4:
	    level = "C";
	    break;
	case 5:
	    level = "B";
	    break;
	case 6:
	    level = "A";
	    break;
	case 7:
	    level = "S";
	    break;
	case 8:
	    level = "SS";
	    break;
	default:
	    break;
	}
	map.put("imgid", imgId);
	map.put("level", level);
	map.put("monster", monster);
	changedNativeData(requstType, true);
    }

}
