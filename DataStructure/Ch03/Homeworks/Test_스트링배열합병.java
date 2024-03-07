package DataStructure.Ch03.Homeworks;

/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;
import java.util.List;
public class Test_스트링배열합병 {
    static void showList(String topic, String [] list) {

    }
    static String[] mergeList(String[]s1, String[] s2) {//리턴값은 스트링주고
    	int i = 0, j = 0,k =0;
    	String[] s3 = new String[10];//s3 을 새로 할당하고 합친다음에 s3리턴
    	
    	return s3;
    }
    public static void main(String[] args) {
	String[] s1 = { "홍길동", "강감찬", "을지문덕", "계백", "김유신" };
	String[] s2 = {"독도", "울릉도", "한산도", "영도", "우도"};
	Arrays.sort(s1);
	Arrays.sort(s2);
	
	showList("s1배열 = ", s1);
	showList("s2배열 = ", s2);

	String[] s3 = mergeList(s1,s2);
	showList("스트링 배열 s3 = s1 + s2:: ", s3);
}
}

//merge 병합
//s1 = 강감찬(p) 계백 김유신 을지문덕 홍길동//p, q 시작점
//s2 = 독도(q) 영도 우도 울릉도 한산도
//s3 = s1+s2
//s3 = 강감찬 계백 김유신 독도 영도 우도 울릉도 을지문덕 한산도 홍길동
//while 루프 돌려서 p 가 돌고 q 가 돌고
//빠져나왔을떄 p 가 남아있는지 q 가 남아있는지 또 while 문을 돌려야된대(?)
//합해진건 새로운 배열
//