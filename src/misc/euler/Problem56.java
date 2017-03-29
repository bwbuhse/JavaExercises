package misc.euler;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Problem56 {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				max = Math.max(max,
						Stream.of(BigInteger.valueOf((long) i).pow(j).toString().split(""))
								.mapToInt(Integer::parseInt)
								.sum()
				);
			}
		}
		System.out.println(max);
	}
}
