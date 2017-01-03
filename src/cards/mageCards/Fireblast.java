package cards.mageCards;

import cards.*;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Fireblast extends HeroPower {
    public Fireblast(){
        cardClass = CardClass.MAGE;
        manaCost = 2;
        name = "Fireblast";
        requiredTarget = RequiredTarget.ENEMY;
    }

    @Override
    public void resolve(Card target, GameState gameState) {
        ((Minion) target).takeDamage(1);
    }
}
