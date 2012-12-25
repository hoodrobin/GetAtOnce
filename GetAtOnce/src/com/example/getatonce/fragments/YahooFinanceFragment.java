package com.example.getatonce.fragments;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.getatonce.R;
import com.example.getatonce.adapters.YahooNewsAdapter;
import com.example.getatonce.models.YahooNews;

public class YahooFinanceFragment extends Fragment {

	private GetYahooNewsTask mGetYahooNewsTask;
	private List<YahooNews> mYahooNewsList;
	private YahooNewsAdapter mYahooNewsAdapter;
	private ListView  mYahooNewsListView;


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initComponents();
		if (savedInstanceState != null) {

		} else {
			startYahooFinanceNewsTask();
		}
	}

	private void startYahooFinanceNewsTask() {
		if (mGetYahooNewsTask != null) {
			mGetYahooNewsTask.cancel(true);
			mGetYahooNewsTask = null;
		}
		mGetYahooNewsTask = new GetYahooNewsTask();
		mGetYahooNewsTask.execute();

	}

	private class GetYahooNewsTask extends AsyncTask<Void, Void, Boolean> {

		@Override
		protected void onPostExecute(Boolean result) {
			setYahooNews();
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Boolean doInBackground(Void... arg0) {
			// Todo: Write here a code to get data from server
			// dummy call. needs to be commented
			mYahooNewsList = getDummyList();
			return true;
		}

	}

	private List<YahooNews> getDummyList() {
		ArrayList<YahooNews> yahooNews = new ArrayList<YahooNews>();
		for (int i = 0; i < 15; i++) {
			YahooNews news = new YahooNews();
			news.setTitle("Happy Holidays, Instagram! Here, Have a Class-Action Lawsuit.");
			news.setDescription("[at AllThingsD] - And a happy new year!");
			news.setPubDate(">Mon, 24 Dec 2012 19:00:54 GMT");
			news.setUrl("http://us.rd.yahoo.com/finance/external/allthingsd/rss/SIG=12r50b03l/*http://allthingsd.com/20121224/happy-holidays-instagram-here-have-a-class-action-lawsuit/?reflink=ATD_yahoo_ticker");
			yahooNews.add(news);
		}
		return yahooNews;
	}

	public void setYahooNews() {
		mYahooNewsAdapter = new YahooNewsAdapter(mYahooNewsList, getActivity());
		mYahooNewsListView.setAdapter(mYahooNewsAdapter);

	}

	private void initComponents() {
	mYahooNewsListView=(ListView)getActivity().findViewById(R.id.yahoo_news_list);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.yahoo_news_fragment, null);
	}

}
