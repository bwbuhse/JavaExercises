package compproblems.preapcontest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Volume {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("volume.txt"))
				.map(s -> s.split(" "))
				.map(line -> Stream.of(line).mapToInt(Integer::parseInt).toArray())
				.forEach(arr -> System.out.printf("%dx%dx%d volume = %d%n", arr[0], arr[1],
						arr[2], arr[0] * arr[1] * arr[2]));
	}
}
