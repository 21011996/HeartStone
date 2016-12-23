import cards.mageCards.minions.WaterElemental;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        WaterElemental waterElemental = new WaterElemental();
        waterElemental.currentHealth = waterElemental.defaultHealth;
        waterElemental.takeDamage(5);
        waterElemental.heal(4);
        waterElemental.addHealth(2);
        System.out.println(waterElemental.getCurrentHealth());
    }
}
