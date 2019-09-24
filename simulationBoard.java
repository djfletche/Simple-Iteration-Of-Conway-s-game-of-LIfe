/**
 * 
 * @author D'Andre Fletcher
 * Beginning implementation of Conways Game of Life
 * Due : Monday Septenmber 23rd
 * Program Cycle 2
 */

/*
 * Creation of the simulation board class. Rather than seperating into multiple files Keeping things 
 * linear helps the work flow of the project.
 * 
 * Wigth and height are used to create the array underneath.
 */
public class simulationBoard {
	int width; 
	int height;
	int [][] board;
	
	public simulationBoard(int width, int height)
	{
		this.width = width;
		this.height= height;
		this.board= new int[width][height];
	}
	/*
	 * The Function printBoard is used to print the board in a string output
	 * board shape.
	 */
	public void printBoard()
	{
		
		for (int y=0; y< height; y++)
		{	String line = "|";
			for (int x = 0; x < width ; x++)
				{
					if(this.board[x][y]==0)
					{
					line+=".";
					}
					else
					{
					line+="*";
					}
		}
			line+="|";
			System.out.println(line);
		}
	}
	/**
	 *  These next two functions are used to check if the cell is dead or alive
	 * 
	 * @param x width of the cell coordinate
	 * @param y height of the cell coordinate
	 */
	public void isAlive(int x, int y)
	{
		this.board[x][y]= 1;
	}
	public void isDead(int x, int y)
	{
		this.board[x][y]= 0;
	}
	
	/**
	 * This section is based on the numerical positions of possible neighbors of one cell
	 * This is how you check for them.
	 * There are two side combinations and three on the bottom and top of a cell
	 * @param x
	 * @param y
	 * @return
	 */
	public int getNeighbors(int x, int y)
	{
		int space = 0;
		
		space += quickCheck(x - 1, y - 1);
		space += quickCheck(x, y - 1);
		space += quickCheck(x + 1, y - 1);

		space += quickCheck(x - 1, y);
		space += quickCheck(x + 1, y);

		space += quickCheck(x - 1, y + 1);
		space += quickCheck(x, y + 1);
		space += quickCheck(x + 1, y + 1);
		
		return space;
		
	}
	/*
	 * The quick check function was used to make sure there were no cells outside of the selected area
	 * This helped stopped any errors I got that were related to bounds.
	 */
	public int quickCheck(int x, int y) 
	{
        if (x < 0 || x >= width) 
        {
        return 0;
        }

        if (y < 0 || y >= height) 
        {
        return 0;
        }
        return this.board[x][y];
    }
	/**
	 * This function should be used to move the generations forward.
	 */
	public void move()
	{
		for (int y=0; y< height; y++)
		{
			for (int x = 0; x < width ; x++)
				{ 
				
				int allAround= getNeighbors(x,y);
				
				
				if(this.board[x][y]==1)
					
				{
					if(allAround<2)
					{
						this.board[x][y]=0;
					}
					else if(allAround==2|| allAround == 3)
					{
						this.board[x][y]=1;
					}
					else if (allAround>3)
					{
						this.board[x][y]= 0;
					}
					else{ if (allAround == 3)
					{
						this.board[x][y] = 1;
					}
					
					}
				}
			}	
		}
	}
	
	/**
	 * This is the creation of the board which I would want to be autimated
	 * I also would want the simulation to continue into generations.
	 * @param args
	 */
	public static void main(String[] args)
	{
		simulationBoard board = new simulationBoard(25,15);
		/*
		 * The first four makes a stable position.
		 * Block
		 */
		board.isAlive(4, 4);
		board.isAlive(4, 3);
		board.isAlive(5, 3);
		board.isAlive(5, 4);
		
		/*
		 * Next Position
		 * 
		 */
		board.isAlive(9, 4);
		board.isAlive(10, 3);
		board.isAlive(8, 3);
		board.isAlive(11, 4);
		board.isAlive(7, 4);
		board.isAlive(4, 10);
		board.isAlive(15, 3);
		board.isAlive(5, 8);
		
	
		board.printBoard();
		board.move();
		System.out.println("");
		
		board.printBoard();
		board.move();
		
		System.out.println("");
		board.printBoard();
		
		System.out.println("");
		board.printBoard();
	
		
		
	}

}
