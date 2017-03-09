package mazesolving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AStar {

	// Num of rows and columns
	private static int R, C;


	// Whatever character represents walls in the maze
	private static char wall;

	private static PriorityQueue<Node> queue = new PriorityQueue<>();
	private static char maze[][];
	private static Node end;

	// Much of the main() can be put into a loop for problems with multiple data sets
	// but you need to do that on your own
	public static void main(String[] args) throws FileNotFoundException {
		int i = 0;

		// Set up the dimensions of the maze, as well as what the walls and finish are
		R = 201;
		C = 201;

		// You could set finish and wall outside of main() if you want
		// Whatever character represents the end of the maze
		char finish = 'G';
		wall = '#';

		// Replace maze.txt with the name of the input
		Scanner file = new Scanner(new File("maze.txt"));

		// The rest of main() may need to be altered based on the format of the input
		// Sets up the maze
		maze = new char[R][];
		for (int r = 0; r < R; r++)
			maze[r] = file.nextLine().toCharArray();

		Node temp = new Node(-1, -1, -1, null, -1);
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// Change S to whatever character signifies the start
				if (maze[r][c] == finish)
					temp = new Node(r, c, -1, null, 0);
			}
		}

		// Adds every spot in the maze to the queue
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// Change S to whatever character signifies the start
				if (maze[r][c] == 'S')
					queue.add(new Node(r, c, 0, null, Math.abs(r - temp.r) + Math.abs(c - temp.c)));
				else if (maze[r][c] != wall)
					queue.add(new Node(r, c, Integer.MAX_VALUE, null, Math.abs(r - temp.r) + Math.abs(c - temp.c)));
			}
		}

		// Finds the shortest path and saves it into end
		while (!(queue.isEmpty())) {
			i++;
			end = queue.poll();
			if (maze[end.r][end.c] == finish) {
				break;
			} else {
				solve(end);
			}
		}

		// Put the output here
		System.out.println(end.dist);
		System.out.println(i);
	}

	private static void solve(Node node) {
		// Updates the cost of all nodes around it
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
		// Alternate cost to compare the next node to
		// If there are spots on the maze with different costs then this must be conditional
		int alt = maze[r][c] == 'm' ? node.dist + 11 : node.dist + 1;
		// Goes through the queue to find the node at spot [r][c] in the maze
		Node next = null;
		for (Node n : queue) {
			// Node's .equals() is based off of only r and c so the distance and previous node don't matter
			if (n.equals(new Node(r, c, -1, null, -1))) {
				next = n;
				break;
			}
		}
		// If the node is still in the queue (e.g. it found it) then update the cost if you found a shorter route
		if (next != null) {
			queue.remove(next);

			if (alt < next.dist) {
				next.dist = alt;
				next.prev = node;
			}

			queue.add(next);
		}
	}

	// You shouldn't need to change any of this
	static class Node implements Comparable<Node> {
		// Row and column
		int r, c;
		// Distance to the node
		int dist;
		// The previous node
		Node prev;
		// Heuristic
		int heuristic;

		Node(int r, int c, int dist, Node prev, int heuristic) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.prev = prev;
			this.heuristic = heuristic;
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
			return (dist + heuristic) - (o.dist + o.heuristic);
		}
	}
}
