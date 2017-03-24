package misc.euler;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Problem16 {
	public static void main(String[] args) {
		System.out.println(
				Stream.of(new BigInteger("2").pow(10000).toString().split(""))
						.mapToInt(Integer::parseInt)
						.sum()
		);
	}
}
