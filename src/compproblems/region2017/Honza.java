package compproblems.region2017;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class Honza {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("src/compproblems/region2017/honza.dat")).forEach(s -> {
			if (s.length() == 0 || !s.contains(" "))
				return;
			int[] nums = Stream.of(s.split("[/ :]")).mapToInt(Integer::parseInt).toArray();
			LocalDateTime time = LocalDateTime.of(nums[2], nums[0], nums[1], nums[3], nums[4]).plusMinutes(nums[5] - 5);
			System.out.printf("%s %d/%d/%d %02d:%02d%n", time.getDayOfWeek(), time.getMonthValue()
					, time.getDayOfMonth(), time.getYear(), time.getHour(), time.getMinute());
		});
	}
}
