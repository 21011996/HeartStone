package cards.priestCards.spells;

import cards.CardClass;
import cards.Minion;
import cards.RequiredTarget;
import cards.Spell;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class HolySmite extends Spell {
    public HolySmite() {
        cardClass = CardClass.PRIEST;

        manaCost = 1;

        name = "Holy Smite";
        requiredTarget = RequiredTarget.ENEMY;
    }

    @Override
    public void resolve(int target, GameState gameState) {
        ((Minion) gameState.getNonActivePlayer().getMinion(target)).takeDamage(2);
    }
}
