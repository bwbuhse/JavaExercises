package sorting;

class Randomizer {
	static int[] intList() {
		return intList(10);
	}

	static int[] intList(int n) {
		int[] list = new int[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * 50) + 1;
		}
		return list;
	}
}
