package com.ruby.java.ch10;
//요거는 책에있는거 Original

import java.util.ArrayList;//이런 자바라이브러리들은 오류에서 임포트가능
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test10_original {
	public static void main(String[] args) {
		lotto_generator(5);
	}
	public static void lotto_generator(int n) {
		Random number = new Random();
		HashSet<Integer> lotto = null;//참조변수 로또
		for (int i = 0; i < n; i++) {
			lotto = new HashSet<Integer>();//생성자
			for (int j = 0; lotto.size() < 6; j++) {
				lotto.add(1+number.nextInt(45));//로또에 애드//1+, 46>>45 --> 로또에 0번없어서
				System.out.println("lotto_size = " + lotto.size());
			}
			List<Integer> L = new ArrayList<Integer>(lotto);//로또를 어레이리스트로 만들어서
			Collections.sort(L);;//컬렉션에 찍어서? 정렬//얘없으면 정렬안됨, 근데 
			System.out.println(L);
		}
	}
}
