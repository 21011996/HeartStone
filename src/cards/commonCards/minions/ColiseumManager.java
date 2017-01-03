package cards.commonCards.minions;

import cards.Card;
import cards.CardClass;
import cards.Minion;
import game.GameState;

import static cards.RequiredTarget.NONE;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class ColiseumManager extends Minion {
    public ColiseumManager() {
        cardClass = CardClass.COMMON;

        manaCost = 3;

        defaultHealth = 5;
        currentHealth = defaultHealth;
        attack = 2;

        name = "Coliseum Manager";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {

    }
}