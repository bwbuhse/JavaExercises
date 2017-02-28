package compproblems.state2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dara {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/state2016/dara.dat"));

		while (file.hasNext()) {
			String function = file.nextLine();
			String first = derive(function);
			String second = derive(first);

			System.out.printf("%s : %s%n", first, second);
		}
	}

	private static String derive(String function) {
		String derivative = "";

		String[] terms = function.split(" ");

		for (String term : terms) {
			if (term.matches("[+-]")) {
				derivative += term;
			} else if (!(term.contains("X"))) {
				if (derivative.contains(" ")) {
					derivative = derivative.substring(0, derivative.lastIndexOf(" "));
					derivative = derivative.substring(0, derivative.lastIndexOf(" "));
				}
			} else if (!(term.contains("^"))) {
				if (term.equals("X"))
					derivative += "1";
				else
					derivative += term.substring(0, term.indexOf("X"));
			} else {
				int n = Integer.parseInt(term.substring(term.indexOf("^") + 1));
				if (term.charAt(0) == 'X')
					derivative += n + "X";
				else
					derivative += n * Integer.parseInt(term.substring(0, term.indexOf("X"))) + "X";
				if (n > 2)
					derivative += "^" + (n - 1);
			}
			derivative += " ";
		}

		return derivative.trim().length() == 0 ? "0" : derivative.trim();
	}
}
