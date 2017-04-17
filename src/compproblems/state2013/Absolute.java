package compproblems.state2013;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Absolute {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("src/compproblems/state2013/absolute.dat"))
				.filter(s -> s.contains(" "))
				.map(s -> s.split(" "))
				.map(s -> Stream.of(s).mapToInt(Integer::parseInt).toArray())
				.map(ints -> function(ints, 0))
				.forEach(out -> System.out.println(out[1] + " " + out[0]));
	}

	private static int[] function(int[] nums, int count) {
		Set<Integer> uniques = new HashSet<>();
		for (int num : nums)
			uniques.add(num);
		if (uniques.size() == 1)
			return new int[]{nums[0], count};
		int[] altered = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1) {
				altered[i] = Math.abs(nums[i] - nums[0]);
			} else {
				altered[i] = Math.abs(nums[i] - nums[i + 1]);
			}
		}
		return function(altered, ++count);
	}
}
