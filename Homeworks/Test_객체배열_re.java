package Homeworks;
//하나의 java file에 Student 객체를 정의하고 구현하는 실습 과제2번
/*
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
abstract class InterfaceStudents {//추상클래스
   public abstract void showObject();//추상메소드
   //추상클래스는 직접적으로 인스턴스화될 수 없음
   //추상 클래스로부터 직접적으로 객체생성X
}

class Student extends InterfaceStudents {//스튜던트클래스가 인터페이스 스튜던트클래스를 상속받았어
 static int countStudents;//객체수
 int sid = 0;//학번,,필드들
 String sname = null; //학생 이름
 String city = null; //주소 도시
 
 public Student() {//디폴트생성자(매개변수x), 객체생성마다 카운트학생+1, 학생객체수 파악
     countStudents++;//숫자파악
 }

 public Student(int sid) {//int 매개변수 학번sid를 받는 생성자
     this.sid = sid;
     countStudents++;//
 }

 public String toString() {
    return "sid="+ sid + ", sname=" + sname + ", city=" + city;
    //투스트링메소드(오브젝트)로 재정의해서 객체의 문자열표현을 return
    //모든 클래스의 최상위 루트는 오브젝트 그걸 재정의한거
 }
 public void showObject() {//스튜던트 출력
    System.out.println("["+sid +", " + sname + ", " + city+"]");
 }
 static void showNumberObjects() {//생성된 객체수를 출력한다.
    System.out.println(" 생성객체수=" + countStudents);
 }
}
class WorkStudent extends Student {
   String eno;
   String company;
   
   public WorkStudent() {
        super(); // Student 클래스의 생성자 호출
    }
   
   public WorkStudent(int sid, String sname, String city, String eno, String company) {
        super(sid);
        this.sname = sname;
        this.city = city;
        this.eno = eno;
        this.company = company;
    }
   
    public String toString() {
       return super.toString() + ", eno=" + eno + ", company=" + company;
    }
    public void showObject() {
       //Student 출력 코드 추가
//       System.out.println("["+eno +", " + company + "]");
       System.out.println("[" + sid + ", " + sname + ", " + city + ", " + eno + ", " + company + "]");
    }
}

class CodingWorkStudent extends WorkStudent {
   String language;
   
   public CodingWorkStudent() {
        super();
    }

    public CodingWorkStudent(int sid, String sname, String city, String eno, String company, String language) {
        super(sid, sname, city, eno, company);
        this.language = language;
    }
   
    public String toString() {
       return super.toString() + ", language=" + language;
    }
    
    public void showObject() {
       //WorkStudent 출력 코드 추가 
//       System.out.println("["+language+"]");
       System.out.println("[" + sid + ", " + sname + ", " + city + ", " + eno + ", " + company + ", " + language + "]");
    }
}
 // 생성자 구현한다.

public class Test_객체배열_re {//요파일의 퍼블릭클래스
    static void showObjects(InterfaceStudents is) {
       is.showObject();
    }
    
    public static void main(String[] args) {
    Student arry[] = new Student[5];
    Student.showNumberObjects();
    arry[0] = new Student();//매개변수 없는 생성자호출
    arry[1] = new Student(202301);
    arry[2] = new WorkStudent(202302, "철수", "부산", "사원1", "삼성");
    arry[3] = new CodingWorkStudent(202303, "영희", "서울", "사원2", "현대", "한국어");
    arry[4] = new WorkStudent(202304, "민재", "제주", "사원3", "LG");
    Student.showNumberObjects();
   /* 매개변수가 없는 생성자를 호출하는 이유는 다양합니다.
    주로 다음과 같은 상황에서 매개변수가 없는 생성자를 호출합니다:
    기본적인 객체 생성: 클래스에 명시적으로 정의된 생성자가 없는 경우, 
    컴파일러는 매개변수가 없는 기본 생성자를 자동으로 생성합니다.
    이 생성자는 객체를 생성할 때 호출됩니다.
    상속 시 부모 클래스의 생성자 호출: 자식 클래스의 생성자에서 super()를 사용하여 부모 클래스의 생성자를 호출할 때,
    매개변수가 없는 생성자를 호출하는 경우가 많습니다.
    이렇게 함으로써 부모 클래스의 초기화를 수행할 수 있습니다.
    인스턴스 변수 초기화: 객체를 생성할 때 인스턴스 변수를 초기화할 필요가 있을 때,
    매개변수가 없는 생성자를 사용하여 초기화 작업을 수행합니다.*/
   
    for (Student s : arry) {
       System.out.println(s.toString());//객체고 객체의 메서드를 부른거
    }
    for (Student sx : arry) {
       showObjects(sx);//객체의 메소드가 아닌거 ~~.이 아니면 일반함수 (위에쇼오브젝트라는 스테틱을 ~ is로?를? 불러서)
    }
 }

}