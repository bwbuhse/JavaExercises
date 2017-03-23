package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MonsterMaze {
	private static final int R = 25;     // Number of rows in the maze
	private static final int C = 25;     // Number of cols in the maze

	private static char[][] maze = new char[R][C];
	private static Queue<Node> queue = new PriorityQueue<>();
	private static Node end = new Node(-1, -1, Integer.MAX_VALUE, null);

	public static void main(String[] args) throws FileNotFoundException {

		Scanner file = new Scanner(new File("maze.txt"));

		for (int i = 0; i < R; i++)
			maze[i] = file.nextLine().toCharArray();

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (maze[r][c] == 'S')
					queue.add(new Node(r, c, 0, null));
				else if (maze[r][c] != '#')
					queue.add(new Node(r, c, Integer.MAX_VALUE, null));
			}
		}

		end = queue.poll();
		solve(end);

		Node temp = end.prev;
		while (temp.prev != null) {
			maze[temp.r][temp.c] = '*';
			temp = temp.prev;
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(maze[r][c]);
			}
			System.out.println();
		}
		System.out.println("Cost: " + end.cost + "HP");
	}

	private static void solve(Node node) {
		if (maze[node.r][node.c] == 'G') {
			return;
		}
		if (maze[node.r + 1][node.c] != '#')
			changeCost(node, node.r + 1, node.c);
		if (maze[node.r - 1][node.c] != '#')
			changeCost(node, node.r - 1, node.c);
		if (maze[node.r][node.c + 1] != '#')
			changeCost(node, node.r, node.c + 1);
		if (maze[node.r][node.c - 1] != '#')
			changeCost(node, node.r, node.c - 1);

		if (!(queue.isEmpty())) {
			end = queue.poll();
			solve(end);
		}

	}

	private static void changeCost(Node node, int r, int c) {
		int alt = node.cost + (maze[r][c] == 'm' ? 11 : 1);

		Node next = null;
		Node tempNode = new Node(r, c, -1, null);

		if (queue.contains(tempNode)) {
			for (Node test : queue) {
				if (test.equals(tempNode)) {
					next = test;
				}
			}
		}

		if (next != null) {
			queue.remove(next);
			if (alt < next.cost) {
				next.cost = alt;
				next.prev = node;
			}
			queue.add(next);
		}

	}

	static class Node implements Comparable<Node> {
		int r, c;
		int cost;
		Node prev;

		Node(int r, int c, int cost, Node prev) {
			this.r = r;
			this.c = c;
			this.cost = cost;
			this.prev = prev;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
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
	}
}
