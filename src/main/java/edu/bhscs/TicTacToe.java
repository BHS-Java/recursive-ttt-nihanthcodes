import java.util.Scanner;

public class TicTacToe {
  private char[][] board;
  private char currentPlayer;

  public TicTacToe() {
      board = new char[3][3];
      currentPlayer = 'X';

      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
              board[i][j] = ' ';
          }
      }
  }

  public void playGame() {
      playTurn();
  }

  public void playTurn() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Player " + currentPlayer + ", enter your move (row and column as int int):");
      int row = scanner.nextInt();
      int col = scanner.nextInt();
      board[row][col] = currentPlayer;
      printBoard();
      if (!checkWin(currentPlayer)){
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        playTurn();
      }
  }

  public void printBoard() {
      for (int i = 0; i < board.length; i++) {
          System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
      }
  } 

  public boolean checkWin(char player) {
    if (checkRow(2, 2, player) || checkColumn(2, 2, player) || checkDiagonal(3, player)) {
      return true;
    }
    return false;
  }

  private boolean checkRow(int row, int col, char player){
    if (board[row][col] == player){
      if (col == 0){
        return true;
      }
      return checkRow(row, col-1, player);
    } else{
      if (row == 0){
        return false;
      }
      return checkRow(row-1, col, player);
    }
  }
  private boolean checkColumn(int row, int col, char player){
    if (board[row][col] == player){
      if (row == 0){
        return true;
      }
      return checkColumn(row-1, col, player);
    } else{
      if (col == 0){
        return false;
      }
      return checkColumn(row, col-1, player);
    }
  }
  private boolean checkDiagonal(int counter, char player){
    boolean rightFlag = false;
    boolean leftFlag = false;
    if (board[counter-1][counter-1] == player){
      if (counter-1 == 0){
        rightFlag = true;
      }
    }
    if (board[(2)-(counter-1)][counter-1] == player){
      if (counter-1 == 0){
        leftFlag = true;
      }
    }
    if (rightFlag && leftFlag){
      return true;
    }
    counter--;
    if (counter == 0){
      return false;
    }
    return checkDiagonal(counter, player);
  }
}