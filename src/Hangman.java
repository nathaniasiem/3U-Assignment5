
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
        String secretWord = input.nextLine();
        for (int space = 0; space < 25; space++) {
            System.out.println("\n");
        }
        //calculate word length
        int length = secretWord.length();
        
        //replace Player 1's word with dashes
        //create setup for Player 2
        for (int i = 0; i < length; i++) {
            String temp = secretWord.substring(i, i+1);
        secretWord = secretWord.replace(temp,"-");    
        }
        
        System.out.println(secretWord);
        
        //
        
        
        
        
        
    }
}
