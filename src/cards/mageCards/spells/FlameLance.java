package cards.mageCards.spells;

import cards.CardClass;
import cards.Spell;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class FlameLance extends Spell {
    public FlameLance() {
        cardClass = CardClass.MAGE;

        manaCost = 5;

        name = "Flame Lance";
    }
}