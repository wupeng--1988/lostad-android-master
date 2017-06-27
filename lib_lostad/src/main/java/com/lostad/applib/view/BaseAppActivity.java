package com.lostad.applib.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.lostad.applib.R;
import com.lostad.applib.util.DialogUtil;
import com.lostad.applib.util.SystemBarTintManager;


public class BaseAppActivity extends ActivitySupport implements IActivitySupport{

	protected BaseAppActivity ctx = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ctx = this;

	}

	protected void initToolBar(Toolbar toolbar) {
		if(toolbar!=null) {
			setSupportActionBar(toolbar);
			toolbar.setTitleTextColor(Color.WHITE);
		}else{
			DialogUtil.showToastCust(this, R.string.msg_toolbar_no_found);
		}
	}
	protected void initToolBarWithBack(Toolbar toolbar) {
		if(toolbar!=null){
			setSupportActionBar(toolbar);
			//toolbar.setNavigationIcon(R.drawable.ic_action_back);
			toolbar.setTitleTextColor(Color.WHITE);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}else{
			DialogUtil.showToastCust(this,R.string.msg_toolbar_no_found);
		}

	}
	protected void initToolBarWithBack(Toolbar toolbar,String title) {
		if(toolbar!=null){
			setSupportActionBar(toolbar);
			//toolbar.setNavigationIcon(R.drawable.ic_action_back);
			toolbar.setTitleTextColor(Color.WHITE);
			super.setTitle(title);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}else{
			DialogUtil.showToastCust(this,R.string.msg_toolbar_no_found);
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(item.getItemId()==android.R.id.home){
			finish();
		}

		return super.onOptionsItemSelected(item);
	}

	////////////////////////////////////////////////////////////////////////
	//导航条渐变
	//
	////////////////////////////////////////////////////////////////////////
	/**
	 * 浸染状态栏底色背景，若使用布局的背景图浸染，设置resId为透明色即可
	 * 其它情况设置resId为ToolBar(ActionBar)的背景色
	 * @param resId 颜色id
	 */
	public void setStatusBarStyle(int resId){
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			setTranslucentStatus(true);
		}
		SystemBarTintManager tintManager = new SystemBarTintManager(this);
		tintManager.setStatusBarTintEnabled(true);
		tintManager.setStatusBarTintResource(resId);//通知栏所需颜色
	}
	@TargetApi(19)
	private void setTranslucentStatus(boolean on) {
		Window win = getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}
	    
/////////////////////////////////////////////////////////////////////////
// 退出事件
//
///////////////////////////////////////////////////////////////////////////

		public boolean onKeyDown(int keyCode, KeyEvent event) {
//			if (keyCode == KeyEvent.KEYCODE_BACK) {
//				super.quitApp();
//				return false;
//			}
			return super.onKeyDown(keyCode, event);
		}

		public void quitApp() {
			if (!isExit) {
				isExit = true;
				Toast.makeText(getApplicationContext(), "再按一次退出程序",Toast.LENGTH_SHORT).show();
				mHandler.sendEmptyMessageDelayed(0, 2000);
			} else {
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
				finish();
			}
		}

		Handler mHandler = new Handler() {
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				isExit = false;
			}

		};
		boolean isExit;
}
