package cards.commonCards.minions;

import cards.Card;
import cards.CardClass;
import cards.Minion;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class DarkscaleHealer extends Minion {
    public DarkscaleHealer() {
        cardClass = CardClass.COMMON;

        manaCost = 5;

        defaultHealth = 5;

        attack = 4;

        name = "Darkscale Healer";
    }

    @Override
    public void resolve(int target, GameState gameState) {
        for (Card card : gameState.getActivePlayer().getBoard().getMinions()) {
            ((Minion) card).heal(2);
        }
    }
}