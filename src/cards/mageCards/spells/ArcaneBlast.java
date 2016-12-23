package cards.mageCards.spells;

import cards.CardClass;
import cards.Minion;
import cards.RequiredTarget;
import cards.Spell;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class ArcaneBlast extends Spell {


    public ArcaneBlast() {
        cardClass = CardClass.MAGE;

        manaCost = 1;

        name = "Arcane Blast";
        requiredTarget = RequiredTarget.ENEMY;
    }

    @Override
    public void resolve(int target, GameState gameState) {
        ((Minion) gameState.getNonActivePlayer().getMinion(target)).takeDamage(2);
    }
}
