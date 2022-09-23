package src;

import java.util.*;
public class afterTDDX_O  {
	public static final int X = 1, O = -1;
	public static final int EMPTY = 0;
	
	public int player = X;
	public int[][] board = new int[3][3];
	public boolean isEmpty = false;

	public void putSign(int x, int y)
	{
		if(x<0 || x>2 || y<0 || y>2)
		{
			System.out.println("Invalid board position");
			return;
		}
		if(board[x][y] != EMPTY)
		{
			System.out.println("Board position occupied");
			return;
		}
		board[x][y] = player;
		player = -player;
	}
	
	public boolean isWin(int player)//The First TDD function
	{
		/*refactor 1--
		 return ((board[0][0] + board[0][1] + board[0][2] == player));
		 		
		 */
		/*refactor 2--
		  return ((board[0][0] + board[0][1] + board[0][2] == player) ||
				(board[1][0] + board[1][1] + board[1][2] == player) ||
				(board[2][0] + board[2][1] + board[2][2] == player) );
		 */
		/*refactor 3--
		   return ((board[0][0] + board[0][1] + board[0][2] == player) ||
				(board[1][0] + board[1][1] + board[1][2] == player) ||
				(board[2][0] + board[2][1] + board[2][2] == player) ||
				(board[0][0] + board[1][0] + board[2][0] == player) ||
				(board[0][1] + board[1][1] + board[2][1] == player) ||
				(board[0][2] + board[1][2] + board[2][2] == player));
		 */
		/*refactor 4--
		  return ((board[0][0] + board[0][1] + board[0][2] == player) ||
				(board[1][0] + board[1][1] + board[1][2] == player) ||
				(board[2][0] + board[2][1] + board[2][2] == player) ||
				(board[0][0] + board[1][0] + board[2][0] == player) ||
				(board[0][1] + board[1][1] + board[2][1] == player) ||
				(board[0][2] + board[1][2] + board[2][2] == player) ||
				(board[0][0] + board[1][1] + board[2][2] == player) ||
				(board[2][0] + board[1][1] + board[0][2] == player));
		 */
		return ((board[0][0] + board[0][1] + board[0][2] == player*3) ||
				(board[1][0] + board[1][1] + board[1][2] == player*3) ||
				(board[2][0] + board[2][1] + board[2][2] == player*3) ||
				(board[0][0] + board[1][0] + board[2][0] == player*3) ||
				(board[0][1] + board[1][1] + board[2][1] == player*3) ||
				(board[0][2] + board[1][2] + board[2][2] == player*3) ||
				(board[0][0] + board[1][1] + board[2][2] == player*3) ||
				(board[2][0] + board[1][1] + board[0][2] == player*3));
	}
	
	public String displayWinner()//The second TDD function
	{
		/*refactor 1--
		 return null;
		*/
		/*refactor 2--
		 if(isWin(X))
		{
			System.out.println("\n X wins...!!");
			return "X wins...!!";
		}
		return null;
		*/
		/*refactor 3--
		if(isWin(X))
		{
			System.out.println("\n X wins...!!");
			return "X wins...!!";
		}
		else if(isWin(O))
		{
			System.out.println("\n O wins...!!");
			return "O wins...!!";
		}
		return null;
		*/
		/*refactor 4--
		 if(isWin(X))
		{
			System.out.println("\n X wins...!!");
			
			return "X wins...!!";
		}
		else if(isWin(O))
		{
			System.out.println("\n O wins...!!");
			
			return "O wins...!!";
		}
		else 
		{
			System.out.println("\n it's a draw");
			return "it's draw";
			
		}
		return null;
	}
		*/
		/*refactor 5--
		if(isWin(X))
		{
			System.out.println("\n X wins...!!");
			
			return "X wins...!!";
		}
		else if(isWin(O))
		{
			System.out.println("\n O wins...!!");
			
			return "O wins...!!";
		}
		else 
		{
			if(!isEmpty)
			{
				System.out.println("\n it's a draw");
				return "it's draw";
				
			}
		}
		return null;
	}
		*/
		if(isWin(X))
		{
			System.out.println("\n X wins...!!");
			isEmpty=false;
			return "X wins...!!";
		}
		else if(isWin(O))
		{
			System.out.println("\n O wins...!!");
			isEmpty=false;
			return "O wins...!!";
		}
		else 
		{
			if(!isEmpty)
			{
				System.out.println("\n it's a draw");
				return "it's draw";
				
			}
		}
		return null;
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		isEmpty = false;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				switch(board[i][j])
				{
				case X: 
					s.append(" X ");
					break;
				case O: 
					s.append(" O ");
					break;
				case EMPTY: 
					s.append("   ");
					isEmpty=true;
					break;
				}
				if(j<2)
				{
					s.append("|");
				}
				
			}
			if(i<2)
			{
				s.append("\n-----------\n");
			}
		}
		return s.toString();
	}
	public static void main(String[] args) {
		
		afterTDDX_O t = new afterTDDX_O();
		Scanner s = new Scanner(System.in);
		int x=0,y=0;
		do
		{
			System.out.println(t.player==t.X?"Player X turn":"Player O turn");
			System.out.println("Enter x(0-2) and y(0-2) places");
			x=s.nextInt();
			y=s.nextInt();
			
			t.putSign(x, y);
			System.out.println(t.toString());
			System.out.println("_____________________________");
			t.displayWinner();
			
		}while(t.isEmpty);
	}
	
}