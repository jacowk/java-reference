package za.co.reference.designpatterns.behavioralpatterns.templatemethod;

//Now we can extend this class in order to implement actual games:

public class Monopoly extends Game {
 
    /* Implementation of necessary concrete methods */
 
    void initializeGame() {
        // Initialize money
    }
 
    void makePlay(int player) {
        // Process one turn of player
    }
 
    boolean endOfGame() {
    	return true;
        // Return true of game is over according to Monopoly rules
    }
 
    void printWinner() {
        // Display who won
    }
 
    /* Specific declarations for the Monopoly game. */
 
    // ...
 
}
