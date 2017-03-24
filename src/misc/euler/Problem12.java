package misc.euler;

public class Problem12 {
	static int[] nums = new int[40000000];

	public static void main(String[] args) {
		for (int i = 1; i < nums.length; i++) {
			for (int j = 1; j * i < nums.length; j++) {
				nums[j * i]++;
			}
		}
		int max = 0;
		for (int n : nums) {
			max = Math.max(max, n);
		}
		System.out.println(max);
		for (int i = 1, sum = 1; i < nums.length; i++, sum += i) {
			System.out.println(sum);
			if (nums[sum] > 500 || nums[i / 2] * 2 > 500) {
				System.out.println("\n" + sum);
			}
		}
	}
}
