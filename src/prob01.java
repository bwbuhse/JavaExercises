import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob01 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("prob01.txt"));

		System.out.printf("Hello, %s. We are Ben, Marcus, and Sam.", file.next());
	}
}
