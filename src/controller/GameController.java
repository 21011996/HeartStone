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

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String getGame(ModelMap map) {
        prepareModelMap(map, gameState, 1);
        return "index";
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public String refresh(ModelMap map) {
        gameState = new GameState().createExample();
        cardToPlay = new DebugCard();
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
        do {
            gameState.nextStage();
        } while (gameState.getOptions().isEmpty());
        prepareModelMap(map, gameState, 1);
        return "redirect:/get-player";
    }

    @RequestMapping(value = "/end-stage2", method = RequestMethod.GET)
    public String endStage2(ModelMap map) {
        do {
            gameState.nextStage();
        } while (gameState.getOptions().isEmpty());
        prepareModelMap(map, gameState, 2);
        return "redirect:/get-player";
    }

    @RequestMapping(value = "/play-card", method = RequestMethod.GET)
    public String playCard(@RequestParam String card, ModelMap map) {
        cardToPlay = new DebugCard();
        for (Card card2 : gameState.getOptions()) {
            if (card2.getId() == Integer.parseInt(card)) {
                cardToPlay = card2;
                break;
            }
        }
        if (gameState.getSecondaryOption(cardToPlay).size() != 0) {
            prepareModelMap(map, gameState, gameState.getActivePlayer().getId(), cardToPlay);
            return "index";
        } else {
            gameState.getActivePlayer().playCard(cardToPlay, new DebugCard(), gameState);
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
                gameState.getActivePlayer().playCard(cardToPlay, card, gameState);
                break;
            }
            case ATTACK: {
                ((Minion) cardToPlay).trade(card);
                break;
            }
            case HERO_POWER: {
                gameState.getActivePlayer().playCard(cardToPlay, card, gameState);
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
