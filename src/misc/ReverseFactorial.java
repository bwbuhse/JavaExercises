package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReverseFactorial {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("reversefactorial.in"));

        while (file.hasNext()) {
            int num = file.nextInt();
            int i = 2;
            System.out.print(num);
            while (num % i == 0)
                num /= i++;
            System.out.println(i % num == 0 ? " = " + (i - 1) + "!" : "   NONE");
        }

    }
}
