class UserDetails {
    public String name;
    public int id;
    public String email;
    private String password;
    private String creditCard;
    private double creditCardBalance;

    public UserDetails(String name, int id, String email, String password, String creditCard, double creditCardBalance) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.creditCardBalance = creditCardBalance;
    }

    public String getMaskedCreditCard() {
        return "****-****-****-" + creditCard.substring(creditCard.length() - 4);
    }

    public double getCreditCardBalance() {
        return creditCardBalance;
    }
}

public class java5 {
    public static void main(String[] args) {
        UserDetails user = new UserDetails("Anusha", 1001, "xyz@gmail.com", "1234", "1234567812345602", 15000.50);

        System.out.println("\n--- User Details ---");
        System.out.println("Name: " + user.name);
        System.out.println("ID: " + user.id);
        System.out.println("Email: " + user.email);
        System.out.println("Masked Credit Card: " + user.getMaskedCreditCard());
        System.out.println("Credit Card Balance: ₹" + user.getCreditCardBalance());
    }
}