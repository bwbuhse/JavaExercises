package misc.euler;

public class Problem4 {
	public static void main(String[] args) {
		for (int i = 998001; i > 1; i--) {
			if (isPalin(i) && factor(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean isPalin(int num) {
		String str = Integer.toString(num);
		String first = str.substring(0, str.length() / 2);
		String last = new StringBuilder(str.substring(str.length() / 2)).reverse().toString();
		return first.equals(last);
	}

	private static boolean factor(int num) {
		for (int i = 100; i < 1000; i++) {
			if (num % i == 0 && Integer.toString(num / i).length() == 3) {
				return true;
			}
		}
		return false;
	}
}
