package compproblems.pshs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MarvelPowers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/competitions/pshs/marvelpowers.dat"));
        int sets = file.nextInt();
        for (int s = 0; s < sets; s++) {
            int a = file.nextInt();
            int b = file.nextInt();
            int c = file.nextInt();
            int d = file.nextInt();
            int e = file.nextInt();
            double expOne = b * Math.log(a);
            double expTwo = d * Math.log(c);
            if (expOne - expTwo > 0 && e == 1 || expOne - expTwo < 0 && e == 2)
                System.out.println("CORRECT");
            else
                System.out.println("INCORRECT");

        }
    }
}
