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
public class RazorfenHunter extends Minion {
    public RazorfenHunter() {
        cardClass = CardClass.COMMON;

        manaCost = 3;

        defaultHealth = 3;
        currentHealth = defaultHealth;
        attack = 2;

        name = "Razorfen Hunter";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {
        gameState.getActivePlayer().addMinion(new Sheep());
    }
}