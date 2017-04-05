

import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author simon7323
 */
public class Hangman {

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

        //convert word to lowercase
        word = word.toLowerCase();

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

        //print out word with replaced dashes
        System.out.println(word);

        //create variables
        //create counter to keep track of position
        int counter = 1;
        //create counter to keep track the number of lives
        int lives = 6;
        //check if user guessed correctly or not
        boolean correct = true;
        //check to see if game is still running or not
        boolean finished = false;
        //counter to keep track number of correct guesses
        int realWord = 0;

        //create a StringBuilder to manipulate strings easier
        StringBuilder build = new StringBuilder(word);

        //create a loop to keep game running
        while (lives > 0 && !finished) {
            //Initiate player 2 to guess
            System.out.println("Player 2: You have " + lives + " lives left. Guess a letter.");

            //take Player 2's guess and store as string
            String guess = input.nextLine();

            //convert letter entered into lowercase
            guess = guess.toLowerCase();

            //check first letter entered if there are multiple letters entered
            char guessCharacter = guess.charAt(0);

            //resets the guess everytime to default
            correct = true;
            //create a loop to check Player 2's guess matches up with Player 1's mystery word
            for (int i = 0; i < build.length();) {

                //guess is correct, replace guessed letter in position of the word
                if (guessCharacter == secretWord.charAt(i)) {
                    build.setCharAt(i, guessCharacter);
                    correct = false;
                    //decrease counter
                    counter--;
                    //increase correct guesses
                    realWord++;
                    //increase counter
                    counter++;
                }
                //increase position to go on to next letter
                i++;

            }
            //reveal guessed letter in the word
            word = build.toString();
            System.out.println(word);

            //when guessed letter is correct
            if (correct == false) {
                System.out.println("Congrats! You got a correct letter!");
                //when guessed letter is incorrect
            } else {
                System.out.println("You are incorrect. Try again!");
                lives--;
            }
            //reset counter back to 1
            counter = 1;

            //if player guessed the word, toggle game finished
            if (realWord == secretWord.length()) {

                System.out.println("Congratulations, you've won!");
                //resets variable for correct guesses matches up with length of word
                finished = true;
            }
        }
        //if player runs out of lives, game over.
        if (lives == 0) {
            System.out.println("Looks like you're out of lives, Game over.");
            System.out.println("The word was '" + secretWord + "' ");
        }
    }
}
