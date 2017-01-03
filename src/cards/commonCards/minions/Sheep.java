package cards.commonCards.minions;

import cards.CardClass;
import cards.Minion;
import game.GameState;

import static cards.RequiredTarget.NONE;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Sheep extends Minion {
    public Sheep() {
        CardClass cardClass = CardClass.COMMON;

        manaCost = 1;

        defaultHealth = 1;

        currentHealth = defaultHealth;

        attack = 1;

        name = "Sheep";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(int target, GameState gameState) {

    }
}