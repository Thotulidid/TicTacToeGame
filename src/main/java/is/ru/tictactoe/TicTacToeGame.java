package is.ru.tictactoe;

import java.util.ArrayList;

public class TicTacToeGame {
	private ArrayList<Move> board;
	private char whoHasTurn = 'X';
	
	public TicTacToeGame(){
		this.board = new ArrayList<Move>(9);
	}
	
	public TicTacToeGame(char firstPlayer){
		if(firstPlayer != 'O' && firstPlayer != 'X')
		{
			throw new IllegalArgumentException("Player must be either 'X' or 'O'");
		}
		this.board = new ArrayList<Move>(9);
		this.whoHasTurn = firstPlayer;
	}
	
	public Move move(int position){
		return new Move(position, whoHasTurn);
	}
	
	public Move move(int position, char player){
		return new Move(position, player);
	}
	
	public boolean move(Move move){
		if(board.contains(move)){
			return false;
		}
		board.add(move);
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
