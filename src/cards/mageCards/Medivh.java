package cards.mageCards;

import cards.Card;
import cards.CardClass;
import cards.Hero;
import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Medivh extends Hero {
    public Medivh() {
        cardClass = CardClass.MAGE;
        name = "Medivh";
        defaultHealth = 30;
        currentHealth = 30;
        heroPower = new Fireblast();
    }

    @Override
    public void resolve(Card target, GameState gameState) {

    }
}
