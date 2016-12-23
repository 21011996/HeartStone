package cards.commonCards.minions;

import cards.CardClass;
import cards.Minion;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class CapturedJormungar extends Minion {
    public CapturedJormungar() {
        cardClass = CardClass.COMMON;

        manaCost = 7;

        defaultHealth = 9;

        attack = 5;

        name = "Captured Jormungar";
    }

    @Override
    public void resolve(int target, GameState gameState) {

    }
}