package dilema.strategies;

import dilema.GameChoice;

public abstract class Strategy {

    protected final String name;

    public Strategy(String name) {
        this.name = name;
    }

    // GameChoice can be NONE, COOPERATE, DEFECT.
    //! Is NONE by default, but NONE is an invalid choice to make and will count as a DEFECT.
    abstract public GameChoice choice(GameChoice othersPreviousChoice);

    @Override
    public String toString() {
        return this.name;
    }
}
