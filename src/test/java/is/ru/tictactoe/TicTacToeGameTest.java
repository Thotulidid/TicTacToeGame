package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicTacToeGameTest {

	@Test
	public void MoveReturnsCorrectMovePosition() {
		TicTacToeGame game = new TicTacToeGame();
		Move newMove = game.move(5);
		assertEquals(5, newMove.getPosition());
	}
	
	@Test
	public void MoveReturnsCorrectMove() {
		TicTacToeGame game = new TicTacToeGame();
		Move newMove = game.move(7, 'X');
		assertEquals('X', newMove.getPlayer());
		assertEquals(7, newMove.getPosition());
	}

}
