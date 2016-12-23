package game;

import cards.Card;
import cards.Minion;
import cards.MinionStatus;

import java.util.ArrayList;
import java.util.function.Predicate;

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

    public ArrayList<Card> getCards() {
        return minions;
    }

    public void playMinion(Card card) {
        minions.add(card);
    }

    public Card getMinion(int id) {
        return minions.get(id);
    }

    public void removeDeadMinions() {
        minions.removeIf(new Predicate<Card>() {
            @Override
            public boolean test(Card card) {
                if (card instanceof Minion) {
                    return ((Minion) card).minionStatus == MinionStatus.DEAD;
                } else {
                    return true;
                }
            }
        });
    }

    public void removeMinion(int id) {
        minions.remove(id);
    }
}
