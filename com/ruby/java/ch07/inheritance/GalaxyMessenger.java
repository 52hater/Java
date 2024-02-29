package com.ruby.java.ch07.inheritance;

public class GalaxyMessenger implements Messenger, WorkFile {//메신저랑 워크파일을 다중상속받음

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "galaxy";
	}

	@Override
	public void setMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println("galaxy에서 메시지를 설정합니다 : " + msg);
	}
	
	public void chageKeyboard() {
		System.out.println("키보드 아이콘 터치 후 키보드를 변경합니다.");
	}

	@Override
	public void fileUpload() {
		// TODO Auto-generated method stub
		//이거랑 밑에거가 워크파일까지 다중상속으로 상속받으면서 새로생긴 워크파일 오버라이드
	}

	@Override
	public void fileDownload() {
		// TODO Auto-generated method stub
		
	}

}
