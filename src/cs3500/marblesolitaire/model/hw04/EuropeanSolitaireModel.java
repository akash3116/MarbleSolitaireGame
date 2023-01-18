package cs3500.marblesolitaire.model.hw04;

/**
 * European Solitaire model class which extends Abstract model.
 * this class contains all game related functions for the implementation.
 * of a European solitaire game model.
 */
public class EuropeanSolitaireModel extends AbstractGameModel {

  /**
   * empty constructor that sets a game board with arm length 3.
   */
  public EuropeanSolitaireModel() {
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
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
  }

  /**
   * constructor that takes in an arm length and places the.
   * empty slot in the center of the board.
   *
   * @param armLength represents the armLength of the given board.
   * @throws IllegalArgumentException if the armLength is invalid.
   */
  public EuropeanSolitaireModel(int armLength) throws IllegalArgumentException {
    super(armLength);
  }

  /**
   * constructor that takes in arm length and initializes the center to inputted row and col.
   *
   * @param armLength represents the armLength of the given board.
   * @param row       represents a row in the game board.
   * @param col       represent a col in the game board.
   * @throws IllegalArgumentException if conditions are invalid.
   */
  public EuropeanSolitaireModel(int armLength, int row, int col) throws IllegalArgumentException {
    super(armLength, row, col);
  }

  @Override
  protected boolean boundaries(int row, int col) {
    int boardLength = (this.arm * 3 - 2);
    int a = (boardLength - this.arm);
    return ((row < (this.arm - 1) && col < ((this.arm - 1) - row)) ||
            // top Right
            (row < (this.arm - 1) && col > ((boardLength - this.arm) + row)) ||
            // bottom left
            (row > (boardLength - this.arm) && col < (row - a)) ||
            // bottom Right
            (row > (boardLength - this.arm) && col > ((2.5 * boardLength - 2.5 * this.arm) - row)));
  }


  // override the initBoard helper method from the abstract class, to initialize a European.
  // game board.

  @Override
  protected void initBoard(int side, int row, int col) {
    int boardLength = (side * 3 - 2);
    int a = (boardLength - side);
    slotStates = new SlotState[boardLength][boardLength];
    for (int i = 0; i < boardLength; i++) {
      for (int j = 0; j < boardLength; j++) {
        // top left
        if ((i < (side - 1) && j < ((side - 1) - i)) ||
                // top Right
                (i < (side - 1) && j > ((boardLength - side) + i)) ||
                // bottom left
                (i > (boardLength - side) && j < (i - a)) ||
                // bottom Right
                (i > (boardLength - side) && j > ((2.5 * boardLength - 2.5 * side) - i))) {
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
