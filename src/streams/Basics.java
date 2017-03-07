package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basics {
	public static void main(String[] args) {

		// Basic example of using streams
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList
				.stream()
				.filter(s -> s.startsWith("c"))
				.map(String::toUpperCase)
				.sorted()
				.forEach(System.out::println);

		System.out.println();
		// IntStream for a range of numbers
		IntStream.range(0, 5)
				.forEach(System.out::println);

		System.out.println();
		// Primitive arrays can use sum() and average()
		Arrays.stream(new int[]{1, 2, 3})
				.map(n -> 2 * n + 1)
				.average()
				.ifPresent(System.out::println);

		System.out.println();
		// Object stream to a primitive stream
		Stream.of("a1", "a2", "a3")
				.map(s -> s.substring(1))
				.mapToInt(Integer::parseInt)
				.max()
				.ifPresent(System.out::println);

		System.out.println();
		// Primitive stream to object stream
		IntStream.range(1, 4)
				.mapToObj(i -> "a" + i)
				.forEach(System.out::println);

		System.out.println();
		// Combination
		Stream.of(1.0, 2.0, 3.0)
				.mapToInt(Double::intValue)
				.mapToObj(i -> "a" + i)
				.forEach(System.out::println);

		System.out.println();
		// Processing order
		Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> {
					System.out.println("filter: " + s);
					return true;
				})
				.forEach(s -> System.out.println("forEach: " + s));

		System.out.println();
		// Why order matters
		Stream.of("d2", "a2", "b1", "b3", "c")
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("A");
				})
				.forEach(s -> System.out.println("forEach: " + s));

		System.out.println();
		// map() and filter() called for every element, forEach() only once
		// versus
		Stream.of("d2", "a2", "b1", "b3", "c")
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
		// Extension of order mattering but with sorting
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
		// Optimized sort
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

		// Streams cannot be optimized, must use a stream supplier


	}
}
