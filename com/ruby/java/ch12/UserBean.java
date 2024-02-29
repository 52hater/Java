package com.ruby.java.ch12;

import java.io.Serializable;

public class UserBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String tel;
	private String address;
	
	//컨트롤스페이스 치면 생성자생성 나옴
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	
	//컨트롤알트s 필드로 생성자
	public UserBean(String id, String name, String tel, String address) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	//컨트롤알트s 게터세터 올셀렉트
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	//컨트롤알트s 투스트링
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", tel=" + tel + ", address=" + address + "]";
	}
	
	

}
