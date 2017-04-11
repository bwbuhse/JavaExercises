package compproblems.region2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.stream.Stream;

public class Honza {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/region2017/honza.dat"));
		int sets = file.nextInt();
		file.nextLine();
		for (int s = 0; s < sets; s++) {
			int[] nums = Stream.of(file.nextLine().split("[/ :]")).mapToInt(Integer::parseInt).toArray();
			LocalDateTime time = LocalDateTime.of(nums[2], nums[0], nums[1], nums[3], nums[4]).plusMinutes(nums[5] - 5);
			System.out.printf("%s %d/%d/%d %02d:%02d%n", time.getDayOfWeek(), time.getMonthValue()
					, time.getDayOfMonth(), time.getYear(), time.getHour(), time.getMinute());
		}
	}
}
