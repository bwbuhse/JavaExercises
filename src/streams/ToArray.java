package streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ToArray {
	public static void main(String[] args) {
		int[] nums = Stream.of("55.66.77.88".split("\\."))
				.mapToInt(Integer::parseInt)
				.toArray();

		System.out.println(Arrays.toString(nums));

		double sum = 0;
		for (int i = 0; i < nums.length - 1; i++)
			sum += Double.parseDouble(nums[i] + "." + nums[i + 1]);

		System.out.printf("%.5f%n", sum);

		sum = IntStream.of(nums).sum();

		System.out.printf("%.5f%n", sum);

	}
}
