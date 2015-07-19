package com.tko.crossandzero;

public class Cluster {
	
	boolean isMark;
	boolean isCrossed;
	
	
	public Cluster (){
		this.isMark=false;
		this.isCrossed=false;
	}
	
	public Cluster (byte x, byte y){
		this.isMark=false;
		this.isCrossed=false;
	}

	public boolean isMark() {
		return isMark;
	}

	public void setMark(boolean isMark) {
		this.isMark = isMark;
	}

	public boolean isCrossed() {
		return isCrossed;
	}

	public void setCrossed(boolean isCrossed) {
		this.isCrossed = isCrossed;
	}
	
	/////////////check methods:
	
	
	public static class Check{
		
		public static void verts(){
			
			for (int i=0; i<8; i++){
				
				if (Data.field[i].isCrossed && Data.field[i+4].isCrossed && Data.field[i+8].isCrossed) {
					
					Data.field[i].isMark=false;
					Data.field[i+4].isMark=false;
					Data.field[i+8].isMark=false;
					Data.crCount++;
					
				}
				
				if (!Data.field[i].isCrossed && !Data.field[i+4].isCrossed && !Data.field[i+8].isCrossed) {
					
					Data.field[i].isMark=false;
					Data.field[i+4].isMark=false;
					Data.field[i+8].isMark=false;
					Data.zeCount++;
					
				}
				
				
			}
			
		}
		
		public static void horis(){
			
			for (int i=0; i<8; i++){
				
				int j=i+(i-i%2);
				
				if (Data.field[j].isCrossed && Data.field[j+1].isCrossed && Data.field[j+2].isCrossed) {
					
					Data.field[j].isMark=false;
					Data.field[j+1].isMark=false;
					Data.field[j+2].isMark=false;
					Data.crCount++;
					
				}
				
				if (!Data.field[j].isCrossed && !Data.field[j+1].isCrossed && !Data.field[j+2].isCrossed) {
					
					Data.field[j].isMark=false;
					Data.field[j+1].isMark=false;
					Data.field[j+2].isMark=false;
					Data.zeCount++;
					
				}
				
			}
		}
		
		public static void Xdiags(){
			
			for (int i=0; i<4; i++){
				
				int j=i+(i-i%2);

				if (Data.field[j].isCrossed && Data.field[j+5].isCrossed && Data.field[j+10].isCrossed){
					
					Data.field[j].isMark=false;
					Data.field[j+5].isMark=false;
					Data.field[j+10].isMark=false;
					Data.crCount++;
					
				}
				
				if (!Data.field[j].isCrossed && !Data.field[j+5].isCrossed && !Data.field[j+10].isCrossed){
					
					Data.field[j].isMark=false;
					Data.field[j+5].isMark=false;
					Data.field[j+10].isMark=false;
					Data.zeCount++;
					
				}
				
				
			}
			
		}
		
		public static void Ydiags(){
			
			for (int i=0; i<4; i++){
				
				int j=i+2+((i/2)*2);
				
				if (Data.field[j].isCrossed && Data.field[j+3].isCrossed && Data.field[j+6].isCrossed){
					
					Data.field[j].isMark=false;
					Data.field[j+3].isMark=false;
					Data.field[j+6].isMark=false;
					Data.crCount++;
					
				}

				if (!Data.field[j].isCrossed && !Data.field[j+3].isCrossed && !Data.field[j+6].isCrossed){
					
					Data.field[j].isMark=false;
					Data.field[j+3].isMark=false;
					Data.field[j+6].isMark=false;
					Data.zeCount++;
					
				}
				
			}
			
		}
		
	}
	
}
