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
public class BloodfenRaptor extends Minion {
    public BloodfenRaptor() {
        cardClass = CardClass.COMMON;

        manaCost = 2;

        defaultHealth = 2;
        currentHealth = defaultHealth;
        attack = 3;

        name = "Bloodfen Raptor";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {

    }
}