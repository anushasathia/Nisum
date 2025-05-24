public class RemoveMultipleSpaces {
    public static void main(String[] args) {
        String text = "This   is  a   sentence    with   multiple spaces.";

        String cleaned = text.replaceAll("\\s+", " ");

        System.out.println(cleaned);
    }
}