public class CharArrayToString {
    public static void main(String[] args) {
        Character[] charArray = {'H', 'e', 'l', 'l', 'o'};

        char[] primitiveCharArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            primitiveCharArray[i] = charArray[i];
        }

        String result = new String(primitiveCharArray);

        System.out.println(result);
    }
}