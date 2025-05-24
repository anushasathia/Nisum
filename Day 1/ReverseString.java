import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        StringBuffer buffer = new StringBuffer(input);
        buffer.reverse();

        System.out.println("Reversed string: " + buffer);

        scanner.close();
    }
}