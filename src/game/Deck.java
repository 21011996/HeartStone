package game;

import cards.Card;

import java.util.*;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Deck {
    public LinkedList<Card> deck;

    public Deck(Card... cards) {
        deck = new LinkedList<>();
        deck.addAll(Arrays.asList(cards));
        Collections.shuffle(deck);
    }

    public Deck(ArrayList<Card> deck) {
        this.deck = new LinkedList<>();
        this.deck.addAll(deck);
        Collections.shuffle(this.deck);
    }

    public List<Card> draw(int count) {
        ArrayList<Card> answer = new ArrayList<>();
        int i = count;
        while (!deck.isEmpty() && i > 0) {
            answer.add(deck.remove());
            i--;
        }
        return answer;
    }

    public int deckSize() {
        return deck.size();
    }
}
