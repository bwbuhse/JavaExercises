package misc.euler;

import java.math.BigInteger;

public class Problem15 {
	public static void main(String[] args) {
		System.out.println(factorial(40).divide(factorial(20)));
		System.out.println(factorial(40));
		System.out.println(factorial(20));

		int sum = 0;
		for (int i = 1; i < 40; i++)
			sum += i;

		System.out.println(sum);
	}

	private static BigInteger factorial(int num) {
		BigInteger factorial = BigInteger.valueOf(1);
		while (num > 1)
			factorial = factorial.multiply(BigInteger.valueOf(num--));
		return factorial;
	}
}
