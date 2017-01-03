import cards.Minion;
import cards.commonCards.minions.RazorfenHunter;
import cards.mageCards.minions.WaterElemental;

import java.util.ArrayList;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ArrayList<Minion> test = new ArrayList<>();
        test.add(new WaterElemental());
        test.add(new RazorfenHunter());
        ArrayList<Minion> testo = new ArrayList<>();
        testo.addAll(test);
        testo.get(0).takeDamage(3);
    }
}
