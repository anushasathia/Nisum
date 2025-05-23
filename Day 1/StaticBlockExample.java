public class StaticBlockExample {
    static int number;

    static {
        number = 42;
        System.out.println("Static block executed. Number is set to " + number);
    }

    public static void main(String[] args) {
        System.out.println("Main method running.");
    }
}
