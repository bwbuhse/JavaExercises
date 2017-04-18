package compproblems.state2013;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Diamonds {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/compproblems/state2013/diamonds.dat"));
		int sets = file.nextInt();
		for (int s = 0; s < sets; s++) {
			Random rng = new Random(file.nextLong());
			boolean[] diamonds = new boolean[13];
			boolean turn = true;
			int a = 0, b = 0;
			while (!isEmpty(diamonds)) {
				boolean coinFlip = rng.nextBoolean();
				int diamond = 0;
				if (coinFlip) {
					for (int i = diamonds.length - 1; i >= 0; i--) {
						if (!diamonds[i]) {
							diamond = 15 + i * 5;
							diamonds[i] = true;
							break;
						}
					}
				} else {
					for (int i = 0; i < diamonds.length; i++) {
						if (!diamonds[i]) {
							diamond = 15 + i * 5;
							diamonds[i] = true;
							break;
						}
					}
				}
				if (turn)
					a += diamond;
				else
					b += diamond;
				turn = !turn;
			}
			if (a == b)
				System.out.println("TIE");
			else if (a > b)
				System.out.println("PLAYER A WON");
			else
				System.out.println("PLAYER B WON");
		}
	}

	static boolean isEmpty(boolean[] a) {
		for (boolean bool : a) {
			if (!bool) {
				return false;
			}
		}
		return true;
	}
}
