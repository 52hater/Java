package DataStructure.Ch05.Homeworks;

//해가 256개 확인 필요 23.12.12
import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//모든 해가 나오는 버젼 만들기 
/*
 * 체스판은 8 x 8 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
 * Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
 * pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능 체스판 최대 배치 문제 : king/16,
 * Queen/8, rook/8, bishop/?, knight/? rook 2개/a, h, knight 2개/b, g, bishop
 * 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
 */
class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}

	@Override
	public boolean equals(Object p) {
		if ((this.ix == ((Point) p).ix) && (this.iy == ((Point) p).iy))
			return true;
		else
			return false;
	}
}

class Stack4 {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	private List<Point> data; // 스택용 배열
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public Stack4(int capacity) {
		this.capacity = capacity;
		data = new ArrayList<Point>();
		top = 0;
	}

	// --- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		if(isFull())
			throw new OverflowGenericStackException("push: stack overflow");
		data.add(x);
		top++;
		System.out.println(top);
		return true;

	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if(isEmpty())
			throw new EmptyGenericStackException("pop: stack empty");
		//리스트의 탑을 리턴한다.
		Point result = data.get(top-1);
		data.remove(top-1);
		top--;
		return result;
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if(isEmpty())
			throw new EmptyGenericStackException("peek: this stack is empty");

		System.out.println(top);
		return data.get(top-1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		if (isEmpty())
			//throw new EmptyGenericStackException("clear: this stack is already empty");
			top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--)
			if (data.get(i).equals(x))
				return i;
		return -1;
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() throws EmptyGenericStackException{
		if (top <= 0)
			throw new EmptyGenericStackException("stack:: dump - empty");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

public class Test_queenEight_구현과제_수정 {
	public static void EightQueen(int[][] d) {
		int count = 0;// 퀸 배치 갯수
		int numberSolutions = 0;
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++;
		ix++;//다음행으로 이동
		st.push(p);// 스택에 현 위치 객체를 push

		//175p
		//주석으로 내 알고리즘 로직을 작성
		//175p 코드를 사용하면 된다
		// (n > 0) >>> 체스판에 퀸을 다음 행에 배치할 수 있으면 으로 바꾸고
		//d[x][y] = 1 , 스택에 s.push(x, y)
		//n = s.pop; >>> pop()한 위치를 사용해서 다음 열을 조사하고 
		//더 이상 없으면 다시 이전 행으로 돌아가고 / (팝을해서 그다음걸 체크하는)
		//코딩전에 손으로 하고 그걸 구조를 이용해서 말로 써봐
		//행끝까지 갔는데 이제 갈데가없으면 앞의 행으로 이전, 컬럼을 다 뒤져
		//이런식으로 말로 쓰고 나서 코딩하는게 더 빨라
		//8퀸은 자료구조보다는 알고리즘의 첫단계
		//스택의 포인터 완성시켜놓고 여기에 적용

		//넥스트무브를 사용해서 -1일때와 아닐때
		while (count < 8) {
			//4*4 일때
			//0,0에 퀸배치, 푸쉬
			//넥스트무브 함수사용
			//다음행으로, 넥스트무브 함수사용, 1,2에 퀸 배치, 푸쉬
			//다음행으로, 넥스트무브 함수사용, 넣을 수 있는 곳X(return -1;)
			//(1,2)pop, (0,0)pop
			//ix++ >> 다음행으로 이동, (1,0)push
			//(0,2)push?

			int newCol;
			if (newCol = nextMove(d, ix, iy) != -1) {
				d[ix][newCol] = 1;
				st.push(p);
				count++;
				ix++;
				continue;
			} else {
				st.pop();
			}
			if(newCol == -1) {
				p = pop();
				x=p.ix
						y=p.iy
						//물리기
						d[x][y]=0
						count--
						y++
						continue
			}
			if (st.isEmpty() != true) {
				p = st.pop();
				System.out.println(p);
				p = p - 2;
				continue;
			}
			break;

		}
		System.out.println("해의 개수 : " + numberSolutions);
	}

	public static boolean checkRow(int[][] d, int crow) { 
		//배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
		//대각선 남서쪽체크 /
		for (int i = 0; i < d[0].length; i++) {
			if (d[crow][i] == 1) {
				return false; // 해당 행에 이미 퀸이 배치되어 있으면
			}
		}
		return true; // 해당 행에 퀸을 배치가능
	}

	public static boolean checkCol(int[][] d, int ccol) {
		//배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
		//대각선 남동쪽체크 \
		for (int i = 0; i < d.length; i++) {
			if (d[i][ccol] == 1) {
				return false; // 해당 열에 이미 퀸있으면
			}
		}
		return true; // 퀸 없으면

	}

	//배열 d 에서 행 cx, 열 cy 에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) {
		// x++, y-- or x--, y++ where 0<= x,y <= 7
		int x = cx, y = cy;
		while (x >= d.length-1 && y >= d[0].length-1) {
			if (d[x][y] == 1)
				return false;
			x--;
			y--;
		}
		while (x < d.length-1 && y < d[0].length-1) {
			if (d[x][y] == 1)
				return false;
			x++;
			y++;
		}
		
		return true;
	}

	//배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {
		int x = cx, y = cy;
		while (x >= 0 && y < d[0].length-1) {
			if (d[x][y] == 1)
				return false;
			x--;
			y++;
		}
		while (x < d.length-1 && y >= 0) {
			if (d[x][y] == 1)
				return false;
			x++;
			y--;
		}
		
		return true;
	}

	//배열 d에서 (x,y)에 퀸을 배치할 수 있는지  조사
	// 배열 d에서 (x,y)에 퀸을 배치할 수 있는지 조사
	//x y가 다음행에 놓을 위치
	//0,0하고나서 1,0 > checkMove(d, 1,0)
	//이 함수는 if(checkRow() && checkCol() && checkDiagSE() && checkDiagSW()), return end;
	//for(int i=0~~~해서 다 체크해서
	//nextMove(d)는 checkMove를 불러서 for(int i = 0~~ if(checkMove(d, 1,0 / return col;
	//다 돌아서 없으면 return = -1;
	//로우 컬럼 체크하고 대각선 체크하고

	//첵무브는 네개를 다 불러서하고
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y)) {
			return true;
		}
		return false;
	}

	// 배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환,
	//이동이 가능하지 않으면 -1를 리턴
	//넥스트무브는 첵무브를 불러서 for루프 돌려서
	public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
		for (int nextCol = col+1; nextCol < d[0].length; nextCol++) {
			//다음열을 탐색해야하니까 col+1로 초기화
			if (checkMove(d, row, nextCol)) {//checkMove가 참이면
				return nextCol; // col+1(다음열로)
			}
		}
		return -1;
	}

	static void showQueens(int[][] data) {// 배열 출력
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		EightQueen(data);

	}

}
