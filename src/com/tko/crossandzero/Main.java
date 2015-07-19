package com.tko.crossandzero;
//import java.util.Map;
//
//
//public class Main {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) { //X=1; O=0
//		// TODO Auto-generated method stub
//		
//		String sfield = "1000010000X0000X";
//		boolean field[][] = new boolean[4][4];
//		boolean
//isMark[][] = new boolean[4][4];
//		
//		
//		
//		for (int i=0; i<4; i++){
//			for (int j=0; j<4; j++) isMark[i][j]=true;
//		}
//		
//		field = sfIntoblf(sfield);
//
//		
//		boolean iCheckThatBool = true;
//		printField(field);
//		
//	}
//	
//	public static boolean[][] sfIntoblf (String sf){
//		boolean field[][] = new boolean[4][4];
//		
//		for (byte i=0; i<4; i++){
//			for (byte j=0; j<4; j++){
//				switch (sf.charAt(i*4+j)){
//				
//				case 'X' :;
//				case '1' : field[i][j]=true;
//					break;
//				case 'O' :;
//				case '0' : field[i][j]=false;
//				
//				}
//			}
//		}
//		
//		return field;
//	}
//	
//	public static void printField (boolean[][] field){
//		
//		for (byte i=0; i<4; i++){
//			for (byte j=0; j<4; j++){
//				
//				if (field[i][j]) System.out.print('X'); else System.out.print('O');
//			}
//			
//			System.out.print("\n");
//		}
//	}
//	
//	
//	
//	/*
//	public static byte checkUpLeftDiags (boolean[][] field, boolean whatIcheck, boolean[][] isMark){
//		
//		byte cnt=0;
//		
//		for (byte i=0; i<2; i++){
//			for (byte j=0; j<2; j++){
//				if (field[i][j]==whatIcheck && field[i+1][j+1]==whatIcheck && field[i+2][j+2]==whatIcheck && isMark[i][j] && isMark[i+1][j+1] && isMark[i+2][j+2]) 
//					{isMark[i][j]=false; isMark[i+1][j+1]=false; isMark[i+2][j+2]=false; cnt++;}
//			}
//		}
//		
//		return cnt;
//	}	
//	
//	public static byte checkUpRightDiags (boolean[][] field, boolean whatIcheck, boolean[][] isMark){
//		
//		byte cnt=0;
//		
//			for (byte i=0; i<2; i++){
//			for (byte j=2; j<4; j++){
//				if (field[i][j]==whatIcheck && field[i+1][j-1]==whatIcheck && field[i+2][j-2]==whatIcheck && isMark[i][j] && isMark[i+1][j-1] && isMark[i+2][j-2]) 
//					{isMark[i][j]=false; isMark[i+1][j-1]=false; isMark[i+2][j-2]=false;  cnt++;}
//			}
//		}
//		
//		return cnt;
//	}
//	
//	public static byte checkVerts (boolean[][] field, boolean whatIcheck, boolean[][] isMark){
//		
//		byte cnt=0;
//		
//		for (byte i=0; i<2; i++){
//			for (byte j=0; j<4; j++){
//				
//				if (field[i][j]==whatIcheck && field[i+1][j]==whatIcheck && field[i+2][j]==whatIcheck && isMark[i][j] && isMark[i+1][j] && isMark[i+2][j]) 
//				{cnt++;}
//				}
//			}
//		}
//		
//		return (byte)cnt;
//	}
//	
//	public static byte checkHoris (boolean[][]field, boolean whatIcheck){
//		
//		byte cnt=0;
//		
//		for (byte i=0; i<4; i++){
//			for (byte j=0; j<2; j++){
//				
//				if (field[i][j]==whatIcheck && field[i][j+1]==whatIcheck && field[i][j+2]==whatIcheck) cnt++;
//			}
//		}
//		
//		return cnt;
//		
//	}
//	
//	public static byte checkAdUpLeftDiag (boolean[][] field, boolean whatIcheck){
//		
//		return (byte)((field[0][0]==whatIcheck && field[1][1]==whatIcheck && field[2][2]==whatIcheck && field[3][3]==whatIcheck)?1:0);
//		
//	}
//	
//	public static byte checkAdUpRightDiag (boolean[][] field, boolean whatIcheck){
//		
//		return (byte)((field[0][3]==whatIcheck && field[1][2]==whatIcheck && field[2][1]==whatIcheck && field[3][0]==whatIcheck)?1:0);
//		
//	}
//	
//	public static byte calculate (boolean[][] field, boolean[][] isMark){
//		
//		byte cnt=
//				(byte)  (checkUpLeftDiags(field, true, isMark)+
//						checkUpRightDiags(field, false, isMark)+
//						checkHoris(field, true)+
//						checkHoris(field, false)+
//						checkVerts(field, true)+
//						checkVerts(field, false)
//						);
//		
	//		return cnt;
	//	}*/
//}
//
//

/*

public class Main{
	
	public static void main(String[] args) {
		
		Cluster[][] field = new Cluster[4][4];
		
		for (byte i=0; i<4; i++){
			for (byte j=0; j<4; j++){
				
				field[i][j] = new Cluster (j,i);
				
			}
		}
		
	}
}

*/
