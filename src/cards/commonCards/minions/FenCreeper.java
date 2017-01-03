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
public class FenCreeper extends Minion {
    public FenCreeper() {
        cardClass = CardClass.COMMON;

        manaCost = 5;

        defaultHealth = 6;
        currentHealth = defaultHealth;
        attack = 3;

        name = "Fen Creeper";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {

    }
}