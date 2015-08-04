package com.tko.crossandzero;

public class Data {
	
	protected static Cluster field[] = new Cluster[16];
	protected static byte crCount = 0;
	protected static byte zeCount = 0;
	protected static byte filled = 0;
	protected static boolean isCross = true;
	
	public static void restart(){
		
		isCross = true;
		crCount = 0;
		zeCount = 0;
		filled = 0;
		
		
		for (int i = 0; i < 16; i++){
			
			field[i] = new Cluster();
			
		}
		
	}
	
}
