package compproblems.mazes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Cabbages {

	static int R, C;
	static char[][] maze;
	static boolean onAang;
	static Node aang;
	static Node merchant;
	static Queue<Node> queue;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/mazes/cabbages.in"));

		while (file.hasNext()) {
			queue = new PriorityQueue<>();
			R = file.nextInt();
			C = file.nextInt();
			file.nextLine();
			maze = new char[R][];
			for (int r = 0; r < R; r++)
				maze[r] = file.nextLine().toCharArray();

			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					if (maze[r][c] == 'A')
						queue.add(new Node(r, c, 0, null));
					else if (maze[r][c] != '@')
						queue.add(new Node(r, c, Integer.MAX_VALUE, null));
			onAang = true;
			aang = queue.poll();
			solve(aang);

			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					if (maze[r][c] == 'C')
						queue.add(new Node(r, c, 0, null));
					else if (maze[r][c] != '@')
						queue.add(new Node(r, c, Integer.MAX_VALUE, null));
			onAang = false;
			merchant = queue.poll();
			solve(merchant);

			int aangDist = aang.dist;
			int merchDist = merchant.dist;
			boolean collision = false;
			Queue<Node> aangQ = new PriorityQueue<>();
			Queue<Node> merchQ = new PriorityQueue<>();
			while (aang != null) {
				aangQ.add(aang);
				aang = aang.prev;
			}

			while (merchant != null) {
				merchQ.add(merchant);
				merchant = merchant.prev;
			}

			while (!(aangQ.isEmpty() || merchQ.isEmpty())) {
				if (aangQ.poll().equals(merchQ.poll())) {
					collision = true;
					break;
				}
			}


			if (collision)
				System.out.println("My Cabbages!");
			else if (aangDist < merchDist)
				System.out.println("Aang");
			else
				System.out.println("Cabbage Merchant");

		}

	}

	private static void solve(Node node) {
		if (node.r == 0 || node.c == 0 || node.r == R - 1 || node.c == C - 1)
			return;

		if (maze[node.r + 1][node.c] != '@')
			changeCost(node, node.r + 1, node.c);
		if (maze[node.r - 1][node.c] != '@')
			changeCost(node, node.r - 1, node.c);
		if (maze[node.r][node.c + 1] != '@')
			changeCost(node, node.r, node.c + 1);
		if (maze[node.r][node.c - 1] != '@')
			changeCost(node, node.r, node.c - 1);

		if (!(queue.isEmpty())) {
			if (onAang) {
				aang = queue.poll();
				solve(aang);
			} else {
				merchant = queue.poll();
				solve(merchant);
			}
		}

	}

	private static void changeCost(Node node, int r, int c) {
		int alt = node.dist + 1;
		Node temp = null;
		for (Node n : queue)
			if (n.equals(new Node(r, c, -1, null)))
				temp = n;

		queue.remove(temp);

		if (temp != null) {
			if (alt < temp.dist) {
				temp.dist = alt;
				temp.prev = node;
			}

			queue.add(temp);
		}
	}

	static class Node implements Comparable<Node> {
		int r, c;
		int dist;
		Node prev;

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
		public int compareTo(Node o) {
			return dist - o.dist;
		}
	}
}
