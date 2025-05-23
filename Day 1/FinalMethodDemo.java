class Calculator {
    final int square(int x) {
        return x * x;
    }

    final int add(int a, int b) {
        return a + b;
    }
}

public class FinalMethodDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Square: " + calc.square(5));
        System.out.println("Add: " + calc.add(3, 7));
    }
}
