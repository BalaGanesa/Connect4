package connect_four;
import java.util.Scanner;

public class ConnectFour {
    private static final int ROW = 6;
    private static final int COLUMN = 7;
    private static int[][] board = new int[ROW][COLUMN];
    private static int currentPlayer = 1;
    static boolean condition = true;
    public static  Scanner scanner = new Scanner(System.in); 
    public static void main(String[] args) {
       int col = 0;
        while (true) {
              printBoard();
            System.out.print("\nPlayer " + currentPlayer + ", enter a column number (1-" + (COLUMN) + "): \n");
					
            		String a = scanner.nextLine();
            		boolean isInteger = true;

            		try {
            		    col =  Integer.parseInt(a);
            		} catch (NumberFormatException e) {
            		    isInteger = false;
            		}
					 if(col >= 1 && col<=7 && isInteger) 
				 { 
						 
					   if (putValue(col)) {
			               if (Wincheck()) {
				                   printBoard();
				                   System.out.println("\n Player " + currentPlayer + " wins!");
				                   System.out.println("1. TryAgain");
				                   
				                   break;
				               }
				               if (checkDraw()) {
				                   printBoard();
				                   System.out.println("Draw!");
				                   break;
				               }
				              if(currentPlayer ==1) {
				            	  currentPlayer = 2;
				              }
				              else {
				            	  currentPlayer = 1;
				              }
				           } else {
				               System.out.println("Column is full. Try again.");
			           }
				}
				 else {
						System.out.println("\n Please Enter valid column Number \n");
					 }
        }				
		
         
        }
    
    
	
		
	
    
    private static boolean putValue(int column) {
    	System.out.println("aa");
          for (int row = ROW-1; row >= 0; row--) {
            if (board[row][column-1] == 0) {
              board[row][column-1] = currentPlayer;
                return true;
            }  
         }
        return false;
    }

    private static boolean Wincheck() {
        for (int row = 0; row < ROW; row++) {
        for (int col = 0; col < COLUMN-3; col++) {
            if (board[row][col] == currentPlayer && board[row][col+1] == currentPlayer && board[row][col+2] == currentPlayer && board[row][col+3] == currentPlayer) {
           return true;
                }
            }
        }
        for (int row = 0; row < ROW-3; row++) {
        for (int col = 0; col < COLUMN; col++) {
            if (board[row][col] == currentPlayer && board[row+1][col] == currentPlayer && board[row+2][col] == currentPlayer && board[row+3][col] == currentPlayer) {
                return true;
                }
            }
        }

        for (int row = 0; row < ROW-3; row++) {
        for (int col = 0; col < COLUMN-3; col++) {
            if (board[row][col] == currentPlayer && board[row+1][col+1] == currentPlayer && board[row+2][col+2] == currentPlayer && board[row+3][col+3] == currentPlayer) {
                return true;
                }
            }
        }

        for (int row = 0; row < ROW-3; row++) {
        for (int col = 3; col < COLUMN; col++) {
            if (board[row][col] == currentPlayer && board[row+1][col-1] == currentPlayer && board[row+2][col-2] == currentPlayer && board[row+3][col-3] == currentPlayer) {
                return true;
                }
            }
        }

        return false;
    }

    private static boolean checkDraw() {
        for (int col = 0; col < COLUMN; col++) {
        if (board[0][col] == 0) {
                return false;
            }
        }
        return true;
    }
    public static void  printBoard() {	
    for (int row = 0; row < board.length; row++) {
    	for (int col = 0; col < board[1].length; col++) {
            System.out.print("| " + board[row][col] +" ");
        }
        System.out.println("|");
    }
}
}