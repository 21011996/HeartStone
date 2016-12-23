package cards.commonCards.minions;

import cards.CardClass;
import cards.Minion;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class BloodfenRaptor extends Minion {
    public BloodfenRaptor() {
        cardClass = CardClass.COMMON;

        manaCost = 2;

        defaultHealth = 2;

        attack = 3;

        name = "Bloodfen Raptor";
    }

    @Override
    public void resolve(int target, GameState gameState) {

    }
}