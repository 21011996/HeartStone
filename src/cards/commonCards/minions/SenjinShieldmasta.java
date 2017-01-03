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
public class SenjinShieldmasta extends Minion {
    public SenjinShieldmasta() {
        cardClass = CardClass.COMMON;

        manaCost = 4;

        defaultHealth = 5;
        currentHealth = defaultHealth;
        attack = 3;

        name = "Senjin Shieldmasta";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {

    }
}