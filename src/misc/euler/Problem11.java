package misc.euler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Problem11 {
	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/misc/euler/problem11.dat"));
		int R = 20, C = 20;
		int[][] arr = new int[R][];
		for (int r = 0; r < R; r++)
			arr[r] = Stream.of(file.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();

		int max = Integer.MIN_VALUE;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (r < R - 4) {
					max = Math.max(max, arr[r][c] * arr[r + 1][c] * arr[r + 2][c] * arr[r + 3][c]);
				}
				if (c < C - 4) {
					max = Math.max(max, arr[r][c] * arr[r][c + 1] * arr[r][c + 2] * arr[r][c + 3]);
					if (r > 3) {
						max = Math.max(max, arr[r][c] * arr[r - 1][c + 1] * arr[r - 2][c + 2] * arr[r - 3][c + 3]);
					}
					if (r < R - 4) {
						max = Math.max(max, arr[r][c] * arr[r + 1][c + 1] * arr[r + 2][c + 2] * arr[r + 3][c + 3]);
					}
				}
			}
		}

		System.out.println(max);
	}
}
