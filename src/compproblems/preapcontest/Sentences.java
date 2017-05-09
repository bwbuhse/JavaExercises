package compproblems.preapcontest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Sentences {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("src/compproblems/preapcontest/sentences.txt"))
				.map(line -> Stream.of(line.split("\\.")))
				.forEach(line -> line.forEach(sen -> System.out.println(sen + ".")));
	}
}
