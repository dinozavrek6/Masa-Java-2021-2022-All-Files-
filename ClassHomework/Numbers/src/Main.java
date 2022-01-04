import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main
{
	private static Scanner scanner;

	public static void main(String[] args)
	{
		System.out.println("Enter numbers (for example: 1 2 3 4 5 12 135 23 etc...): ");
		scanner = new Scanner(System.in);
		String numbers = scanner.nextLine();
		
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(numbers.split(" ")));
		System.out.println(set);
	}
}
