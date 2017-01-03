package cards.priestCards.minions;

import cards.Card;
import cards.CardClass;
import cards.Minion;
import game.GameState;

import static cards.RequiredTarget.NONE;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class NorthshireCleric extends Minion {
    public NorthshireCleric() {
        cardClass = CardClass.PRIEST;
        manaCost = 1;
        name = "Northshire Cleric";
        defaultHealth = 3;
        currentHealth = defaultHealth;
        attack = 1;
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {

    }
}
