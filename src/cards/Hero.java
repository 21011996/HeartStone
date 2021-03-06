package cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public abstract class Hero extends Minion {
    public HeroStatus heroStatus = HeroStatus.ALIVE;
    public HeroPower heroPower;

    public HeroStatus getHeroStatus() {
        return heroStatus;
    }

    public ArrayList<Card> getHeroPower() {
        return new ArrayList<>(Collections.singletonList(heroPower));
    }

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
