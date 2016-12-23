package cards.mageCards.spells;

import cards.CardClass;
import cards.RequiredTarget;
import cards.Spell;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class ArcaneIntellect extends Spell {
    public ArcaneIntellect() {
        cardClass = CardClass.MAGE;

        manaCost = 3;

        name = "Arcane Intellect";
        requiredTarget = RequiredTarget.NONE;
    }

    @Override
    public void resolve(int target, GameState gameState) {
        gameState.getActivePlayer().draw(2);
    }
}