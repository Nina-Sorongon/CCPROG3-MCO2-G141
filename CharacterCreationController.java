import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Controller class for character creation, responsible for handling user input and updating the model and view accordingly.
 */
public class CharacterCreationController {
    private CharacterCreationModel model;
    private CharacterCreationView view;
    private Scanner scanner;

    /**
     * Constructor for the CharacterCreationController class.
     *
     * @param model The CharacterCreationModel object.
     * @param view  The CharacterCreationView object.
     */
    public CharacterCreationController(CharacterCreationModel model, CharacterCreationView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the character creation process, allowing the user to input their character's name and select a job class.
     * Once all required information is entered, the user can confirm their character or go back to the previous screen.
     *
     * @return True if the user wants to go back to the previous screen, false if the character creation is completed.
     */
    public boolean createCharacter() {
        view.displayCharacterCreation();
        int option = 0;
        do {
            view.displayOptions();
            while (true) {
                try {
                    option = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    break; // Exit the loop if input is valid
                } catch (InputMismatchException e) {
                    view.displayInputError();
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            switch (option) {
                case 1:
                    inputPlayerName();
                    break;
                case 2:
                    selectJobClass();
                    break;
                case 3:
                    if (!model.getPlayerName().isEmpty() && !model.getPlayerJobClass().isEmpty()) {
                        confirmCharacter();
                        return false; // End character creation after confirmation
                    } else {
                        view.displayIncompleteCharacter();
                    }
                    break;
                case 4:
                    return true; // Go back to the previous screen
                default:
                    view.displayInvalidOption();
            }
        } while (true); // The loop will continue until the character is confirmed
    }

    /**
     * Prompts the user to input their character's name and sets it in the model.
     */
    private void inputPlayerName() {
        view.displayInputName();
        String name = scanner.nextLine().trim();
        while (name.isEmpty() || name.length() > 25) {
            view.displayInvalidName();
            name = scanner.nextLine().trim();
        }
        model.setPlayerName(name);
    }

    /**
     * Allows the user to select a job class from the available options and sets it in the model.
     */
    private void selectJobClass() {
        view.displaySelectJobClass(model.getJobClasses());
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= model.getJobClasses().length) {
                    validInput = true;
                } else {
                    view.displayInvalidSelection();
                }
            } catch (InputMismatchException e) {
                view.displayInputError();
                scanner.nextLine(); // Consume the invalid input
            }
        }
        model.setPlayerJobClass(model.getJobClasses()[choice - 1]);
        view.displayJobClassStats(choice - 1, model);
        scanner.nextLine(); // Consume newline left-over
    }

    /**
     * Displays a confirmation message for the character creation and waits for the user to press Enter.
     */
    private void confirmCharacter() {
        view.displayConfirmCharacter(model);
        scanner.nextLine(); // Wait for user to press Enter
    }
}
