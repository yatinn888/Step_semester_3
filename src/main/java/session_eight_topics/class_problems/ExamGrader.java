package session_eight_topics.class_problems;

import java.util.Scanner;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String text, String correctAnswer, String studentAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();
    public abstract String getTypeName();
}

class MCQQuestion extends Question {
    public MCQQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
    @Override public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }
    @Override public String getTypeName() { return "MCQ"; }
}

class TFQuestion extends Question {
    public TFQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
    @Override public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }
    @Override public String getTypeName() { return "TF"; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
    @Override public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        for (String kw : keywords) {
            String trimmed = kw.trim();
            if (studentAnswer.toLowerCase().contains(trimmed.toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0.0;
    }
    @Override public String getTypeName() { return "ESSAY"; }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();

        Question[] questions = new Question[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            
            String[] tokens = parseCommandLine(line.substring(firstSpace + 1));
            String qText = tokens[0];
            String corr = tokens[1];
            String stud = tokens[2];
            int pts = Integer.parseInt(tokens[3]);

            if (type.equals("MCQ")) {
                questions[i] = new MCQQuestion(qText, corr, stud, pts);
            } else if (type.equals("TF")) {
                questions[i] = new TFQuestion(qText, corr, stud, pts);
            } else if (type.equals("ESSAY")) {
                questions[i] = new EssayQuestion(qText, corr, stud, pts);
            }
        }

        double totalScore = 0;
        for (Question q : questions) {
            double score = q.calculateScore();
            totalScore += score;
            System.out.printf("%s: %.2f%n", q.getTypeName(), score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
        scanner.close();
    }

    private static String[] parseCommandLine(String str) {
        java.util.List<String> list = new java.util.ArrayList<>();
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("[^\"\s]+|\"([^\"]*)\"").matcher(str);
        while (m.find()) {
            if (m.group(1) != null) list.add(m.group(1));
            else list.add(m.group());
        }
        return list.toArray(new String[0]);
    }
}