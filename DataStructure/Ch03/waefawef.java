package DataStructure.Ch03;

import java.util.ArrayList;

public class waefawef {

    // 외부 클래스인 waefawef 안에 Main 클래스를 정의합니다.
    // 주의: Java에서는 Main 클래스가 public이어야만 별도의 파일로 저장될 수 있습니다.
    public static class Main {
        
        // 프로그램의 시작점입니다.
        public static void main(String[] args) {
            // ArrayList 객체를 생성하여 문자열을 저장할 수 있는 동적 배열을 만듭니다.
            ArrayList<String> names = new ArrayList<>();
            
            // ArrayList에 문자열을 추가합니다.
            names.add("Alice");
            names.add("Bob");
            names.add("Charlie");

            // for-each 문을 사용하여 ArrayList의 각 요소에 대해 반복합니다.
            for (String name : names) {
                // 현재 요소를 출력합니다.
                System.out.println(name);
            }
        }
    }
}