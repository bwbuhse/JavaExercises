package misc;

import java.util.Arrays;
import java.util.List;

public class AdvancedStreams {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Max", 18),
				new Person("Peter", 23),
				new Person("Pamela", 23),
				new Person("David", 12)
		);

		
	}
}

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}
}
