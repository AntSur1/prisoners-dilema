package dilema.strategies;

import dilema.GameChoice;

public class AlwaysCooperateStrat extends Strategy {

    public AlwaysCooperateStrat() {
        super("Cooperative Nick");
    }

    @Override
    public GameChoice choice(GameChoice othersPreviousChoice) {
        return GameChoice.COOPERATE;
    }
}
