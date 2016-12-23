package cards.mageCards.spells;

import cards.CardClass;
import cards.Spell;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Frostbolt extends Spell {
    public Frostbolt() {
        cardClass = CardClass.MAGE;

        manaCost = 2;

        name = "Frostbolt";
    }
}