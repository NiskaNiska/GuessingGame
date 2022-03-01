/**
 * CS1A, Assignment 4, "Guessing Game" 
 * Quarter: Winter 2021
 * @author Tina Shao
 * @author Yuxi Sang
 */
/**
 * The main(String[] args is to keep running the whole program by using
 * while(true) until the user decides to exit the program.
 */
public class Game_Program extends Object
{
    public static void main(String[] args)
    {
        GuessingGame gg = new GuessingGame(); // feel free to add arguments to the constructor, if it helps...
        boolean play_again = true;

        do
        {
            play_again = gg.playGuessingGame();
        } while (play_again == true);

        /*
         * Do whatever else you need to in order to: Step 1:figure out if the game
         * should be played again or that the entire program should quit and Step 2: set
         * the playing variable accordingly. You MUST have the gg.playGuessingGame()
         * method return something, so you will have a variable capture that return (for
         * example you could use the playing variable for that) and use that variable to
         * stop or continue the already written while loop. One example way: if
         * gg.playGuessingGame() == 0 then show a message and quit the game. Remember to
         * adhere to the "Program Guidelines" module item from the first week of the
         * course, such as NOT using the break or continue keywords.
         */
    }
}
