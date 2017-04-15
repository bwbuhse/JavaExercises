package sorting;

class Randomizer {
	static int[] intList() {
		return intList(10);
	}

	static int[] intList(int n) {
		return intList(n, 1, 50);
	}

	static int[] intList(int n, int min, int max) {
		int[] list = new int[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * (max - min)) + min;
		}
		return list;
	}
}
