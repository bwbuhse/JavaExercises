import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GenericDijkstra {

	// Num of rows and columns
	private static int R, C;

	// Whatever character represents the end of the maze
	private static char finish;
	// Whatever character represents walls in the maze
	private static char wall;

	private static PriorityQueue<Node> queue = new PriorityQueue<>();
	private static char maze[][];
	private static Node end;

	// Much of the main() can be put into a loop for problems with multiple data sets
	// but you need to do that on your own
	// You could set finish and wall outside of main() if you want
	public static void main(String[] args) throws FileNotFoundException {
		// Set up the dimensions of the maze, as well as what the walls and finish are
		R = 9;
		C = 8;
		finish = 'E';
		wall = '@';

		// Replace maze.txt with the name of the input
		Scanner file = new Scanner(new File("maze.txt"));

		// The rest of main() may need to be altered based on the format of the input
		// Sets up the maze
		maze = new char[R][];
		for (int r = 0; r < R; r++)
			maze[r] = file.nextLine().toCharArray();

		// Adds every spot in the maze to the queue
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// Change S to whatever character signifies the start
				if (maze[r][c] == 'S')
					queue.add(new Node(r, c, 0, null));
				else
					queue.add(new Node(r, c, Integer.MAX_VALUE, null));
			}
		}

		// Finds the shortest path
		while (!(queue.isEmpty())) {
			end = queue.poll();
			if (maze[end.r][end.c] == finish) {
				break;
			} else {
				solve(end);
			}
		}

		// Output
		System.out.println(end.dist);
	}

	private static void solve(Node node) {
		// For reaching outside do if (node.r == 0 || node.c == 0 || node.r == R - 1 || node.c == C - 1)
		if (maze[node.r][node.c] == finish) {
			return;
		}

		// Updates the cost of all nodes around it
		if (node.r + 1 < R && maze[node.r + 1][node.c] != wall)
			changeCost(node, node.r + 1, node.c);
		if (node.r - 1 >= 0 && maze[node.r - 1][node.c] != wall)
			changeCost(node, node.r - 1, node.c);
		if (node.c + 1 < C && maze[node.r][node.c + 1] != wall)
			changeCost(node, node.r, node.c + 1);
		if (node.c - 1 >= 0 && maze[node.r][node.c - 1] != wall)
			changeCost(node, node.r, node.c - 1);
	}

	private static void changeCost(Node node, int r, int c) {
		// Alternate cost to compare the next node to
		// If there are spots on the maze with different costs then this must be conditional
		int alt = node.dist + 1;
		// Goes through the queue to find the node at spot [r][c] in the maze
		Node next = null;
		for (Node n : queue) {
			// Node's .equals() is based off of only r and c
			if (n.equals(new Node(r, c, -1, null))) {
				next = n;
			}
		}
		// If the node is still in the queue then update the cost if you found a shorter route
		if (next != null) {
			queue.remove(next);

			if (alt < next.dist) {
				next.dist = alt;
				next.prev = node;
			}

			queue.add(next);
		}
	}

	static class Node implements Comparable<Node> {
		// Row and column
		int r, c;
		// Distance to the node
		int dist;
		// The previous node
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
