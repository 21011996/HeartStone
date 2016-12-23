package game;

/**
 * @author Ilya239.
 *         Created on 23.12.2016.
 */
public enum TurnStage {
    CARD_PLAY("Card play"), ATTACK("Attack"), HERO_POWER("Hero powering");

    private final String text;

    /**
     * @param text
     */
    private TurnStage(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
