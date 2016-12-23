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

    public Player(Hero hero) {
        this.hero = hero;
        board = new Board();
        deck = new Deck();
        hand = new Hand();
    }
}
