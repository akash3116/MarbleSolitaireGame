package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Public class that represents the controller for the Marble solitaire game.
 * This class implements the MarbleSolitaireController interface.
 * This class handles all user input and allocates it to the view and model class.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable in;

  /**
   * constructor instantiates the MarbleSolitaireControllerImpl class.
   *
   * @param model represents the marbleSolitaireModel.
   * @param view  represents the MarbleSolitaireView
   * @param in    represents the readable.
   * @throws IllegalArgumentException if any of the model,view, or readable are null.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable in) throws IllegalArgumentException {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException();
    }
    this.model = model;
    this.view = view;
    this.in = in;
  }

  //private method to render board at current state
  private void renderBoard() {
    try {
      view.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException("Invalid board");
    }
  }

  //private method to render message
  private void renderMessage(String s) {
    try {
      view.renderMessage(s);
    } catch (IOException e) {
      throw new IllegalStateException("Invalid message");
    }
  }

  //private method to render message with score
  private void renderScore() {
    renderMessage("\nScore: " + model.getScore());
  }

  //private method to render board when game is over
  private void renderGameOver() {
    renderMessage("\nGame over!\n");
    renderBoard();
    renderMessage("\n" + "Score: " + model.getScore());
  }

  // private method to check if inputted number is valid
  private boolean validInput(String input) {
    int in;
    try {
      in = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      return false;
    }
    return (!(in < 1 || in > model.getBoardSize()));

  }

  /**
   * The playGame method which takes in user input and sends input back to the model.
   * and sends output to the view.
   *
   * @throws IllegalStateException if there are invalid inputs or no more inputs.
   */
  @Override
  public void playGame() throws IllegalStateException {
    //this.renderScore();
    this.renderBoard();
    Scanner scan = new Scanner(in);
    boolean quit = false;
    String value;
    while (!model.isGameOver()) {
      int[] validMoves = new int[4];
      int index = 0;
      while (index < 4) {
        if (!scan.hasNext()) {
          throw new IllegalStateException("There are no more Inputs");
        }
        value = scan.next();
        if (value.equalsIgnoreCase("q")) {
          quit = true;
          break;
        } else if (validInput(value)) {
          validMoves[index] = Integer.parseInt(value);
          index += 1;
        }
      }
      if (quit) {
        renderMessage("\nGame quit!");
        renderMessage("\nState of game when quit:\n");
        renderBoard();
        renderScore();
        break;
      }
      try {
        model.move(validMoves[0] - 1, validMoves[1] - 1, validMoves[2] - 1,
                validMoves[3] - 1);
        this.renderBoard();
        this.renderScore();
      } catch (IllegalArgumentException e) {
        renderMessage("Invalid Move");
      }

    }
    if (!quit) {
      this.renderGameOver();
    }
  }
}
