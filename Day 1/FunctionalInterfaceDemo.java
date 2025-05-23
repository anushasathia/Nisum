@FunctionalInterface
interface Greeting {
    void sayHello();
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Greeting greet = () -> System.out.println("Hello from functional interface!");
        greet.sayHello();
    }
}
