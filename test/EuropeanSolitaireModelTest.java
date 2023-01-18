import org.junit.Test;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import static org.junit.Assert.assertEquals;

/**
 * EuropeanSolitaireModelTest class to represent the testing for a European Solitaire Model.
 */
public class EuropeanSolitaireModelTest {
  @Test
  public void testValidStates() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel();
    //test left side
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);
    //test right side
    assertEquals(tester.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);

    //full row is marble or not
    assertEquals(tester.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 6), MarbleSolitaireModelState.SlotState.Marble);


  }

  @Test
  public void testToString() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel();
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(tester);
    assertEquals("   " +
            " O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", view.toString());
  }


  // test constructor with positive even number

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(4);
  }

  // test constructor with a negative number

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(-4);
  }

  // test constructor with center that has state invalid

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor3() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(0, 1);
  }

  // test constructor that initializes center out of bounds

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor4() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(-1, -1);
  }

  // test constructor that initializes center out of bounds

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor5() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(1, 9);
  }

  // test constructor that initializes center out of bounds and invalid arm length

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor6() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(4, 1, 9);
  }

  // test constructor that initializes center out of bounds and valid arm length
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor7() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3, 1, 9);
  }

  // test constructor that initializes center as valid and invalid arm length
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor8() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(4, 3, 3);
  }

  // tests for teh function getBoardSize which is supposed to return the size of a game board
  // which is the number of slots in the longest row/column

  @org.junit.Test
  public void getBoardSize() {
    //board size test for constructor with three arguments
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3, 3, 3);
    assertEquals(7, tester.getBoardSize());
    //board size test for constructor with one argument
    EuropeanSolitaireModel tester2 = new EuropeanSolitaireModel(5);
    assertEquals(13, tester2.getBoardSize());
    //board size test for constructor with one argument with arm length 5
    EuropeanSolitaireModel tester3 = new EuropeanSolitaireModel(3);
    assertEquals(7, tester3.getBoardSize());
    //board size test for a constructor with no arguments
    EuropeanSolitaireModel tester4 = new EuropeanSolitaireModel();
    assertEquals(7, tester.getBoardSize());
  }

  //test the get slot at method

  @org.junit.Test
  public void getSlotAt() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3, 3, 3);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
  }

  // test if the get score method works after one valid move

  @org.junit.Test
  public void getScore() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3, 3, 3);
    assertEquals(36, tester.getScore());
    tester.move(3, 1, 3, 3);
    assertEquals(35, tester.getScore());
  }
  //Test the move function.

  @Test
  public void testMove() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel();
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    tester.move(3, 1, 3, 3);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    MarbleSolitaireTextView model = new MarbleSolitaireTextView(tester);
    System.out.println(model.toString());
    tester.move(3, 4, 3, 2);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    System.out.println(model.toString());
    tester.move(5, 4, 3, 4);
    System.out.println(model.toString());
    tester.move(2, 4, 4, 4);
    System.out.println(model.toString());

    //test move to the right
    EuropeanSolitaireModel tester2 = new EuropeanSolitaireModel();
    assertEquals(tester2.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    tester2.move(3, 1, 3, 3);
    assertEquals(tester2.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester2.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester2.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);

    //test move to the left
    EuropeanSolitaireModel tester3 = new EuropeanSolitaireModel();
    assertEquals(tester3.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    tester3.move(3, 5, 3, 3);
    assertEquals(tester3.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester3.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester3.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Empty);

    //test move down
    EuropeanSolitaireModel tester4 = new EuropeanSolitaireModel();
    assertEquals(tester4.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    tester4.move(1, 3, 3, 3);
    assertEquals(tester4.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester4.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester4.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Empty);

    //test move up
    EuropeanSolitaireModel tester5 = new EuropeanSolitaireModel();
    assertEquals(tester5.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    tester5.move(5, 3, 3, 3);
    assertEquals(tester5.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester5.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester5.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Empty);

    //test move to new marble state/ diff from the english model
    EuropeanSolitaireModel tester6 = new EuropeanSolitaireModel(3, 1, 1);
    assertEquals(tester6.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Empty);
    tester6.move(1, 3, 1, 1);
    assertEquals(tester6.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester6.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester6.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Empty);
  }

  //test invalid move - the from slot is invalid
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove1() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel();
    tester.move(3, 3, 0, 4);
  }

  //test invalid move  - the to slot is invalid
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove2() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3, 3, 2);
    tester.move(3, 5, 3, 3);
  }

  //test invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove3() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel();
    tester.move(3, 1, 3, 3);
    tester.move(3, 0, 3, 2);
  }

  //test invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove4() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel();
    tester.move(3, 0, 3, 3);
  }

  // test if marble can jump in a direction other than vertical or horizontal
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove5() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3, 4, 2);
    tester.move(2, 0, 4, 2);
  }

  // test to see if the constructor with no arguments forms the game board correctly
  @Test
  public void testConstructor1() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel();
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(6, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void testConstructor2() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3);
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(6, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void testConstructor3() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3, 3);
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(6, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Marble);
  }

  @Test
  public void testConstructor4() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3, 3, 3);
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(0, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(0, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(0, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(1, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(2, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(2, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(3, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(4, 0), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(4, 6), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(5, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(5, 4), MarbleSolitaireModelState.SlotState.Marble);

    assertEquals(tester.getSlotAt(6, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(6, 4), MarbleSolitaireModelState.SlotState.Marble);
  }

  // test to check if view string works
  @Test
  public void testToString3() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3);
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(tester);
    // test initial board with view
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", view.toString());

    // test to see if view works after a single valid move
    tester.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", view.toString());
  }

  // test view for null
  @Test(expected = IllegalArgumentException.class)
  public void testNull() {
    EuropeanSolitaireModel tester = null;
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(tester);
  }

  //test move into extra now valid cells

  @Test
  public void validCorners() {
    EuropeanSolitaireModel tester = new EuropeanSolitaireModel(3, 1, 1);
    assertEquals(tester.getSlotAt(1,1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(1,2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1,3), MarbleSolitaireModelState.SlotState.Marble);
    tester.move(1,3,1,1);
    assertEquals(tester.getSlotAt(1,1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1,2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(1,3), MarbleSolitaireModelState.SlotState.Empty);

    EuropeanSolitaireModel tester2 = new EuropeanSolitaireModel(3, 1, 5);
    assertEquals(tester2.getSlotAt(1,5), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester2.getSlotAt(1,4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester2.getSlotAt(1,3), MarbleSolitaireModelState.SlotState.Marble);
    tester2.move(1,3,1,5);
    assertEquals(tester2.getSlotAt(1,5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester2.getSlotAt(1,4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester2.getSlotAt(1,3), MarbleSolitaireModelState.SlotState.Empty);

    EuropeanSolitaireModel tester3 = new EuropeanSolitaireModel(3, 5, 1);
    assertEquals(tester3.getSlotAt(5,1), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester3.getSlotAt(5,2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester3.getSlotAt(5,3), MarbleSolitaireModelState.SlotState.Marble);
    tester3.move(5,3,5,1);
    assertEquals(tester3.getSlotAt(5,1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester3.getSlotAt(5,2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester3.getSlotAt(5,3), MarbleSolitaireModelState.SlotState.Empty);

    EuropeanSolitaireModel tester4 = new EuropeanSolitaireModel(3, 5, 5);
    assertEquals(tester4.getSlotAt(5,5), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester4.getSlotAt(5,4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester4.getSlotAt(5,3), MarbleSolitaireModelState.SlotState.Marble);
    tester4.move(5,3,5,5);
    assertEquals(tester4.getSlotAt(5,5), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester4.getSlotAt(5,4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester4.getSlotAt(5,3), MarbleSolitaireModelState.SlotState.Empty);


  }
}