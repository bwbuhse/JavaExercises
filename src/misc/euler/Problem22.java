package misc.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Problem22 {
	public static void main(String[] args) throws FileNotFoundException {
		String[] names = new Scanner(new File("src/misc/euler/problem22.txt")).nextLine().split("[\",]+");
		Arrays.sort(names);
		BigInteger sum = BigInteger.ZERO;

		for (int i = 0; i < names.length; i++) {
			sum = sum.add(BigInteger.valueOf((long) names[i].chars().map(s -> s - 64).sum() * i));
		}
		System.out.println(sum);
	}
}
