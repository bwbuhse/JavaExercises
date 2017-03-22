package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class RollercoasterWords {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/enable1.txt"));

		HashSet<String> words = new HashSet<>();
		while (file.hasNext()) {
			String word = file.nextLine();
			if (word.length() > 4 && isRollercoaster(word))
				words.add(word);
		}
		System.out.println(words.size());

	}

	private static boolean isRollercoaster(String word) {
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
