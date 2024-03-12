package DataStructure.Ch02.Homeworks;

import java.util.Arrays;

//서로의 문자열 길이의 차이값을 리턴 //ex)String str = "abcd"/str.compareTo("ab") = 2
//근데 String str = "abcd"/str.compareTo("c") = 3이 아니라 -2임 왜일까?
//comparTo는 같은 위치의 문자만 비교하기 때문에, 첫번째 문자부터 순서대로 비교해서 다를 경우 바로 아스키값을 기준으로 비교처리를 한다
/*비교가 불가능한 지점의 각 문자열의 아스키값을 기준으로 비교를 해준다. 
 * "abcd" 와 "c" 를 비교해줄 경우 첫번째 위치에서 비교가 실패했기 때문에,
"a" 와 "c"의 아스키코드 값의 차이값을 리턴해준다.
이둘의 아스키코드의 차이값은 a = 97 / c = 99 이기 때문에 순서에 따라 -2값이 리턴되는것*/

/*str.compareTo("zefd") 이것의 값은 -25가 나오는데 그 이유는
 * a = 97 / z = 122 이기 때문에 차이값인 -25가 반환되며
 * str.compareTo("ABCD") 이것과 같은 경우는 compareTo의 경우
 * 대소문자를 구분하기 때문에 a = 97 / A = 65 이므로 차이값인 32가 반환되는 것이다.
 * 여기서 대소문자를 무시하고 비교해주는 함수 compareToIgnorecase() 가 존재한다.
 */

public class Test_실습2_14스트링배열정렬 {
   public static void main(String[] args) {
      String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};

      showData("정렬전", data);//정렬 전 데이터출력
      sortData(data);//데이터정렬
      showData("정렬후", data);//정렬 후 데이터출력
   }
   
   static void showData(String message, String[] arr) {
	   System.out.println(message + ":: ");
      for(String name : arr) 
    	  System.out.print(name + " ");//각원소 가져오는거지
      System.out.println();
   }


   static void swap(String[]arr, int ind1, int ind2) {
      String swapArr = arr[ind1]; arr[ind1] = arr[ind2]; arr[ind2] = swapArr;
   }
   
   static void sortData2(String []arr) {
	   Arrays.sort(arr);
	   System.out.println(arr);
   }

   static void sortData(String []arr) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = i + 1; j < arr.length; j++) {
            if (arr[i].compareTo(arr[j]) > 0) //스트링에 compareTo()메소드를 사용하는 것을 자가공부해서 해봐라
               //아스키코드 비교해서 arr[i]가 arr[j]보다 앞이면 스왑(if 문 참)
               //예를들어 "abhg".compareTo("h"); // -7 일때
               //a = 97 / h = 104 이기 때문에 차이값은 -7
               //"abcd".compareTo("abfd"); // -3
               //비교가 불가능한 시점을 찾아줘야 하는데, 여기서 비교가 불가능한 시점이 어디일까?
               //ab는 서로 동일하기에 c와 f의 비교에서 비교가 불가능하다.
               //그렇기 때문에 c = 99 / f =102 이기 때문에 차이값은 -3, 즉 c 가 앞
               
               swap(arr, i, j); //정수일때 스왑을 불렀어 //여튼 스트링버전으로 해봐
         }
      }
   }
}