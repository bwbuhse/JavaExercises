package misc.euler;

public class Problem15 {
	public static void main(String[] args) {
		long sum = 0;
		long num = 0;
		for (long i = 1; i < 400; i++) {
			num += i;
			sum += num;
		}
		System.out.println(sum);
	}
}
