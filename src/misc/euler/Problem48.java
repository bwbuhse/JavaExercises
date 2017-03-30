package misc.euler;

import java.math.BigInteger;

public class Problem48 {
	public static void main(String[] args) {
		BigInteger num = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;
		for (int i = 2; i < 1001; i++) {
			sum = sum.add(num);
			num = BigInteger.valueOf((long) i).pow(i);
		}
		System.out.println(sum);
	}
}
