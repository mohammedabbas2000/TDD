package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import src.beforTDDX_O;

public class beforTDDX_Otest	 {
	@Rule
    public ExpectedException exception = ExpectedException.none();
    beforTDDX_O TestXO;
	@Before
	public final void before() {
		TestXO =new beforTDDX_O();
	}
	@Test
	public void hasWon() {
		
		TestXO.board[0][0] = 1;
		TestXO.board[0][1] = -1;
		TestXO.board[0][2] = -1;
		TestXO.board[1][0] = 0;
		TestXO.board[1][1] = 1;
		TestXO.board[1][2] = 0;
		TestXO.board[2][0] = 0;
		TestXO.board[2][1] = 0;
		TestXO.board[2][2] = 1;
        assertEquals(true,TestXO.isWin(1));
	 }
	@Test
	public void hasDraw() {
		
		TestXO.board[0][0] = 1;
		TestXO.board[0][1] = -1;
		TestXO.board[0][2] = 1;
		TestXO.board[1][0] = 1;
		TestXO.board[1][1] = -1;
		TestXO.board[1][2] = -1;
		TestXO.board[2][0] = -1;
		TestXO.board[2][1] = 1;
		TestXO.board[2][2] = 1;
		//return true if not X and O
        assertEquals(false,TestXO.isWin(-1));
        assertEquals(false,TestXO.isWin(1));
        
	 }
	@Test
	public void TheWinner1() {
		TestXO.board[0][0] = 1;
		TestXO.board[0][1] = -1;
		TestXO.board[0][2] = 1;
		TestXO.board[1][0] = 1;
		TestXO.board[1][1] = -1;
		TestXO.board[1][2] = -1;
		TestXO.board[2][0] = -1;
		TestXO.board[2][1] = 1;
		TestXO.board[2][2] = 1;
		System.out.print("The TheWinner1: ");
		assertEquals("it's draw",TestXO.displayWinner());
	}
	@Test
	public void TheWinner2() {
		TestXO.board[0][0] = 1;
		TestXO.board[0][1] = -1;
		TestXO.board[0][2] = -1;
		TestXO.board[1][0] = 0;
		TestXO.board[1][1] = 1;
		TestXO.board[1][2] = 0;
		TestXO.board[2][0] = 0;
		TestXO.board[2][1] = 0;
		TestXO.board[2][2] = 1;
		System.out.print("The TheWinner2: ");
		assertEquals("X wins...!!",TestXO.displayWinner());
	}
	
	 
}

