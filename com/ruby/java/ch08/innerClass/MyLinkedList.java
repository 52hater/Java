package com.ruby.java.ch08.innerClass;

public class MyLinkedList {
	private Node head;//필드
	private class Node {
		private String data;
		private Node link;
		public Node(String data) {//클래스 내의 생성자
			//생성자는 필드가 2개이므로 heap에 필드 공간 2개를 할당//data만 전달받았고 
			//공간할당:자바가상머신, 생성자가 값만 넣어준다??
			//값이 안들어가면 공간할당안되는게 아님
			//값을 넣어주는게 없어도 공간할당이 됨
			//우리가 하는건 값만 넣어주는 것
			//파라미터 전달받은값넣어주고 링크는 널로
			
			this.data = data; this.link = null;//하나만있으니까 디스안써도된다(?)
		}
	}//이게 내부클래스, 노드에 관련된건 내부에만 있으니까 여기만 보겠다는 것
	//관련있는것을 모은 사례가 되는거지
	
	public void add(String data) {
		Node newNode = new Node(data);
			if (head == null)
				head = newNode; //뉴노드 : 참조변수//헤드가 노드를 가리키게//헤드가 널이면 맨첨에 만들때 하나를 가리킨다
			else {//헤드가 널이 아니면
				Node next = head;//또다른변수 넥스트가 헤드가 가리키는 그걸 hong|null 가리킨다
				while(next.link != null) {
					next = next.link;//null칸을 가리켜
				}
				next.link = newNode;
				//두번째것 kim|null 에 적용(?)
			}
		
	}
	
	public void print() {
		
	}
	
	public MyLinkedList() {//앞의 클래스에 대한 생성자
		this.head = null;
	}
//클래스 내에 클래스 > 359p 그런데 Node 클래스~
}
