package cards.mageCards.spells;

import cards.CardClass;
import cards.RequiredTarget;
import cards.Spell;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Fireball extends Spell {
    public Fireball() {
        cardClass = CardClass.MAGE;

        manaCost = 4;

        name = "Fireball";
        requiredTarget = RequiredTarget.ENEMY;
    }

    @Override
    public void resolve(int target, GameState gameState) {
        gameState.getNonActivePlayer().getMinion(target).takeDamage(6);
    }
}