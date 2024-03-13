package DataStructure.Ch03; //껍데기 다 지운걸로 연습 및 숙달

//comparator 구현 실습
/*
 * 교재 121 실습 3-6 
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;

public class train_실습3_6_0스트링배열정렬이진탐색 {

		//sortData를 하기위한 swap 메소드 > swap 메소드 없이는 어떻게 sortData? : 찾아서 공부
   static void swap(String[]arr, int ind1, int ind2) {
      String swapArr = arr[ind1];
      arr[ind1] = arr[ind2];
      arr[ind2] = swapArr;
   }

   static void sortData(String[] arr) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = i + 1; j < arr.length; j++) {
            if (arr[i].compareTo(arr[j]) > 0)
               swap(arr, i, j);
         }
      }

   }

   static void showData(String msg, String[] arr) {
      System.out.println(msg + " :: ");
      for (String elem : arr) {
         System.out.print(elem + " ");
      }
      System.out.println();
   }

   static void reverse(String[] arr) {//교재 67페이지 //치환문
      for (int i = 0; i < arr.length / 2; i++) {//i 참조변수, reverse_arr : 참조변수의 주소를 갖고있따
         String reverse_arr = arr[i];//변수선언,  i 의 주소를 가짐
         arr[i] = arr[arr.length - i - 1];
         arr[arr.length - i - 1] = reverse_arr;
      }

   }

   static int linearSearch(String[] arr, String key) {
      for(int i = 0; i < arr.length; i++) {
         if (arr[i].equals(key))
            return i;
      }
      return -1;
   }

   static int binarySearch(String[] arr, String key) {
      int pl = 0;
      int pr = arr.length - 1; //0부터 시작하니까

      while (pl <= pr) {
         int pc = (pl + pr) / 2;
         int compare = arr[pc].compareTo(key);

         if (compare == 0) { //검색성공하면
            return pc;//중간인덱스 리턴
         } else if (compare < 0) {
            pl = pc + 1;//중간인덱스보다 크면 오른쪽부분 검색
         } else {
            pr = pc - 1;//중간인덱스보다 작으면 왼쪽부분 검색
         }
      }
      return -1;//없으면 -1 리턴
   }


   public static void main(String[] args) {
	  //주어진 데이터
      String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};//홍봉희 재배 과수
      //정렬 전 데이터 출력
      showData("정렬전", data);
      //데이터 정렬
      System.out.println();
      
      //정렬 후 데이터 출력
      sortData(data);
      showData("정렬후", data);
      System.out.println();
       
      //데이터 리버스
      reverse(data);//역순으로 재배치
      showData("역순 재배치후", data);
      System.out.println();

      //
      Arrays.sort(data);//Arrays.sort(Object[] a);
      showData("Arrays.sort()로 정렬후",data);

      String key = "포도";
      int resultIndex = linearSearch(data, key);//구현
      System.out.println("\nlinearSearch(포도): result = " + resultIndex);

      key = "배";
      /*
       * 교재 109~113
       */
      resultIndex = binarySearch(data, key);//만들어야지
      System.out.println("\nbinarySearch(배): result = " + resultIndex);
      key = "산딸기";
      /*
       * 교재 115 Arrays.binarySearch에 의한 검색
       */
      resultIndex = Arrays.binarySearch(data, key);//갖다쓰는거 키값을주면 찾는//훈련이니까 책에 코드보고 스트링버전으로 만드는걸 연습(컴페어투써서)
      System.out.println("\nArrays.binarySearch(산딸기): result = " + resultIndex);

   }

}
