import java.io.FileOutputStream; // This is the new way to write to files
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class MyGlobalErrorHandler implements Thread.UncaughtExceptionHandler {
    private String logFilePath;

    public MyGlobalErrorHandler(String path) {
        this.logFilePath = path;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        // Now using FileOutputStream, also inside try-with-resources!
        try (FileOutputStream fileOutputStream = new FileOutputStream(logFilePath, true)) {

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            
            // I have to put all the text into one big string first
            // And then convert that string into bytes, because FileOutputStream writes bytes, not characters directly
            String logEntry = "----------------------------------------\n" +
                              "Time: " + timestamp + "\n" +
                              "Problem in Thread: " + t.getName() + "\n" +
                              "Error Type: " + e.getClass().getName() + "\n" +
                              "Message: " + e.getMessage() + "\n" +
                              "More Details: " + e.toString() + "\n" + // Still using e.toString() for simplicity
                              "----------------------------------------\n";
            
            fileOutputStream.write(logEntry.getBytes()); // Write the string as bytes

            System.err.println("Uh oh! An unhandled error happened. Look in: " + logFilePath);

        } catch (IOException logWriteError) {
            System.err.println("Double trouble! Couldn't even write the error to the log file: " + logWriteError.getMessage());
        }
    }
}

public class TheProblematicApp {

    public void doSomethingRisky() {
        int firstNum = 10;
        int secondNum = 0;
        int badResult = firstNum / secondNum; 
        System.out.println("Result was: " + badResult);
    }

    public static void main(String[] args) {
        String myLogFile = "app_stuff_log.txt";

        Thread.setDefaultUncaughtExceptionHandler(new MyGlobalErrorHandler(myLogFile));

        System.out.println("Starting my application...");

        TheProblematicApp myMainThing = new TheProblematicApp();

        System.out.println("Calling a method that might make a mistake...");
        myMainThing.doSomethingRisky();

        System.out.println("This line probably won't show if something went wrong above.");
        System.out.println("Application finished."); 
    }
}
