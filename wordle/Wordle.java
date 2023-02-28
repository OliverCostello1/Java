package wordle;

import java.util.Locale;
import java.util.Scanner;

// TERMINAL WORDLE GAME
public class Wordle {
    public static void main(String[] args) {

        // Colors
        final String BG_GREEN = "\u001b[42m";
        final String BG_YELLOW = "\u001b[43m";
        final String RESET = "\u001b[0m";

        System.out.println("WORDLE GAME: GUESS THE 5 LETTER WORD");
        String correct = "SHAKE";
        Scanner sc = new Scanner(System.in);
        String guess = "";
        // Loop guesses
        for (int round =0; round <6; round++){
            System.out.print("Guess: ");
            guess = sc.nextLine().toUpperCase();
            int lengthGuess = guess. length();
            // LOOP TO ITERATE THROUGH EACH LETTER
            for (int i=0;i<5;i++) {
                if (lengthGuess != 5){
                    System.out.print("Guess must be 5 letters long. Try again:");
                    break;
                }
                else if (guess.substring(i, i + 1).equals(correct.substring(i, i + 1))) {
                    // Letter is in correct location of word
                    System.out.print(BG_GREEN + guess.substring(i, i + 1) + RESET);
                } else if (correct.contains(guess.substring(i, i + 1))) {
                    // Letter is in word but not in correct location
                    System.out.print(BG_YELLOW + guess.charAt(i) + RESET);
                }
                else {
                    // Letter not in word
                    System.out.print(guess.substring(i, i+1));
                }
            }

            System.out.println("");

           if (guess.equals(correct)) {
               System.out.print("Well Done - Correct!");
               break;
            }
        }
        // Print correct answer if player loses
        if (!guess.equals(correct)) {
            System.out.println("Wrong! Correct answer is: " + correct + ".");
        }

    }
}

