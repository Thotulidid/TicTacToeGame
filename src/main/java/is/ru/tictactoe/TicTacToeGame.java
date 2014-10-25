package is.ru.tictactoe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  The <tt>TicTacToeGame</tt> class represents a data type for storing
 *  all information on a particular game of TicTacToeGame.
 *  <p>
 *  @author Þotuliðið
 */

public class TicTacToeGame {
	private ArrayList<Move> board;
	private char whoHasTurn;
	private boolean gameIsOver;
	private char winner;
	
    /**
     * Initializes the <tt>TicTacToeGame</tt> object with the default 
     * staring player 'X'.
     */
	
	public TicTacToeGame(){
		initializeGame('X');
	}
	
	  /**
     * Initializes the <tt>TicTacToeGame</tt> object with the <tt>firstPlayer</tt>
     * @param firstPlayer the first player to move in this game
     * @throws IllegalArgumentException if the player is not 'X' or 'O'
     */
	public TicTacToeGame(char firstPlayer){
		if(firstPlayer != 'O' && firstPlayer != 'X'){
			throw new IllegalArgumentException("Player must be either 'X' or 'O'");
		}
		initializeGame(firstPlayer);
	}
	
	
	// helper function for the two TicTacToeGame constructor.
	// initializes all of the fields of the class.
	private void initializeGame(char firstPlayer) {
		this.board = new ArrayList<Move>(9);
		this.whoHasTurn = firstPlayer;
		this.gameIsOver = false;
		this.winner = '?';
	}
	
	/**
     * Calls the constructor of <tt>Move</tt> to construct
     * a Move with <tt>position<tt> and the player who's turn
     * it is in the game
     * @param position the position of the move
     * @return The <tt>Move</tt> constructed or null if the move
     * could not take place in the game
     */
	public Move move(int position){
		Move theMove = new Move(position, this.whoHasTurn);
		if(this.move(theMove)){
			return theMove;	
		}
		else{
			return null;
		}
	}
	
	/**
     * Calls the constructor of <tt>Move</tt> to construct
     * a Move with <tt>position<tt> and <tt>player<tt>.
     * @param position the position of the move
     * @param player the player of the move
     * @return The <tt>Move</tt> constructed or null if the move
     * could not take place in the game
     */
	public Move move(int position, char player){
		Move theMove = new Move(position, player);
		if(this.move(theMove)){
			return theMove;
		}
		else{
			return null;
		}
	}
	
	/**
     * Adds the <tt>Move</tt> as the next move of the
     * <tt>TicTacToeGame<tt>
     * @param move
     * @return <tt>false</tt> if the game was could not
     * be added to the game and <tt>true<tt> if the add 
     * was successful
     */
	public boolean move(Move move){
		if(board.contains(move) || move.getPlayer() != this.whoHasTurn || this.gameIsOver){
			return false;
		}
		board.add(move);
		if(this.whoHasTurn == 'X'){
			this.whoHasTurn = 'O';
		}
		else{
			this.whoHasTurn = 'X';
		}
		this.gameOver();
		return true;
	}
	/**
     * Return the players who�s turn it is in
     * the <tt>TicTacToeGame</tt>.
     * @return The player who's turn it is
     */
	public char hasMove(){
		return this.whoHasTurn;
	}
	
	/**
     * Determines whether the <tt>TicTacToeGame<tt> is
     * over or not
     * @return <tt>true<tt> if the game is over and
     * <tt>false<tt> otherwise.
     */
	public boolean gameOver(){
		if(this.gameIsOver){
			return true;
		}
		
		if(this.board.size() == 9){
			endGame('D');
			return true;
		}
		
		char[] gameBoard = new char[9];
		for(int i = 0; i < 9; i++){
			gameBoard[i] = (char)(i + 33);
		}
		for(Move m : this.board){
			gameBoard[m.getPosition()] = m.getPlayer();
		}
		
		if(gameBoard[0] == gameBoard[1] && gameBoard[0] == gameBoard[2]){
			endGame(gameBoard[0]);
			return true;
		}
		else if(gameBoard[3] == gameBoard[4] && gameBoard[3] == gameBoard[5]){
			endGame(gameBoard[3]);
			return true;
		}
		else if(gameBoard[6] == gameBoard[7] && gameBoard[6] == gameBoard[8]){
			endGame(gameBoard[6]);
			return true;
		}
		else if(gameBoard[0] == gameBoard[3] && gameBoard[0] == gameBoard[6]){
			endGame(gameBoard[0]);
			return true;
		}
		else if(gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7]){
			endGame(gameBoard[1]);
			return true;
		}
		else if(gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8]){
			endGame(gameBoard[2]);
			return true;
		}
		else if(gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8]){
			endGame(gameBoard[0]);
			return true;
		}
		else if(gameBoard[6] == gameBoard[4] && gameBoard[6] == gameBoard[2]){
			endGame(gameBoard[6]);
			return true;
		}
		
		return false;
	}

	/**
	 * ends the game ant sets <tt>winner<tt>
	 * as the winner of the game.
	 * @param winner
	 */
	private void endGame(char winner) {
		this.winner = winner;
		this.gameIsOver = true;
	}
	/**
	 * Returns the character array representing the <tt>TicTacToeGame<tt>
	 * board
	 * @return the character array representing the board
	 */
	
	public Move[] getBoard(){
		Move[] gameBoard = new Move[9];
		for(Move m : this.board){
			gameBoard[m.getPosition()] = m;
		}	
		return gameBoard;
	}
	/**
	 * Resets the <tt>TicTacToeGame<tt>
	 */
	public void resetGame(){
		initializeGame('X');
	}
	
	/**
	 * Resets Winner of the <tt>TicTacToeGame<tt>
	 * or 'D' if the game was drawn.
	 */
	
	public char winner(){
		return winner;
	}
}
