import java.io.Closeable;
import java.io.IOException;

class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class AgeChecker implements Closeable {

    public void checkThisAge(int inputAge) {
        if (inputAge <= 0) {
            throw new InvalidAgeException("Age is a problem: 0 or less");
        }
        System.out.println("Age " + inputAge + " looks good");
    }

    public void close() throws IOException {
        System.out.println("Age checker is done");
    }

    public static void main(String[] args) {
        try (AgeChecker myCheckerThing = new AgeChecker()) {

            int goodAge = 25;
            myCheckerThing.checkThisAge(goodAge);

            int badAgeZero = 0;
            myCheckerThing.checkThisAge(badAgeZero); 

            int negativeAge = -5;
            myCheckerThing.checkThisAge(negativeAge); 

        } catch (InvalidAgeException ageTrouble) {
            System.out.println("Caught an age error: " + ageTrouble.getMessage());
        } catch (Exception anyOtherTrouble) {
            System.out.println("Caught some unexpected error: " + anyOtherTrouble.getMessage());
        }

    }
}
