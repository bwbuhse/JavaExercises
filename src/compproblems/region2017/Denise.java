package compproblems.region2017;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Denise {

	private static char maze[][];
	private static List<Node> open;
	private static Set<Node> closed;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/region2017/denise.dat"));
		int sets = file.nextInt();
		for (int s = 0; s < sets; s++) {
			file.nextLine();
			maze = new char[10][];
			List<Node> objects = new ArrayList<>();
			List<Node> entrances = new ArrayList<>();
			List<Node> shortestPaths = new ArrayList<>();
			for (int r = 0; r < maze.length; r++)
				maze[r] = file.nextLine().toCharArray();
			for (int r = 0; r < maze.length; r++) {
				for (int c = 0; c < maze[r].length; c++) {
					if (maze[r][c] == 'o')
						objects.add(new Node(r, c));
					if ((r == 0 || c == 0 || r == maze.length - 1 || c == maze[r].length - 1) && maze[r][c] != '#')
						entrances.add(new Node(r, c, 0, null));
				}
			}
			for (Node object : objects) {
				for (Node entrance : entrances) {
					open = new ArrayList<>();
					closed = new HashSet<>();
					open.add(entrance);
					while (!open.isEmpty() && !object.equals(new Node(open.get(0).r, open.get(0).c))) {
						Node node = open.remove(0);
						closed.add(node);
						solve(node);
						Collections.sort(open);
					}
					if (open.get(0).equals(object)) {
						if (shortestPaths.contains(object)) {
							Node node = shortestPaths.remove(shortestPaths.indexOf(object));
							shortestPaths.add(node.dist < open.get(0).dist ? node : open.get(0));
						} else {
							shortestPaths.add(open.get(0));
						}
					}
				}
			}
			shortestPaths.sort((o1, o2) -> o2.dist - o1.dist);
			for (int i = 0; i < shortestPaths.size(); i++) {
				Node node = shortestPaths.get(i).prev;
				while (node != null && node.prev != null) {
					if (objects.contains(node)) {
						shortestPaths.remove(node);
					}
					node = node.prev;
				}
			}
			System.out.println(shortestPaths.size());
		}
	}

	private static void solve(Node node) {
		if (node.r + 1 < maze.length && maze[node.r + 1][node.c] != '#')
			changeCost(node, node.r + 1, node.c);
		if (node.c + 1 < maze[node.r].length && maze[node.r][node.c + 1] != '#')
			changeCost(node, node.r, node.c + 1);
		if (node.r - 1 >= 0 && maze[node.r - 1][node.c] != '#')
			changeCost(node, node.r - 1, node.c);
		if (node.c - 1 >= 0 && maze[node.r][node.c - 1] != '#')
			changeCost(node, node.r, node.c - 1);
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
		int alt = node.dist + (maze[r][c] == '.' ? 2 : 1);
		if (next.dist == -1) {
			next.dist = alt;
			next.prev = node;
			open.add(next);
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
