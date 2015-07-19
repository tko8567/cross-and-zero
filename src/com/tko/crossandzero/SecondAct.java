package com.tko.crossandzero;

import com.tko.crossandzeroextended.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SecondAct extends Activity {

	private ImageView opt1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_act);
		
		opt1 = (ImageView) findViewById(R.id.opt1);
		opt1.setOnClickListener(menuClick);
		
		
	}
	
	private OnClickListener menuClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
				
			case R.id.opt1 : {
				Intent toOnePhoneGame = new Intent(SecondAct.this, OnePhoneGame.class);
				startActivity(toOnePhoneGame);
			}
				
				
			}
		}
	};
	
}
