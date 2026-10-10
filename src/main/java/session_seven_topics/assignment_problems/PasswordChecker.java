package session_seven_topics.assignment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password == null) return "Weak";
        int len = password.length();
        if (len < 6) {
            return "Weak";
        } else if (len <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println(pc.getStrength()); // Weak
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength()); // Strong
    }
}