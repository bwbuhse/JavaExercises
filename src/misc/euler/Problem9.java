package misc.euler;

public class Problem9 {
	public static void main(String[] args) {
		int sum = 1000;
		for (int a = 1; a < sum; a++) {
			for (int b = 1; b < sum; b++) {
				if (a + b < sum && a * a + b * b == (sum - a - b) * (sum - a - b)) {
					System.out.println(a * b * (sum - a - b));
				}
			}
		}
	}
}
