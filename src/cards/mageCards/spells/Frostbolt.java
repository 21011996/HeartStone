package cards.mageCards.spells;

import cards.*;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Frostbolt extends Spell {
    public Frostbolt() {
        cardClass = CardClass.MAGE;

        manaCost = 2;

        name = "Frostbolt";
        requiredTarget = RequiredTarget.ENEMY;
    }

    @Override
    public void resolve(Card target, GameState gameState) {
        ((Minion) target).takeDamage(3);
    }
}