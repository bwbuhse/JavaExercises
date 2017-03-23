package misc.euler;

import java.util.Arrays;

public class Problem10 {
	public static void main(String[] args) {
		int length = 100000000;
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

		long sum = 0;
		for (int i = 1; i < 2000000; i++) {
			if (nums[i])
				sum += i;
		}
		System.out.println(sum);
	}
}
