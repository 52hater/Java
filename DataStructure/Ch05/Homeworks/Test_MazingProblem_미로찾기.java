package DataStructure.Ch05.Homeworks;

import java.util.ArrayList;
import java.util.List;

enum Directions2 {N, NE, E, SE, S, SW, W, NW}
class Items3 {
	int x;
	int y;
	int dir;
	public Items3(int x, int y, int d) { //생성자
		this.x = x;
		this.y = y;
		this.dir = d;
		//객체의 필드
	}
	@Override
	public String toString() {
		return "x = " + x + ", y = " + y + ", dir = " + dir;
	}
}
class Offsets3 {
	int a;
	int b;

	public Offsets3(int a, int b) { //생성자
		this.a = a;
		this.b = b;
		//객체의 필드
	}
}
class StackList {
	private List<Items3> data; // 스택용 배열 // data 는 스택박스
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 실행시 예외 : 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EmptyIntStackException() {
		}
	}

	// --- 실행시 예외 : 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public OverflowIntStackException() {
		}
	}

	// --- 생성자(constructor) ---//
	public StackList(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<>(0); // 스택 본체용 배열을 생성 (스택박스)
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x 를 푸시 ---//
	public void push(Items3 p) throws OverflowIntStackException {
		if (top >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException();
		data.add(p);
		top++;
		return;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Items3 pop() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data.remove(--top);
	}

	// --- 스택에서 x 를 찾아 인덱스(벌견하지 못하면 –1)를 반환 ---//
	public int indexOf(Items3 x) {
		for (int i = top - 1; i >= 0; i--) // 정상 쪽에서 선형검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	static void showMatrix(int[][] maze, int x, int y) {
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				System.out.print(maze[i][j] + " ");
				
			}
			System.out.println();
		}
	}

	public class Test_MazingProblem_미로찾기 {

		static Offsets3[] moves = new Offsets3[8];//static 을 선언하는 이유를 알아야 한다

		//이게 핵심구현
		public static void path(int[][] maze, int[][] mark, int ix, int iy) {

			mark[1][1] = 1; //울타리때문에 [1][1]
			StackList st = new StackList(50);
			Items3 temp = new Items3(0, 0, 0);//N :: 0//x y dir//temporary?
			temp.x = 1; //울타리가 있으니 1로 초기화?
			temp.y = 1;
			temp.dir = 2;//E:: 2 ? east? / east 부터 탐색시작이라는 소리인듯? 그럼 NE가 1인가
			mark[temp.x][temp.y] = 2;//미로 찾기 궤적은 2로 표시 // 갔다온거??
			st.push(temp);
			//temp 시작지점?

			while (!st.isEmpty()) // 스택에 뭐가 들어갈때까지 루프 / 비면 빠져나와
			{
				Items3 tmp = st.pop(); // unstack// tmp 객체에 팝한걸 넣고
				int i = tmp.x;
				int j = tmp.y;
				int d = tmp.dir;
				int g = i + moves[d].a; //g, h 는 이전위치, i, j 는 이동 할 위치
				int h = j + moves[d].b; //다음이동할위치의 y 좌표 ?

				mark[i][j] = 1;//backtracking 궤적은 1로 표시
				//현재위치를 backtracking 마킹한거
				// 1, 2 헷갈리는데 개념이해를 아직 제대로 못한 듯
				//백트레킹이니까 벽을 세우는거지

				// moves forward
				while (d < 8) {//이전지점이 있으니까 d < 8 / 가능한 모든 이동 dir 탐색
					if ((g == ix) && (h == iy)) { // 이전위치가 다음위치 = 출구? 막혀?
						showMatrix(maze, i, j);
					}

					if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
						temp = new Items3(0, 0, 0); //while문 반복마다 새로운 객체사용하기위해// output path
						temp.x = i;
						temp.y = j;
						temp.dir = d+1; //다음 이동 dir 설정 ex) E + 1 = SE

						g = i + moves[d].a;
						h = j + moves[d].b;

						mark[i][j] = 2; //이동한지점 마킹
						st.push(temp);

						i = g;
						j = h;
						d = 0;
					} else
						d++; //북쪽으로 못가면 d++로 북동쪽(?) / move 배열에 방향
					g = i + moves[d].a;
					h = j + moves[d].b;
				}
			}
			System.out.println("no path in maze ");
		}
		
		public static void main(String[] args) {
			int[][] maze = new int[14][17]; //울타리가2
			int[][] mark = new int[14][17]; //mark : 지나온 곳 다시 가지 않도록 check

			int input[][] = { // 12 x 15
					{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
					{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
					{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
					{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
					{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
					{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
					{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
					{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }

			};

			for (int ia = 0; ia < 8; ia++)
				moves[ia] = new Offsets3(0, 0);//배열에 offsets 객체를 치환해야 한다.
			//moves 배열 : 8방향 0~7 저장
			//ia가 moves 배열에 새로운 Offsets3 객체를 할당하는데 사용되는 반복인덱스
			moves[0].a = -1;	moves[0].b = 0;
			moves[1].a = -1;	moves[1].b = 1;
			moves[2].a = 0;		moves[2].b = 1;
			moves[3].a = 1;		moves[3].b = 1;
			moves[4].a = 1;		moves[4].b = 0;
			moves[5].a = 1;		moves[5].b = -1;
			moves[6].a = 0;		moves[6].b = -1;
			moves[7].a = -1;	moves[7].b = -1;
			//Directions d;
			//d = Directions.N;
			//d = d + 1;//java는 지원안됨
			
			// input[][]을 maze[][]로 변환
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 17; j++) {
					if (i == 0 || j == 0 || i == maze.length || j == maze[0].length) {
						maze[i][j] = 1;
					} else {
						maze[i][j] = input[i-1][j-1];
						//메이즈가 if 문 거쳐서 나올때 테두리만 나온상태니까
						//테두리 내부는 빈상태 > 그 빈상태를 else 로 받는 것
						//그래서 maze[i-2][j-2]가 아닌듯
					}
				}
			}
			
//			System.out.println("maze[12,15]::");
//			showMatrix(maze, 13, 16);
//
//			System.out.println("mark::");
//			showMatrix(mark, 13, 16);
//
//			path(maze, mark, 12, 15);
//			System.out.println("mark::");
//			showMatrix(mark, 12, 15);
		}
	}
}

