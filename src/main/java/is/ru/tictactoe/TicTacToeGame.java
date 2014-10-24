package is.ru.tictactoe;

import java.util.ArrayList;

public class TicTacToeGame {
	private ArrayList<Move> board;
	private char whoHasTurn = 'X';
	
	public Move move(int position){
		return new Move(position, whoHasTurn);
	}
	
	public Move move(int position, char player){
		return new Move(position, player);
	}
	
	public boolean move(Move move){
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
