package misc.euler;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Problem20 {
	public static void main(String[] args) {
		BigInteger fact = BigInteger.valueOf(1);
		for (int i = 1; i <= 100; i++)
			fact = fact.multiply(BigInteger.valueOf(i));
		System.out.println(
				Stream.of(fact.toString().split(""))
						.mapToInt(Integer::parseInt)
						.sum()
		);
	}
}
