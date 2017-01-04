package game;

import cards.Card;
import cards.Hero;
import cards.HeroStatus;
import cards.Minion;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Player {
    private Hero hero;
    private Board board;
    private Deck deck;
    private Hand hand;
    private int id;
    private int manaLeft;

    public Player(Hero hero, int id, Deck deck) {
        this.hero = hero;
        board = new Board();
        this.deck = deck;
        hand = new Hand();

        this.id = id;
    }

    public boolean alive() {
        return hero.getHeroStatus() == HeroStatus.ALIVE;
    }

    public int getId() {
        return id;
    }

    public int getManaLeft() {
        return manaLeft;
    }

    public void setManaLeft(int manaLeft) {
        this.manaLeft = manaLeft;
    }

    public void playCard(Card toPlay, Card target, GameState gameState) {
        if (canPlay(toPlay)) {
            hand.playCard(toPlay, target, gameState);
            spendMana(toPlay.getManaCost());
            if (toPlay instanceof Minion) {
                board.playMinion(toPlay);
            }
        }
    }

    public Card getMinion(int id) {
        return board.getMinion(id);
    }

    public void removeMinion(Card id) {
        board.removeMinion(id);
    }

    public void addMinion(Minion minion) {
        board.playMinion(minion);
    }

    private boolean canPlay(Card card) {
        return card.getManaCost() <= manaLeft;
    }

    private void spendMana(int mana) {
        manaLeft -= mana;
    }

    public Card getHero() {
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
