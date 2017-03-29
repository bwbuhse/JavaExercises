package misc.euler;

import java.util.Arrays;

public class Problem15 {
	public static void main(String[] args) {
		long[][] paths = new long[21][21];
		Arrays.fill(paths[0], 1);
		for (int r = 1; r < paths.length; r++)
			paths[r][0] = 1;

		for (int r = 1; r < paths.length; r++) {
			for (int c = 1; c < paths[r].length; c++) {
				paths[r][c] += paths[r - 1][c] + paths[r][c - 1];
			}
		}

		System.out.println(paths[20][20]);
	}
}
