package cards.mageCards.spells;

import cards.CardClass;
import cards.Spell;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Fireball extends Spell {
    public Fireball() {
        cardClass = CardClass.MAGE;

        manaCost = 4;

        name = "Fireball";
    }
}