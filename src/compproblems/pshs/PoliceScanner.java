package compproblems.pshs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PoliceScanner {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/pshs/policescanner.dat"));

		int sets = file.nextInt();
		file.nextLine();
		PriorityQueue<Hero> queue = new PriorityQueue<>();
		for (int s = 0; s < sets; s++) {
			queue.add(new Hero(file.nextLine().split(" ")));
		}
		for (int i = 0; i < 3; i++)
			System.out.println(queue.poll());

	}

	static class Hero implements Comparable<Hero> {
		String[] line;

		private Hero(String[] line) {
			this.line = line;
		}

		public int compareTo(Hero o) {
			return Integer.parseInt(o.line[2]) - Integer.parseInt(line[2]);
		}

		public String toString() {
			String out = "";
			for (String s : line)
				out += s + " ";
			return out.trim();
		}
	}
}
