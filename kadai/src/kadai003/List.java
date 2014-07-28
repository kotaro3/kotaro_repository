package kadai003;

import java.util.ArrayList;

public class List {

	static ArrayList<Person> persons = new ArrayList<>();

	public static void main(String[] args) {
		persons.add(new Person("船橋 太郎", 20, "千葉県船橋市"));
		persons.add(new Student("船橋 花子", 21, "千葉県千葉市中央区", "3G1"));
		persons.add(new Teacher("朝賀 先生", 99, "千葉県xxx市", "ネットワーク科"));
		persons.add(new ClubMenber("松元 ぶちょー", 20, "ワシントンD.C.", "2G1", "技術部"));

		for (Person person : persons) {
			person.print();
			System.out.println();
		}

	}
}
