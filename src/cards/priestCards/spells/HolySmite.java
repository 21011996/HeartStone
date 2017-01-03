package cards.priestCards.spells;

import cards.*;
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
    public void resolve(Card target, GameState gameState) {
        ((Minion) target).takeDamage(2);
    }
}
