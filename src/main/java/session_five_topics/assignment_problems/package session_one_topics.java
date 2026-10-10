package session_one_topics.assignment_problems;

public class TypingSpeedAccuracy {
    public static void checkTypingAccuracy(String original, String typed) {
        int matches = 0;
        int total = original.length();
        int firstMismatchIndex = -1;

        for (int i = 0; i < total; i++) {
            if (i < typed.length() && original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatchIndex == -1) {
                firstMismatchIndex = i;
            }
        }

        double accuracy = ((double) matches / total) * 100;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matches, total, accuracy);
        if (firstMismatchIndex != -1) {
            char originalChar = original.charAt(firstMismatchIndex);
            char typedChar = (firstMismatchIndex < typed.length()) ? typed.charAt(firstMismatchIndex) : ' ';
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n", 
                (firstMismatchIndex + 1), originalChar, typedChar);
        } else {
            System.out.println(" | No Mismatches");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}