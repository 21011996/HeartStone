package cards.priestCards;

import cards.Card;
import cards.CardClass;
import cards.Hero;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Anduin extends Hero{
    public Anduin() {
        cardClass = CardClass.PRIEST;
        name = "Anduin";
        defaultHealth = 30;
        currentHealth = 30;
        heroPower = new LesserHeal();
    }

    @Override
    public void resolve(Card target, GameState gameState) {
    }
}
