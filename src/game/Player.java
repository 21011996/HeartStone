package game;

import cards.Card;
import cards.Hero;
import cards.Minion;

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

    public void playCard(int id, int target, GameState gameState) {
        Card toPlay = hand.getCards().get(id);
        if (canPlay(toPlay)) {
            hand.playCard(id, target, gameState);
            spendMana(toPlay.getManaCost());
        }
    }

    public Minion getMinion(int id) {
        return board.getMinion(id);
    }

    public void removeMinion(int id) {
        board.removeMinion(id);
    }

    public void addMinion(Minion minion) {
        board.playMinion(minion);
    }

    public boolean canPlay(Card card) {
        return card.getManaCost() <= manaLeft;
    }

    public void spendMana(int mana) {
        manaLeft -= mana;
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
