package misc.euler;

public class Problem12 {

	public static void main(String[] args) {
		int sum = 1;
		int i = 2;
		while (numFactors(sum) <= 500) {
			sum += i++;
		}
		System.out.println(sum);
	}

	static int numFactors(int num) {
		int factors = 1;
		for (int i = 2; i < Math.sqrt(num); i++)
			if (num % i == 0)
				factors += 2;
		return factors;
	}
}
