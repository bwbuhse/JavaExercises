package misc.euler;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Problem13 {
	public static void main(String[] args) throws IOException {
		System.out.println(
				Files.lines(Paths.get("src/misc/euler/problem13.dat"))
						.map(BigInteger::new)
						.reduce(BigInteger.ZERO, BigInteger::add)
		);
	}
}
