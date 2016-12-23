package cards;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public abstract class Hero extends Card {
    public HeroStatus heroStatus = HeroStatus.ALIVE;

    public int currentHealth;
    public int defaultHealth;

    public HeroPower heroPower;

    public int getDefaultHealth(){
        return defaultHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth <= 0) {
            heroStatus = HeroStatus.DEAD;
        }
    }

    public void heal(int healAmount) {
        if (currentHealth + healAmount <= defaultHealth) {
            currentHealth += healAmount;
        } else {
            currentHealth = defaultHealth;
        }
    }
}
