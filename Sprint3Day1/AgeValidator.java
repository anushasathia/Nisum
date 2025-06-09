class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class AgeValidator {
    public void validateAge(int inputAge) {
        if (inputAge <= 0) {
            throw new InvalidAgeException("Age cannot be 0 or negative");
        }
        System.out.println("Age " + inputAge + " is valid");
    }

    public static void main(String[] args) {
        AgeValidator validator = new AgeValidator();

        int normalAge = 20;
        try {
            validator.validateAge(normalAge);
        } catch (InvalidAgeException ageIssue) {
            System.out.println("InvalidAgeException occurred: " + ageIssue.getMessage());
        } catch (Exception unexpectedIssue) {
            System.out.println("An unexpected error occurred: " + unexpectedIssue.getMessage());
        }

        int zeroAge = 0;
        try {
            validator.validateAge(zeroAge);
        } catch (InvalidAgeException ageIssue) {
            System.out.println("InvalidAgeException occurred for age 0: " + ageIssue.getMessage());
        } catch (Exception unexpectedIssue) {
            System.out.println("An unexpected error occurred for age 0: " + unexpectedIssue.getMessage());
        }

        int negativeAge = -20;
        try {
            validator.validateAge(negativeAge);
        } catch (InvalidAgeException ageIssue) {
            System.out.println("InvalidAgeException occurred for negative age: " + ageIssue.getMessage());
        } catch (Exception unexpectedIssue) {
            System.out.println("An unexpected error occurred for negative age: " + unexpectedIssue.getMessage());
        }
    }
}
