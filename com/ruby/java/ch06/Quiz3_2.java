package com.ruby.java.ch06;

public class Quiz3_2 {

public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] mA = {//3*4
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		
		int[][] mB = {//4*3
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
		};
		
		int[][] mC = new int[mA.length][mB[0].length];
		for (int i = 0; i < mA.length; i++) {
			for (int j = 0; j < mB[0].length; j++) {
				mC[i][j]=0;//??
				for (int k = 0; k < mA[0].length; k++) {
                    mC[i][j] += mA[i][k] * mB[k][j];//a+=b : a=a+b니까 mA의 행과 mB의 열의 곱을
                    								//mC[][]에 더해주는
				}
			}
		}
                    
                    System.out.println("mC" + "\n");//mC와 70사이에 한 줄 띄운 것
                    for(int i = 0; i < mC.length; i++) {
                    	for(int j = 0; j < mC[0].length; j++) {
                    		System.out.print(mC[i][j] + "\t");
                    	}
                    	System.out.println("\n");//프린트라인()으로 3열씩 나오게하고
                    							//\n으로 한 줄 씩 띄어준 것
                    }


	}
}


