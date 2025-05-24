import java.util.HashMap;

public class CharacterCount {
    public static void main(String[] args) {
        String input = "Super Man Bat Man Spider Man";
        input = input.toLowerCase(); // optional: make it case-insensitive

        HashMap<Character, Integer> countMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }

        System.out.println("Character occurrences:");
        for (char c : countMap.keySet()) {
            System.out.println("'" + c + "' : " + countMap.get(c));
        }
    }
}