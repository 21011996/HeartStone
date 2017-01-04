package cards.commonCards.minions;

import cards.Card;
import cards.CardClass;
import cards.Hero;
import cards.Minion;
import game.GameState;

import static cards.RequiredTarget.NONE;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class DarkscaleHealer extends Minion {
    public DarkscaleHealer() {
        cardClass = CardClass.COMMON;

        manaCost = 5;

        defaultHealth = 5;
        currentHealth = defaultHealth;
        attack = 4;

        name = "Darkscale Healer";
        requiredTarget = NONE;
    }

    @Override
    public void resolve(Card target, GameState gameState) {
        ((Hero) gameState.getActivePlayer().getHero()).heal(2);
        for (Card card : gameState.getActivePlayer().getBoard().getMinions()) {
            ((Minion) card).heal(2);
        }
    }
}