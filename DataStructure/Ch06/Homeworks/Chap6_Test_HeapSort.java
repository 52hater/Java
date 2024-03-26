package DataStructure.Ch06.Homeworks;

import java.util.Random;
import java.util.Scanner;

//강의자료참고해서 자바버전으로 바꿔보면서 해

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap

	public Heap(int sz) {//생성자
		MaxSize = sz;
		heap = new int[MaxSize];//배열할당
		n = 0; //current size of MaxHeap 초기화
	}

	public void display() {
		for (int i = 0; i <= n; i++) {//현재사이즈
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
	@Override
	public void Insert(int x) {
		if (n == MaxSize) { //현재 힙배열의 크기가 맥스힙 한도사이즈와 같으면
			HeapFull(); //힙풀 호출
			return; //반환
		}
		n++; // 이게 없어서 자꾸 하나만 insert 됐음
		int i;
		//idx 1로 시작하니까 범위 i >= 1;
		//끝자리로 초기화
		//끝자리에서 계속 반으로 나누니까 > 중간으로가면서 insert
		for (i = n; i >= 1; i /= 2) {
			if (i == 1) break; //한개면 그 값이 루트가 되고 break;
			//브레이크 먹고 지금 이 for 문에서 빠져나가서
			//heap[i] = x; 이렇게 1번 인덱스에 x 값을 넣고
			//case1로 다시 날아가서 두번째인 i = 2를 받아서 다시 메소드호출을 타고 여기로 날아와
			if (x <= heap[i / 2]) break;
			//새로 받는 x 값이 현재힙 중간위치의 값 이하이면 break 하고 다시 값 받으러감
			
			// move from parent to i
			heap[i] = heap[i / 2]; //
		}
		heap[i] = x;
		
	}
	@Override
	//최댓값을 삭제하는 메소드 > 최댓값을 삭제해서 배열에 넣으면 오름차순으로 sort 되지
	public int DeleteMax() { //이걸 계속 호출하면 정렬된 결과가 나온다//받는값없으니 파라미터는 필요없지
		if (n == 0) {
			HeapEmpty();
			return -1;
		}
		//x = heap[1]; Element<Type> k = heap[n]; n--;
		int root = heap[1]; //0말고 인덱스 1부터(필기)
		int last = heap[n]; //current size of MaxHeap > 마지막 인덱스
		n--; //del 과정에서 정렬이 되면서 힙에서는 하나씩없어지니까 --;
		int i;//얘가 부모
		int j;//얘가 자식(왼쪽) / j+1은 오른쪽자식
		for (i = 1; i <= n; i++) {
			for (j = 2; j <= n; j++)
				if (heap[j] < heap[j+1]) {
					j++;
					continue;
				}
			if (heap[j] >= heap[j+1]) {
				heap[j+1] = heap[j];
			}
			if (heap[last] == heap[j]) {//힙에 하나만 남으면
				break;
			}
			heap[i] = heap[j];
			i = j; //자식을 부모로만들고
			j *= 2; //j=j*2 > 자식의 인덱스 = 부모인덱스 *2
		}
		heap[i] = last;
		return root;

	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}
public class Chap6_Test_HeapSort {
	static void showData(int[] d) {
		for (int i = 0; i < d.length; i++)
			System.out.print(d[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner scn = new Scanner(System.in);
		Heap heap = new Heap(20);
		final int count = 10;
//		int [] x = new int[count]; //case1에서 쓰임
		int [] sorted = new int[count];

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = scn.nextInt(); // case num 입력
			switch (select) {
			case 1://입력
				// count 변수에 지정된 10번만큼 반복해서 힙에 데이터 삽입
				for (int i = 1; i <= count; i++) { //count=10
					heap.Insert(rnd.nextInt(30)+1); //case 1 의 배열 //count+1 : 왜 +1?
                     //클래스명. > 메소드사용 
                    // heap 클래스에서 Insert 메소드를 사용해서 x[i]에 insert
				}
				break;
			case 2://출력
				heap.display(); //heap 클래스에서 display 메소드 사용
				break;
			case 3://정렬 > for 루프돌려서 딜리트맥스 계속 불러서 구현을 해
				for (int i = 0; i < count; i++) {
                    sorted[i] = heap.DeleteMax(); // 최대값 삭제하여 정렬 배열에 저장
                    //배열 sorted[i]
                }
                System.out.println("Sorted Array: ");
                showData(sorted);
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}