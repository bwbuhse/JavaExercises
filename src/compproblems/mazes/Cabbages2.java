package compproblems.mazes;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Cabbages2 {

	private static char[][] maze;
	private static List<Node> open;
	private static Set<Node> closed;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/mazes/cabbages.in"));
		while (file.hasNext()) {
			maze = new char[file.nextInt()][];
			file.nextLine();
			for (int i = 0; i < maze.length; i++) {
				maze[i] = file.nextLine().toCharArray();
			}
			open = new ArrayList<>();
			closed = new HashSet<>();
			for (int r = 0; r < maze.length; r++)
				for (int c = 0; c < maze[r].length; c++)
					if (maze[r][c] == 'A')
						open.add(new Node(r, c, 0, null));
			Node aangShort, merchShort;
			dijkstra();
			aangShort = open.get(0);
			open = new ArrayList<>();
			closed = new HashSet<>();
			for (int r = 0; r < maze.length; r++)
				for (int c = 0; c < maze[r].length; c++)
					if (maze[r][c] == 'C')
						open.add(new Node(r, c, 0, null));
			dijkstra();
			merchShort = open.get(0);

			Node aangStart = aangShort, merchStart = merchShort;
			List<Node> aang = new ArrayList<>();
			List<Node> merch = new ArrayList<>();
			while (aangStart.prev != null) {
				aang.add(aangStart);
				aangStart = aangStart.prev;
			}
			while (merchStart.prev != null) {
				merch.add(merchStart);
				merchStart = merchStart.prev;
			}
			Collections.sort(aang);
			Collections.sort(merch);
			boolean out = false;
			for (int i = 0; i < aang.size() && i < merch.size(); i++) {
				if (aang.get(i).equals(merch.get(i))) {
					out = true;
					System.out.println("My Cabbages!");
					break;
				}
			}
			if (!out) {
				System.out.println(aangShort.dist < merchShort.dist ? "Aang" : "Cabbage Merchant");
			}

		}
	}

	private static void dijkstra() {
		while (!open.isEmpty()) {
			if (open.get(0).r == 0 || open.get(0).c == 0 || open.get(0).r == maze.length - 1 || open.get(0).c == maze[0].length - 1)
				return;

			Node node = open.remove(0);
			closed.add(node);
			solve(node);
			Collections.sort(open);
		}
	}

	private static void solve(Node node) {
		if (node.r + 1 < maze.length && maze[node.r + 1][node.c] != '@')
			changeCost(node, node.r + 1, node.c);
		if (node.r - 1 >= 0 && maze[node.r - 1][node.c] != '@')
			changeCost(node, node.r - 1, node.c);
		if (node.c + 1 < maze[node.r].length && maze[node.r][node.c + 1] != '@')
			changeCost(node, node.r, node.c + 1);
		if (node.c - 1 >= 0 && maze[node.r][node.c - 1] != '@')
			changeCost(node, node.r, node.c - 1);
	}

	private static void changeCost(Node node, int r, int c) {
		Node next = new Node(r, c);
		if (closed.contains(next))
			return;
		for (Node n : open)
			if (next.equals(n))
				next = n;
		int alt = node.dist + 1;
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

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
			dist = -1;
		}

		public Node(int r, int c, int dist, Node prev) {
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
