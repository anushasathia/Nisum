public class MyDivisionAssignment {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero tried");
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        MyDivisionAssignment divisionCalculator = new MyDivisionAssignment();

        int num1 = 150;
        int num2 = 15;
        try {
            int result1 = divisionCalculator.divide(num1, num2);
            System.out.println("Result of " + num1 + " / " + num2 + " is: " + result1);
        } catch (ArithmeticException e) {
            System.out.println("Error during division: " + e.getMessage());
        }

        int num3 = 75;
        int num4 = 0; 
        try {
            int result2 = divisionCalculator.divide(num3, num4);
            System.out.println("This line should not be printed: " + result2);
        } catch (ArithmeticException e) {
            System.out.println("Successfully caught division error: " + e.getMessage());
            System.out.println("Attempted to divide " + num3 + " by " + num4);
        }
    }
}
