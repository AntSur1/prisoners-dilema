package dilema;

import dilema.strategies.TitForTat;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- App start --- \n");
        DilemaGame game = new DilemaGame(3, new NeverCooperate(), new TitForTat());

        game.playGame();

        System.out.println(" \n--- App end ---");

    }
}