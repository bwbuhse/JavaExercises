package misc;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Stream;

public class WatchTracker {
	public static void main(String[] args) throws IOException {
		Reader csvData = new FileReader("src/misc/timing_run_short.csv");
		CSVParser parser = new CSVParser(csvData, CSVFormat.RFC4180);
		List<CSVRecord> list = parser.getRecords();
		CSVRecord header = list.remove(0);

		System.out.printf("%6s|%7s|%15s|%18s|%16s|%n", header.get(0), header.get(1),
				header.get(3), header.get(4), header.get(5));

		list.stream()
				.map(records -> Stream.of(new String[]{records.get(0), records.get(1),
						records.get(3), records.get(4), records.get(5)}))
				.map(records -> records.mapToDouble(Double::parseDouble).toArray())
				.forEach(records -> System.out.printf("%6.3f|%7.3f|%15d|%18.3f|%16.3f|%n", records[0], records[1],
						(int) records[2], records[3], records[4]));
	}
}
