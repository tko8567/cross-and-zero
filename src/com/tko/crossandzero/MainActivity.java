package com.tko.crossandzero;

import com.tko.crossandzeroextended.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	//protected File data = new File("data.caze");
	private ImageView iv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        
        iv = (ImageView) findViewById(R.id.iv);
        
        iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent toSecondAct = new Intent(MainActivity.this, SecondAct.class);
				startActivity(toSecondAct);
			}
		});
        
    }
    
    
    
}
