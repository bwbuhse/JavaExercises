package sorting;

import java.util.Arrays;

public class Mergesort {
	public static void main(String[] args) {
		int[] nums = {11, 4, 8, 15, 5, 10, 12, 1, 17, 18};
		nums = sort(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[25];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 1;
		}
		System.out.println(Arrays.toString(nums));
		nums = sort(nums);
		System.out.println(Arrays.toString(nums));
	}

	private static int[] sort(int[] nums) {
		if (nums.length == 1)
			return nums;

		return merge(sort(Arrays.copyOfRange(nums, 0, nums.length / 2)),
				sort(Arrays.copyOfRange(nums, nums.length / 2, nums.length)));
	}

	private static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i, j, k;
		i = j = k = 0;

		while (i < a.length && j < b.length) {
			if (a[i] < b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		while (i < a.length)
			c[k++] = a[i++];
		while (j < b.length)
			c[k++] = b[j++];

		return c;
	}


}
