package mazesolving;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DijkstraLists {

	private static int R = 201, C = 201;
	private static char wall;
	private static char[][] maze = new char[R][];
	private static List<Node> open = new ArrayList<>();
	private static Set<Node> closed = new HashSet<>();

	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();
		Scanner file = new Scanner(new File("maze.txt"));
		wall = '#';
		Node node;
		char finish = 'G';

		for (int r = 0; r < R; r++)
			maze[r] = file.nextLine().toCharArray();

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (maze[r][c] == 'S') {
					open.add(new Node(r, c, 0, null));
					break;
				}
			}
		}
		while (!open.isEmpty() && maze[open.get(0).r][open.get(0).c] != finish) {
			node = open.remove(0);
			closed.add(node);
			solve(node);
			Collections.sort(open);
		}

		System.out.println(open.get(0).dist);
		System.out.println(System.currentTimeMillis() - start);
	}

	private static void solve(Node node) {
		if (node.c + 1 < C && maze[node.r][node.c + 1] != wall)
			changeCost(node, node.r, node.c + 1);
		if (node.c - 1 >= 0 && maze[node.r][node.c - 1] != wall)
			changeCost(node, node.r, node.c - 1);
		if (node.r + 1 < R && maze[node.r + 1][node.c] != wall)
			changeCost(node, node.r + 1, node.c);
		if (node.r - 1 >= 0 && maze[node.r - 1][node.c] != wall)
			changeCost(node, node.r - 1, node.c);
	}

	private static void changeCost(Node node, int r, int c) {
		Node next = new Node(r, c);
		if (closed.contains(next))
			return;
		for (Node n : open) {
			if (n.equals(next)) {
				next = n;
				break;
			}
		}
		int alt = node.dist + (maze[r][c] == 'm' ? 11 : 1);
		if (next.dist == -1) {
			open.add(new Node(r, c, alt, node));
		} else if (alt < next.dist) {
			next.dist = alt;
			next.prev = node;
		}
	}

	static class Node implements Comparable<Node> {
		int r, c;
		int dist;
		Node prev;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
			dist = -1;
		}

		Node(int r, int c, int dist, Node prev) {
			this.r = r;
			this.c = c;
			this.dist = dist;
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
			return dist - o.dist;
		}
	}
}
