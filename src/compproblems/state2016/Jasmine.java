package compproblems.state2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Jasmine {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/state2016/jasmine.dat"));

		while (file.hasNext()) {
			List<String> list = new ArrayList<>();
			String name = file.nextLine();
			int i = name.length() / 3;

			list.add(name.substring(0, i));
			list.add(name.substring(i, 2 * i));
			list.add(name.substring(2 * i));
			list.forEach(s -> System.out.print(s + " "));
			System.out.print("==> ");

			if (list.get(0).length() < list.get(2).length()) {
				list.set(0, new StringBuilder(list.get(0).toLowerCase()).reverse().toString());
				list.set(1, Stream.of(list.get(1).toUpperCase().split(""))
						.sorted(String::compareTo)
						.reduce("", String::concat));
				list.set(2, list.get(2).toUpperCase());
				System.out.println(list.get(2) + list.get(0) + list.get(1));
			} else {
				list.set(0, list.get(0).toUpperCase());
				list.set(1, new StringBuilder(list.get(1).toLowerCase()).reverse().toString());
				list.set(2, new StringBuilder(list.get(2).toLowerCase()).reverse().toString());
				System.out.println(list.get(0) + list.get(1) + list.get(2));
			}

		}
	}
}
