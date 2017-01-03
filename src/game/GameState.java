package game;

import cards.Card;
import cards.Hero;
import cards.Minion;
import cards.Spell;
import cards.commonCards.minions.*;
import cards.mageCards.Medivh;
import cards.mageCards.minions.WaterElemental;
import cards.mageCards.spells.*;
import cards.priestCards.Anduin;
import cards.priestCards.minions.HoodedAcolyte;
import cards.priestCards.minions.KabalTalonpriest;
import cards.priestCards.minions.NorthshireCleric;
import cards.priestCards.spells.HolyNova;
import cards.priestCards.spells.HolySmite;
import cards.priestCards.spells.MindControl;
import cards.priestCards.spells.PowerWordShield;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class GameState {
    public String card;
    public String card2;
    private Player player1;
    private Player player2;
    private TurnStage turnStage;
    private ActivePlayer activePlayer;
    private int turn;

    public GameState(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public GameState() {
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCard2() {
        return card2;
    }

    public void setCard2(String card2) {
        this.card2 = card2;
    }

    public Player getPlayer(int i) {
        switch (i) {
            case 1:
                return player1;
            case 2:
                return player2;
            default:
                return player1;
        }
    }

    public Player getNonPlayer(int i) {
        switch (i) {
            case 1:
                return player2;
            case 2:
                return player1;
            default:
                return player2;
        }
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

    private void setTurnStage(TurnStage turnStage) {
        this.turnStage = turnStage;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void initGameState() {
        turn = 1;
        player1.draw(3);
        player2.draw(3);
        setActivePlayer(ActivePlayer.PLAYER_1);
        getActivePlayer().setManaLeft(turn);
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

    private void setActivePlayer(ActivePlayer activePlayer) {
        this.activePlayer = activePlayer;
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

    public ArrayList<Card> getOptions(int playerId) {
        if (playerId == getActivePlayer().getId()) {
            return getOptions();
        } else {
            return new ArrayList<>();
        }
    }

    public ArrayList<Card> getOptions() {
        Player currentPlayer = getActivePlayer();
        switch (turnStage) {
            case CARD_PLAY:
                //TODO check manacost
                return currentPlayer.getHand().getCards();
            case ATTACK:
                //TODO fix super mega mindfury and charge
                return currentPlayer.getBoard().getMinions();
            case HERO_POWER:
                //TODO check manacost
                return ((Hero) currentPlayer.getHero()).getHeroPower();
            default:
                return new ArrayList<>();
        }
    }

    public ArrayList<Card> getSecondaryOption(int playerId, Card card) {
        if (playerId == getActivePlayer().getId()) {
            return getSecondaryOption(card);
        } else {
            return new ArrayList<>();
        }
    }

    public ArrayList<Card> getSecondaryOption(Card card) {
        ArrayList<Card> target = new ArrayList<>();
        if (card instanceof Spell) {
            switch (((Spell) card).getRequiredTarget()) {
                case ENEMY:
                    target = getNonActivePlayer().getBoard().getMinions();
                    target.add(getNonActivePlayer().getHero());
                    break;
                case FRIENDLY:
                    target = getActivePlayer().getBoard().getMinions();
                    target.add(getActivePlayer().getHero());
                    break;
                case NONE:
                    return new ArrayList<>();
            }
            return target;
        } else if (card instanceof Minion) {
            target = getNonActivePlayer().getBoard().getMinions();
            target.add(getNonActivePlayer().getHero());
            return target;
        }
        return new ArrayList<>();
    }

    public void removeDeadMinions() {
        getActivePlayer().getBoard().removeDeadMinions();
        getNonActivePlayer().getBoard().removeDeadMinions();
    }

    private void turnBeginDraw() {
        getActivePlayer().setManaLeft(turn);
        getActivePlayer().draw(1);
    }

    private void changeActivePlayer() {
        switch (activePlayer) {
            case PLAYER_1: {
                activePlayer = ActivePlayer.PLAYER_2;
                turn = turn >= 10 ? 10 : turn + 1;
                break;
            }
            case PLAYER_2:
                activePlayer = ActivePlayer.PLAYER_1;
                break;
        }
    }

    public void nextStage() {
        switch (turnStage) {
            case CARD_PLAY:
                turnStage = TurnStage.ATTACK;
                break;
            case ATTACK:
                turnStage = TurnStage.HERO_POWER;
                break;
            case HERO_POWER: {
                turnStage = TurnStage.CARD_PLAY;
                changeActivePlayer();
                turnBeginDraw();
                refreshMinions();
                break;
            }
        }
    }

    void refreshMinions() {
        getActivePlayer().getBoard().refreshMinions();
    }

    public GameState createExample() {
        ArrayList<Card> deck1 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            deck1.add(new HolySmite());
            deck1.add(new NorthshireCleric());
            deck1.add(new PowerWordShield());
            deck1.add(new BloodfenRaptor());
            deck1.add(new RiverCrocolisk());
            deck1.add(new ColiseumManager());
            deck1.add(new KabalTalonpriest());
            deck1.add(new RazorfenHunter());
            deck1.add(new ChillwindYeti());
            deck1.add(new GnomishInventor());
            deck1.add(new HoodedAcolyte());
            deck1.add(new SenjinShieldmasta());
            deck1.add(new DarkscaleHealer());
            deck1.add(new HolyNova());
            deck1.add(new MindControl());
        }

        ArrayList<Card> deck2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            deck2.add(new ArcaneBlast());
            deck2.add(new BloodfenRaptor());
            deck2.add(new RiverCrocolisk());
            deck2.add(new Frostbolt());
            deck2.add(new ArcaneIntellect());
            deck2.add(new SpiderTank());
            deck2.add(new ChillwindYeti());
            deck2.add(new Fireball());
            deck2.add(new GnomishInventor());
            deck2.add(new SenjinShieldmasta());
            deck2.add(new WaterElemental());
            deck2.add(new FenCreeper());
            deck2.add(new BoulderfistOgre());
            deck2.add(new Flamestrike());
        }
        deck2.add(new FlameLance());
        deck2.add(new CapturedJormungar());

        Player player1 = new Player(new Anduin(), 1, new Deck(deck1));
        Player player2 = new Player(new Medivh(), 2, new Deck(deck2));
        GameState answer = new GameState(player1, player2);
        answer.initGameState();
        return answer;
    }
}
