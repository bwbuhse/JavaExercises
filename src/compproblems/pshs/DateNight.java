package compproblems.pshs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DateNight {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/competitions/pshs/datenight.dat"));

        int sets = file.nextInt();
        for (int s = 0; s < sets; s++) {
            int time = 0;
            int signals = file.nextInt();
            for (int i = 0; i < signals; i++) {
                time += file.nextInt();
            }
            time *= 60;
            time /= 40;
            time *= 2;
            int start = file.nextInt();
            int end = file.nextInt();
            int arrival = convert(start, time);
            System.out.println(time);
            if (arrival < end)
                System.out.println("Batman arrived at his date at " + arrival + " and was early for his date");
            else if (arrival == end)
                System.out.println("Batman arrived at his date at " + arrival + " and was on time for his date");
            else
                System.out.println("Batman arrived at his date at " + arrival + " and was late for his date");

        }
    }

    private static int convert(int start, int length) {
        int mins = start % 100 + length;
        int hours = start / 100;
        hours *= 100;
        while (mins > 59) {
            hours += 100;
            mins -= 60;
        }
        hours += mins;
        return hours;
    }
}
