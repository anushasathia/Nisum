interface Greeting {
    static void sayHello() {
        System.out.println("Hello from static method in interface!");
    }
}

public class StaticInterfaceDemo {
    public static void main(String[] args) {
        Greeting.sayHello();
    }
}
