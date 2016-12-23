package cards.mageCards;

import cards.CardClass;
import cards.Hero;
import cards.HeroPower;
import cards.HeroStatus;

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
}
