package misc.euler;

import java.util.Arrays;
import java.util.HashSet;

public class Problem35 {
	public static void main(String[] args) {
		int length = 1000000;
		boolean[] nums = new boolean[length];
		Arrays.fill(nums, true);
		nums[0] = false;
		nums[1] = false;
		for (int i = 2; i * i < length; i++) {
			if (nums[i]) {
				for (int j = 2; j * i < length; j++) {
					nums[j * i] = false;
				}
			}
		}

		HashSet<Integer> checked = new HashSet<>();
		HashSet<Integer> primes = new HashSet<>();
		for (int i = 2; i < nums.length; i++) {
			if (checked.contains(i))
				continue;
			int num = i;
			int len = (num + "").length();
			boolean cyclicalPrime = true;
			HashSet<Integer> tempPrimes = new HashSet<>();
			for (int j = 0; j < len; j++) {
				checked.add(num);
				if (!nums[num])
					cyclicalPrime = false;
				else
					tempPrimes.add(num);
				num = rotate(num);
			}
			if (cyclicalPrime)
				primes.addAll(tempPrimes);
		}
		System.out.println(primes.size());
	}

	private static int rotate(int num) {
		String[] digits = (num + "").split("");
		for (int i = digits.length - 1; i > 0; i--) {
			String temp = digits[i];
			digits[i] = digits[i - 1];
			digits[i - 1] = temp;
		}
		String out = "";
		for (String digit : digits) {
			out += digit;
		}
		return Integer.parseInt(out);
	}
}
