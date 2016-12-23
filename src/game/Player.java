package game;

import cards.Hero;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Player {
    public Hero hero;
    public Board board;
    public Deck deck;
    public Hand hand;

    public int manaLeft;
    public int id;

    public Player(Hero hero, int id) {
        this.hero = hero;
        board = new Board();
        deck = new Deck();
        hand = new Hand();
        this.id = id;
    }

    public void playCard(int id, GameState gameState) {
        hand.playCard(id, gameState);
    }

    public Hero getHero() {
        return hero;
    }

    public Board getBoard() {
        return board;
    }

    public Deck getDeck() {
        return deck;
    }

    public Hand getHand() {
        return hand;
    }

    public void draw(int count) {
        hand.addCards(deck.draw(count));
    }
}
