package cards;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public abstract class Minion extends Card{
    public MinionStatus minionStatus = MinionStatus.ALIVE;

    public int currentHealth;
    public int defaultHealth;

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int attack;

    public int getAttack() {
        return attack;
    }

    // TODO add this
    //public abstract void whenPlayed();

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth <= 0) {
            minionStatus = MinionStatus.DEAD;
        }
    }

    public void addHealth(int healthBuff) {
        defaultHealth += healthBuff;
        currentHealth += healthBuff;
    }

    public void heal(int healAmount) {
        if (currentHealth + healAmount <= defaultHealth) {
            currentHealth += healAmount;
        } else {
            currentHealth = defaultHealth;
        }
    }
}
