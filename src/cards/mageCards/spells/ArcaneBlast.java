package cards.mageCards.spells;

import cards.*;
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
    public void resolve(Card target, GameState gameState) {
        ((Minion) target).takeDamage(2);
    }
}
