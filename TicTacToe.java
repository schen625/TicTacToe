import java.util.Scanner;

public class TicTacToe {

  /**
   * private helper function to print the board for users 
   * @param board the board to be printed
   */
  private static void printBoard(char[] board) {
    System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
    System.out.println("---+---+---");
    System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
    System.out.println("---+---+---");
    System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
    System.out.println();
    }
  
  /**
   * private helper method to check if there is a win on the board
   * @param board
   */
  private static boolean checkWin(char[] board, char turn) {
    if(
      //3 ways to win horizontally
        (board[0]+board[1]+board[2] == (turn*3)) ||
        (board[3]+board[4]+board[5] == (turn*3)) ||
        (board[6]+board[7]+board[8] == (turn*3)) ||
      //3 ways to win vertically
        (board[0]+board[3]+board[6] == (turn*3)) ||
        (board[1]+board[4]+board[7] == (turn*3)) ||
        (board[2]+board[5]+board[8] == (turn*3)) ||
      //2 ways to win diagonally   
        (board[0]+board[4]+board[8] == (turn*3)) ||
        (board[2]+board[4]+board[6] == (turn*3))
        ) {
      return true;
    }else {
      return false;
    } 
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //use so use can choose to play again
    boolean restart = true;
    
    while(restart) {
      
      //set up the board
      char[] board = { '1','2','3','4','5','6','7','8','9'};
      //keep track of which squares taken and whose turn it is
      int squaresHit = 0;
      char turn = 'X';
      
      System.out.println("Tic Tac Toe Game");
      System.out.println();
      
      //print empty board to start
      printBoard(board);
      
      while (squaresHit<9) {
        System.out.printf("Player %s, choose a square.\n", turn);
        int input = scanner.nextInt();
        
        //make sure user enters correct input
        if (input < 1 || input > 9) {
          System.out.println("Input must be a number from 1-9.");
          continue;
        }
        
        //make sure input is number 
        if(!scanner.hasNextInt()) {
          System.out.println("Input not valid. Please enter a number!");
          scanner.next();
          continue;
        }
        
        //make sure squares not filled
        if((board[input-1] == 'X') || (board[input-1] == 'O')) {
          System.out.println("The square is filled already, please pick another square.");
          continue;
        }
        
        board[input-1] = turn;
        squaresHit++;
        printBoard(board);
        
        //check if there is a winner yet 
        if(checkWin(board, turn)) {
          printBoard(board);
          System.out.println("Game Over!");
          System.out.printf("Congrats, player %s has won!\n",turn);
          System.out.println();
          break;
        }
        
        //check if there's a tie
        if(squaresHit == 9) {
          printBoard(board);
          System.out.println("Game Over!");
          System.out.println("Game ended in a draw!");
          System.out.println();
          break;
        }
        
        //change whose turn it is 
        if(turn == 'X') {
          turn = 'O';
        }else {
          turn = 'X';
        }
      }
        
      //allow player to play again
      System.out.println("Click Y to play again!");
      String userAnswer = scanner.next().trim();
      restart = userAnswer.equals("Y");
      
      if(!restart) {
        System.out.println("Thanks for playing!");
      }
    }
    scanner.close();
  }
}
