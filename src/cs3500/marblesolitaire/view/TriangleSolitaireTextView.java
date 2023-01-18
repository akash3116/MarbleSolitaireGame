package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * TriangleSolitaireTextView class which is used to represent the view of a TriangleSolitaireModel.
 */
public class TriangleSolitaireTextView implements MarbleSolitaireView {
  private MarbleSolitaireModelState test;
  private Appendable out;

  /**
   * Constructor that takes in a modelState and an Appendable and checks
   * if either of these fields are null.
   *
   * @param test represents the MarbleSolitaireModelState field.
   * @param out  represents the Appendable field.
   * @throws IllegalArgumentException when the board or the appendable field is null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState test, Appendable out)
          throws IllegalArgumentException {
    if (test == null || out == null) {
      throw new IllegalArgumentException("Board is null");
    }
    this.test = test;
    this.out = out;
  }

  /**
   * checks if the MarbleSolitaireModelState is null.
   *
   * @param test represents the MarbleSolitaireModelState.
   * @throws IllegalArgumentException if the board is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState test) throws IllegalArgumentException {
    if (test == null) {
      throw new IllegalArgumentException("Board is null");
    }
    this.test = test;
    this.out = System.out;
  }

  /**
   * toString method to represent the board with Os and _s.
   *
   * @return O's for marbles and _'s for empty.
   */
  @Override
  public String toString() {
    String view = "";

    for (int i = 0; i < test.getBoardSize(); i++) {
      String curRow = " ".repeat(test.getBoardSize() - 1 - i);

      for (int j = 0; j < test.getBoardSize(); j++) {
        if (test.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          curRow = curRow + "O ";
        }
        if (this.test.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid) {
          curRow = curRow + "  ";
        }
        if (this.test.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          curRow = curRow + "_ ";
        }
      }

      curRow = curRow.stripTrailing();
      if ((i < test.getBoardSize()) && i != 0) {
        view = view + '\n';
      }
      view = view + curRow;
    }

    return view;
  }

  /**
   * renderBoard method transmits a rendered board to the view.
   *
   * @throws IOException if the board improperly transmits to the view.
   */
  @Override
  public void renderBoard() throws IOException {
    out.append(toString() + "\n");
  }

  /**
   * the renderMessage method transmits a message to the view.
   *
   * @param message the message to be transmitted.
   * @throws IOException if the message is improperly transmitted.
   */
  @Override
  public void renderMessage(String message) throws IOException {
    out.append(message);

  }
}

