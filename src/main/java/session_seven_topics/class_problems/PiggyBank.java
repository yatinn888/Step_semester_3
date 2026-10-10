package session_seven_topics.class_problems;

public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("savings = " + pb.getSavings()); // 100
        pb.withdraw(30);
        System.out.println("savings = " + pb.getSavings()); // 70
        pb.withdraw(500);
        System.out.println("savings after rejected withdrawal = " + pb.getSavings()); // 70
    }
}