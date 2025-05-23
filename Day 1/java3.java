import java.util.Scanner;

class UserProfile {
    String name;
    int age;
    String email;

    public UserProfile(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void displayInfo() {
        System.out.println("\n--- User Profile ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }
}

public class java3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        UserProfile user = new UserProfile(name, age, email);

        user.displayInfo();

        scanner.close();
    }
}