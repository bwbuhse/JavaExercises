package compproblems.utdspring2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class B {
	public static void main(String[] args) throws FileNotFoundException {

		System.out.println(Integer.parseInt("K", 21));

		Scanner file = new Scanner(new File("src/compproblems/utdspring2017/b.txt"));
		int sets = file.nextInt();
		file.nextLine();
		for (int s = 0; s < sets; s++) {
			String[] line = file.nextLine().split(" radix ");
			int radix = Integer.parseInt(line[1]);
			int[] nums = Stream.of(line[0].split("[+*\\-\\\\]")).mapToInt(n -> Integer.parseInt(n, radix)).toArray();
			System.out.println(Arrays.toString(nums));
		}
	}
}
