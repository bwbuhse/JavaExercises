package misc.interviews;

import java.util.Stack;

public class TowersOfHanoi {

	private static final int DISKS = 5;
	private static Stack<Integer> a = new Stack<>();
	private static Stack<Integer> b = new Stack<>();
	private static Stack<Integer> c = new Stack<>();

	public static void main(String[] args) {
		for (int i = DISKS; i > 0; i--) a.add(i);
		solve(DISKS, a, c, b);
	}

	private static void solve(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> auxiliary) {
		if (n <= 0)
			return;
		solve(n - 1, source, auxiliary, target);
		target.add(source.pop());
		System.out.printf("%s\n%s\n%s\n##########\n", a, b, c);
		solve(n - 1, auxiliary, target, source);
	}
}
