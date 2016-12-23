package cards.commonCards.minions;

import cards.CardClass;
import cards.Minion;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class SpiderTank extends Minion {
    public SpiderTank() {
        cardClass = CardClass.COMMON;

        manaCost = 3;

        defaultHealth = 4;

        attack = 3;

        name = "SpiderTank";
    }
}