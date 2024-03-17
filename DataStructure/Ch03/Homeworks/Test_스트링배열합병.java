package DataStructure.Ch03.Homeworks;

/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;
import java.util.List;

public class Test_스트링배열합병 {
	static void showList(String message, String [] list) {
		System.out.println(message + " :: ");
		for (String elem : list) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	static String[] mergeList(String[]s1, String[] s2) {//리턴값은 스트링주고 //리턴타입배열
		int i = 0, j = 0, k = 0; //이 형식 외워
		String[] s3 = new String[10];//s3 을 새로 할당하고 합친다음에 s3리턴//새로운배열을만들고 채워넣고 리턴
		
		while(i < s1.length && j < s2.length) {
			if(s1[i].compareTo(s2[j]) < 0) {
				s3[k++] = s1[i++];
//				i++;
			} else {
				s3[k++] = s2[j++];
//				j++;
			}
//			k++;
		}

		while(i < s1.length) {
			s3[k++] = s1[i++];
//			k++;
//			i++;
		}

		while(j < s2.length) {
			s3[k++] = s2[j++];
//			k++;
//			j++;
		}

		return s3;
	}
// 헷갈리게 증감식 따로 적지말고 그냥 안에 적자... 한참 고생했네
	//머지리스트메소드 이거 꼭 복습!
	public static void main(String[] args) {
		String[] s1 = { "홍길동", "강감찬", "을지문덕", "계백", "김유신" };
		String[] s2 = {"독도", "울릉도", "한산도", "영도", "우도"};

		Arrays.sort(s1);//comparable, comparator 도 없다 > comparable 의 compareTo()를 사용
		showList("s1배열", s1);
		System.out.println();

		Arrays.sort(s2);
		showList("s2배열", s2);
		System.out.println();

		String[] s3 = mergeList(s1,s2); //함수에 전달하고 받고 리턴값, 리턴타입 훈련
		showList("s3 = s1 + s2", s3);
	}
}

//merge 병합
//a = [1, 5, 9, 10, 11, 15] 정렬
//b = [2, 4, 8] 정렬
//c = a+b //c 도 정렬
//p, q를 써서 비교해서 쭉 [1, 2, 4, 5, 8, 9 하고나서 남은 10 11 15 싹 넣는게 merge
//s1 = 강감찬(p) 계백 김유신 을지문덕 홍길동//p, q 시작점
//s2 = 독도(q) 영도 우도 울릉도 한산도
//s3 = s1+s2
//s3 = 강감찬 계백 김유신 독도 영도 우도 울릉도 을지문덕 한산도 홍길동
//while 루프 돌려서 p 가 돌고 q 가 돌고
//빠져나왔을떄 p 가 남아있는지 q 가 남아있는지 또 while 문을 돌려야된다(남은거)
//합해진건 새로운 배열