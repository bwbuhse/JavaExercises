package misc.euler;

import java.util.Arrays;

public class Problem7 {
	public static void main(String[] args) {
		int length = 100000000;
		boolean[] nums = new boolean[length];
		Arrays.fill(nums, true);

		for (int i = 2; i < Math.sqrt(length); i++) {
			if (nums[i]) {
				for (int j = i * i; j < length; j += i) {
					nums[j] = false;
				}
			}
		}

		int count = 0;
		int i = 2;
		while (i < length && count < 10001) {
			if (nums[i++])
				count++;
		}
		System.out.println(i);
		System.out.println(count);
	}
}
