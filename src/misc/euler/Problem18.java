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

		open.add(new Node(0, 0, triangle[0][0], triangle[1][0], triangle[1][1]));
		while (!open.isEmpty() && open.get(0).leftChild >= 0) {
			Node current = open.remove(0);
			closed.add(current);
			solve(current);
			Collections.sort(open);
		}
	}

	// TODO how?
	private static void solve(Node node) {
	}

	static class Node implements Comparable<Node> {
		int r, c;
		int sum;
		int leftChild;
		int rightChild;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public Node(int r, int c, int sum, int leftChild, int rightChild) {
			this.r = r;
			this.c = c;
			this.sum = sum;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Node node = (Node) o;

			if (r != node.r) return false;
			return c == node.c;
		}

		@Override
		public int hashCode() {
			int result = r;
			result = 31 * result + c;
			return result;
		}

		@Override
		public int compareTo(@NotNull Node o) {
			return o.sum - sum;
		}
	}
}
