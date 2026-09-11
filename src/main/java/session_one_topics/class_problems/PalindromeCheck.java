package session_one_topics.class_problems;

public class PalindromeCheck {

    public static boolean isPalindrome(String input) {
        if (input == null) return false;

        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanInput.length() - 1;

        while (left < right) {
            if (cleanInput.charAt(left) != cleanInput.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {"madam", "A man, a plan, a canal: Panama", "hello", "racecar"};

        for (String test : testCases) {
            System.out.printf("\"%s\" is palindrome? %b%n", test, isPalindrome(test));
        }
    }
}