import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.nio.CharBuffer;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Public test class to test the functionality of the MarbleSolitaireController with a European.
 * Game Board.
 */
public class EuropeanModelControllerTest {

  // testing if the game renders correctly after inputting an invalid move and the letter q

  @Test
  public void testQuitAfterInvalidMove() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("1 2 3 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O OInvalid Move\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36"
            , out.toString());

  }
  // test if the game renders correctly after inputting q as the first input

  @Test
  public void testQuitFirstMove() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Readable in = new StringReader("q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32"
            , out.toString());

  }
  // test to check if the game renders correctly after the input of one valid move and 'q'.

  @Test
  public void quitAfterValidMove() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4 2 4 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , out.toString());
  }
  // test if the game renders and quits after three invalid inputs and an input of q after.

  @Test
  public void testQuitAfterThreeInvalidMoves() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4 1 4 4 4 2 4 5 4 3 4 5 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O OInvalid MoveInvalid MoveInvalid Move\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", out.toString());
  }
  // test if the game renders after one valid move.

  @Test
  public void testGameAfterTwoValidMove() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4 2 4 4 4 5 4 3 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ O _ _ O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 34\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ O _ _ O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 34", out.toString());

  }
  // test if the game renders correctly after inputting "Q" as the first input

  @Test
  public void testQuitFirstMove2() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("Q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36"
            , out.toString());

  }
  // testing if the same move works for different input formats
  // this also tests if different input formats work

  // Valid move input on single line

  @Test
  public void testValidMoveOnSingleLineAndQuit() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4 2 4 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , out.toString());
  }
  // Valid move input on two line 2 on first and 2 on second.

  @Test
  public void testValidMoveOnTwoLinesAndQuit() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4 2\n 4 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , out.toString());
  }
  // 1 num on the first line and 3 num on the second line and then quit

  @Test
  public void testValidMoveOnTwoLinesAndQuit2() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4\n 2 4 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , out.toString());
  }
  // 3 valid input on the first line and 1 valid input on the second line and then quit

  @Test
  public void testValidMoveOnTwoLinesAndQuit3() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4 2 4\n 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , out.toString());
  }
  // test if the input can handle miscellaneous inputs.

  @Test
  public void testMiscellaneousInputs() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4 2 a b c d 4 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , out.toString());
  }
  // testing quit after inputting one value

  @Test
  public void testQuitAfterOneInputValue() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("1 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36"
            , out.toString());

  }
  // testing quit after inputting two values

  @Test
  public void testQuitAfterTwoInputValues() {
    EuropeanSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("1 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36"
            , out.toString());
  }
  // testing quit after inputting three values

  @Test
  public void testQuitAfterThreeInputValues() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("1 4 4 q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36"
            , out.toString());
  }
  // test play whole game

  @Test
  public void testPlayWholeGame() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4 2 4 4 2 2 4 2 4 1 4 3 2 4 2 2 3 4 3 2  4 4 4 2 4 6 4" +
            " 4 2 5 4 5 3 1 3 3 5 4 3 4 3 4 3 2 3 7 3 5 5 2 5 4 5 5 5 3 5 7 5 5 6 3 4 3 4 3 4" +
            " 1 2 2 4 2 4 1 4 3 6 5 6 3 6 2 6 4 7 4 5 4 5 4 5 6 6 6 4 6 4 6 4 4 4 3 4 5 4 5 2 " +
            "5 2 6 2 4 1 4 3 4");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35    O O O\n" +
            "  _ O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 34    O O O\n" +
            "  _ O O O O\n" +
            "O _ O O O O O\n" +
            "_ _ O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 33    O O O\n" +
            "  O _ _ O O\n" +
            "O _ O O O O O\n" +
            "_ _ O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 32    O O O\n" +
            "  O _ _ O O\n" +
            "O O _ _ O O O\n" +
            "_ _ O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 31    O O O\n" +
            "  O _ _ O O\n" +
            "O O _ _ O O O\n" +
            "_ O _ _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 30    O O O\n" +
            "  O _ _ O O\n" +
            "O O _ _ O O O\n" +
            "_ O _ O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 29    O O O\n" +
            "  O _ _ _ O\n" +
            "O O _ _ _ O O\n" +
            "_ O _ O O _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 28    O O O\n" +
            "  O _ _ _ O\n" +
            "_ _ O _ _ O O\n" +
            "_ O _ O O _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 27    O O O\n" +
            "  O _ _ _ O\n" +
            "_ _ O O _ O O\n" +
            "_ O _ _ O _ O\n" +
            "O O O _ O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 26    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ _ O O\n" +
            "_ O _ _ O _ O\n" +
            "O O O _ O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 25    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "_ O _ _ O _ O\n" +
            "O O O _ O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 24    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "_ O _ _ O _ O\n" +
            "O _ _ O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 23    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "_ O _ _ O _ O\n" +
            "O _ O _ _ O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 22    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "_ O _ _ O _ O\n" +
            "O _ O _ O _ _\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 21    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "_ O O _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  O _ O O O\n" +
            "    O O O\n" +
            "Score: 20    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "O _ _ _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  O _ O O O\n" +
            "    O O O\n" +
            "Score: 19    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "O O _ _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  O _ O O O\n" +
            "    O O O\n" +
            "Score: 18    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  O _ O O O\n" +
            "    O O O\n" +
            "Score: 17    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  O O _ _ O\n" +
            "    O O O\n" +
            "Score: 16    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  _ _ O _ O\n" +
            "    O O O\n" +
            "Score: 15    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ O O _ _\n" +
            "  _ _ _ _ O\n" +
            "    O _ O\n" +
            "Score: 14    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ _ _ O _\n" +
            "  _ _ _ _ O\n" +
            "    O _ O\n" +
            "Score: 13    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O O O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 12    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O O _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 11    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ O _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 10    O O O\n" +
            "  _ _ _ O O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 9    O O O\n" +
            "  _ _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 8    O _ O\n" +
            "  _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 7\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "  _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 7", out.toString());

  }
  // tests if an IllegalArgumentException is thrown if a constructor has a null model.

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    new MarbleSolitaireControllerImpl(null,
            new MarbleSolitaireTextView(model), new StringReader(""));
  }

  // tests if an IllegalArgumentException is thrown if a constructor has a null view

  @Test(expected = IllegalArgumentException.class)
  public void testNullView() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    new MarbleSolitaireControllerImpl(model, null, new StringReader(""));
  }

  // tests if an IllegalArgumentException is thrown if a constructor has a null readable

  @Test(expected = IllegalArgumentException.class)
  public void testNullReadable() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    new MarbleSolitaireControllerImpl(model, new MarbleSolitaireTextView(model), null);
  }

  // test if an exception is thrown when the readable

  @Test(expected = IllegalStateException.class)
  public void testReadableRunOut() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    Readable in = new StringReader("4 5 4 ");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }


  // test if renderBoard works along with try and catch.

  @Test
  public void testRenderBoard() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    try {
      view.renderBoard();
    } catch (IOException i) {
      fail("IOException should not be thrown");
    }

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", out.toString());
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
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35    O O O\n" +
            "  _ O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 34    O O O\n" +
            "  _ O O O O\n" +
            "O _ O O O O O\n" +
            "_ _ O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 33    O O O\n" +
            "  O _ _ O O\n" +
            "O _ O O O O O\n" +
            "_ _ O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 32    O O O\n" +
            "  O _ _ O O\n" +
            "O O _ _ O O O\n" +
            "_ _ O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 31    O O O\n" +
            "  O _ _ O O\n" +
            "O O _ _ O O O\n" +
            "_ O _ _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 30    O O O\n" +
            "  O _ _ O O\n" +
            "O O _ _ O O O\n" +
            "_ O _ O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 29    O O O\n" +
            "  O _ _ _ O\n" +
            "O O _ _ _ O O\n" +
            "_ O _ O O _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 28    O O O\n" +
            "  O _ _ _ O\n" +
            "_ _ O _ _ O O\n" +
            "_ O _ O O _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 27    O O O\n" +
            "  O _ _ _ O\n" +
            "_ _ O O _ O O\n" +
            "_ O _ _ O _ O\n" +
            "O O O _ O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 26    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ _ O O\n" +
            "_ O _ _ O _ O\n" +
            "O O O _ O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 25    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "_ O _ _ O _ O\n" +
            "O O O _ O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 24    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "_ O _ _ O _ O\n" +
            "O _ _ O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 23    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "_ O _ _ O _ O\n" +
            "O _ O _ _ O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 22    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "_ O _ _ O _ O\n" +
            "O _ O _ O _ _\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 21    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "_ O O _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  O _ O O O\n" +
            "    O O O\n" +
            "Score: 20    O O O\n" +
            "  O _ _ _ O\n" +
            "_ O _ _ O _ _\n" +
            "O _ _ _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  O _ O O O\n" +
            "    O O O\n" +
            "Score: 19    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "O O _ _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  O _ O O O\n" +
            "    O O O\n" +
            "Score: 18    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  O _ O O O\n" +
            "    O O O\n" +
            "Score: 17    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  O O _ _ O\n" +
            "    O O O\n" +
            "Score: 16    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ _ O _ _\n" +
            "  _ _ O _ O\n" +
            "    O O O\n" +
            "Score: 15    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ O O _ _\n" +
            "  _ _ _ _ O\n" +
            "    O _ O\n" +
            "Score: 14    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ _ _ O _\n" +
            "  _ _ _ _ O\n" +
            "    O _ O\n" +
            "Score: 13    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O _ O O O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 12    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O O _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 11    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ O _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 10    O O O\n" +
            "  _ _ _ O O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 9    O O O\n" +
            "  _ _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 8    O _ O\n" +
            "  _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 7\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "  _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O _ O\n" +
            "Score: 7", out.toString());

  }
  // tests if a fake appendable throws an exception

  @Test(expected = IllegalStateException.class)
  public void testFailAppendable1() {
    Readable in = new StringReader("");
    MarbleSolitaireControllerImplTest.CrashAppendable out =
            new MarbleSolitaireControllerImplTest.CrashAppendable();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
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
    MarbleSolitaireModel model = new EuropeanSolitaireModel(9, 11, 11);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController testController = new MarbleSolitaireControllerImpl(model, view, in);

    testController.playGame();
  }
  // Valid move input on individual lines.

  @Test
  public void testValidMoveOnIndividualLines() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("4\n 2\n 4\n 4\n q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , out.toString());
  }

  // InValid move input on individual lines.

  @Test
  public void testInValidMoveOnIndividualLines() {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Readable in = new StringReader("a\n b\n 100\n 3\n q");
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36"
            , out.toString());
  }
}


