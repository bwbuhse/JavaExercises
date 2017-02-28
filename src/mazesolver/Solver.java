package mazesolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solver {

    static Node shortest = new Node(-1, -1, Integer.MAX_VALUE, null);
    static char[][] maze = new char[1][];
    static Queue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/mazesolver/maze.txt"));

        for (int i = 0; file.hasNextLine(); i++) {
            maze[i] = file.nextLine().toCharArray();
            if (file.hasNextLine())
                maze = Arrays.copyOf(maze, maze.length + 1);
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                if (maze[r][c] == 'S') {
                    queue.add(new Node(r, c, 0, null));
                    visited[r][c] = true;
                }
            }
        }

        while (!(queue.isEmpty())) {
            Node node = queue.peek();
            if (maze[node.r][node.c] == 'E' && node.distance < shortest.distance)
                shortest = node;
            solve(queue.poll(), visited);
        }

        System.out.println();
        Node node = shortest;
        while (node != null) {
            System.out.println(node);
            node = node.prev;
        }
    }

    //TODO Detect when there is a shorter route to an already visited node
    static void solve(Node node, boolean[][] visited) {

        System.out.println(node);

        if (maze[node.r][node.c] == '*')
            node.distance += 1;

        if (node.r != 0 && !(visited[node.r - 1][node.c])
                && maze[node.r - 1][node.c] != '#') {

            queue.add(new Node(node.r - 1, node.c, node.distance + 1, node));
            visited[node.r - 1][node.c] = true;
        }
        if (node.c != 0 && !(visited[node.r][node.c - 1])
                && maze[node.r][node.c - 1] != '#') {

            queue.add(new Node(node.r, node.c - 1, node.distance + 1, node));
            visited[node.r][node.c - 1] = true;
        }
        if (node.r != maze.length - 1 && !(visited[node.r + 1][node.c])
                && maze[node.r + 1][node.c] != '#') {

            queue.add(new Node(node.r + 1, node.c, node.distance + 1, node));
            visited[node.r + 1][node.c] = true;
        }
        if (node.c != maze[node.r].length - 1 && !(visited[node.r][node.c + 1])
                && maze[node.r][node.c + 1] != '#') {

            queue.add(new Node(node.r, node.c + 1, node.distance + 1, node));
            visited[node.r][node.c + 1] = true;
        }
    }

    static class Node implements Comparable<Node> {
        int r, c;
        int distance;
        Node prev;

        public Node(int r, int c, int distance, Node prev) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.prev = prev;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", distance=" + distance +
                    '}';
        }
    }
}
