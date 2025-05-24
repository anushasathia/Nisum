
import java.util.Scanner;

public class CharAtIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.print("Enter the index to fetch the character from: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < inputString.length()) {
            char result = inputString.charAt(index);
            System.out.println("Character at index " + index + " is: " + result);
        } else {
            System.out.println("The index is out of bounds. Please enter a number between 0 and " + (inputString.length() - 1));
        }

        scanner.close();
    }
}