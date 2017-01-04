package game;

import cards.Minion;
import cards.commonCards.minions.RazorfenHunter;
import cards.priestCards.minions.NorthshireCleric;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Ilya239.
 *         Created on 04.01.2017.
 */
public class BoardTest {

    private GameState gameState = new GameState().createExample();
    private NorthshireCleric northshireCleric = new NorthshireCleric();

    @Test
    public void playMinion() throws Exception {
        gameState.getActivePlayer().getHand().playCard(new RazorfenHunter(), null, gameState);
        assertEquals("Sheep", gameState.getActivePlayer().getBoard().getMinions().get(0).getName());
    }

    @Test
    public void refreshMinions() throws Exception {
        gameState.getActivePlayer().getBoard().playMinion(northshireCleric);
        assertEquals(true, ((Minion) gameState.getActivePlayer().getBoard().getMinions().get(0)).isExhausted());
        gameState.getActivePlayer().getBoard().refreshMinions();
        assertEquals(false, ((Minion) gameState.getActivePlayer().getBoard().getMinions().get(0)).isExhausted());
    }

    @Test
    public void removeMinion() throws Exception {
        gameState.getActivePlayer().getBoard().removeMinion(northshireCleric);
        assertEquals(0, gameState.getActivePlayer().getBoard().getMinions().size());
    }

}