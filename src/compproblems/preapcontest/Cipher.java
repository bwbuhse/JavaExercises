package compproblems.preapcontest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cipher {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("cipher.txt"));
		int sets = file.nextInt();
		int num = file.nextInt();
		file.nextLine();

		for (int s = 0; s < sets; s++) {
			char[] line = file.nextLine().toCharArray();
			for (int i = 0; i < line.length; i++) {
				line[i] -= num;
			}
			System.out.println(line);
		}
	}
}
