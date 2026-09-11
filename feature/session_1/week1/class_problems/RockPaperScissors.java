package week1.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    static String getComputerMove(Random random) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        return moves[random.nextInt(3)];
    }

    static String formatMove(String move) {
        move = move.trim().toLowerCase();

        if (move.equals("rock")) return "Rock";
        if (move.equals("paper")) return "Paper";
        if (move.equals("scissors")) return "Scissors";

        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int rounds = 5;
        int wins = 0, losses = 0, draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        for (int i = 0; i < rounds; i++) {
            String playerMove;

            do {
                System.out.print("Round " + (i + 1) +
                        " - Enter Rock, Paper or Scissors: ");
                playerMove = formatMove(sc.nextLine());

                if (playerMove.isEmpty()) {
                    System.out.println("Invalid move. Try again.");
                }
            } while (playerMove.isEmpty());

            String computerMove = getComputerMove(random);
            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%d     | %-11s | %-13s | %s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        sc.close();
    }
}
