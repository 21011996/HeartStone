package cards.commonCards.minions;

import cards.CardClass;
import cards.Minion;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class GnomishInventor extends Minion {
    public GnomishInventor() {
        cardClass = CardClass.COMMON;

        manaCost = 4;

        defaultHealth = 4;

        attack = 2;

        name = "Gnomish Inventor";
    }

    @Override
    public void resolve(int target, GameState gameState) {
        gameState.getActivePlayer().draw(1);
    }
}