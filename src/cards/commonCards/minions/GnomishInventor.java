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
public class GnomishInventor extends Minion {
    public GnomishInventor() {
        cardClass = CardClass.COMMON;

        manaCost = 4;

        defaultHealth = 4;
        currentHealth = defaultHealth;
        attack = 2;

        name = "Gnomish Inventor";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {
        gameState.getActivePlayer().draw(1);
    }
}