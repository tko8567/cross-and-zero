package com.tko.crossandzero;

import com.tko.crossandzeroextended.R;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OnePhoneGame extends Activity {
	
	private GridLayout gl;
	
	protected ImageView bts[] = new ImageView[16];
	protected boolean isCross = true;
	private TextView TVcrCnt;
	private TextView TVzeCnt;
	
	private Animation hideAnim;
	
	private byte AnimTurn = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		
		Data.crCount=0;
		Data.zeCount=0;
		Data.filled=0;
		isCross = true;
		
		TVcrCnt = (TextView) findViewById(R.id.cr_cnt);
		TVzeCnt = (TextView) findViewById(R.id.ze_cnt);

		for (int i=0; i<16; i++){
			hideAnim=AnimationUtils.loadAnimation(this, R.anim.hide);
			
		}
		
		TVcrCnt.setTextColor(Color.rgb(00, 00, 255));
		
		gl = (GridLayout) findViewById(R.id.gl);
		gl.setColumnCount(4);
		
		
		
		
		
		for (int i=0; i<16; i++){
			bts[i] = new ImageView(this);
			bts[i].setImageResource(R.drawable.square);
			bts[i].setLayoutParams(new LayoutParams(100,100));
			bts[i].setId(i);
			gl.addView(bts[i]);
			bts[i].setOnClickListener(squareClick);
			
			Data.field[i] = new Cluster();
		}
		
		
		
		
	}
	
	private OnClickListener squareClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			int i=v.getId();
			
			if (isCross){

				TVzeCnt.setTextColor(Color.rgb(00, 00, 255));
				TVcrCnt.setTextColor(Color.rgb(00, 00, 00));
			} else {
				
				TVcrCnt.setTextColor(Color.rgb(00, 00, 255));
				TVzeCnt.setTextColor(Color.rgb(00, 00, 00));
			}
			
			/*Toast.makeText(OnePhoneGame.this.getApplicationContext(), Integer.toString(v.getId()), Toast.LENGTH_SHORT).show();*/ /**to check bt's id * must be 0-15*/
			if (isCross && !Data.field[i].isMark) {
				
				bts[i].setImageResource(R.drawable.c_square);
				Data.field[i].setCrossed(true);
				
			} else if (!Data.field[i].isMark) {
					
				bts[i].setImageResource(R.drawable.z_square);
				Data.field[i].setCrossed(false);
			}
			
			if (!Data.field[i].isMark) {
				isCross=!isCross;
				Data.filled++;
				
			}
			
			Data.field[i].setMark(true);
			
			if (Data.filled==16){
				
				Toast.makeText(OnePhoneGame.this.getApplicationContext(), "Filled, calculating...", Toast.LENGTH_SHORT).show();
				calculate();
				refresh();
				if (Data.filled==16) {
					hideTheField();
					findTheWinner();
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
	
	
	//////////////////////////////////////////////
	/**
	 * bts - массив с кнопками
	 * кнопок 16
	 * 
	 */
	
	/*
	private void hideTheField(int i){
		
		for (int j=100; j>80; j--){//начало ухода кнопки в альфу
			
			bts[i].setImageAlpha(j);
			
			try{ //задержка на 1мс с отловленным исключением
				Thread.currentThread().sleep(1);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		if (i>0)hideTheField(i-1); //рекурсивный переход к следующей кнопке
		
		
		
		for (int j=80; j>-1; j--){ //уход в альфу до конца
			bts[i].setImageAlpha(j);
			
			try{
				
				Thread.currentThread().sleep(1);
			} catch(InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	*/

	private void hideTheField(){
		
			
			bts[AnimTurn].startAnimation(hideAnim);
		
	}
	
	//////////////////////////////////////////////
	
	
	private void findTheWinner(){
		
		
	}
	
	
	Animation.AnimationListener hideAnimListener = new Animation.AnimationListener(){
		
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
			if (AnimTurn < 15) {AnimTurn++; bts[AnimTurn].startAnimation(hideAnim);}
		}
	};
	
}
