package cards.mageCards.spells;

import cards.*;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Flamestrike extends Spell {
    public Flamestrike() {
        cardClass = CardClass.MAGE;

        manaCost = 7;

        name = "Flamestrike";
        requiredTarget = RequiredTarget.NONE;
    }

    @Override
    public void resolve(int target, GameState gameState) {
        for (Card minion : gameState.getNonActivePlayer().getBoard().getMinions()) {
            ((Minion) minion).takeDamage(4);
        }
    }
}