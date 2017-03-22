package misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RollercoasterWords {
	public static void main(String[] args) throws IOException {
		System.out.println(
				Files.lines(Paths.get("src/enable1.txt"))
						.filter(s -> s.length() > 4)
						.filter(RollercoasterWords::isRollercoaster)
						.count()
		);
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
			} else if (at <= next) {
				return false;
			}
			direction = !direction;
		}
		return true;
	}

}
