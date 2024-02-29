package com.ruby.java.ch06;
//하나의 java file에 Student 객체를 정의하고 구현하는 실습 과제2번
/*
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
abstract class InterfaceStudents {//추상클래스
	public abstract void showObject();//추상메소드
}
class Student extends InterfaceStudents {//상속
 static int countStudents;//객체수
 int sid;//학번
 String sname; //학생 이름
 String city; //주소 도시
 
// public Student() {//자바컴파일러가 자동으로 생성해주는 디폴트 생성자
//	 sid = 0; 
// sname = null; city = null;
//	countStudents++;
// }

 public Student(int sid) {
	 this();
	 this.sid = sid;
//	 sname = null; city = null;
//	 countStudents++; 
 }
 
 public Student(int sid, String name, String city) {
	 this(sid);
	 this.sid = sid;
	 this.sname = name; this.city = city;
 }
 
 public String toString() {//생성자 만들기 전
	 return "sid="+sid + ", sname=" + sname + ", city=" + city;
	 //모든 클래스의 최상위 루트는 오브젝트 그걸 재정의한거
 }
 public void showObject() {
	 System.out.println("["+sid +", " + sname + ", " + city+"]");
 }
 static void showNumberObjects() {//생성된 객체수를 출력한다.
	 System.out.println(" 생성객체수=" + countStudents);
 }
}
class WorkStudent extends Student {
	String eno;
	String company;
	public WorkStudent(int sid, String sname, String city, String eno, String company) {
//		this.sid = sid;
//		this.sname = sname;
//		this.city = city; //이거 세개가 중복이니까 super를 부름
		super(sid, sname, city);//이거를 사용하라는게 과제의 핵심 > 중복코딩제거(여기서는 슈퍼를 써서 중복코딩제거)
		this.eno = eno; //이넘버?
		this.company = company;
	}
	 public String toString() {
		 return 
	 }
	 public void showObject() {
		 //Student 출력 코드 추가
		 System.out.println("["+eno +", " + company + "]");
	 }
}
class CodingWorkStudent extends WorkStudent {
	String language;
	 public String toString() {
		 return 
	 }
	 public void showObject() {
		 //WorkStudent 출력 코드 추가 
		 System.out.println("["+language+"]");
	 }
}
 // 생성자 구현한다.
public class Test_객체배열 {//요파일의 퍼블릭클래스
	 static void showObjects(InterfaceStudents is) {
		 is.showObject();
	 }
	 public static void main(String[] args) {
	 Student arry[] = new Student[10];
	 showNumberObjects();
	 arry[0] = new Student();//파라미터가 없어 디폴트 생성자야
	 arry[1] = new Student(202301);//파라미터 하나
	 arry[2] = new Student(202301, "Hong", "Busan");//클래스홍 샐러리2만 파라미터 3개받는거
	 arry[3] = new WorkStudent();
	 arry[4] = new CodingWorkStudent();
	 arry[5] = new WorkStudent();
	 showNumberObjects();
	 for (Student s : arry) {
		 System.out.println(s.toString());//객체고 객체의 메서드를 부른거
	 }
	 for (Student sx : arry) {
		 showObjects(sx);//객체의 메소드가 아닌거 ~~.이 아니면 일반함수 (위에쇼오브젝트라는 스테틱을 ~ is로?를? 불러서)
	 }
 }

}
