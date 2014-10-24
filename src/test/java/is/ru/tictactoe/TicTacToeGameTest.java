package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeGameTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
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
	
	@Test
	public void MoveToOccupiedPositionReturnsFalse() {
		TicTacToeGame game = new TicTacToeGame();
		Move move = new Move(2, 'O');
		game.move(move);
		boolean goodMove = game.move(move);
		assertEquals(goodMove, false);
	}
	
	@Test
	public void MoveToUnoccupiedPositionReturnsTrue() {
		TicTacToeGame game = new TicTacToeGame();
		Move move = new Move(2, 'O');
		Move newMove = new Move(4, 'X');
		game.move(move);
		boolean goodMove = game.move(newMove);
		assertEquals(goodMove, true);
	}
	
	@Test
	public void ConstructorThrowsExceptionForIllegalArgument(){
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Player must be either 'X' or 'O'");
        TicTacToeGame game = new TicTacToeGame('G');
	}

}
