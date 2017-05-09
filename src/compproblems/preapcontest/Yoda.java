package compproblems.preapcontest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Yoda {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("yoda.txt"))
				.map(s -> s.split(" "))
				.filter(arr -> arr.length > 1)
				.forEach(arr -> {
					for (int i = 2; i < arr.length; i++) {
						System.out.print(arr[i] + " ");
					}
					System.out.println(arr[0] + " " + arr[1]);
				});
	}
}
