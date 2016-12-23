package game;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class GameState {
    public Player player1;
    public Player player2;

    public int turn;

    public GameState(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
}
