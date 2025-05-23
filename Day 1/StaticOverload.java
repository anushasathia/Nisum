public class StaticOverload {
    static void greet() {
        System.out.println("Hello!");
    }

    static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    static void greet(String name, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Hi " + name);
        }
    }

    public static void main(String[] args) {
        greet();
        greet("Anil");
        greet("Sara", 2);
    }
}
