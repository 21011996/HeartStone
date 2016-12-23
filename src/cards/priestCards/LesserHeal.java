package cards.priestCards;

import cards.CardClass;
import cards.HeroPower;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class LesserHeal extends HeroPower {
    public LesserHeal(){
        cardClass = CardClass.PRIEST;
        manaCost = 2;
        name = "Lesser Heal";
    }
}
