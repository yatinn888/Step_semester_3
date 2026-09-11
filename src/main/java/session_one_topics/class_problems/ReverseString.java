package session_one_topics.class_problems;

public class ReverseString {

    public static String reverseWithStringBuilder(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    public static String reverseWithLoop(String input) {
        if (input == null) return null;
        char[] chars = input.toCharArray();
        String reversed = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }
        return reversed;
    }

    public static void main(String[] args) {
        String testInput = "Java Programming";

        System.out.println("Original String: " + testInput);
        System.out.println("Reversed (StringBuilder): " + reverseWithStringBuilder(testInput));
        System.out.println("Reversed (Loop): " + reverseWithLoop(testInput));
    }
}