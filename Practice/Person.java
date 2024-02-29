package Practice;

public class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}



public static void main(String[] args) {
	Person p = new Person();
	p.setName("철수");
	p.setAge(34);

	System.out.println("이름 : " + p.getName());
	System.out.println("나이 : " + p.getAge());
	}
}