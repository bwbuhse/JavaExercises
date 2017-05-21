package compproblems.hackerrank;

import java.util.Scanner;
import java.util.stream.Stream;

public class SimpleArraySum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextLine();
		System.out.println(Stream.of(in.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.sum()
		);
	}
}
