package compproblems.state2014;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Knight {

	private static boolean[][] board;
	private static List<Node> open;
	private static Set<Node> closed;
	private static int n;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/state2014/knight.dat"));
		n = file.nextInt();
		int p = file.nextInt();
		board = new boolean[n][n];
		open = new ArrayList<>();
		closed = new HashSet<>();
		for (int i = 0; i < p; i++) {
			board[file.nextInt()][file.nextInt()] = true;
		}
		open.add(new Node(0, 0, 0, null));
		while (!open.isEmpty() && open.get(0).c < n - 1) {
			Node node = open.remove(0);
			closed.add(node);
			solve(node);
			Collections.sort(open);
		}
		System.out.println(open.get(0).captured);
	}

	private static void solve(Node node) {
		if (node.r + 1 < n && node.c + 2 < n)
			adjust(node, node.r + 1, node.c + 2);
		if (node.r + 2 < n && node.c + 1 < n)
			adjust(node, node.r + 2, node.c + 1);
		if (node.r - 1 >= 0 && node.c + 2 < n)
			adjust(node, node.r - 1, node.c + 2);
		if (node.r - 2 >= 0 && node.c + 1 < n)
			adjust(node, node.r - 2, node.c + 1);
	}

	private static void adjust(Node node, int r, int c) {
		Node next = new Node(r, c);
		if (closed.contains(next))
			return;
		for (Node n : open)
			if (next.equals(n))
				next = n;
		int alt = node.captured + (board[r][c] ? 1 : 0);
		if (next.captured == -1) {
			open.add(new Node(r, c, alt, node));
		} else if (alt > next.captured) {
			next.captured = alt;
			next.prev = node;
		}
	}

	static class Node implements Comparable<Node> {
		int r, c;
		int captured;
		Node prev;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
			this.captured = -1;
		}

		public Node(int r, int c, int captured, Node prev) {
			this.r = r;
			this.c = c;
			this.captured = captured;
			this.prev = prev;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Node node = (Node) o;

			return r == node.r && c == node.c;
		}

		@Override
		public int hashCode() {
			int result = r;
			return 31 * result + c;
		}

		@Override
		public int compareTo(@NotNull Node o) {
			return o.captured - captured;
		}
	}
}
