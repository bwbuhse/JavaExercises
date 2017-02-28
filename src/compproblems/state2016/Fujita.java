package compproblems.state2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fujita {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/state2016/fujita.dat"));

		while (file.hasNext()) {
			double num = Math.log10(file.nextDouble()) / Math.log10(file.nextDouble());

			for (int i = 0; i < num; i++)
				System.out.print("*");
			System.out.println();
		}
	}
}