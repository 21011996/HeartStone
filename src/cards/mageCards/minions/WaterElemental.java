package cards.mageCards.minions;

import cards.Card;
import cards.CardClass;
import cards.Minion;
import game.GameState;

import static cards.RequiredTarget.NONE;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class WaterElemental extends Minion {

    public WaterElemental() {
        cardClass = CardClass.MAGE;

        manaCost = 4;

        defaultHealth = 6;
        currentHealth = defaultHealth;
        attack = 3;

        name = "Water Elemental";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {

    }
}