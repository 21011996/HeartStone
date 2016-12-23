package cards.commonCards.minions;

import cards.CardClass;
import cards.Minion;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class ColiseumManager extends Minion {
    public ColiseumManager() {
        cardClass = CardClass.COMMON;

        manaCost = 3;

        defaultHealth = 5;

        attack = 2;

        name = "Coliseum Manager";
    }

    @Override
    public void resolve(int target, GameState gameState) {

    }
}