package com.gulup.dqm3dquery.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import org.gulup.core.ext.NativeHandleAction;

import com.gulu.dqm3dquery.R;
import com.gulup.dqm3dquery.bean.Monster;
import com.gulup.dqm3dquery.db.DQDao;
import com.gulup.dqm3dquery.view.MonsterListView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

public class MainAction extends NativeHandleAction {

    private SharedPreferences sp;
    private Editor edit;
    private DQDao dao;

    public MainAction(Context context) {
	super(context);
    }

    public void setData() {
	sp = context.getSharedPreferences("dqm3d", Context.MODE_PRIVATE);
	if (!sp.getBoolean("isfirst", true)) {
	    return;
	} else {
	    File filePath = new File("/data/data/" + context.getPackageName()
		    + "/databases/");
	    File file = new File("/data/data/" + context.getPackageName()
		    + "/databases/dqm3d.db");
	    if (!filePath.exists()) {
		filePath.mkdir();
	    }
	    try {
		InputStream is = context.getResources().openRawResource(
			R.raw.dqm3d);
		FileOutputStream fos = new FileOutputStream(file);
		byte[] buffer = new byte[8192];
		int index = 0;
		while ((index = is.read(buffer)) != -1) {
		    fos.write(buffer, 0, index);
		}
		is.close();
		fos.close();
	    } catch (FileNotFoundException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    edit = sp.edit();
	    edit.putBoolean("isfirst", false);
	    edit.commit();
	}
    }
    
    public void toMonsterDetail(int index){
	if(dao == null){
	    dao = new DQDao(context);
	}
	List<Monster> monsters = dao.getMonsters(index);
	Bundle bundle = new Bundle();
	bundle.putSerializable("monsters", (Serializable) monsters);
	changeView(context,MonsterListView.class,bundle);
    }
}
