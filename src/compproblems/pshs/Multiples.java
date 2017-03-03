package compproblems.pshs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Multiples {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/competitions/pshs/multiples.dat"));

        while (file.hasNext()) {
            String[] s = file.nextLine().split(" ");
            long[] x = new long[s.length];
            for (int i = 0; i < x.length; i++)
                x[i] = Long.parseLong(s[i]);

            System.out.println(lcm(x));
        }
    }

    private static long lcm(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }

    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    private static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
