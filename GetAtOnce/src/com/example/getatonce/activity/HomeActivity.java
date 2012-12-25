package com.example.getatonce.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.FrameLayout;

import com.example.getatonce.R;
import com.example.getatonce.fragments.YahooFinanceFragment;

public class HomeActivity extends FragmentActivity {
	private FrameLayout fragmentLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initComponents();
		if(findViewById(R.id.fragment_ccontainer)!=null){
			YahooFinanceFragment yahooFinanceFragment=new YahooFinanceFragment();
			getSupportFragmentManager().beginTransaction()
            .add(R.id.fragment_ccontainer, yahooFinanceFragment).commit();
			
		}
	}

	private void initComponents() {
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}

}
