package cards.commonCards.minions;

import cards.Card;
import cards.CardClass;
import cards.Minion;
import game.GameState;

import static cards.RequiredTarget.NONE;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class RiverCrocolisk extends Minion {
    public RiverCrocolisk() {
        cardClass = CardClass.COMMON;

        manaCost = 2;

        defaultHealth = 3;
        currentHealth = defaultHealth;
        attack = 2;

        name = "River Crocolisk";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {

    }
}