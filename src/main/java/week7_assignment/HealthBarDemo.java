package week7_assignment;

class Character {
    private int health;
    private final int maxHealth;

    // Constructor: set maximum health and start at full health
    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    // Take damage (clamp at 0)
    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
        System.out.println("After taking " + amount + " damage, health = " + health);
    }

    // Heal (clamp at maxHealth)
    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
        System.out.println("After healing " + amount + ", health = " + health);
    }

    // Read-only access to current health
    public int getHealth() {
        return health;
    }
}

public class HealthBarDemo {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);   // health = 70
        c.heal(50);         // health = 100 (capped)
        c.takeDamage(150);  // health = 0 (floored)

        System.out.println("Final health: " + c.getHealth());
    }
}

