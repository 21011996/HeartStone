package cards.priestCards.spells;

import cards.*;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class HolyNova extends Spell{
    public HolyNova() {
        cardClass = CardClass.PRIEST;

        manaCost = 5;

        name = "Holy Nova";
        requiredTarget = RequiredTarget.NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {
        for (Card card : gameState.getNonActivePlayer().getBoard().getMinions()) {
            ((Minion) card).takeDamage(2);
        }
        for (Card card : gameState.getActivePlayer().getBoard().getMinions()) {
            ((Minion) card).heal(2);
        }
    }
}
