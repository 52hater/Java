package DataStructure.Ch04;
/*
 * 교재에 있는 소스코드
 * 입력하여 실행 실습
 * 정수형 스택 소스 코드
 * 객체스택과 큐에 대한 구현도 정수 스택의 예외처리 방식을 반복 적용함 
 */

import java.util.Scanner;

//int형 고정 길이 스택

class IntStack4 {//외부클래스
	private int[] stk; // 스택용 배열
	private int capacity; // 스택의 크기(stk=new int[10]이면 10이지) 사이즈지정//용량
	private int top; // 스택 포인터 //ptr > top으로 바꾸자//스택에서의 탑임 이게//

	//--- 실행시 예외: 스택이 비어있음 ---//
	//빈스택이면 탑이 아래 > pop을 하려함 > 예외발생(Empt~라는 예외를 발생시키겠다)
	//top = 0
	public class EmptyIntStackException extends RuntimeException {//내부클래스
		//익셉션 아래의 런타임익셉션
		//자바 내장클래스들
		public EmptyIntStackException() {

		}
	}

}

//--- 실행시 예외: 스택이 가득 참 ---//push가 안되겠지?
public class OverflowIntStackException extends RuntimeException {
	public OverflowIntStackException() {

	}

}

//--- 생성자(constructor) ---//
//생성자에 파라미터가 왜 하나지?
//Class Student{String name; int age; String city;(클래스의 필드/데이터멤버들)가 있으면
//이거에 대해서 생성자는 public Student(name, age, city){} >>가 아니지
//생성자함수 정의(생성자함수를 다 구현하는 것/undefined:함수정의x)
//함수정의 > 함수안에서 타입을 다 지정해줘야지 함수명, 데이터타입, 
//public Student(String name, int age, String city) 이렇게 해야지
//암기를 해 그냥 이거는 그냥 암기

public IntStack4(int maxlen) {
	top = 0;
	capacity = maxlen;
	try {//예외를 던지고
		stk = new int[capacity]; // 스택 본체용 배열을 생성
	} catch (OutOfMemoryError e) { // 생성할 수 없음//캐치가 예외를 받는다//(클래스OOME 변수e)
		capacity = 0;//스택을 만들었는데 메모리가없어서 스택의크기가 0이야 > 못만든거지
	}
}

//--- 스택에 x를 푸시 ---//
public void push(int x) throws OverflowIntStackException {
	if (isFull()) // 스택이 가득 참(true)
		throw new OverflowIntStackException();//생성자에서 객체를 하나 만듦
	//예외가 발생해서 그걸 던지면 실행안하고 빠져나옴
	//받는게 뭐냐? 메인메소드에 case1의 캐치가 받음
	//스루는 객체를 던지고 캐치는 타입으로 받는다
	return stk[top++] = x; //0위치에 넣고 top 을 증가시키고
}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
public int pop() throws EmptyIntStackException {
	if (isEmpty()) // 스택이 빔
		throw new EmptyIntStackException();
	//이걸 엠티라 안하고 오버플로우예외를 갖다 써버리면?
	//>에러는 안남, but 둘은 다른 예외지 > 캐치하는 부분이 달라져야됨
	//예외의 종류가 달라서 클래스를 만들어놓은 것(?)
	//구분만가능하면 당연히 이름은 상관없지만 다른사람이 볼 수 있으니 이해가능한 작명으로
	//가독성의 문제
	return stk[--top];//--가 오른쪽인지 왼쪽인지 방향?? 여튼 차이 개념정리해서 여기 적어놔

}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
//pop과 peek의 차이
//pop은 꼭대기의 값을 가져와 > 크기가 줄어
//peek는 꺼내는것이 아니라 꼭대기의 값이 뭔지 묻는 것(ptr의 변동이 없다)
public int peek() throws EmptyIntStackException {
	//if (ptr <= 0) 이거 대신에 isEmpty()함수사용
	//지금은 위에거가 편하겠지만
	//swap을 쓰면 코딩이 간단해지는 것 처럼
	//작은함수를 만들어서 문제를 해결하는것을 습관화 시켜야 내실
	if (isEmpty()) // 스택이 빔
		throw new EmptyIntStackException();
	return stk[top -1];
}

//--- 스택을 비움 ---//

public void clear() throws EmptyIntStackException {
	/*
	 * stack을 empty로 만들어야 한다.
	 * stack이 empty일 때 clear()가 호출된 예외 발생해야 한다 
	 * pop()으로 구현하지 않는다
	 */
	if (isEmpty()) // 스택이 빔 //비었는데 클리어니까 예외발생시켜라
		throw new EmptyIntStackException();

}
//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
public int indexOf(int x) {
	for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
		if (stk[i] == x)
			return i; // 검색 성공
	return -1; // 검색 실패
}

//--- 스택의 크기를 반환 ---//
public int getCapacity() {
	return capacity;
}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
public int size() {
	return top;
}

//--- 스택이 비어있는가? ---//
public boolean isEmpty() {
	return top <= 0;
}

//--- 스택이 가득 찼는가? ---//
public boolean isFull() {
	return top >= capacity;
}

//--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
public void dump() throws EmptyIntStackException{
	if (isEmpty()) {
		System.out.println("스택이 비어 있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.println(stk[i] + " ");
			System.out.println();
		}
		throw new EmptyIntStackException();
		//여기서 예외가 발생을하면 case4로 감

	}
}

public class 실습4_2정수스택_배열 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack4 s = new IntStack4(4); // 최대 64 개를 푸시할 수 있는 스택

		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(5)clear  (0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {

			case 1: // 푸시
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {//try 블럭에서 예외가 발생하면
					s.push(x);
				} catch (IntStack4.OverflowIntStackException e) {//캐치해서 처리를한다
					//여기 왜 . ? > 내부클래스
					//자바에선 괄호치면 함수로간주 >catch()도 함수로 보면됨
					//catch(데이터타입:클래스 매개변수e) {바디}
					System.out.println("스택이 가득 찼습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 2: // 팝
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (IntStack4.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack4.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 4: // 덤프 //위에거 보면서 만들어봐
				try {
					s.dump();
				} catch() {//예외가 발생되면 캐치에서 받아서

					break;
				case 5: //clear//위에거보면서 예외발생시 처리하는걸 구현해봐

					break;
				}
			}
		}
	}