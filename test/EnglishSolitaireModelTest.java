import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;

/**
 * Test class for English Solitaire model.
 */
public class EnglishSolitaireModelTest {


  // test to check is the game is over or not
  @org.junit.Test
  public void isGameOver() {
    // test for true isGameOver() state.
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3);
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(tester);
    tester.move(3, 5, 3, 3);
    tester.move(5, 4, 3, 4);
    tester.move(3, 3, 3, 5);
    tester.move(4, 2, 4, 4);
    tester.move(2, 2, 4, 2);
    tester.move(3, 6, 3, 4);
    tester.move(3, 4, 5, 4);
    tester.move(4, 1, 4, 3);
    tester.move(4, 6, 4, 4);
    tester.move(2, 1, 4, 1);
    tester.move(4, 4, 4, 2);
    tester.move(4, 1, 4, 3);
    tester.move(1, 3, 3, 3);
    tester.move(4, 3, 2, 3);
    tester.move(2, 4, 2, 2);
    tester.move(1, 2, 3, 2);
    tester.move(0, 4, 2, 4);
    tester.move(0, 2, 0, 4);
    tester.move(2, 5, 2, 3);
    tester.move(6, 4, 4, 4);
    tester.move(5, 2, 5, 4);
    tester.move(5, 4, 3, 4);
    tester.move(6, 2, 6, 4);
    assertEquals(true, tester.isGameOver());

    //test for false isGameOver() state
    EnglishSolitaireModel tester2 = new EnglishSolitaireModel(3);
    tester2.move(3, 5, 3, 3);
    tester2.move(5, 4, 3, 4);
    tester2.move(3, 3, 3, 5);
    tester2.move(4, 2, 4, 4);
    tester2.move(2, 2, 4, 2);
    tester2.move(3, 6, 3, 4);
    tester2.move(3, 4, 5, 4);
    tester2.move(4, 1, 4, 3);
    tester2.move(4, 6, 4, 4);
    tester2.move(2, 1, 4, 1);
    tester2.move(4, 4, 4, 2);
    tester2.move(4, 1, 4, 3);
    tester2.move(1, 3, 3, 3);
    tester2.move(4, 3, 2, 3);
    tester2.move(2, 4, 2, 2);
    tester2.move(1, 2, 3, 2);
    assertEquals(false, tester2.isGameOver());
  }

  // test constructor with positive even number
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(4);
  }

  // test constructor with a negative number
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(-4);
  }

  // test constructor with center that has state invalid
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor3() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(0, 1);
  }

  // test constructor that initializes center out of bounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor4() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(-1, -1);
  }

  // test constructor that initializes center out of bounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor5() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(1, 9);
  }

  // test constructor that initializes center out of bounds and invalid arm length
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor6() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(4, 1, 9);
  }

  // test constructor that initializes center out of bounds and valid arm length
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor7() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3, 1, 9);
  }

  // test constructor that initializes center as valid and invalid arm length
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor8() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(4, 3, 3);
  }


  // tests for teh function getBoardSize which is supposed to return the size of a game board
  // which is the number of slots in the longest row/column
  @org.junit.Test
  public void getBoardSize() {
    //board size test for constructor with three arguments
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3, 3, 3);
    assertEquals(7, tester.getBoardSize());
    //board size test for constructor with one argument
    EnglishSolitaireModel tester2 = new EnglishSolitaireModel(5);
    assertEquals(13, tester2.getBoardSize());
    //board size test for constructor with one argument with arm length 5
    EnglishSolitaireModel tester3 = new EnglishSolitaireModel(3);
    assertEquals(7, tester3.getBoardSize());
    //board size test for a constructor with no arguments
    EnglishSolitaireModel tester4 = new EnglishSolitaireModel();
    assertEquals(7, tester.getBoardSize());
  }

  @org.junit.Test
  public void getSlotAt() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3, 3, 3);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
  }

  @org.junit.Test
  public void getScore() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3, 2, 0);
    assertEquals(32, tester.getScore());
    tester.move(3, 1, 3, 3);
    assertEquals(31, tester.getScore());
  }

  @Test
  public void testMove() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel();
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
    EnglishSolitaireModel tester2 = new EnglishSolitaireModel();
    assertEquals(tester2.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    tester2.move(3, 1, 3, 3);
    assertEquals(tester2.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester2.getSlotAt(3, 2), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester2.getSlotAt(3, 1), MarbleSolitaireModelState.SlotState.Empty);

    //test move to the left
    EnglishSolitaireModel tester3 = new EnglishSolitaireModel();
    assertEquals(tester3.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    tester3.move(3, 5, 3, 3);
    assertEquals(tester3.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester3.getSlotAt(3, 4), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester3.getSlotAt(3, 5), MarbleSolitaireModelState.SlotState.Empty);

    //test move down
    EnglishSolitaireModel tester4 = new EnglishSolitaireModel();
    assertEquals(tester4.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    tester4.move(1, 3, 3, 3);
    assertEquals(tester4.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester4.getSlotAt(2, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester4.getSlotAt(1, 3), MarbleSolitaireModelState.SlotState.Empty);

    //test move up
    EnglishSolitaireModel tester5 = new EnglishSolitaireModel();
    assertEquals(tester5.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Empty);
    tester5.move(5, 3, 3, 3);
    assertEquals(tester5.getSlotAt(3, 3), MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(tester5.getSlotAt(4, 3), MarbleSolitaireModelState.SlotState.Empty);
    assertEquals(tester5.getSlotAt(5, 3), MarbleSolitaireModelState.SlotState.Empty);
  }

  //test invalid move - the from slot is invalid
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove1() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel();
    tester.move(3, 3, 0, 4);
  }

  //test invalid move  - the to slot is invalid
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove2() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3, 3, 2);
    tester.move(3, 5, 3, 3);
  }

  //test invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove3() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel();
    tester.move(3, 1, 3, 3);
    tester.move(3, 0, 3, 2);
  }

  //test invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove4() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel();
    tester.move(3, 0, 3, 3);
  }

  // test if marble can jump in a direction other than vertical or horizontal
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove5() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3, 4, 2);
    tester.move(2, 0, 4, 2);
  }

  // test to see if the constructor with no arguments forms the game board correctly
  @Test
  public void testConstructor1() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel();
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Invalid);
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

  // test to see if the constructor with row and col for empty slot forms the game board correctly
  @Test
  public void testConstructor2() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3, 3);
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Invalid);
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

  // test to see if the constructor with arm length, row and col for center as input forms
  // the game board correctly
  @Test
  public void testConstructor4() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3, 3, 3);
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Invalid);
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


  // test to see if the constructor with arm length as input forms the game board correctly
  @Test
  public void testConstructor3() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3);
    //testing all slots (marble, empty, and invalid) using the getSlotAt method
    assertEquals(tester.getSlotAt(0, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(0, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(0, 6), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 5), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(1, 6), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(5, 1), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 0), MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(tester.getSlotAt(6, 1), MarbleSolitaireModelState.SlotState.Invalid);

    assertEquals(tester.getSlotAt(5, 5), MarbleSolitaireModelState.SlotState.Invalid);
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

  // test to check the current score of the board
  @org.junit.Test
  public void isGetScore() {
    // test with board of size 3
    EnglishSolitaireModel tester = new EnglishSolitaireModel();
    assertEquals(32, tester.getScore());
    // check score after one valid move
    tester.move(3, 5, 3, 3);
    assertEquals(31, tester.getScore());
  }

  // test to check if view string works
  @Test
  public void testToString() {
    EnglishSolitaireModel tester = new EnglishSolitaireModel(3);
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(tester);
    // test initial board with view
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view.toString());

    // test to see if view works after a single valid move
    tester.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view.toString());
  }

  // test view for null
  @Test(expected = IllegalArgumentException.class)
  public void testNull() {
    MarbleSolitaireModelState tester = null;
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(tester);
  }

}

