package is.ru.tictactoe;

import java.util.ArrayList;

public class TicTacToeGame {
	private ArrayList<Move> board;
	private char whoHasTurn;
	private boolean gameIsOver;
	private char winner;
	
	public TicTacToeGame(){
		initializeGame('X');
	}
	
	public TicTacToeGame(char firstPlayer){
		if(firstPlayer != 'O' && firstPlayer != 'X'){
			throw new IllegalArgumentException("Player must be either 'X' or 'O'");
		}
		initializeGame(firstPlayer);
	}
	
	private void initializeGame(char firstPlayer) {
		this.board = new ArrayList<Move>(9);
		this.whoHasTurn = firstPlayer;
		this.gameIsOver = false;
		this.winner = 'D';
	}
	
	public Move move(int position){
		Move theMove = new Move(position, this.whoHasTurn);
		if(this.move(theMove)){
			return theMove;	
		}
		else{
			return null;
		}
	}
	
	public Move move(int position, char player){
		Move theMove = new Move(position, player);
		if(this.move(theMove)){
			return theMove;
		}
		else{
			return null;
		}
	}
	
	public boolean move(Move move){
		if(board.contains(move) || move.getPlayer() != this.whoHasTurn || this.gameOver()){
			return false;
		}
		board.add(move);
		if(this.whoHasTurn == 'X'){
			this.whoHasTurn = 'O';
		}
		else{
			this.whoHasTurn = 'X';
		}
		return true;
	}
	
	public char hasMove(char player){
		return 'X';
	}
	
	public boolean gameOver(){
		if(this.gameIsOver || this.board.size() == 9){
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
			return endGame(gameBoard[0]);
		}
		else if(gameBoard[3] == gameBoard[4] && gameBoard[3] == gameBoard[5]){
			return endGame(gameBoard[3]);
		}
		else if(gameBoard[6] == gameBoard[7] && gameBoard[6] == gameBoard[8]){
			return endGame(gameBoard[6]);
		}
		else if(gameBoard[0] == gameBoard[3] && gameBoard[0] == gameBoard[6]){
			return endGame(gameBoard[0]);
		}
		else if(gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7]){
			return endGame(gameBoard[1]);
		}
		else if(gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8]){
			return endGame(gameBoard[2]);
		}
		else if(gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8]){
			return endGame(gameBoard[0]);
		}
		else if(gameBoard[6] == gameBoard[4] && gameBoard[6] == gameBoard[2]){
			return endGame(gameBoard[6]);
		}
		
		return false;
	}

	private boolean endGame(char winner) {
		this.winner = winner;
		this.gameIsOver = true;
		return true;
	}
	
	public ArrayList<Move> getBoard(){
		return null;
	}
	
	public void resetGame(){
		return;
	}
	
	public char winner(){
		return winner;
	}
}
