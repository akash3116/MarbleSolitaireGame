package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractGameModel;

/**
 * English solitaire model which represents the solitaire model.
 * implements MarbleSolitaireModel interface.
 * Contains all game related functions.
 */
public class EnglishSolitaireModel extends AbstractGameModel {

  /**
   * empty constructor that sets a game board with arm length 3.
   */
  public EnglishSolitaireModel() {
    super();
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
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(3, sRow, sCol);
  }

  // constructor 3

  /**
   * constructor that takes in an arm length and places the.
   * empty slot in the center of the board.
   *
   * @param armLength represents the armLength of the given board.
   * @throws IllegalArgumentException if the armLength is invalid.
   */
  public EnglishSolitaireModel(int armLength) throws IllegalArgumentException {
    super(armLength);
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
  public EnglishSolitaireModel(int armLength, int row, int col) throws IllegalArgumentException {
    super(armLength, row, col);
  }

  @Override
  // helper method to create board for each constructor
  // takes in an arm length, row, and column and initializes a board
  protected void initBoard(int armLength, int row, int col) {
    slotStates = new SlotState[(armLength * 3 - 2)][(armLength * 3 - 2)];
    for (int i = 0; i < (armLength * 3 - 2); i++) {
      for (int j = 0; j < (armLength * 3 - 2); j++) {
        if ((i < (armLength - 1) && j < (armLength - 1))
                || (i > (armLength * 2 - 2) && j < (armLength - 1)) || (i < (armLength - 1)
                &&
                j > (armLength * 2 - 2))
                || (i > (armLength * 2 - 2) && j > (armLength * 2 - 2))) {
          slotStates[i][j] = SlotState.Invalid;
        } else if (i == row && j == col) {
          slotStates[i][j] = SlotState.Empty;
        } else {
          slotStates[i][j] = SlotState.Marble;
        }
      }
    }
  }
}

