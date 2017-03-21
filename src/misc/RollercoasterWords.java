package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class RollercoasterWords {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/enable1.txt"));

		HashSet<String> dictionary = new HashSet<>();
		while (file.hasNext()) {
			dictionary.add(file.nextLine());
		}

		System.out.println(
				dictionary.stream()
						.filter(s -> s.length() > 4)
						.filter(RollercoasterWords::isRollercoaster)
						.count()
		);

	}

	private static boolean isRollercoaster(String word) {
		word = word.toLowerCase();
		boolean direction;
		if (word.charAt(0) < word.charAt(1))
			direction = false;
		else if (word.charAt(0) > word.charAt(1))
			direction = true;
		else
			return false;

		for (int i = 1; i < word.length() - 1; i++) {
			char at = word.charAt(i);
			char next = word.charAt(i + 1);
			if (direction) {
				if (at >= next)
					return false;
			} else {
				if (at <= next)
					return false;
			}
			direction = !direction;
		}
		return true;
	}

}
