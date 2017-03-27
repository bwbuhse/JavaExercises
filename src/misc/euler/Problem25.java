package misc.euler;

import java.math.BigInteger;

public class Problem25 {
	public static void main(String[] args) {
		BigInteger fib = new BigInteger("2");
		BigInteger previous = new BigInteger("1");
		BigInteger index = new BigInteger("3");

		while (fib.toString().length() < 1000) {
			BigInteger temp = new BigInteger(fib.toString());
			fib = fib.add(previous);
			previous = temp;
			index = index.add(BigInteger.ONE);
		}

		System.out.println(index);
	}
}
