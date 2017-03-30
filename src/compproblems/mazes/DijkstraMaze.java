package compproblems.mazes;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class DijkstraMaze {

	private static int R, C;
	private static int[][] grid;
	private static List<Node> open;
	private static Set<Node> closed;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/mazes/dijkstraMaze.txt"));
		int sets = file.nextInt();
		for (int s = 0; s < sets; s++) {
			R = file.nextInt();
			C = file.nextInt();
			grid = new int[R][];
			open = new ArrayList<>();
			closed = new HashSet<>();
			file.nextLine();

			for (int r = 0; r < R; r++) {
				grid[r] = Stream.of(file.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			open.add(new Node(0, 0, grid[0][0], null));
			while (!open.isEmpty() && !(open.get(0).r == R - 1 && open.get(0).c == C - 1)) {
				Node current = open.remove(0);
				closed.add(current);
				solve(current);
				Collections.sort(open);
			}

			System.out.println(open.get(0).cost);
		}
	}

	private static void solve(Node node) {
		if (node.r - 1 >= 0)
			changeCost(node, node.r - 1, node.c);
		if (node.c - 1 >= 0)
			changeCost(node, node.r, node.c - 1);
		if (node.r + 1 < R)
			changeCost(node, node.r + 1, node.c);
		if (node.c + 1 < C)
			changeCost(node, node.r, node.c + 1);

	}

	private static void changeCost(Node node, int r, int c) {
		Node next = new Node(r, c);
		if (closed.contains(next))
			return;
		for (Node n : open) {
			if (next.equals(n)) {
				next = n;
				break;
			}
		}
		int alt = node.cost + grid[r][c];
		if (next.cost == -1) {
			open.add(new Node(r, c, alt, node));
		} else if (alt < node.cost) {
			next.cost = alt;
			next.prev = node;
		}
	}

	static class Node implements Comparable<Node> {
		int r, c;
		int cost;
		Node prev;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
			cost = -1;
		}

		Node(int r, int c, int cost, Node prev) {
			this.r = r;
			this.c = c;
			this.cost = cost;
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
			result = 31 * result + c;
			return result;
		}


		@Override
		public int compareTo(@NotNull Node o) {
			return cost - o.cost;
		}
	}
}
