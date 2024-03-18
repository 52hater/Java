package DataStructure.Ch05;

// 미로문제나 여러가지 갈 때 이 스타일을 따라감

import java.util.Scanner;

public class Recur {
	static void recur(int n) {
		IntStack s = new IntStack(n);
	// while (n > 0) { //if (n > 0)을 바꿔치기 한 것
	while(true) {
		if(n > 0) {
			s.push(n); // recur(n-1); 대신에
			n = n-1;
			continue;
		}
		if (s.isEmpty() != true) { //엠티가 아니면 빠져나오고
			n = s.pop;
			System.out.println(n);
			n = n-2;
			continue; // 실행하면 바로 while 로 가는 
		}
		else
			break; // 빠져나오는 것
//		recur(n-1); // 자기 자신을 부르는 곳1
//		System.out.println(n);// n 값 출력하기전에 자기자신을 자꾸 불러
//		n = n-2; // recur(n-2);를 바꿔치기 한 것
	}

}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("정수를 입력하시오 : ");
		int x = scn.nextInt();
		
		recur(x);
	}
}