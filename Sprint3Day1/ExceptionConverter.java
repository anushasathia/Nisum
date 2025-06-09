import java.io.IOException;
import java.io.UncheckedIOException; 

class LegacyDataService {
    public String fetchData() throws IOException {
        throw new IOException("Data retrieval failed");
    }
}
public class ExceptionConverter {

    public String performWrappedOperation() {
        LegacyDataService service = new LegacyDataService();
        try {
            return service.fetchData();
        } catch (IOException checkedException) {
            throw new UncheckedIOException("An underlying I/O operation failed", checkedException);
        }
    }

    public static void main(String[] args) {
        ExceptionConverter converter = new ExceptionConverter();

        System.out.println("Attempting to perform wrapped operation");

        try {
            String fetchedData = converter.performWrappedOperation();
            System.out.println("Data fetched: " + fetchedData);
        } catch (UncheckedIOException runtimeException) {
            System.out.println("Caught an unchecked I/O exception: " + runtimeException.getMessage());
            System.out.println("Original cause: " + runtimeException.getCause().getMessage());
        } catch (Exception generalException) {
            System.out.println("Caught an unexpected error: " + generalException.getMessage());
        }
    }
}
