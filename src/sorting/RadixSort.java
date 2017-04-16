package sorting;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] nums = Randomizer.intList();
		System.out.println(Arrays.toString(nums));
		nums = sort(nums);
		System.out.println(Arrays.toString(nums));

		nums = Randomizer.intList(100);
		System.out.println(Arrays.toString(nums));
		nums = sort(nums);
		System.out.println(Arrays.toString(nums));

		nums = Randomizer.intList(100000, 0, 1000);
		System.out.println(Arrays.toString(nums));
		nums = sort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static int[] sort(int[] nums) {
		int length = 0;
		for (int num : nums)
			length = (Integer.toString(num).length() > length) ? Integer.toString(num).length() : length;

		for (int i = 0, digit = 1; i < length; i++, digit *= 10) {
			int[] counts = new int[10];
			int[] list = new int[nums.length];
			for (int num : nums)
				counts[Math.abs(num / digit % 10)]++;
			for (int j = 1; j < counts.length; j++)
				counts[j] += counts[j - 1];
			for (int j = nums.length - 1; j >= 0; j--)
				list[--counts[Math.abs(nums[j] / digit % 10)]] = nums[j];
			nums = list;
		}
		return nums;
	}
}
