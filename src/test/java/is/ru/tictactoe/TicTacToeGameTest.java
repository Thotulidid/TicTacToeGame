package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeGameTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void ConstructorThrowsExceptionForIllegalArgument(){
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Player must be either 'X' or 'O'");
        TicTacToeGame game = new TicTacToeGame('G');
	}
	
	@Test
	public void MoveWithOnlyPositionReturnsCorrectMovePosition() {
		TicTacToeGame game = new TicTacToeGame();
		Move newMove = game.move(5);
		assertEquals(5, newMove.getPosition());
	}
	
	@Test
	public void MoveWithPositionAndPlayerReturnsCorrectMove() {
		TicTacToeGame game = new TicTacToeGame();
		Move newMove = game.move(7, 'X');
		assertEquals('X', newMove.getPlayer());
		assertEquals(7, newMove.getPosition());
	}
	
	@Test
	public void MoveWithMoveToOccupiedPositionReturnsFalse() {
		TicTacToeGame game = new TicTacToeGame('O');
		Move move = new Move(2, 'O');
		game.move(move);
		boolean goodMove = game.move(move);
		assertEquals(goodMove, false);
	}
	
	@Test
	public void MoveWithMoveToUnoccupiedPositionReturnsTrue() {
		TicTacToeGame game = new TicTacToeGame('O');
		Move move = new Move(2, 'O');
		Move newMove = new Move(4, 'X');
		game.move(move);
		boolean goodMove = game.move(newMove);
		assertEquals(goodMove, true);
	}
	
	@Test
	public void TwoLegalPositionMovesInARowFromTheSamePlayerShouldReturnFalseForTheSecondMove(){
		TicTacToeGame game = new TicTacToeGame('X');
		game.move(new Move(3, 'X'));
		assertEquals(false, game.move(new Move(5, 'X')));
	}
}
