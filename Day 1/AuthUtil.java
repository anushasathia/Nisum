import java.util.regex.*;

public class AuthUtil {
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static boolean isValidPassword(String password) {
        if (password == null) return false;
        boolean hasLetter = password.matches(".*[a-zA-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        return hasLetter && hasDigit && hasSpecial;
    }

    public static void main(String[] args) {
        String user = "test@example.com";
        String pass = "abc@123";

        if (isValidEmail(user) && isValidPassword(pass)) {
            System.out.println("Login details are valid.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
