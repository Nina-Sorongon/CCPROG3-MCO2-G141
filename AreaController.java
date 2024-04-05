import java.util.Scanner;

/**
 * The controller class for managing the interactions between the player, the area model, and the view.
 */
public class AreaController {
	 private AreaModel model;
	 private AreaView view;

	 /**
	     * Constructs an AreaController with the specified model and view.
	     *
	     * @param model The model representing the area.
	     * @param view  The view for displaying the area.
	     */
	    public AreaController(AreaModel model, AreaView view) {
	        this.model = model;
	        this.view = view;
	    }
	    
	    /**
	     * Changes the current floor of the area to the specified floor index.
	     *
	     * @param floorIndex The index of the floor to change to.
	     */
	    public void changeFloor(int floorIndex) {
	        model.changeFloor(floorIndex);
	        view.displayCurrentFloor();
	    }

	    /**
	     * Moves the player in the specified direction.
	     *
	     * @param direction The direction to move the player ('w', 'a', 's', 'd').
	     */
	    public void movePlayer(char direction) {
	        model.movePlayer(direction);
	        view.displayCurrentFloor();
	    }

	    /**
	     * Interacts with the current tile the player is on.
	     */
	    public void interactWithCurrentTile() {
	        model.interactWithCurrentTile();
	        view.displayCurrentFloor();
	    }


	    /**
	     * Allows the player to explore the area, taking input commands from the provided scanner.
	     *
	     * @param scanner The scanner object to read user input.
	     */
	    public void exploreArea(Scanner scanner) {
	        boolean exploring = true;
	        view.displayCurrentFloor();
	        while (exploring) {
	            System.out.println("Enter a command ([W] MOVE UP, [S] MOVE DOWN, [A] MOVE LEFT, [D] MOVE RIGHT, [E] INTERACT, [Q] QUIT): ");
	            String command = scanner.nextLine().toLowerCase();
	            switch (command) {
	                case "w":
	                case "a":
	                case "s":
	                case "d":
	                    movePlayer(command.charAt(0));
	                    break;
	                case "e":
	                    interactWithCurrentTile();
	                    break;
	                case "q":
	                    exploring = false;
	                    break;
	                default:
	                    System.out.println("Invalid command.");
	                    break;
	            }	            
	        }	        
	    }
}
