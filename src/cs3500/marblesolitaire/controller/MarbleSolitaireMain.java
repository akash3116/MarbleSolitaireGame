package cs3500.marblesolitaire.controller;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.AbstractGameModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * class for the main method that allows the user to play this game.
 * Allows the user to play different game boards using command line inputs.
 */
public class MarbleSolitaireMain {

  /**
   * The main method which allows the client to play the game.
   *
   * @param args These are the arguments that are passed into the main class.
   */
  public static void main(String[] args) {
    Readable in = new InputStreamReader(System.in);
    MarbleSolitaireModel model = userInput(args);
    MarbleSolitaireView view = userOutput(model);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);

    controller.playGame();
  }

  private static AbstractGameModel userInput(String... args) {
    if (args.length > 1) {
      return customGame(args);
    } else {
      return defaultModel(args[0]);
    }
  }

  // private method to make custom game
  private static AbstractGameModel customGame(String... args) {
    switch (args[1].toLowerCase()) {
      case "-size":
        switch (args[0].toLowerCase()) {
          case "english":
            return new EnglishSolitaireModel(Integer.parseInt(args[2]));
          case "european":
            return new EuropeanSolitaireModel(Integer.parseInt(args[2]));
          case "triangular":
            return new TriangleSolitaireModel(Integer.parseInt(args[2]));
          default:
            throw new IllegalStateException();
        }
      case "-hole":
        switch (args[0].toLowerCase()) {
          case "english":
            return new EnglishSolitaireModel(Integer.parseInt(args[2]),
                    Integer.parseInt(args[3]));
          case "european":
            return new EuropeanSolitaireModel(Integer.parseInt(args[2]),
                    Integer.parseInt(args[3]));
          case "triangular":
            return new TriangleSolitaireModel(Integer.parseInt(args[2]),
                    Integer.parseInt(args[3]));
          default:
            throw new IllegalStateException();
        }
      default:
        throw new IllegalStateException();
    }
  }

  // different cases for command line args
  private static AbstractGameModel defaultModel(String arg) {

    AbstractGameModel returnBoard = null;
    boolean picked = false;

    while (!picked) {

      switch (arg) {
        case "english":
          returnBoard = new EnglishSolitaireModel();
          picked = true;
          break;
        case "european":
          returnBoard = new EuropeanSolitaireModel();
          picked = true;
          break;
        case "triangle":
          returnBoard = new TriangleSolitaireModel();
          picked = true;
          break;
        default:
          System.out.println("Invalid board type, must be one of:\n" +
                  "english\n" + "european\n" + "triangle\n");

      }
    }

    return returnBoard;
  }

  // output of command line inputs
  private static MarbleSolitaireView userOutput(MarbleSolitaireModel model) {
    if (model instanceof TriangleSolitaireModel) {
      return new TriangleSolitaireTextView(model, System.out);
    } else {
      return new MarbleSolitaireTextView(model, System.out);
    }
  }
}
