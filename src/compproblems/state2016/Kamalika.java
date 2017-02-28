package compproblems.state2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.TreeMap;

public class Kamalika {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/state2016/kamalika.dat"));

		while (file.hasNext()) {
			TreeMap<BigDecimal, String> ops = new TreeMap<>();

			BigDecimal a = file.nextBigDecimal();
			BigDecimal b = file.nextBigDecimal();

			ops.put(a.subtract(b), "Dif");
			ops.put(a.add(b), "Sum");
			try {
				ops.put(a.divide(b), "Div");
			} catch (Exception e) {
				ops.put(a.divide(b, BigDecimal.ROUND_HALF_UP), "Div");
			}
			ops.put(a.multiply(b), "Prd");
			ops.put(a.remainder(b), "Mod");
			ops.put(BigDecimal.valueOf(Math.pow(a.doubleValue(), b.doubleValue())), "A^B");
			ops.put(BigDecimal.valueOf(Math.pow(b.doubleValue(), a.doubleValue())), "B^A");

			String out = "|";
			for (BigDecimal n : ops.keySet()) {
				out += String.format("%s%6.2f|", ops.get(n), n);
			}

			System.out.println(out);
		}
	}
}
