package sorting;

public class Runner {
	public static void main(String[] args) {
		long time;
		int[] list = Randomizer.intList(10000000, 1, 10);
		time = System.currentTimeMillis();
		MergeSort.sort(list);
		System.out.println(System.currentTimeMillis() - time);
		time = System.currentTimeMillis();
		RadixSort.sort(list);
		System.out.println(System.currentTimeMillis() - time);
	}
}
