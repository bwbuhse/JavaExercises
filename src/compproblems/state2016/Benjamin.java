package compproblems.state2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Benjamin {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/state2016/benjamin.dat"));

		List<Integer> initial = Stream.of(file.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());

		LinkedList<Integer> q = new LinkedList<>(initial);
		Stack<Integer> s = new Stack<>();

		initial.forEach(s::add);

		while (file.hasNext()) {
			List<String> line = Stream.of(file.nextLine().split(" "))
					.collect(Collectors.toList());

			Collection<Integer> current = line.get(0).equals("S") ? s : q;

			String type = line.get(0);
			line.remove(0);

			if (current instanceof Stack) {
				line.forEach((String command) -> {
					if (command.startsWith("P(")) {
						s.push(Integer.parseInt(command.split("\\D")[2]));
					} else if (command.startsWith("P")) {
						s.pop();
					} else if (command.startsWith("L(")) {
						int min = Integer.MAX_VALUE;
						for (int i = 0; i < s.size(); i++)
							min = Math.min(min, s.elementAt(i));
						s.insertElementAt(Integer.parseInt(command.split("\\D")[2]), s.size() - s.search(min));
					} else if (command.startsWith("L")) {
						int min = Integer.MAX_VALUE;
						for (int i = 0; i < s.size(); i++)
							min = Math.min(min, s.elementAt(i));
						s.removeElementAt(s.size() - s.search(min));
					} else if (command.startsWith("H(")) {
						int max = Integer.MIN_VALUE;
						for (int i = 0; i < s.size(); i++)
							max = Math.max(max, s.elementAt(i));
						s.insertElementAt(Integer.parseInt(command.split("\\D")[2]), s.size() - s.search(max) + 1);
					} else if (command.startsWith("H")) {
						int max = Integer.MIN_VALUE;
						for (int i = 0; i < s.size(); i++)
							max = Math.max(max, s.elementAt(i));
						s.removeElementAt(s.size() - s.search(max));
					} else if (command.startsWith("M(")) {
						s.insertElementAt(Integer.parseInt(command.split("\\D")[2]), s.size() / 2);
					} else if (command.startsWith("M")) {
						s.removeElementAt(s.size() / 2 - 1);
					}
				});
			} else {
				line.forEach((String command) -> {
					if (command.startsWith("P(")) {
						q.add(Integer.parseInt(command.split("\\D")[2]));
					} else if (command.startsWith("P")) {
						q.poll();
					} else if (command.startsWith("L(")) {
						int min = Integer.MAX_VALUE;
						for (Integer aQ : q) min = Math.min(min, aQ);
						q.add(q.indexOf(min), Integer.parseInt(command.split("\\D")[2]));
					} else if (command.startsWith("L")) {
						int min = Integer.MAX_VALUE;
						for (Integer aQ : q) min = Math.min(min, aQ);
						q.remove(q.indexOf(min));
					} else if (command.startsWith("H(")) {
						int max = Integer.MIN_VALUE;
						for (Integer aQ : q) max = Math.max(max, aQ);
						q.add(q.indexOf(max) + 1, Integer.parseInt(command.split("\\D")[2]));
					} else if (command.startsWith("H")) {
						int max = Integer.MIN_VALUE;
						for (Integer aQ : q) max = Math.max(max, aQ);
						q.remove(q.indexOf(max));
					} else if (command.startsWith("M(")) {
						q.add(q.size() / 2, Integer.parseInt(command.split("\\D")[2]));
					} else if (command.startsWith("M")) {
						q.remove(q.size() / 2 - 1);
					}
				});
			}

			System.out.println(type + " " + current);
		}
	}
}
