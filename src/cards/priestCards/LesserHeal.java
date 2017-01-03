package cards.priestCards;

import cards.*;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class LesserHeal extends HeroPower {
    public LesserHeal(){
        cardClass = CardClass.PRIEST;
        manaCost = 2;
        name = "Lesser Heal";
        requiredTarget = RequiredTarget.FRIENDLY;
    }

    @Override
    public void resolve(Card target, GameState gameState) {
        ((Minion) target).heal(2);
    }
}
