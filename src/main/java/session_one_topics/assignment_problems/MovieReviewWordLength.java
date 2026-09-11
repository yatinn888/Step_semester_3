package session_one_topics.assignment_problems;

public class MovieReviewWordLength {
    public static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortWords = 0, mediumWords = 0, longWords = 0;

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            int len = cleanWord.length();

            if (len >= 1 && len <= 4) {
                shortWords++;
            } else if (len >= 5 && len <= 8) {
                mediumWords++;
            } else if (len >= 9) {
                longWords++;
            }
        }

        System.out.println("Review: \"" + review + "\"");
        System.out.printf("Short Words (1-4): %d | Medium Words (5-8): %d | Long Words (9+): %d%n%n", 
            shortWords, mediumWords, longWords);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}