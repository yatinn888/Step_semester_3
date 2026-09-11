package session_one_topics.assignment_problems;

public class CountVowelsConsonants {

    public static void analyzeText(String input) {
        if (input == null) {
            System.out.println("Input is null.");
            return;
        }

        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;
        int specialChars = 0;

        String text = input.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (ch >= '0' && ch <= '9') {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            } else {
                specialChars++;
            }
        }

        System.out.println("Input Text: \"" + input + "\"");
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
        System.out.println("Special Characters: " + specialChars);
    }

    public static void main(String[] args) {
        analyzeText("Hello World! 2026");
    }
}