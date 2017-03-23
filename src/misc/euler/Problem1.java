package misc.euler;

public class Problem1 {
	public static void main(String[] args) {
		int maxNum = 1000;
		int sum = 0;
		for (int i = 1; i < maxNum / 3.0; i++) {
			sum += 3 * i;
		}
		for (int i = 1; i < maxNum / 5.0; i++) {
			sum += 5 * i;
		}
		for (int i = 1; i < maxNum / 15.0; i++) {
			sum -= 15 * i;
		}
		System.out.println(sum);
	}
}
