package cards.priestCards.minions;

import cards.CardClass;
import cards.Minion;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class KabalTalonpriest extends Minion {
    public KabalTalonpriest() {
        cardClass = CardClass.PRIEST;

        manaCost = 3;

        defaultHealth = 4;

        attack = 3;

        name = "Kabal Talonpriest";
    }

    @Override
    public void resolve(int target, GameState gameState) {
        ((Minion) gameState.getActivePlayer().getMinion(target)).addHealth(3);
    }
}