package misc.euler;

public class Problem14 {
	public static void main(String[] args) {
		long max = 1;
		long length = 1;
		for (long i = 1; i < 1000000; i++) {
			long len = collatz(i);
			if (len > length) {
				max = i;
				length = len;
			}
		}
		System.out.println(max);
		System.out.println(collatz(13));
	}

	private static long collatz(long num) {
		long length = 1;
		while (num > 1) {
			if ((num & 1) == 0)
				num /= 2;
			else
				num = num * 3 + 1;
			length++;
		}
		return length;
	}
}
