package controller;

import cards.Card;
import cards.Minion;
import cards.debug.DebugCard;
import game.GameState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Ilya239.
 *         Created on 16.12.2016.
 */
@Controller
public class GameController {
    private GameState gameState = new GameState().createExample();
    private Card cardToPlay;
    private int id;

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String getGame(ModelMap map) {
        prepareModelMap(map, gameState, 1);
        return "index";
    }

    @RequestMapping(value = "/get-player", method = RequestMethod.GET)
    public String getGamePlayer(@RequestParam String playerNo, ModelMap map) {
        prepareModelMap(map, gameState, Integer.parseInt(playerNo));
        return "index";
    }

    @RequestMapping(value = "/get-player1", method = RequestMethod.GET)
    public String getGamePlayer1(ModelMap map) {
        prepareModelMap(map, gameState, 1);
        return "redirect:/get-player";
    }

    @RequestMapping(value = "/get-player2", method = RequestMethod.GET)
    public String getGamePlayer2(ModelMap map) {
        prepareModelMap(map, gameState, 2);
        return "redirect:/get-player";
    }

    @RequestMapping(value = "/end-stage1", method = RequestMethod.GET)
    public String endStage1(ModelMap map) {
        gameState.nextStage();
        prepareModelMap(map, gameState, 1);
        return "redirect:/get-player";
    }

    @RequestMapping(value = "/end-stage2", method = RequestMethod.GET)
    public String endStage2(ModelMap map) {
        gameState.nextStage();
        prepareModelMap(map, gameState, 2);
        return "redirect:/get-player";
    }

    @RequestMapping(value = "/play-card", method = RequestMethod.GET)
    public String playCard(@RequestParam String card, ModelMap map) {
        Card card1 = null;
        for (Card card2 : gameState.getOptions()) {
            if (card2.getId() == Integer.parseInt(card)) {
                card1 = card2;
                break;
            }
            id++;
        }
        cardToPlay = card1;
        if (gameState.getSecondaryOption(card1).size() != 0) {
            prepareModelMap(map, gameState, gameState.getActivePlayer().getId(), card1);
            return "index";
        } else {
            gameState.getActivePlayer().playCard(id, new DebugCard(), gameState);
            gameState.removeDeadMinions();
            prepareModelMap(map, gameState, gameState.getActivePlayer().getId());
            return "redirect:/get-player";
        }
    }

    @RequestMapping(value = "/play-target", method = RequestMethod.GET)
    public String playCardTarget(@RequestParam String card2, ModelMap map) {
        Card card = new DebugCard();
        for (Card card3 : gameState.getSecondaryOption(cardToPlay)) {
            if (card3.toString().equals(card2)) {
                card = card3;
                break;
            }
        }
        switch (gameState.getTurnStage()) {
            case CARD_PLAY: {
                gameState.getActivePlayer().playCard(id, card, gameState);
                break;
            }
            case ATTACK: {
                ((Minion) gameState.getActivePlayer().getBoard().getMinion(id)).trade(card);
                break;
            }
            case HERO_POWER: {
                gameState.getActivePlayer().playCard(id, card, gameState);
                break;
            }
        }
        gameState.removeDeadMinions();

        prepareModelMap(map, gameState, gameState.getActivePlayer().getId());
        return "redirect:/get-player";
    }

    private void prepareModelMap(ModelMap map, GameState gameState, int playerNo) {
        map.addAttribute("gameState", gameState);
        map.addAttribute("playerNo", playerNo);
        map.addAttribute("cardPlay", new DebugCard());
    }

    private void prepareModelMap(ModelMap map, GameState gameState, int playerNo, Card card) {
        map.addAttribute("gameState", gameState);
        map.addAttribute("playerNo", playerNo);
        map.addAttribute("cardPlay", card);
    }
}
