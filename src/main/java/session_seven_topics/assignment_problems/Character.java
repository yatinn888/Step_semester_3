package session_seven_topics.assignment_problems;

public class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            currentHealth -= amount;
            if (currentHealth < 0) {
                currentHealth = 0;
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            currentHealth += amount;
            if (currentHealth > maxHealth) {
                currentHealth = maxHealth;
            }
        }
    }

    public int getHealth() {
        return currentHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("health = " + c.getHealth()); // 70
        c.heal(50);
        System.out.println("health = " + c.getHealth() + " (capped)"); // 100
        c.takeDamage(150);
        System.out.println("health = " + c.getHealth() + " (floored)"); // 0
    }
}