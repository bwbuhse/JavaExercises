package misc.euler;

import java.math.BigInteger;
import java.util.HashSet;

public class Problem29 {
	public static void main(String[] args) {
		HashSet<BigInteger> nums = new HashSet<>();

		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				nums.add(BigInteger.valueOf((long) i).pow(j));
			}
		}

		System.out.println(nums.size());
	}
}
