class User {
    private static User instance;
    private String name;
    private String email;

    private User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static User getInstance(String name, String email) {
        if (instance == null) {
            instance = new User(name, email);
        }
        return instance;
    }

    public void showUser() {
        System.out.println("User Name: " + name);
        System.out.println("Email: " + email);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        User user1 = User.getInstance("Anjali", "anjali@example.com");
        user1.showUser();

        User user2 = User.getInstance("Ravi", "ravi@example.com");
        user2.showUser();  // Will still show Anjali's data
    }
}
