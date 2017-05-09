package compproblems.preapcontest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Blocks {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("src/compproblems/preapcontest/blocks.txt"))
				.filter(s -> s.split(" ").length > 1)
				.map(String::toUpperCase)
				.map(String::toCharArray)
				.map(s -> {
					int[] arr = new int[26];
					for (char c : s) {
						if (c != ' ') {
							arr[c - 65]++;
						}
					}
					return arr;
				})
				.forEach(arr -> {
					for (int i : arr) {
						System.out.print(i + " ");
					}
					System.out.println();
				});

	}
}
