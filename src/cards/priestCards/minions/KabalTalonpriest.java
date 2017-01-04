package cards.priestCards.minions;

import cards.Card;
import cards.CardClass;
import cards.Minion;
import game.GameState;

import static cards.RequiredTarget.FRIENDLY_MINIONS;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public class KabalTalonpriest extends Minion {
    public KabalTalonpriest() {
        cardClass = CardClass.PRIEST;

        manaCost = 3;

        defaultHealth = 4;
        currentHealth = defaultHealth;
        attack = 3;

        name = "Kabal Talonpriest";
        requiredTarget = FRIENDLY_MINIONS;
    }

    @Override
    public void resolve(Card target, GameState gameState) {
        ((Minion) target).addHealth(3);
    }
}