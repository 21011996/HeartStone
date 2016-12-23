package cards.priestCards.minions;

import cards.CardClass;
import cards.Minion;

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
        attack = 1;
    }
}
