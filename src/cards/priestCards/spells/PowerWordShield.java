package cards.priestCards.spells;

import cards.CardClass;
import cards.RequiredTarget;
import cards.Spell;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class PowerWordShield extends Spell{
    public PowerWordShield() {
        requiredTarget = RequiredTarget.FRIENDLY;
        cardClass = CardClass.PRIEST;

        manaCost = 10;

        name = "Mind Control";
    }

    @Override
    public void resolve(int target, GameState gameState) {
        gameState.getActivePlayer().draw(1);
        gameState.getActivePlayer().getMinion(target).addHealth(2);
    }
}
