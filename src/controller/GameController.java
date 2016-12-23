package controller;

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

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String getGame(ModelMap map) {
        prepareModelMap(map, gameState, 1);
        return "index";
    }

    @RequestMapping(value = "/get-player", method = RequestMethod.GET)
    public String getGamePlayer(@RequestParam String name, ModelMap map) {
        prepareModelMap(map, gameState, Integer.parseInt(name));
        return "index";
    }

    private void prepareModelMap(ModelMap map, GameState gameState, int playerNo) {
        map.addAttribute("gameState", gameState);
        map.addAttribute("playerNo", playerNo);
    }
}
