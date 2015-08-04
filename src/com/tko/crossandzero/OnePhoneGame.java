package com.tko.crossandzero;

import com.tko.crossandzeroextended.R;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OnePhoneGame extends Activity {
	
	private GridLayout gl;
	
	protected ImageView bts[] = new ImageView[16];
	private TextView TVcrCnt;
	private TextView TVzeCnt;
	
	private Animation[] fadeOut = new Animation[16];
	
	private byte AnimTurn = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		
		Data.crCount=0;
		Data.zeCount=0;
		Data.filled=0;
		Data.isCross = true;
		
		TVcrCnt = (TextView) findViewById(R.id.cr_cnt);
		TVzeCnt = (TextView) findViewById(R.id.ze_cnt);
		
		TVcrCnt.setTextColor(Color.rgb(00, 00, 255));
		
		gl = (GridLayout) findViewById(R.id.gl);
		gl.setColumnCount(4);
		
		
		int d=0;
		
		for (int i=0; i < 16; i++){
			
			fadeOut[i] = AnimationUtils.loadAnimation(OnePhoneGame.this.getApplicationContext(), R.anim.abc_fade_out);
			fadeOut[i].setStartOffset(d);
			fadeOut[i].setAnimationListener(fadeOutListener);
			d+=75;
		}
		
		
		for (int i=0; i<16; i++){
			bts[i] = new ImageView(this);
			bts[i].setImageResource(R.drawable.square);
			bts[i].setLayoutParams(new LayoutParams(100,100));
			bts[i].setId(i);
			bts[i].setImageAlpha(0);
			gl.addView(bts[i]);
			bts[i].setOnClickListener(squareClick);
			
			Data.field[i] = new Cluster();
		}
		
		
		
		
		
	}
	
	
	/**
	 * Menu
	 *  - Restart : resets the field
	 */
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		menu.add("Restart");
		
		return super.onCreateOptionsMenu(menu);
	}
	
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Data.restart();
		refresh();
		return super.onMenuItemSelected(featureId, item);
	}
	
	
	
	
	
	
	private OnClickListener squareClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			int i=v.getId();
			
			if (Data.isCross){

				TVzeCnt.setTextColor(Color.rgb(00, 00, 255));
				TVcrCnt.setTextColor(Color.rgb(00, 00, 00));
			} else {
				
				TVcrCnt.setTextColor(Color.rgb(00, 00, 255));
				TVzeCnt.setTextColor(Color.rgb(00, 00, 00));
			}
			
			/*Toast.makeText(OnePhoneGame.this.getApplicationContext(), Integer.toString(v.getId()), Toast.LENGTH_SHORT).show();*/ /**to check bt's id * must be 0-15*/
			if (Data.isCross && !Data.field[i].isMark) {
				
				bts[i].setImageResource(R.drawable.c_square);
				Data.field[i].setCrossed(true);
				
			} else if (!Data.field[i].isMark) {
					
				bts[i].setImageResource(R.drawable.z_square);
				Data.field[i].setCrossed(false);
			}
			
			if (!Data.field[i].isMark) {
				Data.isCross = !Data.isCross;
				Data.filled++;
				
			}
			
			Data.field[i].setMark(true);
			
			if (Data.filled==16){
				
				Toast.makeText(OnePhoneGame.this.getApplicationContext(), "Filled, calculating...", Toast.LENGTH_SHORT).show();
				calculate();
				refresh();
				
				if (Data.filled==16 || (Data.crCount >= 25 || Data.zeCount >= 25)) {
					
					hideTheField();
					//findTheWinner(); !
				}
			}
		}
	};
	
	private void calculate(){ 
		
		Cluster.Check.verts();
		Cluster.Check.horis();
		Cluster.Check.Xdiags();
		Cluster.Check.Ydiags();
		
	}
	
	private void refresh(){
		
		Data.filled=0;
		for (int i=0; i<16; i++){
			if (!Data.field[i].isMark) {bts[i].setImageResource(R.drawable.square);} else { Data.filled++;
				if (Data.field[i].isCrossed) bts[i].setImageResource(R.drawable.c_square); else bts[i].setImageResource(R.drawable.z_square);
			}
			
		}

		TVcrCnt.setText("Cross: "+Integer.toString(Data.crCount));
		TVzeCnt.setText("Zero: "+Integer.toString(Data.zeCount));
		
	}

	private void hideTheField(){
		
		for (int i=0; i<16; i++){
			
			bts[i].startAnimation(fadeOut[i]);
			
		}
		
	}
	
	/* !!!!!
	private void findTheWinner(){
		
		
	}
	*/
	
	
	private Animation.AnimationListener fadeOutListener = new Animation.AnimationListener(){
		
		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			
			bts[AnimTurn].setImageAlpha(0);
			AnimTurn++;
		}
	};
	
	
	
	
}
