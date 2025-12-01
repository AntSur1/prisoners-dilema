package dilema;

import dilema.strategies.Strategy;

import java.util.ArrayList;
import java.util.List;

public class DilemaGame {
    private final int rounds;
    private final Strategy player1;
    private final Strategy player2;
    private int p1score = 0;
    private int p2score = 0;
    private GameChoice p1lastChoice = GameChoice.NONE;
    private GameChoice p2lastChoice = GameChoice.NONE;
    private final List<RoundResult> history = new ArrayList<>();

    public DilemaGame(int rounds, Strategy player1, Strategy player2) {
        this.rounds = rounds;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playGame() {
        System.out.println("Game started");
        System.out.printf("%d rounds%n\n", rounds);
        System.out.printf("%s vs %s\n", player1, player2);

        for (int i = 0; i < rounds; i++) {
            runNextRound(i);
        }

        System.out.println("Results:");

        if (p1score == p2score) {
            System.out.printf("Draw %d\n", p1score);
        } else if (p1score > p2score) {
            System.out.printf("%s won %d\n", player1, p1score);
            System.out.printf("%s %d\n", player2, p2score);
        } else {
            System.out.printf("%s won %d\n", player2, p2score);
            System.out.printf("%s %d\n", player1, p1score);
        }

        System.out.printf("History %s\n", history);
    }

    private void runNextRound(int round) {
        //System.out.printf("round %d\n", round);
        GameChoice p1Choice = this.player1.choice(p2lastChoice);
        GameChoice p2Choice = this.player2.choice(p1lastChoice);

        p1lastChoice = p1Choice == GameChoice.NONE ? GameChoice.DEFECT : p1Choice;
        p2lastChoice = p2Choice == GameChoice.NONE ? GameChoice.DEFECT : p2Choice;

        RoundResult roundResult = resolve(p1lastChoice, p2lastChoice);

        switch (roundResult) {
            case COO_COO:
                p1score += 3;
                p2score += 3;
                break;

            case COO_DEF:
                p2score += 5;
                break;

            case DEF_COO:
                p1score += 5;
                break;

            case DEF_DEF:
                p1score += 1;
                p2score += 1;
                break;
        }

        history.add(roundResult);
    }

    private RoundResult resolve(GameChoice p1, GameChoice p2) {
        String key = p1 + "_" + p2;

        return switch (key) {
            case "COOPERATE_COOPERATE" -> RoundResult.COO_COO;
            case "COOPERATE_DEFECT" -> RoundResult.COO_DEF;
            case "DEFECT_COOPERATE" -> RoundResult.DEF_COO;
            case "DEFECT_DEFECT" -> RoundResult.DEF_DEF;
            default -> throw new IllegalStateException("Unexpected key: " + key);
        };
    }

    private enum RoundResult {
        COO_COO, COO_DEF, DEF_COO, DEF_DEF
    }
}
