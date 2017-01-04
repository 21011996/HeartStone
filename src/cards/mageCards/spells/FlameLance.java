package cards.mageCards.spells;

import cards.*;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class FlameLance extends Spell {
    public FlameLance() {
        cardClass = CardClass.MAGE;

        manaCost = 5;

        name = "Flame Lance";
        requiredTarget = RequiredTarget.ENEMY_MINIONS;
    }

    @Override
    public void resolve(Card target, GameState gameState) {
        ((Minion) target).takeDamage(8);
    }
}