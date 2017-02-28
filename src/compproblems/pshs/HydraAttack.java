package compproblems.pshs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HydraAttack {
	private static boolean[][] grid;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/pshs/hydraattack.dat"));

		int sets = file.nextInt();
		for (int s = 0; s < sets; s++) {
			grid = new boolean[file.nextInt()][file.nextInt()];

			int numTanks = file.nextInt();
			for (int i = 0; i < numTanks; i++) {
				int r = file.nextInt();
				int c = file.nextInt();
				grid[r][c] = true;
				setGrid(r, c);
			}

			System.out.println(grid.length * grid[0].length - countTrues());
		}
	}

	private static int countTrues() {
		int count = 0;
		for (boolean[] r : grid)
			for (boolean c : r)
				if (c)
					count++;
		return count;
	}

	private static void setGrid(int r, int c) {
		int rSave = r;
		int cSave = c;

		while (r-- > 0 && c-- > 0) {
			grid[r][c] = true;
		}

		r = rSave;
		c = cSave;

		while (r-- > 0 && c++ < grid[r].length - 1) {
			grid[r][c] = true;
		}

		r = rSave;
		c = cSave;

		while (r++ < grid.length - 1 && c-- > 0) {
			grid[r][c] = true;
		}

		r = rSave;
		c = cSave;

		while (r++ < grid.length - 1 && c++ < grid[r].length - 1) {
			grid[r][c] = true;
		}
	}
}
