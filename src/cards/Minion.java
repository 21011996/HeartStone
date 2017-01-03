package cards;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public abstract class Minion extends Card {
    public MinionStatus minionStatus = MinionStatus.ALIVE;


    public int defaultHealth;
    public int currentHealth = defaultHealth;
    public int attack;
    public boolean exhausted = true;

    public boolean isExhausted() {
        return exhausted;
    }

    public void setExhausted(boolean exhausted) {
        this.exhausted = exhausted;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void trade(Card card) {
        setExhausted(true);
        if (card instanceof Hero) {
            ((Hero) card).takeDamage(getAttack());
        } else if (card instanceof Minion) {
            ((Minion) card).takeDamage(getAttack());
            takeDamage(((Minion) card).getAttack());
        }
    }

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
