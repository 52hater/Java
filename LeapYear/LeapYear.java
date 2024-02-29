package LeapYear;

import java.util.Scanner;

/*윤년 검사 (LeapYear)
• 임의의 년도를 입력 받아서 윤년인지를 판단하는 메소드를 구현해 보세요.
• 4로 나누어 떨어지는 해는 윤년, 그 밖의 해는 평년
• 4로 나누어 떨어지더라도 100으로 나누어지고 떨어지면 평년
• 4로 나누어 떨어지더라도 100으로 나누어지고 떨어지지만 400으로 나누어 떨어지면 윤년
 */

public class LeapYear {

   public static boolean isLeapYear(int year) {
      if (year % 4 == 0) {
         return true;
      } if (year % 100 == 0) {
         return false;
      } else if (year % 400 == 0) {
         return true;
      } else {
         return false;
      }
      
   }


   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      System.out.println("연도 입력 : ");
      int year = sc.nextInt();

      boolean leapYear = isLeapYear(year);

      if (leapYear) {
         System.out.println("윤년");
      } else {
         System.out.println("평년");
      }

      sc.close();
   }
}