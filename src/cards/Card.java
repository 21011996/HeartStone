package cards;

import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public abstract class Card {
    public CardClass cardClass;
    public int manaCost;
    public String name;

    public CardClass getCardClass() {
        return cardClass;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName() {
        return name;
    }

    public abstract void resolve(int target, GameState gameState);

    @Override
    public String toString() {
        return getName() + " (" + getManaCost() + ")";
    }
}
