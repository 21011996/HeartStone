package cards.commonCards.minions;

import cards.CardClass;
import cards.Minion;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class BoulderfistOgre extends Minion {
    public BoulderfistOgre() {
        cardClass = CardClass.COMMON;

        manaCost = 6;

        defaultHealth = 7;

        attack = 6;

        name = "Boulderfist Ogre";
    }

    @Override
    public void resolve(int target, GameState gameState) {

    }
}