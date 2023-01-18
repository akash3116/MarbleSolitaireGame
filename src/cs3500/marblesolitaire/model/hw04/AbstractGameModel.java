package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents the Abstract game model which any of the game models can extend.
 * Implements the MarbleSolitaireModel interface.
 * Contains all common game related functions.
 */
public abstract class AbstractGameModel implements MarbleSolitaireModel {
  // variable for arm thickness.
  protected int arm;
  // 2D array of the Enum SlotState given in the MarbleSolitaireModelState class.
  protected SlotState[][] slotStates;

  /**
   * empty constructor that sets a game board with arm length 3.
   */
  public AbstractGameModel() {
    this.arm = 3;
    initBoard(3, 3, 3);
  }


  /**
   * constructor that takes in a row and column number.
   * and initializes that place to the empty slot.
   * arm length stays as 3 in this constructor.
   *
   * @param sRow represents a row in the game board.
   * @param sCol represents a col in the game board.
   * @throws IllegalArgumentException if the row and col are in invalid positions.
   */
  public AbstractGameModel(int sRow, int sCol) throws IllegalArgumentException {
    this.arm = 3;
    if (boundaries(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
    initBoard(3, sRow, sCol);
  }

  // constructor 3

  /**
   * constructor that takes in an arm length and places the.
   * empty slot in the center of the board.
   *
   * @param armLength represents the armLength of the given board.
   * @throws IllegalArgumentException if the armLength is invalid.
   */
  public AbstractGameModel(int armLength) throws IllegalArgumentException {
    this.arm = armLength;
    if (armConditions()) {
      throw new IllegalArgumentException("arm is an invalid length");
    } else {
      initBoard(armLength, (armLength - 1) / 2 * 3, (armLength - 1) / 2 * 3);
    }
  }

  //constructor 4

  /**
   * constructor that takes in arm length and initializes the center to inputted row and col.
   *
   * @param armLength represents the armLength of the given board.
   * @param row       represents a row in the game board.
   * @param col       represent a col in the game board.
   * @throws IllegalArgumentException if conditions are invalid.
   */
  public AbstractGameModel(int armLength, int row, int col) throws IllegalArgumentException {
    this.arm = armLength;
    if (armConditions() || boundaries(row, col)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + row + "," + col + ")");
    } else {
      initBoard(armLength, row, col);
    }
  }

  // boolean method which returns:
  // true: if the arm conditions are invalid
  // false: if the arm conditions are valid (positive and odd number)
  protected boolean armConditions() {
    return this.arm % 2 == 0 || this.arm < 0;
  }

  // boolean method which returns:
  // true: if the row and col are out of bounds
  // false: if the row and col are in bounds
  protected boolean boundaries(int row, int col) {
    return (((row <= this.arm - 2) || (row >= this.arm * 2 - 1))
            && ((col <= this.arm - 2) || (col >= this.arm * 2 - 1)));
  }

  // helper method to create board for each constructor
  // takes in an arm length, row, and column and initializes a board
  abstract protected void initBoard(int armLength, int row, int col);


  // helper method to check if there is a valid move to the right at a given positon
  // returns true if there is a valid move
  // returns false if there is no valid move
  protected boolean validRight(int row, int col) {
    if ((col + 2) > (getBoardSize() - 1)) {
      return false;
    } else if ((slotStates[row][col] != SlotState.Marble)
            || ((slotStates[row][col + 2] == SlotState.Invalid))) {
      return false;
    } else {
      return ((slotStates[row][col + 1] == SlotState.Marble)
              && (slotStates[row][col + 2] == SlotState.Empty));
    }
  }

  // helper method to check if there is a valid move to the left at a given positon
  // returns true if there is a valid move
  // returns false if there is no valid move
  protected boolean validLeft(int row, int col) {
    if ((col - 2) < 0) {
      return false;
    } else if ((slotStates[row][col] != SlotState.Marble)
            || ((slotStates[row][col - 2] == SlotState.Invalid))) {
      return false;
    } else if ((slotStates[row][col - 1] == SlotState.Marble)
            && (slotStates[row][col - 2] == SlotState.Empty)) {
      return true;
    }
    return false;
  }

  // helper method to check if there is a valid move upwards at a given positon
  // returns true if there is a valid move
  // returns false if there is no valid move
  protected boolean validUp(int row, int col) {
    if ((row - 2) < 0) {
      return false;
    } else if ((slotStates[row][col] != SlotState.Marble)
            || ((slotStates[row - 2][col] == SlotState.Invalid))) {
      return false;
    } else if ((slotStates[row - 1][col] == SlotState.Marble)
            && (slotStates[row - 2][col] == SlotState.Empty)) {
      return true;
    }
    return false;
  }

  // helper method to check if there is a valid move downwards at a given positon
  // returns true if there is a valid move
  // returns false if there is no valid move
  protected boolean validDown(int row, int col) {
    {
      if ((row + 2) > (getBoardSize() - 1)) {
        return false;
      } else if ((slotStates[row][col] != SlotState.Marble)
              || ((slotStates[row + 2][col] == SlotState.Invalid))) {
        return false;
      } else if ((slotStates[row + 1][col] == SlotState.Marble)
              && (slotStates[row + 2][col] == SlotState.Empty)) {
        return true;
      }
      return false;
    }
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
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (outOfBounds(fromRow, fromCol) || outOfBounds(toRow, toCol)) {
      throw new IllegalArgumentException("invalid move positions");
    }
    if ((fromRow == toRow) && ((validRight(fromRow, fromCol)) || (validLeft(fromRow, fromCol)))) {
      if ((toCol - fromCol) == 2) {
        slotStates[fromRow][fromCol] = SlotState.Empty;
        slotStates[fromRow][fromCol + 1] = SlotState.Empty;
        slotStates[fromRow][fromCol + 2] = SlotState.Marble;
      } else if ((fromCol - toCol) == 2) {
        slotStates[fromRow][fromCol] = SlotState.Empty;
        slotStates[fromRow][fromCol - 1] = SlotState.Empty;
        slotStates[fromRow][fromCol - 2] = SlotState.Marble;
      } else {
        throw new IllegalArgumentException("invalid move positions");
      }
    } else if ((fromCol == toCol) && ((validUp(fromRow, fromCol))
            || (validDown(fromRow, fromCol)))) {
      if ((toRow - fromRow) == 2) {
        slotStates[fromRow][fromCol] = SlotState.Empty;
        slotStates[fromRow + 1][fromCol] = SlotState.Empty;
        slotStates[fromRow + 2][fromCol] = SlotState.Marble;
      } else if ((fromRow - toRow) == 2) {
        slotStates[fromRow][fromCol] = SlotState.Empty;
        slotStates[fromRow - 1][fromCol] = SlotState.Empty;
        slotStates[fromRow - 2][fromCol] = SlotState.Marble;
      } else {
        throw new IllegalArgumentException("invalid move positions");
      }
    } else {
      throw new IllegalArgumentException("invalid move positions");
    }
  }

  // helper method to check if a row and col are off the board
  // returns true if position is off board
  // returns false if position is on board
  protected boolean outOfBounds(int row, int col) {
    return ((row < 0) || (col < 0) || (row > (getBoardSize() - 1))
            || (col > (getBoardSize() - 1)));
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
        boolean a = validDown(i, j) || validUp(i, j) || validLeft(i, j) || validRight(i, j);
        anyValidMoves = anyValidMoves || a;
      }
    }
    return !anyValidMoves;
  }

  /**
   * method to check the board size of this board.
   *
   * @return the board size of this board.
   */
  @Override
  public int getBoardSize() {
    if (slotStates != null) {
      return this.arm * 3 - 2;
    }
    return 0;
  }

  /**
   * returns the SlotState at a given row and col in the board.
   *
   * @param row the row of the position sought, starting at 0.
   * @param col the column of the position sought, starting at 0.
   * @return the slotState at the inputted row and col.
   * @throws IllegalArgumentException if the row and col are beyond the dimensions of the board.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if ((row > slotStates.length) || col > slotStates.length) {
      throw new IllegalArgumentException("beyond the dimensions of the board");
    }
    return slotStates[row][col];
  }

  /**
   * method to return the score of this game.
   *
   * @return the current score of the game.
   */
  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if (slotStates[i][j] == SlotState.Marble) {
          score += 1;
        }
      }

    }
    return score;
  }
}
