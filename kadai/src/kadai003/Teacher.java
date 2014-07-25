package kadai003;

public class Teacher extends Person {
	String depertment;

	public Teacher(String name, int age, String address,String depertment) {
		super(name, age, address);
	}

	public void print() {
		System.out.println("学科:" + depertment);
	}





}
