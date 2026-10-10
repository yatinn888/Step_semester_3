package session_eight_topics.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();
    public String getName() { return name; }
    public LocalDate getStartDate() { return startDate; }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public int getValidityDays() { return 30; }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public int getValidityDays() { return 90; }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public int getValidityDays() { return 365; }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        SubscriptionPlan[] plans = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());

            if (type.equals("BASIC")) {
                plans[i] = new BasicPlan(name, startDate);
            } else if (type.equals("STANDARD")) {
                plans[i] = new StandardPlan(name, startDate);
            } else if (type.equals("PREMIUM")) {
                plans[i] = new PremiumPlan(name, startDate);
            }
        }

        for (SubscriptionPlan plan : plans) {
            LocalDate renewalDate = plan.getStartDate().plusDays(plan.getValidityDays());
            System.out.println(plan.getName() + ": " + renewalDate);
        }
        scanner.close();
    }
}