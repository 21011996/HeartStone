package game;

import cards.Hero;
import cards.Minion;
import cards.MinionStatus;
import cards.commonCards.minions.ChillwindYeti;
import cards.mageCards.Fireblast;
import cards.mageCards.Medivh;
import cards.priestCards.Anduin;
import cards.priestCards.minions.NorthshireCleric;
import cards.priestCards.spells.MindControl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Ilya239.
 *         Created on 04.01.2017.
 */
public class GameStateTest {
    private GameState gameState;

    @Before
    public void setUp() throws Exception {
        gameState = new GameState().createExample();
    }

    @Test
    public void minionPlayTest() {
        gameState.getActivePlayer().getBoard().playMinion(new NorthshireCleric());
        assertEquals(gameState.getActivePlayer().getBoard().getMinions().get(0).toString(), new NorthshireCleric().toString());
    }

    @Test
    public void takeDamageTest() {
        ((Hero) gameState.getActivePlayer().getHero()).takeDamage(10);
        ((Hero) gameState.getActivePlayer().getHero()).heal(3);
        assertEquals(((Hero) gameState.getActivePlayer().getHero()).getCurrentHealth(), 23);

        NorthshireCleric northshireCleric = new NorthshireCleric();
        northshireCleric.trade(gameState.getActivePlayer().getHero());

        assertEquals(((Hero) gameState.getActivePlayer().getHero()).getCurrentHealth(), 22);
        assertEquals(northshireCleric.getCurrentHealth(), northshireCleric.getDefaultHealth());

        northshireCleric.trade(new ChillwindYeti());
        assertEquals(northshireCleric.getCurrentHealth(), 0);
        assertEquals(northshireCleric.minionStatus, MinionStatus.DEAD);

        ChillwindYeti chillwindYeti = new ChillwindYeti();
        chillwindYeti.takeDamage(3);
        assertEquals(2, chillwindYeti.getCurrentHealth());
    }

    @Test
    public void getPlayer() throws Exception {
        assertEquals(gameState.getPlayer(1).getHero().getName(), new Anduin().getName());
    }

    @Test
    public void getNonPlayer() throws Exception {
        assertEquals(gameState.getNonPlayer(1).getHero().getName(), new Medivh().getName());
    }

    @Test
    public void bothAlive() throws Exception {
        assertEquals(true, gameState.bothAlive());
        ((Hero) gameState.getActivePlayer().getHero()).takeDamage(100);
        assertEquals(false, gameState.bothAlive());
    }

    @Test
    public void getTurnStage() throws Exception {
        assertEquals(TurnStage.CARD_PLAY, gameState.getTurnStage());
        gameState.nextStage();
        assertEquals(TurnStage.ATTACK, gameState.getTurnStage());
    }

    @Test
    public void getOptions() throws Exception {
        setUp();
        assertEquals(0, gameState.getOptions().size());
    }

    @Test
    public void getSecondaryOption() throws Exception {
        assertEquals("Medivh", gameState.getSecondaryOption(new Fireblast()).get(0).getName());
        assertEquals(0, gameState.getSecondaryOption(new MindControl()).size());
    }

    @Test
    public void removeDeadMinions() throws Exception {
        gameState.getActivePlayer().getBoard().playMinion(new ChillwindYeti());
        ((Minion) gameState.getActivePlayer().getBoard().getMinions().get(0)).takeDamage(5);
        gameState.removeDeadMinions();
        assertEquals(0, gameState.getActivePlayer().getBoard().getMinions().size());
    }
}