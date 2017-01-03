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
public class SpiderTank extends Minion {
    public SpiderTank() {
        cardClass = CardClass.COMMON;

        manaCost = 3;

        defaultHealth = 4;
        currentHealth = defaultHealth;
        attack = 3;

        name = "SpiderTank";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {

    }
}