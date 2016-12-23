package game;

import cards.Card;

import java.util.ArrayList;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Board {
    public ArrayList<Card> minions;

    public Board() {
        minions = new ArrayList<>();
    }

    public ArrayList<Card> getMinions() {
        return minions;
    }

    public void playMinion(Card card) {
        minions.add(card);
    }
}
