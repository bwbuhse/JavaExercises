package compproblems.state2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Emiliano {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/state2016/emiliano.dat"));

		int sets = file.nextInt();
		for (int s = 0; s < sets; s++) {
			Set<String> dictionary = new HashSet<>();
			int dLen = file.nextInt();
			file.nextLine();
			for (int i = 0; i < dLen; i++)
				dictionary.add(file.nextLine().toLowerCase());

			int compounds = 0;
			int words = file.nextInt();
			file.nextLine();
			for (int n = 0; n < words; n++) {
				String word = file.nextLine().toLowerCase();

				for (int x = 1; x < word.length(); x++) {
					if (dictionary.contains(word.substring(0, x))) {
						if (dictionary.contains(word.substring(x)))
							compounds++;
					}
				}
			}

			System.out.println(compounds);

		}

	}

}
