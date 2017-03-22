package misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RollercoasterWords {
	public static void main(String[] args) throws IOException {
		System.out.println(
				Files.lines(Paths.get("src/enable1.txt"))
						.filter(s -> s.length() > 4)
						.filter(s -> {
							boolean direction;
							if (s.charAt(0) < s.charAt(1))
								direction = false;
							else if (s.charAt(0) > s.charAt(1))
								direction = true;
							else
								return false;

							for (int i = 1; i < s.length() - 1; i++) {
								char at = s.charAt(i);
								char next = s.charAt(i + 1);
								if (direction && at >= next)
									return false;
								else if (!direction && at <= next)
									return false;
								direction = !direction;
							}
							return true;
						})
						.count()
		);
	}
}
