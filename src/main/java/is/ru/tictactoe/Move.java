package is.ru.tictactoe;

public class Move {
	private int position;
	private char player;
	public Move(int position, char player){
		StringBuilder errorMessage = null;
		if(position < 0 || position > 8){
			errorMessage = new StringBuilder();
			errorMessage.append("Position must be in range [0, 8]");
		}
		if(player != 'X' && player != 'O'){
			if(errorMessage == null){
				errorMessage = new StringBuilder();
			}
			else{
				errorMessage.append(", ");
			}
			errorMessage.append("Player must be either 'X' or 'O'");
		}
		if(errorMessage != null){
			throw new IllegalArgumentException(errorMessage.toString());
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
