public class BookStore {
    static {
        System.out.println("Static Block: Loading book data...");
    }

    static void showBooks() {
        System.out.println("Static Method: Displaying available books.");
    }

    public static void main(String[] args) {
        showBooks();
    }
}
