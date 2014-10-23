package is.ru.tictactoe;

public class Move {
	private int position;
	private char player;
	public Move(int position, char player){
		if(position < 0 || position > 8){
			throw new IllegalArgumentException("Position must be in range [0, 8]");
		}
		else if(player != 'X' && player != 'O'){
			throw new IllegalArgumentException("Player must be either 'X' or 'O'");
		}
		this.position = position;
		this.player = player;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public char getPlayer(){
		return this.player;
	}
}
