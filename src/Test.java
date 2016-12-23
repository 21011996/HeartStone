import game.GameState;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        GameState gameState = new GameState().createExample();
        gameState.nextStage();
    }
}
