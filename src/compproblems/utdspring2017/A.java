package compproblems.utdspring2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class A {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/utdspring2017/a.txt"));
		String line;
		int game = 1;
		while (!(line = file.nextLine()).equals("End of games")) {
			int joe = 0;
			int jane = 0;
			boolean over = false;
			while (!(line = file.nextLine()).equals("End of game")) {
				if (over)
					continue;
				int num = Stream.of(line.split(": ")[1].split(" ")).mapToInt(Integer::parseInt).sum();
				if (line.split(": ")[0].equals("Joe"))
					joe += num;
				else
					jane += num;
				if (jane >= 301) {
					System.out.printf("Game %d: Jane has won.%n", game++);
					over = true;
				} else if (joe >= 301) {
					System.out.printf("Game %d: Joe has won.%n", game++);
					over = true;
				}
			}
			if (joe < 301 && jane < 301) {
				System.out.printf("Game %d: Game ended too son. No one has won.%n", game++);
			}
		}
	}
}
