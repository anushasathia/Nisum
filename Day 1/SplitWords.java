import java.util.Scanner;

public class SplitWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String[] words = sentence.split(" ");

        System.out.println("The words are:");
        for (String word : words) {
            System.out.println(word);
        }

        scanner.close();
    }
}