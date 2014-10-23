package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoveTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void MoveReturnsCorrectPosition() {
		Move move = new Move(0, 'X');
		assertEquals(0, move.getPosition());
	}
	
	@Test
	public void MoveReturnsCorrectPlayer() {
		Move move = new Move(0, 'X');
		assertEquals('X', move.getPlayer());
	}

	@Test
	public void MoveThrowsIllegalArgumentExceptionIfPositionIsNotInRange0To8(){
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Position must be in range [0, 8]");
        Move move = new Move(10, 'O');
	}
	
	@Test
	public void MoveThrowsIllegalArgumentExceptionIfPlayerIsNotXorO(){
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Player must be either 'X' or 'O'");
        Move move = new Move(5, 'F');
	}
	
	@Test
	public void MoveThrowsIllegalArgumentExceptionIfPlayerIsNotXorOAndPositionIsNotInRange0To8(){
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Position must be in range [0, 8], Player must be either 'X' or 'O'");
        Move move = new Move(-3, 'F');
	}
}
