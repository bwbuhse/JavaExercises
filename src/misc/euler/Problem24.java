package misc.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem24 {
	private static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		permute(IntStream.range(0, 10).toArray());

		System.out.println(list.stream()
				.filter(s -> s.length() == new HashSet<>(Arrays.asList(s.split(""))).size())
				.collect(Collectors.toList())
				.get(1000000));
	}

	private static void permute(int[] nums) {
		list.add(Stream.of(nums).map(s -> s + "").reduce("", (p1, p2) -> p1 + p2));

		int k = -1;
		int i = -1;
		for (int j = 0; j < nums.length - 1; j++)
			if (nums[j] < nums[j + 1])
				k = j;

		for (int j = k; j < nums.length; j++)
			if (nums[k] < nums[j])
				i = j;

		int temp = nums[i];
		nums[i] = nums[k];
		nums[k] = temp;

		//TODO add reverser thing
	}
}
