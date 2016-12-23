package cards.mageCards.minions;

import cards.CardClass;
import cards.Minion;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class WaterElemental extends Minion {
    public CardClass cardClass = CardClass.MAGE;

    public int manaCost = 4;

    public int defaultHealth = 6;

    public int attack = 3;

    public String name = "Water Elemental";

    public WaterElemental() {
        CardClass cardClass = CardClass.MAGE;

        manaCost = 4;

        defaultHealth = 6;

        attack = 3;

        name = "Water Elemental";
    }
}