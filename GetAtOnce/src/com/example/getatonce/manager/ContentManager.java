package com.example.getatonce.manager;

import java.util.ArrayList;
import java.util.List;

import com.example.getatonce.models.YahooNews;
import com.example.getatonce.utils.ActivityUtils;

public class ContentManager {
	private static ContentManager contentManager;
	public static ContentManager getInstance(){
		if(contentManager!=null){
			return contentManager;
		}else{
		contentManager=new ContentManager();	
		return contentManager;
		}
	}
	
	public List<YahooNews> getYahooFinanceNews(){
		String xml=ActivityUtils.getXmlFromUrl("");
		
		return new ArrayList<YahooNews>();
	}

	
	
}
