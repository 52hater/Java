
package com.ruby.java.ch09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//login 웹으로 개발시 필수 내용
//446~447p

public class Test18 {

	public static void main(String[] args) {

		String firstName = "Oh";
		String lastName = "Jung-Im";
		String tel = "010-1234-5678";
		String email = "purum@ruby.com";
		String email2 = "Hong.Bong.Hee@ruby.com";
		boolean firstName_check = Pattern.matches("[A-Z][a-zA-Z]*", firstName);//패턴이라는 자바의 클래스
		//보고 해석할 줄 알면 됨
		//이메일 주소나 암호등 
		//매치라는 항목을 통해서 맞느냐 안맞느냐 체크
		//챗봇사용하면 쉽겠지
		boolean lastName_check = Pattern.matches("[a-zA-Z]+(['-][a-zA-Z]+)*", lastName);
		System.out.println("first Name :" + firstName_check);
		System.out.println("Last Name :" + lastName_check);
		
		String tel_pat = "01[0-9]-\\d{3,4}-\\d{4}";
		String email_pat = "\\w+@\\w+\\.\\w+(\\.\\w+)?";

		boolean tel_check = Pattern.matches(tel_pat, tel);
		boolean email_check = Pattern.matches(email_pat, email);
		boolean email2_check = Pattern.matches(email_pat, email2);

		System.out.println("tel :" + tel_check);
		System.out.println("email:" + email_check);
		System.out.println("email2:" + email2_check);
		System.out.println(Pattern.matches("\\w", "!"));
		// 암호 코드 추가
        String password = "YourPassword123!"; // 여기에 암호를 입력하세요
        String password2 = "yourpassword123!"; 
        String regex = "^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";
        //이게 암호설정의 조건으로 짱나게 하는 그건데 챗봇이 알아서 짜줄테지만 뭔지는 알아야됨
        //회원가입 그런걸 분명히 할텐데 이런걸 알아놔야함 아니면 이메일형식 그런거

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password2);

        if(matcher.matches()) {//매치라는 함수가 T or F 해주는거지
            System.out.println("암호가 유효합니다.");
        } else {
            System.out.println("암호가 유효하지 않습니다. 암호는 대문자 1개 이상, 특수문자 2개 이상, 숫자 1개 이상, 문자 1개 이상을 포함해야 합니다.");
        }
	}
}