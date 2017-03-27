package misc.euler;

import java.util.HashMap;

public class Problem17 {

	private static HashMap<Integer, String> words = new HashMap<>();

	public static void main(String[] args) {
		words.put(1, "one");
		words.put(2, "two");
		words.put(3, "three");
		words.put(4, "four");
		words.put(5, "five");
		words.put(6, "six");
		words.put(7, "seven");
		words.put(8, "eight");
		words.put(9, "nine");
		words.put(10, "ten");
		words.put(20, "twenty");
		words.put(30, "thirty");
		words.put(40, "forty");
		words.put(50, "fifty");
		words.put(60, "sixty");
		words.put(70, "seventy");
		words.put(80, "eighty");
		words.put(90, "ninety");
		words.put(100, "hundred");
		words.put(1000, "thousand");

		int length = 0;
		for (int i = 1; i <= 1000; i++) {
			int l = length(i);
			length += l;
			System.out.println(l);
		}
		System.out.println(length);
	}

	private static int length(int num) {
		int length = 0;
		if (num > 1000) {
			length += words.get(num / 1000).length() + words.get(1000).length();
			num %= 1000;
		}
		if (num > 100) {
			length += words.get(num / 100).length() + words.get(100).length();
			num %= 100;
			if (num > 0)
				length += "and".length();
		}
		if (num > 10) {
			length += words.get(num / 10 * 10).length();
			num %= 10;
		}
		if (num > 0) {
			length += words.get(num).length();
		}
		return length;
	}
}
