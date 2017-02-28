package misc;

import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {
		// Inefficient
		Stream.of("d2", "a2", "b1", "b3", "c")
				.sorted((s1, s2) -> {
					System.out.printf("sort: %s; %s%n", s1, s2);
					return s1.compareTo(s2);
				})
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("a");
				})
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.forEach(s -> System.out.println("forEach: " + s));

		System.out.println();
		// Efficient
		Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("a");
				})
				.sorted((s1, s2) -> {
					System.out.printf("sort: %s; %s%n", s1, s2);
					return s1.compareTo(s2);
				})
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.forEach(s -> System.out.println("forEach: " + s));

	}
}
