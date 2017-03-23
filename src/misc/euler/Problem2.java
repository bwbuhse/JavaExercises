package misc.euler;

public class Problem2 {
	public static void main(String[] args) {
		int max = 4000000;
		int sum = 0;
		for (int x = 1, y = 2, t; y < max; t = y, y += x, x = t) {
			if ((y & 1) == 0)
				sum += y;
		}
		System.out.println(sum);

	}
}
