package misc.euler;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Problem18 {

	private static int[][] triangle;
	private static List<Node> open = new ArrayList<>();
	private static Set<Node> closed = new HashSet<>();

	public static void main(String[] args) throws IOException {
		Scanner file = new Scanner(new File("src/misc/euler/problem18.dat"));
		triangle = new int[(int) Files.lines(Paths.get("src/misc/euler/problem18.dat")).count()][];
		for (int i = 0; i < triangle.length; i++) {
			triangle[i] = Stream.of(file.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		open.add(new Node(triangle[0][0], triangle[0][0], triangle[1][0], triangle[1][1]));
		while (!open.isEmpty() && open.get(0).leftChild >= 0) {
			Node current = open.remove(0);
			closed.add(current);

		}
	}

	static class Node implements Comparable<Node> {
		int num;
		int sum;
		int leftChild;
		int rightChild;

		Node(int num) {
			this.num = num;
		}

		Node(int num, int sum, int leftChild, int rightChild) {
			this.num = num;
			this.sum = sum;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Node node = (Node) o;

			return num == node.num && leftChild == node.leftChild && rightChild == node.rightChild;
		}

		@Override
		public int hashCode() {
			int result = num;
			result = 31 * result + leftChild;
			result = 31 * result + rightChild;
			return result;
		}

		@Override
		public int compareTo(@NotNull Node o) {
			return num - o.num;
		}
	}
}
