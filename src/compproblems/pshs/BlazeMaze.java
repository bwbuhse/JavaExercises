package compproblems.pshs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BlazeMaze {

	private static char[][] maze;
	private static boolean[][] visited;
	private static Node end;
	private static int mazeNum = 1;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/competitions/pshs/blazemaze.dat"));

		int sets = file.nextInt();
		for (int s = 0; s < sets; s++) {
			int dim = file.nextInt();
			maze = new char[dim][dim];
			visited = new boolean[dim][dim];

			int rStart = file.nextInt();
			int cStart = file.nextInt();
			maze[rStart][cStart] = 'S';
			Node start = new Node(rStart, cStart, null, -1);
			maze[file.nextInt()][file.nextInt()] = 'F';

			int walls = file.nextInt();
			for (int i = 0; i < walls; i++)
				maze[file.nextInt()][file.nextInt()] = 'W';

			System.out.println("Maze " + mazeNum++ + ":");
			if (solve(start)) {
				Node node = end;
				Stack<String> directions = new Stack<>();
				while (node.prev != null) {
					switch (node.dir) {
						case 0:
							directions.add("UP");
							break;
						case 1:
							directions.add("RIGHT");
							break;
						case 2:
							directions.add("DOWN");
							break;
						case 3:
							directions.add("LEFT");
					}
					node = node.prev;
				}

				while (!(directions.isEmpty()))
					System.out.println(directions.pop());

			} else {
				System.out.println("UNSOLVABLE");
			}
			System.out.println();

		}
	}

	private static boolean solve(Node node) {
		if (node.r < 0 || node.c < 0 || node.r >= maze.length || node.c >= maze.length)
			return false;
		if (visited[node.r][node.c])
			return false;
		visited[node.r][node.c] = true;
		if (maze[node.r][node.c] == 'F') {
			end = node;
			return true;
		}
		return maze[node.r][node.c] != 'W' && solve(new Node(node.r - 1, node.c, node, 0)) ||
				solve(new Node(node.r + 1, node.c, node, 2)) ||
				solve(new Node(node.r, node.c - 1, node, 3)) ||
				solve(new Node(node.r, node.c + 1, node, 1));

	}

	static class Node {
		int r, c;
		Node prev;
		int dir;

		Node(int r, int c, Node prev, int dir) {
			this.r = r;
			this.c = c;
			this.prev = prev;
			this.dir = dir;
		}
	}
}
