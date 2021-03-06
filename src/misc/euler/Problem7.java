package misc.euler;

import java.util.Arrays;

public class Problem7 {
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

		for (int i = 1, count = 0; i < length; i++) {
			if (nums[i])
				count++;
			if (count == 10001) {
				System.out.println(i);
				break;
			}
		}

	}
}
