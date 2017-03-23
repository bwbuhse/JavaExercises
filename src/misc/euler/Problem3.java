package misc.euler;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
	public static void main(String[] args) {
		long n = 600851475143L;
		List<Long> factors = new ArrayList<>();
		for (long i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		System.out.println(factors.get(factors.size() - 1));
	}
}
