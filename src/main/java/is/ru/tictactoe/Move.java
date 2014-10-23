package is.ru.tictactoe;

public class Move {
	private int position;
	private char player;
	public Move(int position, char player){
		this.position = position;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public char getPlayer(){
		return 'a';
	}
}
