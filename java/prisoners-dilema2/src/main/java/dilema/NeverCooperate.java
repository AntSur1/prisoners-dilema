package dilema;

import dilema.strategies.Strategy;

public class NeverCooperate extends Strategy {
    public NeverCooperate() {
        super("Never Coop");
    }

    @Override
    public GameChoice choice(GameChoice othersPreviousChoice) {
        return GameChoice.DEFECT;
    }
}
