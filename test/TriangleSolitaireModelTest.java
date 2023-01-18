import org.junit.Test;

import java.io.IOException;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import static org.junit.Assert.assertEquals;


/**
 * Class to represent all the testing for a TriangleSolitaireModel.
 */
public class TriangleSolitaireModelTest {

  // test to check is the game is over or not
  @org.junit.Test
  public void isGameOver() {
    // test for true isGameOver() state.
    TriangleSolitaireModel tester = new TriangleSolitaireModel();
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(tester);
    tester.move(2, 2, 0, 0);
    tester.move(2, 0, 2, 2);
    tester.move(4, 0, 2, 0);
    tester.move(3, 2, 3, 0);
    tester.move(4, 2, 4, 0);
    tester.move(4, 4, 4, 2);
    tester.move(3, 3, 1, 1);
    tester.move(0, 0, 2, 2);
    tester.move(2, 0, 0, 0);
    tester.move(4, 0, 2, 0);
    assertEquals(true, tester.isGameOver());
  }

  // test to check is the game is over or not
  @org.junit.Test
  public void isGameOverFalse() {
    // test for true isGameOver() state.
    TriangleSolitaireModel tester = new TriangleSolitaireModel();
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(tester);
    tester.move(2, 2, 0, 0);
    tester.move(2, 0, 2, 2);
    tester.move(4, 0, 2, 0);
    tester.move(3, 2, 3, 0);
    tester.move(4, 2, 4, 0);
    tester.move(4, 4, 4, 2);
    tester.move(3, 3, 1, 1);
    tester.move(0, 0, 2, 2);
    tester.move(2, 0, 0, 0);
    assertEquals(false, tester.isGameOver());
  }

  @Test
  public void testToString2() throws IOException {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(5);
    MarbleSolitaireView view = new TriangleSolitaireTextView(tester);
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O",view.toString());
  }

  // test constructor with a negative number
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(-4);
  }

  // test constructor with center that has state invalid
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor3() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(0, 1);
  }

  // test constructor that initializes center out of bounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor4() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(-1, -1);
  }

  // test constructor that initializes center out of bounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor5() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(1, 9);
  }

  // test constructor that initializes center out of bounds and invalid arm length
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor6() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(-4, 0, 0);
  }

  // test constructor that initializes center out of bounds and valid arm length
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor7() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(3, 1, 2);
  }

  // test constructor that initializes center as valid and invalid arm length
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor8() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(-1, 3, 2);
  }

  // tests for teh function getBoardSize which is supposed to return the size of a game board
  // which is the number of slots in the longest row/column
  @org.junit.Test
  public void getBoardSize() {
    //board size test for constructor with three arguments
    TriangleSolitaireModel tester = new TriangleSolitaireModel(3, 3, 2);
    assertEquals(3, tester.getBoardSize());
    //board size test for constructor with one argument
    TriangleSolitaireModel tester2 = new TriangleSolitaireModel(5);
    assertEquals(5, tester2.getBoardSize());
    //board size test for constructor with one argument with arm length 5
    TriangleSolitaireModel tester3 = new TriangleSolitaireModel(3);
    assertEquals(3, tester3.getBoardSize());
    //board size test for a constructor with no arguments
    TriangleSolitaireModel tester4 = new TriangleSolitaireModel();
    assertEquals(5, tester4.getBoardSize());
  }

  // test get slot at method
  @org.junit.Test
  public void getSlotAt() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel();
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Empty);
  }

  @Test
  public void testMove() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel();
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Empty);
    tester.move(2, 2, 0, 0);
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Marble);

    //test move to the right
    TriangleSolitaireModel tester2 = new TriangleSolitaireModel(5, 3, 3);
    assertEquals(tester2.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    tester2.move(3, 1, 3, 3);
    assertEquals(tester2.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester2.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester2.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);

    //test move to the left
    TriangleSolitaireModel tester3 = new TriangleSolitaireModel(5, 3, 1);
    assertEquals(tester3.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);
    tester3.move(3, 3, 3, 1);
    assertEquals(tester3.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester3.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester3.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);

    //test move down
    TriangleSolitaireModel tester4 = new TriangleSolitaireModel(5, 3, 1);
    assertEquals(tester4.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);
    tester4.move(1, 1, 3, 1);
    assertEquals(tester4.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester4.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester4.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Empty);

    //test move up
    TriangleSolitaireModel tester5 = new TriangleSolitaireModel(1, 1);
    assertEquals(tester5.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Empty);
    tester5.move(3, 1, 1, 1);
    assertEquals(tester5.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester5.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester5.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);
  }

  //test invalid move - the from slot is invalid
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove1() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel();
    tester.move(3, 4, 0, 4);
  }

  //test invalid move  - the to slot is invalid
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove2() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(3, 3, 2);
    tester.move(0, 0, 2, 2);
  }

  //test invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove3() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel();
    tester.move(3, 1, 3, 3);
    tester.move(3, 0, 3, 2);
  }

  //test invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove4() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel();
    tester.move(3, -1, 3, 3);
  }

  // test to see if the constructor with no arguments forms the game board correctly
  @Test
  public void testConstructor1() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel();
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);


    assertEquals(tester.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Invalid);


    assertEquals(tester.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);

  }

  // test to see if the constructor with no arguments forms the game board correctly
  @Test
  public void testConstructor2() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(5);
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);


    assertEquals(tester.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Invalid);


    assertEquals(tester.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);

  }

  // test to see if the constructor with no arguments forms the game board correctly
  @Test
  public void testConstructor3() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(0, 0);
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);


    assertEquals(tester.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Invalid);


    assertEquals(tester.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);

  }

  // test to see if the constructor with no arguments forms the game board correctly
  @Test
  public void testConstructor4() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(5, 0, 0);
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);


    assertEquals(tester.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Invalid);


    assertEquals(tester.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);

  }

  // test to check if view string works
  @Test
  public void testToString() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(3);
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(tester);
    // test initial board with view
    assertEquals("  _\n" +
            " O O\n" +
            "O O O", view.toString());

    // test to see if view works after a single valid move
    tester.move(2, 2, 0, 0);
    assertEquals("  O\n" +
            " O _\n" +
            "O O _", view.toString());
  }

  // test view for null
  @Test(expected = IllegalArgumentException.class)
  public void testNull() {
    TriangleSolitaireModel tester = null;
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(tester);
  }

  @Test
  public void testMoveDiagonal() {
    // diag up
    TriangleSolitaireModel tester = new TriangleSolitaireModel(5);
    assertEquals(tester.getSlotAt(0,0), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(1,1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2,2), MarbleSolitaireModelState.SlotState.Marble);
    tester.move(2,2,0,0);
    assertEquals(tester.getSlotAt(0,0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1,1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(2,2), MarbleSolitaireModelState.SlotState.Empty);

    // diag down
    TriangleSolitaireModel tester2 = new TriangleSolitaireModel(5,2,2);
    assertEquals(tester2.getSlotAt(0,0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester2.getSlotAt(1,1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester2.getSlotAt(2,2), MarbleSolitaireModelState.SlotState.Empty);
    tester2.move(0,0,2,2);
    assertEquals(tester2.getSlotAt(0,0), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester2.getSlotAt(1,1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester2.getSlotAt(2,2), MarbleSolitaireModelState.SlotState.Marble);
  }

  //test score
  @Test
  public void testScore() {
    TriangleSolitaireModel tester2 = new TriangleSolitaireModel(5,2,2);
    assertEquals(tester2.getScore(),14);
    tester2.move(0,0,2,2);
    assertEquals(tester2.getScore(),13);
  }

  // test jumping over empty slot
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveJump() {
    TriangleSolitaireModel tester = new TriangleSolitaireModel(5,1,1);
    tester.move(2, 2, 0, 0);
  }


}