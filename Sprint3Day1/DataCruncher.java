import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataCruncher {

    public void processMyNumbersFromFile(String fileLocation) {
        System.out.println("Trying to read numbers from: " + fileLocation);
        try (FileReader fileStream = new FileReader(fileLocation);
             BufferedReader lineReader = new BufferedReader(fileStream)) {

            String oneLine;
            int lineNumber = 0;
            while ((oneLine = lineReader.readLine()) != null) {
                lineNumber++;
                int myNumber = Integer.parseInt(oneLine);
                System.out.println("Found a number on line " + lineNumber + ": " + myNumber);
            }
            System.out.println("Finished processing numbers from the file.");

        } catch (IOException | NumberFormatException anErrorHappened) {
            System.out.println("Something went wrong while processing the file.");
            System.out.println("Problem: " + anErrorHappened.getClass().getSimpleName() + " - " + anErrorHappened.getMessage());
        }
    }

    public static void main(String[] args) {
        DataCruncher myTool = new DataCruncher();

        String goodFilePath = "my_numbers.txt"; 
        String missingFilePath = "no_such_file_here.txt"; 

        myTool.processMyNumbersFromFile(goodFilePath);

        System.out.println("Testing with a missing file now");

        myTool.processMyNumbersFromFile(missingFilePath);

        System.out.println("All done with file parsing tests");
    }
}
