package game;

import cards.Card;
import cards.Minion;

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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCards(ArrayList<Card> cards) {
        this.cards.addAll(cards);
    }

    public void playCard(Card toPlay, Card target, GameState gameState) {
        this.cards.remove(toPlay);
        toPlay.resolve(target, gameState);
        if (toPlay instanceof Minion) {
            ((Minion) toPlay).currentHealth = ((Minion) toPlay).defaultHealth;
        }
    }

    public int handSize() {
        return cards.size();
    }
}
