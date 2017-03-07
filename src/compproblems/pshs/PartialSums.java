package compproblems.pshs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartialSums {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/competitions/pshs/partialsums.dat"));

        int sets = file.nextInt();
        for (int s = 0; s < sets; s++) {
            long num = file.nextLong();
            long sum = 0;

            for (long i = 0; i < num; i++) {
                sum += .5 * i * (i + 1);
            }

            System.out.println(sum);
        }
    }
}
