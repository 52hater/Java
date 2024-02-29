package com.ruby.java.ch04;

import java.util.Random;

public class Test37 {

	public static void main(String[] args) {
	//난수 생성하기(Random 이라는 클래스로)(클래스:반:모아놨잖아 > 난수에 관련된걸 모아놓은 클래스 Random)
	//개체를 모아놓은거 : 클래스
		Random rnd = new Random();
		int [] score = new int[20];	//20개의 난수 생성
		for (int i = 0; i < score.length; i++) {	//이게 난수를 만드는 로컬변수?
			score[i] = rnd.nextInt(20)+1;	//20이하의 난수가 생성되는 것/+1은 왜했지(min때문)
		}
		for (int num : score)
			System.out.println(num);
	//이제 이 난수 20개들의 총점, 평균, 최솟값, 최댓값을 구하자
		
		int sum = 0;	//추적이 용이하도록 값을 초기화를 시켜주자 int sum; 으로 하지말고 초기값을 0으로 지정
		double avg = 0.0;
		int max = 0;
		int min = 999; //맥스는0이니까 바뀌는데 민은 큰숫자로해야 
		
//		for(int i = 0; i < score.length; i++) {
//			if (i % 4 == 0)
//				System.out.println("\n");
//		if (score[i] < 10)
//			System.out.println(" "); //10보다 작으면 한칸띄고 값을 찍도록 > 칸 보기가 이쁘게 맞춰보는거지
//			System.out.print(score[i] + " ");
//		}	
		//4개찍고 내려가고 칸 보기 이쁘게 출력하는 연습 이런것도 숙달되게 자꾸 연습
		//근데 뭐가 이상하게 나오는데? 다시 살펴보고 4개씩 나오고 한칸내려가게 고쳐보자
		
		for(int i = 0; i < score.length; i++ ) {	//이게 아래의 값들을 구하는 로컬변수?
			sum += score[i];
			if(max < score[i])
				max = score[i];
			if(min > score[i])
				min = score[i];
		}
		
		avg = sum / score.length;
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
		}

	}

