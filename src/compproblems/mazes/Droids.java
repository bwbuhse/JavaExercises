package compproblems.mazes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Droids {

	static char[][] maze;
	static boolean[][] visited;
	static String path;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/mazes/droids.dat"));

		int sets = file.nextInt();
		for (int s = 0; s < sets; s++) {
			path = "";
			maze = new char[file.nextInt()][file.nextInt()];
			visited = new boolean[maze.length][maze[0].length];
			file.nextLine();

			for (int i = 0; i < maze.length; i++) {
				maze[i] = file.nextLine().toCharArray();
			}

			for (int r = 0; r < maze.length; r++) {
				for (int c = 0; c < maze[0].length; c++) {
					if (maze[r][c] == 'S') {
						solve(r, c, '\0');
					}
				}
			}

			System.out.println(path);
		}
	}

	static boolean solve(int r, int c, char dir) {
		if (r < 0 || r > maze.length || c < 0 || c > maze[0].length || visited[r][c])
			return false;

		return false;
	}
}
