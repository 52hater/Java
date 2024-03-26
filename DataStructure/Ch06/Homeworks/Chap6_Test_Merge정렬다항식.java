package Chap6_Sorting;
/*
 * 6장 구현과제1
 */

class Polynomial3 implements Comparable<Polynomial3>{
    double coef;           // 계수
    int    exp;            // 지수

    Polynomial3(){}
    //--- 생성자(constructor) ---//
    Polynomial3(double coef, int exp) {
        this.coef = coef;  this.exp = exp; 
    }

    //--- 신체검사 데이터를 문자열로 반환 --//
    @Override
	public String toString() {
        return coef + "x**" + exp + " ";
    }
    @Override
    public int compareTo(Polynomial3 d2) { //지수가 같으면 계수로 비교 //지수만가지고 비교
    	return d2.exp - exp;
    }
}
public class 실습6_12_3MergeSort다항식정렬 {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb ) {
		//배열하나가지고 왼쪽 반 오른쪽 반 해서 하는거
		 //body를 지우고 작성 훈련 연습이 도움이 된다 
		Polynomial3 temp[] = new Polynomial3[30];
		//구현코드
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial3[] a, int left, int right) {//책이랑 똑같고
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}
	static void ShowPolynomial(String str, Polynomial3[] x, int count) {
		//스트링을받고 다항식배열을받고 다항식개수를 받고
		//str 변수는 다항식 이름으로 스트링이다
		//count가 -1이면 다항식 x의 length로 계산하고 -1이면 count가 다항식 항의 숫자이다 
		//정렬후 다항식 x = 2.5x**7  + 3.8x**5  + 3.1x**4  + 1.5x**3  + 3.3x**2  + 4.0x**1  + 2.2x**0 
		//윗줄처럼 출력하는 코드를 작성하라
		int n = 0;
		if (count < 0)
			n = x.length;
		else
			n = count;
		//구현코드
	}
	static int AddPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		//z = x + y, 다항식 덧셈 결과를 z로 주고 z의 항의 수 terms을 리턴한다
		//terms > 항의 수 > 그걸 리턴해주는게 필요할거야
		int p=0,q=0,r=0;
		int terms = 0;
		//구현코드
		return terms;
		
	}
	static int addTerm(Polynomial3[]z, Polynomial3 term, int terms) {
		//지수로 정렬돼있으니까 머지하는거랑같아
		//다항식 z에 새로운 항 term을 추가한다. 지수가 같은 항이 있으면 계수만 합한다
		//추가된 항의 수를 count하여 terms으로 리턴한다.
		//구현코드
		return ++terms;
			
	}
	static int MultiplyPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		//z = x * y, 다항식 z의 항의 수는 terms으로 리턴한다 (terms : 항의 수)
		//terms = addTerm(z, term, terms);사용하여 곱셈항을 추가한다.
		//다항식x,y의 곱셈 z 를 손으로 해봐
		//첫항곱셈까지하면 정렬이 되는데
		//그다음항은 또 + (결괏값) 이 되고,
		//항을 더할때 첫항곱셈한거랑 지수가다르면 항을집어넣고 지수가같으면 계수만더하고 치워버리고
		int p=0,q=0,r=0;
		int terms = 0;
		for (int p = 0; ) //0부터 올리고
			for (int q=0;) {//0부터 올리고
				Poltnomial3 newTerm = new Poltnomial3(); //새로운 항을 만들고
				newTerm.coef = x[p].coef * y[q].coef; //계수는곱하고
				newTerm.exp = x[p].exp + y[q].exp; //지수는 더하고
				terms = addTerm(z, newTerm, terms);//다항식을 곱하는데 addTerm함수를 만든것을 이용해서 구현
				//처음에는 텀이 0, 애드텀해서 새로운항을 add텀에 넣는데 증가된걸 가져와서 계속 반복
			}
		//구현코드
		return terms;
	}
	static double EvaluatePolynomial(Polynomial3[]z, int zTerms, int value) {
		//zTerms는 다항식 z의 항의 수, value는 f(x)를 계산하기 위한 x 값
		//항의수가있어야됨 > ex)zTerms의 수를 모르잖아
		//다항식 계산 결과를 double로 리턴한다 
		double result = 0.0;
		//구현 코드
		return result;
	}
	public static void main(String[] args) {
		Polynomial3[] x = {
		         new Polynomial3(1.5, 3),
		         new Polynomial3(2.5, 7),
		         new Polynomial3(3.3, 2),
		         new Polynomial3(4.0, 1),
		         new Polynomial3(2.2, 0),
		         new Polynomial3(3.1, 4),
		         new Polynomial3(3.8, 5),
		     };
		Polynomial3[] y = {
		         new Polynomial3(1.5, 1),
		         new Polynomial3(2.5, 2),
		         new Polynomial3(3.3, 3),
		         new Polynomial3(4.0, 0),
		         new Polynomial3(2.2, 4),
		         new Polynomial3(3.1, 5),
		         new Polynomial3(3.8, 6),
		     };
		int nx = x.length;


		ShowPolynomial("다항식 x = ", x, -1);
		ShowPolynomial("다항식 y = ", y, -1);
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		ShowPolynomial("정렬후 다항식 x = ", x, -1);
		ShowPolynomial("정렬후 다항식 y = ", y, -1);
		
		Polynomial3[] z = new Polynomial3[20];
		
		for (int i =0; i < z.length; i++)
			z[i] = new Polynomial3();
	
		int zTerms = AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);

		
		zTerms = MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
		MergeSort(z, 0, zTerms); // 배열 x를 퀵정렬
		ShowPolynomial("곱셈후 다항식 z = ", z, zTerms);
		double result = EvaluatePolynomial(z, zTerms, 1);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println(" result = " + result );
	}
}
