package com.gulup.dqm3dquery.view;

import org.gulup.annotation.GAction;
import org.gulup.annotation.GContentView;
import org.gulup.annotation.GView;
import org.gulup.core.GData;
import org.gulup.utils.ScreenUtil;
import org.gulup.view.GBaseView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.gulu.dqm3dquery.R;
import com.gulup.dqm3dquery.action.MainAction;
import com.gulup.dqm3dquery.adapter.MainAdapter;
import com.gulup.mydialog.Effectstype;
import com.gulup.mydialog.NiftyDialogBuilder;

@GContentView(value = R.layout.main_view)
public class MainActivity extends GBaseView implements OnItemClickListener {

    @GView(value = R.id.main_list)
    private GridView main_list;
    
    @GAction
    private MainAction action;

    private MainAdapter adapter;

    private NiftyDialogBuilder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	ScreenUtil.initScreen(this, 720, 1280);
	super.onCreate(savedInstanceState, false);
	main_list.setAdapter(adapter);
	main_list.setOnItemClickListener(this);
    }

    @Override
    public void init() {
	action.setData();
	adapter = new MainAdapter(this);
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
	action.toMonsterDetail(position+1);
    }

    @Override
    public void onBackPressed() {
	showExitDialog();
    }
    
    public void showExitDialog(){
	dialog = NiftyDialogBuilder.getInstance(this);
	dialog.withTitle(getString(R.string.exit))
		.withMessage(getString(R.string.exit_msg))
		.isCancelableOnTouchOutside(false).withDuration(700)
		.withEffect(Effectstype.Fall)
		.withButton1Text(getString(R.string.ok))
		.withButton2Text(getString(R.string.cancel))
		.setButton1Click(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
			dialog.dismiss();
			MainActivity.this.finish();
		    }
		}).setButton2Click(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
			dialog.dismiss();
		    }
		}).show();
    }

}
