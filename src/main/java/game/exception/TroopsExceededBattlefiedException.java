package game.exception;

public class TroopsExceededBattlefiedException extends RuntimeException {
    public TroopsExceededBattlefiedException(String message) {
        super(message);
    }
}
