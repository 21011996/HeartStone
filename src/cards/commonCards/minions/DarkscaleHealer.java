package cards.commonCards.minions;

import cards.CardClass;
import cards.Minion;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class DarkscaleHealer extends Minion {
    public DarkscaleHealer() {
        cardClass = CardClass.COMMON;

        manaCost = 5;

        defaultHealth = 5;

        attack = 4;

        name = "Darkscale Healer";
    }
}