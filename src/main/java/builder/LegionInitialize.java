package builder;

import game.Legion;
import validation.ArgumentValidator;

public class LegionInitialize {
    public Legion init(ArgumentValidator validator) {
        Legion legion = new Legion(validator);
        legion.play();
        return legion;
    }
}