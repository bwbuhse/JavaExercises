package streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdvancedOperations {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Max", 18),
				new Person("Peter", 23),
				new Person("Pamela", 23),
				new Person("David", 12));


		// toList() creates a list from a stream, also a toSet()
		List<Person> filtered =
				persons
						.stream()
						.filter(p -> p.name.startsWith("P"))
						.collect(Collectors.toList());

		System.out.println(filtered);

		System.out.println();
		// Group persons by age
		Map<Integer, List<Person>> personsByAge = persons
				.stream()
				.collect(Collectors.groupingBy(p -> p.age));

		personsByAge.forEach((age, p) -> System.out.format("age %s: %s%n", age, p));

		System.out.println();
		// Get average age
		Double averageAge = persons
				.stream()
				.collect(Collectors.averagingInt(p -> p.age));

		System.out.println(averageAge);

		System.out.println();
		// Summary statistics object
		IntSummaryStatistics ageSummary =
				persons
						.stream()
						.collect(Collectors.summarizingInt(p -> p.age));

		System.out.println(ageSummary);

		System.out.println();
		// Join all persons into a single string
		String phrase = persons
				.stream()
				.filter(p -> p.age >= 18)
				.map(p -> p.name)
				.collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

		System.out.println(phrase);

		System.out.println();
		// Transforming the stream into a map
		// Keys must be unique without a merge function
		Map<Integer, String> map = persons
				.stream()
				.collect(Collectors.toMap(
						p -> p.age,
						p -> p.name,
						(name1, name2) -> name1 + ";" + name2));

		System.out.println(map);

		System.out.println();
		// Creating a collector
//		Collector<Person, StringJoiner, String> personNameCollector =
//				Collector.of(
//						() -> new StringJoiner(" | "),          // supplier
//						(j, p) -> j.add(p.name.toUpperCase()),  // accumulator
//						(j1, j2) -> j1.merge(j2),               // combiner
//						StringJoiner::toString);                // finisher
//
////		String names = persons
////				.stream()
////				.collect(personNameCollector);
//
//		System.out.println(names);

		System.out.println();
		// FlatMap
		List<Foo> foos = new ArrayList<>();

		// create foos
		IntStream
				.range(1, 4)
				.forEach(i -> foos.add(new Foo("Foo" + i)));

		// create bars
		foos.forEach(f ->
				IntStream
						.range(1, 4)
						.forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

		foos.stream()
				.flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));

		System.out.println();
		// FlatMap thing into one pipeline of streams
		IntStream.range(1, 4)
				.mapToObj(i -> new Foo("Foo" + i))
				.peek(f -> IntStream.range(1, 4)
						.mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
						.forEach(f.bars::add))
				.flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));

		System.out.println();
		// Reduce methods are used to combine elements of a stream into a single result
		// This one makes them into one element of the stream
		persons
				.stream()
				.reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
				.ifPresent(System.out::println);

		System.out.println();
		// Second use of a reduce method; constructs a new Person with the aggregated names and
		// ages of all others in the stream
		Person result =
				persons
						.stream()
						.reduce(new Person("", 0), (p1, p2) -> {
							p1.age += p2.age;
							p1.name += p2.name;
							return p1;
						});
		System.out.printf("name=%s; age=%s%n", result.name, result.age);

		System.out.println();
		// Third reduce method; three parameters...
		// An identity value, a BiFunction accumulator, and a combiner function of Binary Operator
		Integer ageSum = persons
				.parallelStream()
				.reduce(0,
						(sum, p) -> {
							System.out.printf("accumulator: sum=%s; person=%s\n", sum, p);
							return sum + p.age;
						},
						(sum1, sum2) -> {
							System.out.printf("combiner: sum1=%s; sum2=%s%n", sum1, sum2);
							return sum1 + sum2;
						});

		System.out.println(ageSum);
	}

}

class Foo {
	String name;
	List<Bar> bars = new ArrayList<>();

	Foo(String name) {
		this.name = name;
	}
}

class Bar {
	String name;

	Bar(String name) {
		this.name = name;
	}
}
