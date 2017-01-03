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

    public void playCard(int id, Card target, GameState gameState) {
        Card playCard = this.cards.remove(id);
        playCard.resolve(target, gameState);
        if (playCard instanceof Minion) {
            ((Minion) playCard).currentHealth = ((Minion) playCard).defaultHealth;
        }
    }

    public int handSize() {
        return cards.size();
    }
}
