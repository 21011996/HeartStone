package cards.mageCards.spells;

import cards.CardClass;
import cards.Spell;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class ArcaneIntellect extends Spell {
    public ArcaneIntellect() {
        cardClass = CardClass.MAGE;

        manaCost = 3;

        name = "Arcane Intellect";
    }
}