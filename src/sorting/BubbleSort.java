package sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] nums = Randomizer.intList();
		System.out.println(Arrays.toString(nums));
		nums = sort(nums);
		System.out.println(Arrays.toString(nums));

		nums = Randomizer.intList(30);
		System.out.println(Arrays.toString(nums));
		nums = sort(nums);
		System.out.println(Arrays.toString(nums));

		nums = Randomizer.intList(10, 10, 20);
		System.out.println(Arrays.toString(nums));
		nums = sort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static int[] sort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums;
	}
}
