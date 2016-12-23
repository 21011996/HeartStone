package cards;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public abstract class Card {
    public CardClass cardClass;

    public CardClass getCardClass() {
        return cardClass;
    }

    public int manaCost;

    public abstract int getManaCost();

    public String name;

    public abstract String getName();
}
