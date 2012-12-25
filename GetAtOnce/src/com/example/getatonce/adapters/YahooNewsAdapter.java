package com.example.getatonce.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.getatonce.R;
import com.example.getatonce.models.YahooNews;

public class YahooNewsAdapter extends BaseAdapter {

	private List<YahooNews> mYahooNewsList;
	private Context mContext;
	private LayoutInflater inflater;

	public YahooNewsAdapter(List<YahooNews> yahooNews, Context context) {
		mContext = context;
		mYahooNewsList = yahooNews;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mYahooNewsList.size();
	}

	@Override
	public YahooNews getItem(int position) {

		return mYahooNewsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView==null){
			viewHolder=new ViewHolder();
			convertView=inflater.inflate(R.layout.news_item, null);
			viewHolder.title=(TextView)convertView.findViewById(R.id.title);
			viewHolder.discription=(TextView)convertView.findViewById(R.id.discription);
			convertView.setTag(viewHolder);
		}
		YahooNews news=getItem(position);
		viewHolder=(ViewHolder)convertView.getTag();
		viewHolder.discription.setText(news.getDescription());
		viewHolder.title.setText(news.getTitle());
		return convertView;
	}

	public static class ViewHolder {
		public TextView title;
		public TextView discription;
	}
}
