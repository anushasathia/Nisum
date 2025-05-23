// Method Overloading Example in Java
public class OverloadingExample {

    // Method with 1 int parameter
    void display(int a) {
        System.out.println("Method with 1 int: " + a);
    }

    // Method with 2 int parameters
    void display(int a, int b) {
        System.out.println("Method with 2 ints: " + a + ", " + b);
    }

    // Method with 1 double parameter
    void display(double a) {
        System.out.println("Method with 1 double: " + a);
    }

    // Method with String parameter
    void display(String msg) {
        System.out.println("Method with 1 String: " + msg);
    }

    public static void main(String[] args) {
        OverloadingExample obj = new OverloadingExample();

        obj.display(10);
        obj.display(10, 20);
        obj.display(3.14);
        obj.display("Hello Java");
    }
}
