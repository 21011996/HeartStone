package cards.commonCards.minions;

import cards.CardClass;
import cards.Minion;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class ChillwindYeti extends Minion {
    public ChillwindYeti() {
        cardClass = CardClass.COMMON;

        manaCost = 4;

        defaultHealth = 5;

        attack = 4;

        name = "Chillwind Yeti";
    }

    @Override
    public void resolve(int target, GameState gameState) {

    }
}