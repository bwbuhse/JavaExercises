package misc.euler;

public class Problem6 {
	public static void main(String[] args) {
		int sumOfSquares = 0;
		int squareOfSums = (int) Math.pow((100) * (101) / 2, 2);
		for (int i = 1; i <= 100; i++)
			sumOfSquares += Math.pow(i, 2);
		System.out.println(squareOfSums - sumOfSquares);

	}
}
