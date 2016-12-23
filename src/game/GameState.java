package game;

import cards.Card;

import java.util.ArrayList;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class GameState {
    public Player player1;
    public Player player2;

    public TurnStage turnStage;
    public ActivePlayer activePlayer;
    public int turn;

    public GameState(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public TurnStage getTurnStage() {
        return turnStage;
    }

    public void setTurnStage(TurnStage turnStage) {
        this.turnStage = turnStage;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void initGameState() {
        player1.draw(3);
        player2.draw(3);
        setActivePlayer(ActivePlayer.PLAYER_1);
        setTurnStage(TurnStage.CARD_PLAY);
    }

    public Player getActivePlayer() {
        switch (activePlayer) {
            case PLAYER_1:
                return player1;
            case PLAYER_2:
                return player2;
        }
        return player1;
    }

    public Player getNonActivePlayer() {
        switch (activePlayer) {
            case PLAYER_1:
                return player2;
            case PLAYER_2:
                return player1;
        }
        return player2;
    }

    public void setActivePlayer(ActivePlayer activePlayer) {
        this.activePlayer = activePlayer;
    }

    public ArrayList<Card> getOptions() {
        Player currentPlayer = getActivePlayer();
        switch (turnStage) {
            case CARD_PLAY:
                return currentPlayer.getHand().getCards();
            case ATTACK:
                return currentPlayer.getBoard().getMinions();
            case HERO_POWER:
                return currentPlayer.getHero().getHeroPower();
            default:
                return new ArrayList<>();
        }
    }

    public void turnBeginDraw() {
        getActivePlayer().draw(1);
    }

    public void changeActivePlayer() {
        switch (activePlayer) {
            case PLAYER_1:
                activePlayer = ActivePlayer.PLAYER_1;
            case PLAYER_2:
                activePlayer = ActivePlayer.PLAYER_2;
        }
    }

    public void nextStage() {
        switch (turnStage) {
            case CARD_PLAY:
                turnStage = TurnStage.ATTACK;
            case ATTACK:
                turnStage = TurnStage.HERO_POWER;
            case HERO_POWER: {
                turnStage = TurnStage.CARD_PLAY;
                changeActivePlayer();
                turnBeginDraw();
            }
        }
    }
}
