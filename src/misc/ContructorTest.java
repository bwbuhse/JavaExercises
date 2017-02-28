package misc;

public class ContructorTest {

}

class Thing {
	String name;
	int age;

	public Thing(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s%d", name, age);
	}
}
