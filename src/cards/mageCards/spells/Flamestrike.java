package cards.mageCards.spells;

import cards.CardClass;
import cards.Spell;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Flamestrike extends Spell {
    public Flamestrike() {
        cardClass = CardClass.MAGE;

        manaCost = 7;

        name = "Flamestrike";
    }
}