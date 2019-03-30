package za.co.reference.designpatterns.behavioralpatterns.templatemethod;

public class Chess extends Game {
	 
    /* Implementation of necessary concrete methods */
 
    void initializeGame() {
        // Put the pieces on the board
    }
 
    void makePlay(int player) {
        // Process a turn for the player
    }
 
    boolean endOfGame() {
    	return true;
        // Return true if in Checkmate or Stalemate has been reached
    }
 
    void printWinner() {
        // Display the winning player
    }
 
    /* Specific declarations for the chess game. */
 
    // ...
 
}
