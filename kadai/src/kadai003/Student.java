package kadai003;

public class Student extends Person {
	String clazz;

	public Student(String name, int age, String address, String clazz) {
		super(name, age, address);
		this.clazz = clazz;

	}

	@Override
	void print() {
		super.print();
		System.out.println("クラス:" + clazz);
	}

}
