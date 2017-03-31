
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
        // create a scanner to scan input
        Scanner input = new Scanner(System.in);


        //ask player 1 to type in word for player 2 to guess
        System.out.println("Player 1: Enter a word for Player 2 to guess:");

        //store input in strings
        //stores the word that will be later converted into '-' 
        String secretWord = input.nextLine();
        //stores the entered word in letters
        String realWord = secretWord;

        //create loop to clear the screen
        for (int space = 0; space < 25; space++) {
            System.out.println("\n");
        }

        //calculate word length
        int length = secretWord.length();

        //replace Player 1's word with dashes
        //create setup for Player 2
        for (int i = 0; i < length; i++) {
            String temp = secretWord.substring(i, i + 1);
            secretWord = secretWord.replace(temp, "-");
        }
        //word is hidden with dashes
        System.out.println(secretWord);

        //created a counter to count the position
        int counter = 1;

        //create a counter for the number of lives
        int lives = 6;

        //create StringBuilder to be able to modify Player 1's word easier
        StringBuilder temp = new StringBuilder(secretWord);


        //Initiate Player 2 to start guessing
        //create loop
        while (lives > 0) {
            System.out.println("Player 2: You have " + lives + " lives left. Guess a letter:");
            //stores guessed letter as string
            String guess = input.nextLine();

            //convert upper case into lowercase
            guess = guess.toLowerCase();

            //checks first letter guess if multiple letters were entered
            char guessCharacter = guess.charAt(0);

            //take input to match with Player 1's word
            //create a loop
            for (int i = 0; i < length; i++) {

                //if guess matches with any letter in Player 1's word
                if (guessCharacter == realWord.charAt(i)) {
                    //sets letter in the position 'i' as the guessed letter
                    temp.setCharAt(i, guessCharacter);
                    System.out.println("Congrats you got one!");
                }

                //counter decrease for position 
                counter--;

                //counter increase for position 
                counter++;
            }
            //if guess does not match with any letter in Player 1's word
            if (counter > temp.length()) {
                //decrease counter for number of lives
                System.out.println("You lost a life Try again");
                lives = lives - 1;
            }
            //output correct letter in position on Player 1's mystery word
            System.out.println(temp);
        }
    }
}
