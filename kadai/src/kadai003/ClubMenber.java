package kadai003;

public class ClubMenber extends Student {
	String club;

	public ClubMenber(String name, int age, String address, String clazz,String club) {
		super(name, age, address, clazz);
	}

	@Override
	public void print() {
		System.out.println("部活動:" + club);
	}


}
