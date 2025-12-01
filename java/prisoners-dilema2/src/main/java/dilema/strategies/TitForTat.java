package dilema.strategies;

import dilema.GameChoice;

public class TitForTat extends Strategy {

    public TitForTat(){
        super("Tit for Tat");
    }

    @Override
    public GameChoice choice(GameChoice othersPreviousChoice) {
        return othersPreviousChoice == GameChoice.NONE ? GameChoice.COOPERATE : othersPreviousChoice;
    }
}
