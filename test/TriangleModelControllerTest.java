import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.nio.CharBuffer;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Class to represent the testing for the controller with a TriangleSolitaireModel.
 */
public class TriangleModelControllerTest {

  @Test
  public void testQuitAfterInvalidMove() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("1 2 3 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Invalid Move\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 14"
            , out.toString());

  }
  // test if the game renders correctly after inputting q as the first input

  @Test
  public void testQuitFirstMove() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 14"
            , out.toString());

  }
  // test to check if the game renders correctly after the input of one valid move and 'q'.

  @Test
  public void quitAfterValidMove() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("3 3 1 1 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13"
            , out.toString());
  }
  // test if the game renders and quits after three invalid inputs and an input of q after.

  @Test
  public void testQuitAfterThreeInvalidMoves() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("4 1 4 4 4 2 4 5 4 3 4 5 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Invalid MoveInvalid MoveInvalid Move\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "\n" +
            "Score: 14", out.toString());
  }
  // test if the game renders after one valid move.

  @Test
  public void testGameAfterTwoValidMove() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("3 3 1 1 3 1 3 3 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(
            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13    O\n" +
                    "   O _\n" +
                    "  _ _ O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 12\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  _ _ O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 12", out.toString());

  }
  // test if the game renders correctly after inputting "Q" as the first input

  @Test
  public void testQuitFirstMove2() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("Q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 14"
            , out.toString());

  }
  // testing if the same move works for different input formats
  // this also tests if different input formats work

  // Valid move input on single line

  @Test
  public void testValidMoveOnSingleLineAndQuit() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("3 3 1 1 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13"
            , out.toString());
  }
  // Valid move input on two line 2 on first and 2 on second.

  @Test
  public void testValidMoveOnTwoLinesAndQuit() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("3 3\n 1 1 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13"
            , out.toString());
  }
  // 1 num on the first line and 3 num on the second line and then quit

  @Test
  public void testValidMoveOnTwoLinesAndQuit2() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("3\n 3 1 1 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13"
            , out.toString());
  }
  // 3 valid input on the first line and 1 valid input on the second line and then quit

  @Test
  public void testValidMoveOnTwoLinesAndQuit3() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("3 3 1\n 1 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13"
            , out.toString());
  }
  // test if the input can handle miscellaneous inputs.

  @Test
  public void testMiscellaneousInputs() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("3 3 a b c d 1 1 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13"
            , out.toString());
  }
  // testing quit after inputting one value

  @Test
  public void testQuitAfterOneInputValue() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("1 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 14"
            , out.toString());

  }
  // testing quit after inputting two values

  @Test
  public void testQuitAfterTwoInputValues() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("1 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 14"
            , out.toString());
  }
  // testing quit after inputting three values

  @Test
  public void testQuitAfterThreeInputValues() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("1 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 14"
            , out.toString());
  }
  // test play whole game

  @Test
  public void testPlayWholeGame() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("3 3 1 1 3 1 3 3 5 1 3 1 4 3 4 1 5 3 5 1 5 5 5 3 4 4 2 2 " +
            "1 1 3 3 3 1 1 1 5 1 3 1");
    Appendable out = new StringBuilder();
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "\n" +
            "Score: 13    O\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "\n" +
            "Score: 12    O\n" +
            "   O _\n" +
            "  O _ O\n" +
            " _ O O O\n" +
            "_ O O O O\n" +
            "\n" +
            "Score: 11    O\n" +
            "   O _\n" +
            "  O _ O\n" +
            " O _ _ O\n" +
            "_ O O O O\n" +
            "\n" +
            "Score: 10    O\n" +
            "   O _\n" +
            "  O _ O\n" +
            " O _ _ O\n" +
            "O _ _ O O\n" +
            "\n" +
            "Score: 9    O\n" +
            "   O _\n" +
            "  O _ O\n" +
            " O _ _ O\n" +
            "O _ O _ _\n" +
            "\n" +
            "Score: 8    O\n" +
            "   O O\n" +
            "  O _ _\n" +
            " O _ _ _\n" +
            "O _ O _ _\n" +
            "\n" +
            "Score: 7    _\n" +
            "   O _\n" +
            "  O _ O\n" +
            " O _ _ _\n" +
            "O _ O _ _\n" +
            "\n" +
            "Score: 6    O\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " O _ _ _\n" +
            "O _ O _ _\n" +
            "\n" +
            "Score: 5    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " _ _ _ _\n" +
            "_ _ O _ _\n" +
            "\n" +
            "Score: 4\n" +
            "Game over!\n" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " _ _ _ _\n" +
            "_ _ O _ _\n" +
            "\n" +
            "Score: 4", out.toString());

  }
  // tests if an IllegalArgumentException is thrown if a constructor has a null model.

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    new MarbleSolitaireControllerImpl(null,
            new TriangleSolitaireTextView(model), new StringReader(""));
  }

  // tests if an IllegalArgumentException is thrown if a constructor has a null view

  @Test(expected = IllegalArgumentException.class)
  public void testNullView() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    new MarbleSolitaireControllerImpl(model, null, new StringReader(""));
  }

  // tests if an IllegalArgumentException is thrown if a constructor has a null readable

  @Test(expected = IllegalArgumentException.class)
  public void testNullReadable() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    new MarbleSolitaireControllerImpl(model, new TriangleSolitaireTextView(model), null);
  }

  // test if an exception is thrown when the readable

  @Test(expected = IllegalStateException.class)
  public void testReadableRunOut() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    Readable in = new StringReader("4 5 4 ");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }


  // test if renderBoard works along with try and catch.

  @Test
  public void testRenderBoard() {
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new StringBuilder();
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(model, out);
    try {
      view.renderBoard();
    } catch (IOException i) {
      fail("IOException should not be thrown");
    }

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n", out.toString());
  }

  // test quit and game over at same time, game should be over not quit

  @Test
  public void testQuitAfterLastMove() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4 2 4 4 2 2 4 2 4 1 4 3 2 4 2 2 3 4 3 2  4 4 4 2 4 6" +
            " 4 4 2 5 4 5 3 1 3 3 5 4 3 4 3 4 3 2 3 7 3 5 5 2 5 4 5 5 5 3 5 7 5 5 6 3 4 3 4 " +
            "3 4 1 2 2 4 2 4 1 4 3 6 5 6 3 6 2 6 4 7 4 5 4 5 4 5 6 6 6 4 6 4 6 4 4 4 3 4 5 4 " +
            "5 2 5 2 6 2 4 1 4 3 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("", out.toString());

  }
  // tests if a fake appendable throws an exception

  @Test(expected = IllegalStateException.class)
  public void testFailAppendable1() {
    Readable in = new StringReader("");
    MarbleSolitaireControllerImplTest.CrashAppendable out =
            new MarbleSolitaireControllerImplTest.CrashAppendable();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController testController = new MarbleSolitaireControllerImpl(model, view, in);

    testController.playGame();
  }

  /**
   * The inner class that allows tests to throw IOExceptions with a mock, corrupted appendable.
   */
  public class CrashAppendable implements Appendable {

    /**
     * Appends the specified character sequence to this {@code Appendable}.
     *
     * <p>Depending on which class implements the character sequence
     * {@code csq}, the entire sequence may not be appended.  For
     * instance, if {@code csq} is a {@link CharBuffer} then
     * the subsequence to append is defined by the buffer's position and limit.
     *
     * @param csq The character sequence to append.  If {@code csq} is
     *            {@code null}, then the four characters {@code "null"} are
     *            appended to this Appendable.
     * @return A reference to this {@code Appendable}
     * @throws IOException If an I/O error occurs
     */
    @Override
    public Appendable append(CharSequence csq) throws IOException {
      throw new IOException();
    }

    /**
     * Appends a subsequence of the specified character sequence to this
     * {@code Appendable}.
     *
     * <p>An invocation of this method of the form {@code out.append(csq, start, end)}
     * when {@code csq} is not {@code null}, behaves in
     * exactly the same way as the invocation
     *
     * <pre>
     *     out.append(csq.subSequence(start, end)) </pre>
     *
     * @param csq   The character sequence from which a subsequence will be
     *              appended.  If {@code csq} is {@code null}, then characters
     *              will be appended as if {@code csq} contained the four
     *              characters {@code "null"}.
     * @param start The index of the first character in the subsequence
     * @param end   The index of the character following the last character in the
     *              subsequence
     * @return A reference to this {@code Appendable}
     * @throws IndexOutOfBoundsException If {@code start} or {@code end} are negative, {@code start}
     *                                   is greater than {@code end}, or {@code end} is greater than
     *                                   {@code csq.length()}
     * @throws IOException               If an I/O error occurs
     */
    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
      throw new IOException();
    }

    /**
     * Appends the specified character to this {@code Appendable}.
     *
     * @param c The character to append
     * @return A reference to this {@code Appendable}
     * @throws IOException If an I/O error occurs
     */
    @Override
    public Appendable append(char c) throws IOException {
      throw new IOException();
    }
  }

  // test with custom board size.

  @Test(expected = IllegalStateException.class)
  public void testFailAppendable2() {
    Readable in = new StringReader("");
    MarbleSolitaireControllerImplTest.CrashAppendable out =
            new MarbleSolitaireControllerImplTest.CrashAppendable();
    MarbleSolitaireModel model = new TriangleSolitaireModel(9, 11, 11);
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController testController = new MarbleSolitaireControllerImpl(model, view, in);

    testController.playGame();
  }
  // Valid move input on individual lines.

  @Test
  public void testValidMoveOnIndividualLines() {
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("3\n 3\n 1\n 1\n q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 13"
            , out.toString());
  }

  // InValid move input on individual lines.

  @Test
  public void testInValidMoveOnIndividualLines() {
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    Readable in = new StringReader("a\n b\n 100\n 3\n q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "\n" +
                    "Score: 14"
            , out.toString());
  }
}

