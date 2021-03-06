package game;

import cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Deck {
    private LinkedList<Card> deck;
    private int currId = 0;

    public Deck(Card... cards) {
        deck = new LinkedList<>();
        deck.addAll(Arrays.asList(cards));
        for (Card card : deck) {
            card.setId(currId++);
        }
        Collections.shuffle(deck);
    }

    public Deck(ArrayList<Card> deck) {
        this.deck = new LinkedList<>();
        this.deck.addAll(deck);
        for (Card card : deck) {
            card.setId(currId++);
        }
        Collections.shuffle(this.deck);
    }

    public ArrayList<Card> draw(int count) {
        ArrayList<Card> answer = new ArrayList<>();
        int i = count;
        while (!deck.isEmpty() && i > 0) {
            answer.add(deck.remove());
            i--;
        }
        return answer;
    }

    public void add(Card card) {
        deck.add(card);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public int deckSize() {
        return deck.size();
    }
}
