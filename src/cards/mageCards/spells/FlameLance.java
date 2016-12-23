package cards.mageCards.spells;

import cards.CardClass;
import cards.RequiredTarget;
import cards.Spell;
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
        requiredTarget = RequiredTarget.ENEMY;
    }

    @Override
    public void resolve(int target, GameState gameState) {
        gameState.getNonActivePlayer().getMinion(target).takeDamage(8);
    }
}