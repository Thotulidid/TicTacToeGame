package is.ru.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveTest {

	@Test
	public void MoveReturnsCorrectPosition() {
		Move move = new Move(0, 'X');
		assertEquals(0, move.getPosition());
	}

}
