package com.lostad.app.demo.view.my;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lostad.app.base.util.DownloadUtil;
import com.lostad.app.base.view.BaseActivity;
import com.lostad.app.demo.R;
import com.lostad.app.demo.entity.Tour;
import com.lostad.applib.util.Validator;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

public class ListMyTourAdapter extends BaseAdapter {

	private BaseActivity mContext;
	List<Tour> mListData = null;

	private LayoutInflater mInflater;
	private String myId;
	public ListMyTourAdapter(BaseActivity context, List<Tour> list) {
		mContext = context;
		this.mListData = list;

		mInflater =  LayoutInflater.from(mContext);

	}
	
	public int getCount() {
		return mListData.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder ;
		if (convertView == null) {
			convertView     = mInflater.inflate(R.layout.list_item_tour, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		} 

		final Tour f = mListData.get(position);
		holder.tv_title.setText("title");
		holder.tv_desc.setText("desc");
		if(Validator.isNotEmpty(f.picUrl)){
			DownloadUtil.loadImage(mContext,holder.iv_pic, f.picUrl);
		}


		return convertView;
	}

	
	
	public void checkAll(){
		notifyDataSetChanged();
	}
	
	
	public class ViewHolder {    
		public ViewHolder(View convertView) {

			x.view().inject(this, convertView);
		}
		
		@ViewInject(R.id.iv_pic)
		public ImageView  iv_pic;

		@ViewInject(R.id.tv_title)
		public TextView tv_title;

		@ViewInject(R.id.tv_desc)
		public TextView tv_desc;

	}
	
	
}
