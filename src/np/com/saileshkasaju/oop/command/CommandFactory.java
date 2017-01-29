package np.com.saileshkasaju.oop.command;

/**
 * Created by Edge on 1/24/2017.
 */
public class CommandFactory {
  public Command get(String[] tokens) {
    try {
      switch (tokens[0]) {
        case "add":
          break;
        case "save":
          break;
        case "show":
          break;
        case "edit":
          System.out.println("Edit block\n" +
            "Yet to be implemented.");
          break;
        case "del":
          break;
        case "help":
          System.out.println("Help block\n" +
            "Yet to be implemented.");
          break;
        case "menu":
          System.out.println("Menu block\n" +
            "Yet to be implemented.\n" +
            "Should display current menu");
          break;
        default:
          System.out.println("command not found.\nAsk the programmer to add this feature.");
          break;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Syntax error");
    }
    return null;
  }
}
