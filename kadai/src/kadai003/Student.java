package kadai003;

public class Student extends Person {
	static String clazz;

	public Student(String name, int age, String address, String clazz) {
		super(name, age, address);

	}

	public void print() {
		System.out.println("クラス:" + clazz);
	}

}
