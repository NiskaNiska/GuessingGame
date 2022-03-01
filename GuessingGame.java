
// You may use the nested comments below as hints only. Remember, there is no one right or wrong way 
// to 'solve' this Assignment, so feel free to delete the comments if you find them distracting.

import java.util.Random;
import java.util.Scanner;

/**
 * CS1A, Assignment 4, "Guessing Game" <br>
 * Quarter: Winter2021<br>
 * 
 * Description: This is a program that designed for users to guess a random
 * number between -64 and 64 within 7 guesses. The user will be reminded whether
 * the secret number is bigger or smaller than the guess number each time.<br>
 * 
 * Tip:The most efficiently method is through binary search. That is, guess a
 * sorted range by repeatedly dividing the guess interval in half. If the value
 * is less than the item in the middle of interval, narrow the interval to the
 * lower half. Otherwise narrow it to the upper half.<br>
 * 
 * @author Tina Shao
 * @author Yuxi Sang
 */

public class GuessingGame extends Object
{
    // List any instance variables, including constants, here.
    private static final int MAX_POSSIBLE_GUESS = 64;
    private static final int MIN_POSSIBLE_GUESS = -64; // This is a constant
    // Use an array instance variable to hold the guesses

    Random randomNumberGenerator = new Random();

    // If you need to get a number for the user to guess (randomly),
    // call the method below and it will create one for you.
    // The number may be as low as -64, and as high as 64
    // (This will be 129 separate numbers that the user might try to guess)
    // Of course, you will have to create a variable space to hold this number
    // when it is returned (for example, secretNumber)

    /**
     * The getRandomNumber() method generates a random secret number in the range
     * and store it in the variable.
     * 
     * @return
     */
    private int getRandomNumber()
    {
        int max = MAX_POSSIBLE_GUESS - MIN_POSSIBLE_GUESS;
        int zeroToMax = randomNumberGenerator.nextInt(max + 1);
        int secretNumber = zeroToMax + MIN_POSSIBLE_GUESS;
        return zeroToMax + MIN_POSSIBLE_GUESS;
    }

    // You may want to create a method that will display the welcome message and
    // rules (e.g., welcome)
    /**
     * The welcome() method is to print out the welcome message and game rules at
     * the very beginning.
     */
    private void welcome()
    {
        System.out.println("Welcome!");
        System.out.println("Rules:");
        System.out.println("1) You have 7 guesses");
        System.out.println("2) If you guess the wrong number, a hint will be displayed");
        System.out.println("3) Your guess has to be between -64 and 64");
    }

    /**
     * The isGuessNum(int counter) method is to get the users input, check if it's
     * an integer in the range, store the value in a variable if all the
     * requirements are met.
     * 
     * @param counter
     * @return
     */
    private int isGuessNum(int maximum, int minimum)
    {
        int GuessNum = -65;
        Scanner keyboard = new Scanner(System.in);
        boolean checker = keyboard.hasNextInt();
        while (keyboard.hasNext())
        {
            if (keyboard.hasNextInt())
            {
                GuessNum = keyboard.nextInt();
                if (GuessNum < minimum || GuessNum > maximum)
                {
                    System.out.print("is NOT a number in the valid range! Please enter a whole number: ");

                    keyboard.nextLine();
                } else
                {
                    return GuessNum;
                }
            }
            if (!keyboard.hasNextInt())
            {
                System.out.print("is NOT a number in the valid range! Please enter a whole number: ");
                keyboard.nextLine();
            }
        }
        return GuessNum;
    }

    /**
     * The printGuessed(int GuessNum)is to print out the number that users guessed
     * this time.
     * 
     * @param GuessNum
     * @return
     */
    private int printGuessed(int GuessNum)
    {
        int userinput = GuessNum;
        System.out.println("You guessed: " + userinput);
        return userinput;

    }
    // You may want to create a method (e.g., isGuessNum) that will check to see
    // that the number entered is a whole number,
    // assign it to a variable like userGuess, and then handle all
    // the various options regarding that number: has it been guessed before?; is it
    // the secret number?; if it isn't the secret number store it in the proper
    // location for cross checking; display messages regarding the number of guesses
    // made,
    // incorrect guesses, guesses remaining, secret number if all guesses used up,
    // error handling, etc.

    // You may want to create a method to print the user's previous guesses

    // You may want to create a method to store the user's guesses in the 8 elements
    // of the array
    /**
     * The method array(int userinput, int guessingTimes, int[] userAllGuesses, int
     * MAX_GUESSES) is to check the user input times. If the input times is less
     * than MAX_GUESSES-1, the userinput will be stored in the array. Otherwise, it
     * will just return the array userAllGuess.
     * 
     * @param userinput
     * @param guessingTimes
     * @param userAllGuesses
     * @param MAX_GUESSES
     * @return userAllGuesses
     */
    private int[] array(int userinput, int guessingTimes, int[] userAllGuesses, int MAX_GUESSES)
    {
        userAllGuesses[guessingTimes] = userinput;
        return userAllGuesses;

    }

    // You will NEED a getInput method for getting integer input from the user (see
    // the assignment instructions on applying the techniques of structured
    // (functional) decomposition)).

    // You may want to create a boolean method to check that the user's guess is
    // within range (between a minimum and maximum)
    // and will return true if it is

    // You may want to create a boolean method to see if the number has been guessed
    // previously and will return true if it has
    /**
     * The method checkIfNumberGuessed(int guessingTimes, int userinput, int[]
     * userAllGuesses) is to check if the user input(userinput) matches previous
     * input(userAllGuess). If it matches, the program will print out "You have
     * guessed this number." The counter in this method is to prevent print the line
     * more than one time.
     * 
     * @param guessingTimes
     * @param userinput
     * @param userAllGuesses
     * @return status2
     */
    private boolean checkIfNumberGuessed(int guessingTimes, int userinput, int[] userAllGuesses)
    {
        Boolean[] status = new Boolean[guessingTimes];
        boolean status2 = false;
        int counter = 0;
        for (int i = 0; i < guessingTimes; i++)
        {
            if (userAllGuesses[i] == userinput)
            {
                status2 = true;
                if (counter == 0)
                {
                    System.out.println("You have guessed this number.");
                }

                counter++;
            }
        }
        return status2;
    }

    // You may want to create a boolean method to see if the number matches the
    // secret number and will return true if it does or false if it doesn't
    /**
     * The method CompareWithSecretNumber(int userinput, int secretNumber, int
     * counter) is to compare the user input(userinput) with the secret
     * number(secretNumer). If the two number match, the program will print "You
     * won!", otherwise the program will show the hint.
     * 
     * @param userinput
     * @param secretNumber
     * @param counter
     * @return compare
     */
    private boolean CompareWithSecretNumber(int userinput, int secretNumber, int counter)
    {
        boolean compare = false;
        if (userinput == secretNumber)
        {
            compare = true;
            System.out.println("You won!");
            // playGame();
        } else if (userinput > secretNumber)
        {
            System.out.println("Hint: The correct number is SMALLER than you guessed.");

        } else if (userinput < secretNumber)
        {
            System.out.println("Hint: The correct number is BIGGER than you guessed.");
        }
        return compare;
    }

    // You may want to create a method to give a hint about the number guessed
    // (e.g., "My secret number is GREATER than " or "My secret number is LESS than
    // ")
    /**
     * The method playgame() is to print the choices when the user used all seven
     * times to guess the secret number incorrectly. The user can choose 1 to re-run
     * the whole program or choose 0 to exit the program.
     * 
     * @return userChoice
     */
    private boolean playGame()
    {
        int userChoice = 0;
        System.out.println("1) Enter '1' to play again.");
        System.out.println("2) Enter '0' to quit.");

        int userchoice = isGuessNum(1, 0);
        if (userchoice == 0)
        {
            System.exit(0);
            return false;
        }
        if (userchoice == 1)
        {
            return true;
        } else
        {
            System.out.println("Please enter number 0 or 1.");
        }

        return true;
    }

    // You may want to create a method (e.g., playGame) that will check if the user
    // wants to play again, by calling the method for getting integer input from the
    // user,
    // (1 for 'yes', 0 for 'no') and incorporate the proper functionality depending
    // on the user's choice ( 1 or 0).
    /**
     * The playGuessingGame() method combine methods above. It starts with welcome()
     * method to welcome the user. The for loop in this method calculate the
     * remaining times the user have. isGuessNum method is to check if the user
     * input is a whole number beteween -64 and 64. If the user input is in the
     * range, the input value will pass from isGuessNum(counter) to
     * printGuessed(GuessNum2). The array userAllGuesses2 is to store the input in
     * range to the array. checkIfNumberGuessed(guessingTimes, userinput,
     * userAllGuesses2) is to check if the number guessed
     * before.CompareWithSecretNumber(userinput, secretNumber, i) is to check if the
     * user input match the secret number. playgame() is to print out the choices
     * when the user uses all seven times.
     */

    public boolean playGuessingGame()
    {
        final int MAX_GUESSES = 7;
        int guessesLeft = MAX_GUESSES;
        int[] inputGuess = new int[MAX_GUESSES];
        int counter = 0;
        int guessingTimes = 0;
        int[] userAllGuesses2;
        int secretNumber = this.getRandomNumber();
        boolean status = false;

        // Feel free to move this into another method
        int[] userAllGuesses = new int[MAX_GUESSES];
        boolean play_again = false;
        boolean compare = false;
        welcome();// You might call a welcome() method here instead

        int i = 0;
        while ((i < MAX_GUESSES) && (!compare))
        {
            if (counter == 0)
            {
                System.out.print("\nEnter a whole number between -64 and 64: ");
            }
            int GuessNum2 = isGuessNum(MAX_POSSIBLE_GUESS, MIN_POSSIBLE_GUESS);
            int userinput = this.printGuessed(GuessNum2);
            userAllGuesses2 = array(GuessNum2, guessingTimes, userAllGuesses, MAX_GUESSES);

            status = this.checkIfNumberGuessed(guessingTimes, userinput, userAllGuesses2);
            compare = this.CompareWithSecretNumber(userinput, secretNumber, i);
            boolean status2;
            System.out.print("Previous guess(es): ");
            for (int j = 0; j <= i; j++)
            {

                if (i == j)
                {
                    System.out.print(userAllGuesses2[j] + ". ");
                    System.out.println("\nYou have " + (6 - j) + " guesses left.");
                } else
                {
                    System.out.print(userAllGuesses2[j] + ", ");
                }
            }
            i++;
            guessingTimes++;
        }
        play_again = this.playGame();

        // You might create a loop here that will check numberGuesses 8 times and print

        // the guess number and call the
        // pertinent method (e.g., isGuessNum)

        // You might call and capture results from method (e.g., playGame) to see if
        // user wants to play again and if
        // so return it. Example: int playAgain = this.playGame();

        // if you want to end the game early & go directly back to main,
        // you can use a "return;" statement like this one (e.g., return playAgain;)

        return play_again;
    }

}
