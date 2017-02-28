package compproblems.pshs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Hangman {

	private static List<String> dictionary = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/compproblems/pshs/hangman.dat"));

		int numWords = file.nextInt();
		file.nextLine();
		for (int i = 0; i < numWords; i++) {
			dictionary.add(file.nextLine());
		}

		int sets = file.nextInt();
		file.nextLine();
		for (int n = 0; n < sets; n++) {
			TreeMap<Character, Integer> letters = new TreeMap<>();
			String given = file.next();
			String stringGuessed = file.nextLine().trim();
			char[] guessed = new char[0];
			for (int i = 0; i < stringGuessed.length(); i++) {
				if (stringGuessed.charAt(i) != ' ') {
					guessed = Arrays.copyOf(guessed, guessed.length + 1);
					guessed[guessed.length - 1] = stringGuessed.charAt(i);
				}
			}

			TreeSet<String> possibleSet = new TreeSet<>();
			for (String s : dictionary) {
				if (possible(given, s, guessed)) {
					possibleSet.add(s);
				}
			}

			for (String s : possibleSet) {
				TreeSet<Character> wordLets = new TreeSet<>();
				for (Character c : s.toCharArray())
					wordLets.add(c);
				for (Character c : wordLets) {
					if (letters.containsKey(c)) {
						letters.put(c, letters.get(c) + 1);
					} else {
						letters.put(c, 1);
					}
				}
			}

			for (char c : given.toCharArray()) {
				letters.remove(c);
			}

			char mostUsed = 0;
			int uses = 0;
			for (char c : letters.keySet()) {
				if (letters.get(c) > uses) {
					mostUsed = c;
					uses = letters.get(c);
				}
			}

			System.out.println(mostUsed);
		}

	}

	private static boolean possible(String given, String toTest, char[] guessed) {
		if (toTest.length() != given.length())
			return false;

		for (char c : guessed)
			if (toTest.contains(c + ""))
				return false;

		char[] givenArr = given.toCharArray();
		char[] toTestArr = toTest.toCharArray();

		List<Character> givenList = new ArrayList<>();
		List<Character> toTestList = new ArrayList<>();

		for (int i = 0; i < givenArr.length; i++) {
			givenList.add(givenArr[i]);
			toTestList.add(toTestArr[i]);
		}

		for (int i = 0; i < givenArr.length; i++) {
			if (givenArr[i] != toTestArr[i] && givenArr[i] != '-')
				return false;
		}

		for (int i = 0; i < givenList.size(); i++) {
			if (givenList.get(i) != '-' && Collections.frequency(givenList, givenArr[i]) != Collections.frequency(toTestList, givenArr[i]))
				return false;
		}

		return true;
	}
}
