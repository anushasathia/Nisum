import java.util.*;
import java.util.function.Predicate;

public class ValidationDemo {

    public static class ValidationException extends RuntimeException {
        private final List<String> errors;

        public ValidationException(List<String> errors) {
            super("Validation failed: See getErrors() for details.");
            this.errors = errors;
        }

        public List<String> getErrors() {
            return errors;
        }
    }

    public interface Validator<T> {
        Optional<String> validate(T t);

        static <T> Validator<T> of(Predicate<T> predicate, String message) {
            return t -> predicate.test(t) ? Optional.empty() : Optional.of(message);
        }
    }

    public static class ValidationEngine<T> {
        private final List<Validator<T>> validators = new ArrayList<>();

        public ValidationEngine<T> addRule(Validator<T> validator) {
            validators.add(validator);
            return this;
        }

        public void validate(T object) {
            List<String> errors = validators.stream()
                    .map(v -> v.validate(object))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

            if (!errors.isEmpty()) {
                throw new ValidationException(errors);
            }
        }
    }

    public record User(String name, String email, int age) {}
    public static void main(String[] args) {
        User user = new User("Anusha", "xyz.com", -5);

        ValidationEngine<User> userValidator = new ValidationEngine<User>()
                .addRule(Validator.of(u -> u.name() != null && u.name().length() >= 3, "Name must be at least 3 characters"))
                .addRule(Validator.of(u -> u.email() != null && u.email().contains("@"), "Email must contain '@'"))
                .addRule(Validator.of(u -> u.age() >= 0, "Age cannot be negative"));

        try {
            userValidator.validate(user);
        } catch (ValidationException e) {
            System.out.println("Validation errors:");
            e.getErrors().forEach(System.out::println);
        }
    }
}