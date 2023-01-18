package cs3500.marblesolitaire.model.hw04;

/**
 * The class which represents the TriangleSolitaire game model.
 * Extends the AbstractGameModel(which implements MarbleSolitaireModel interface).
 * Contains all game related functions.
 */
public class TriangleSolitaireModel extends AbstractGameModel {
  protected int size;

  /**
   * empty constructor that sets the board size to 5.
   */
  public TriangleSolitaireModel() {
    this.size = 5;
    initBoard(5, 0, 0);
  }

  /**
   * constructor that takes in a row and column number.
   * and initializes that place to the empty slot.
   * Size stays as 5 in this constructor.
   *
   * @param sRow represents a row in the game board.
   * @param sCol represents a col in the game board.
   * @throws IllegalArgumentException if the row and col are in invalid positions.
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this.size = 5;
    if (boundaries(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
    initBoard(5, sRow, sCol);
  }

  // constructor 3

  /**
   * constructor that takes in a board size and places the.
   * empty slot in the (0,0) position on the board.
   *
   * @param size represents the size of the given board.
   * @throws IllegalArgumentException if the size is invalid.
   */
  public TriangleSolitaireModel(int size) throws IllegalArgumentException {
    this.size = size;
    if (armConditions()) {
      throw new IllegalArgumentException("arm is an invalid length");
    } else {
      initBoard(size, 0, 0);
    }
  }

  //constructor 4

  /**
   * constructor that takes in arm length and initializes the center to inputted row and col.
   *
   * @param size represents the armLength of the given board.
   * @param row  represents a row in the game board.
   * @param col  represent a col in the game board.
   * @throws IllegalArgumentException if conditions are invalid.
   */
  public TriangleSolitaireModel(int size, int row, int col) throws IllegalArgumentException {
    this.size = size;
    if (armConditions() || boundaries(row, col)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + row + "," + col + ")");
    } else {
      initBoard(size, row, col);
    }
  }

  // override the initBoard helper method from the abstract class, to initialize a triangle.
  // game board.

  @Override
  protected void initBoard(int side, int row, int col) {
    slotStates = new SlotState[side][side];
    for (int i = 0; i < side; i++) {
      for (int j = 0; j < side; j++) {
        if (j > i) {
          slotStates[i][j] = SlotState.Invalid;
        } else if (i == row && j == col) {
          slotStates[i][j] = SlotState.Empty;
        } else {
          slotStates[i][j] = SlotState.Marble;
        }
      }
    }
  }

  @Override
  // boolean method which returns:
  // true: if the row and col are out of bounds
  // false: if the row and col are in bounds
  protected boolean boundaries(int row, int col) {
    return ((col > row) || row < 0 || col < 0);
  }

  @Override
  // boolean method which returns:
  // true: if the arm conditions are invalid
  // false: if the arm conditions are valid (positive and odd number)
  protected boolean armConditions() {
    return this.size < 0;
  }

  /**
   * method to check the board size of this board.
   *
   * @return the board size of this board.
   */
  @Override
  public int getBoardSize() {
    if (slotStates != null) {
      return this.size;
    }
    return 0;
  }

  /**
   * method that moves a game piece from fromRow to toRow.
   * and from fromCol to toCol, only if the move is valid.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move being attempted is invalid
   */

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (this.outOfBounds(fromRow, fromCol) || this.outOfBounds(toRow, toCol)) {
      throw new IllegalArgumentException("Invalid move. Try Again.");
    }
    // check if the three slots are in valid SlotStates
    if (this.isValidMove(fromRow, fromCol, toRow, toCol)) {
      // execute move
      this.slotStates[fromRow][fromCol] = SlotState.Empty;
      this.slotStates[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = SlotState.Empty;
      this.slotStates[toRow][toCol] = SlotState.Marble;
    } else {
      throw new IllegalArgumentException("Invalid Move. Try again.");
    }
  }

  private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return this.validVertical(fromRow, fromCol, toRow, toCol)
            || this.validHorizontal(fromRow, fromCol, toRow, toCol)
            || this.validDiagonalHelp(fromRow, fromCol, toRow, toCol);
  }

  // helper to check if there is a valid vertical move.
  private boolean validVertical(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromCol != toCol) {
      return false;
    }
    // move up two valid?
    if ((toRow == fromRow + 2) && (this.slotStates[fromRow + 1][fromCol] == SlotState.Marble)) {
      return this.slotStates[toRow][toCol] == SlotState.Empty;
    }
    if ((toRow == fromRow - 2) && (this.slotStates[fromRow - 1][fromCol] == SlotState.Marble)) {
      return this.slotStates[toRow][toCol] == SlotState.Empty;
    }
    return false;
  }

  // helper to check if there is a valid horizontal move.
  private boolean validHorizontal(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromRow != toRow) {
      return false;
    }

    if ((toCol == fromCol + 2) && (this.slotStates[fromRow][fromCol + 1] == SlotState.Marble)) {
      return this.slotStates[toRow][toCol] == SlotState.Empty;
    }
    if ((toCol == fromCol - 2) && (this.slotStates[fromRow][fromCol - 1] == SlotState.Marble)) {
      return this.slotStates[toRow][toCol] == SlotState.Empty;
    }
    return false;
  }

  // helper method for valid diagonal moves
  private boolean validDiagonalHelp(int fromRow, int fromCol, int toRow, int toCol) {

    if ((toRow == fromRow + 2 && toCol == fromCol + 2)
            || (toRow == fromRow - 2 && toCol == fromCol - 2)) {
      return this.slotStates[toRow][toCol] == SlotState.Empty;
    }
    return false;
  }

  // helper method to check if there is a valid diagonal move up.
  private boolean validDiagonalUp(int row, int col) {
    if (((row - 2) < 0) || ((col - 2) < 0)) {
      return false;
    } else if ((slotStates[row][col] != SlotState.Marble)
            || ((slotStates[row - 2][col - 2] == SlotState.Invalid))) {
      return false;
    } else if ((slotStates[row - 1][col - 1] == SlotState.Marble)
            && (slotStates[row - 2][col - 2] == SlotState.Empty)) {
      return true;
    }
    return false;
  }

  // helper method to check if there is a valid diagonal down move.
  private boolean validDiagonalDown(int row, int col) {
    if (((row + 2) > this.size - 1) || ((col + 2) > this.size - 1)) {
      return false;
    } else if ((slotStates[row][col] != SlotState.Marble)
            || ((slotStates[row + 2][col + 2] == SlotState.Invalid))) {
      return false;
    } else if ((slotStates[row + 1][col + 1] == SlotState.Marble)
            && (slotStates[row + 2][col + 2] == SlotState.Empty)) {
      return true;
    }
    return false;
  }

  /**
   * method to check if the game is over and there are no more possible valid moves for.
   * every place in the board.
   *
   * @return true if game is over and false if the game is not over.
   */
  @Override
  public boolean isGameOver() {
    boolean anyValidMoves = false;
    if (this.getScore() <= 1) {
      return true;
    }

    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        boolean a = validDown(i, j) || validUp(i, j) || validLeft(i, j) || validRight(i, j) ||
                validDiagonalUp(i, j) || validDiagonalDown(i, j);
        anyValidMoves = anyValidMoves || a;
      }
    }
    return !anyValidMoves;
  }


}
