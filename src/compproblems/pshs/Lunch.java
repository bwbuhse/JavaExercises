package compproblems.pshs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Lunch {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/competitions/pshs/lunch.dat"));
        int sets = file.nextInt();
        file.nextLine();
        for (int s = 0; s < sets; s++) {
            String line = file.nextLine();
            String hero = line.substring(0, line.indexOf(": ") + 1);
            String[] sentences = line.substring(line.indexOf(": ") + 1).split("[\\.!\\?]");
            HashSet<Character> charsOne = new HashSet<>();
            HashSet<Character> charsTwo = new HashSet<>();
            for (int i = 0; i < sentences[0].length(); i++)
                if (sentences[0].substring(i, i + 1).matches("\\w"))
                    charsOne.add(sentences[0].charAt(i));
            for (int i = 0; i < sentences[1].length(); i++)
                if (sentences[1].substring(i, i + 1).matches("\\w"))
                    charsTwo.add(sentences[1].charAt(i));

            HashSet<String> charsOne1 = new HashSet<>();
            HashSet<String> charsTwo2 = new HashSet<>();
            for (char c : charsOne)
                charsOne1.add((c + "").toLowerCase());
            for (char c : charsTwo)
                charsTwo2.add((c + "").toLowerCase());

            if (charsOne1.size() < 26 || charsTwo2.size() < 26)
                System.out.printf("%s(%d, %d)%n", hero, 26 - charsOne1.size(), 26 - charsTwo2.size());
            else
                System.out.println(line);

        }
    }
}
