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
	
	public Heap(int sz) {

	}

	public void display() {

	}
	@Override
	public void Insert(int x) {
		if (n == MaxSize) { //현재 힙배열의 크기가 맥스힙 한도사이즈와 같으면
			HeapFull(); //힙풀 호출
			return; //반환
		}
		int i;
		for (i = n; i >= 1; i /= 2) { //
			if (i == 1) break; // at root //한개니까 루트가 되고
			if (x <= heap[i / 2]) break; //부모인덱스가 x 보다 크거나 같으면
			// move from parent to i
			heap[i] = heap[i / 2];
		}
		heap[i] = x;
	}
	@Override
	public int DeleteMax() { //이걸 계속 호출하면 정렬된 결과가 나온다

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
	    int [] x = new int[count+1];
	    int [] sorted = new int[count];

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = scn.nextInt();
			switch (select) {
			case 1://입력
	
				break;
			case 2://출력
				heap.display();
				break;
			case 3://정렬 > for 루프돌려서 딜리트맥스 계속 불러서 구현을 해

				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}
