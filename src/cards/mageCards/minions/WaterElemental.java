package cards.mageCards.minions;

import cards.CardClass;
import cards.Minion;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class WaterElemental extends Minion {

    public WaterElemental() {
        cardClass = CardClass.MAGE;

        manaCost = 4;

        defaultHealth = 6;

        attack = 3;

        name = "Water Elemental";
    }

    @Override
    public void resolve(int target, GameState gameState) {

    }
}