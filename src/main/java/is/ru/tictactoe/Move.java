package is.ru.tictactoe;

/**
 *  The <tt>Move</tt> class represents a data type for storing positions
 *  in <tt>TicTacToeGame</tt>.
 *  <p>
 *  @author Þotuliðið
 */

public class Move {
	private int position;
	private char player;
	
    /**
     * Initializes the <tt>Move</tt> object with <tt>position</tt> and <tt>player</tt>
     * @param position the position of the move
     * @param player the player of the move
     * @throws IllegalArgumentException if the position is not in the range [0, 8]
     * @throws IllegalArgumentException if the player is not 'X' or 'O'
     */
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
	
	/**
     * Returns the position of the <tt>Move</tt>.
     * @return The position of the <tt>Move</tt>.
     */
	public int getPosition(){
		return this.position;
	}
	
	/**
     * Returns the player of the <tt>Move</tt>.
     * @return The player of the <tt>Move</tt>.
     */
	public char getPlayer(){
		return this.player;
	}
	
	@Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object != null && object instanceof Move)
        {
            sameSame = this.position == ((Move) object).position;
        }

        return sameSame;
    }
}
