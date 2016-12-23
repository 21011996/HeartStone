package cards.commonCards.minions;

import cards.CardClass;
import cards.Minion;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class SenjinShieldmasta extends Minion {
    public SenjinShieldmasta() {
        cardClass = CardClass.COMMON;

        manaCost = 4;

        defaultHealth = 5;

        attack = 3;

        name = "Senjin Shieldmasta";
    }
}