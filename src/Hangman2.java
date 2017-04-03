
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author simon7323
 */
public class Hangman2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a scanner to scan user input
        Scanner input = new Scanner(System.in);

        //ask Player 1 to enter word for Player 2 to guess
        System.out.println("Enter a word for Player 2 to guess:");

        //store Player 1 input that will be later converted into '-'
        String word = input.nextLine();

        //store word in letters
        String secretWord = word;

        //create loop to clear screen
        for (int space = 0; space < 25; space++) {
            System.out.println("\n");
        }

        //create set up for Player 2
        //calculate word length
        int length = word.length();
        //replace letters with '-'
        for (int i = 0; i < length; i++) {
            String temp = word.substring(i, i + 1);
            word = word.replace(temp, "-");
        }


    }
}
