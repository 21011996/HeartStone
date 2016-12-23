package game;

import cards.Card;

import java.util.ArrayList;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Hand {
    public ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCards(ArrayList<Card> cards) {
        this.cards.addAll(cards);
    }

    public void playCard(int id) {
        this.cards.remove(id);
    }

    public int handSize() {
        return cards.size();
    }
}
