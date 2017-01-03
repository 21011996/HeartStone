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
public class CapturedJormungar extends Minion {
    public CapturedJormungar() {
        cardClass = CardClass.COMMON;

        manaCost = 7;

        defaultHealth = 9;
        currentHealth = defaultHealth;
        attack = 5;

        name = "Captured Jormungar";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {

    }
}