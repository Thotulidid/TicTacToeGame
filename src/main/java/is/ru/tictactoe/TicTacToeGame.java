package is.ru.tictactoe;

import java.util.ArrayList;

public class TicTacToeGame {
	private ArrayList<Move> board;
	private char whoHasTurn = 'X';
	
	public TicTacToeGame(){
		this.board = new ArrayList<Move>(9);
	}
	
	public TicTacToeGame(char firstPlayer){
		if(firstPlayer != 'O' && firstPlayer != 'X'){
			throw new IllegalArgumentException("Player must be either 'X' or 'O'");
		}
		this.board = new ArrayList<Move>(9);
		this.whoHasTurn = firstPlayer;
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
		if(board.contains(move) || move.getPlayer() != this.whoHasTurn){
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
		return true;
	}
	
	public ArrayList<Move> getBoard(){
		return null;
	}
	
	public void resetGame(){
		return;
	}
	
	public char winner(){
		return 'X';
	}
}
