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
public class MindControl extends Spell{
    public MindControl() {
        cardClass = CardClass.PRIEST;

        manaCost = 10;

        name = "Mind Control";

        requiredTarget = RequiredTarget.ENEMY;
    }

    @Override
    public void resolve(int target, GameState gameState) {
        Minion targeted = (Minion) gameState.getNonActivePlayer().getMinion(target);
        gameState.getNonActivePlayer().removeMinion(target);
        gameState.getActivePlayer().addMinion(targeted);
    }
}
