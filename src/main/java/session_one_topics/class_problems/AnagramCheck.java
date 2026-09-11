package session_one_topics.assignment_problems;

import java.util.Arrays;

public class AnagramCheck {

    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) return false;

        String s1 = str1.replaceAll("\\s+", "").toLowerCase();
        String s2 = str2.replaceAll("\\s+", "").toLowerCase();

        if (s1.length() != s2.length()) return false;

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        String word1 = "Listen";
        String word2 = "Silent";
        String word3 = "Hello";
        String word4 = "World";

        System.out.println("\"" + word1 + "\" and \"" + word2 + "\" are anagrams? " + isAnagram(word1, word2));
        System.out.println("\"" + word3 + "\" and \"" + word4 + "\" are anagrams? " + isAnagram(word3, word4));
    }
}