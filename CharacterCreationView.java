/**
 * View class for character creation, responsible for displaying the character creation interface and messages.
 */
public class CharacterCreationView {

    /**
     * Displays the character creation title.
     */
    public void displayCharacterCreation() {
        System.out.println("Character Creation");
    }

    /**
     * Displays the character creation options.
     */
    public void displayOptions() {
        System.out.println("1) Input Name");
        System.out.println("2) Select Job Class");
        System.out.println("3) Confirm");
        System.out.println("4) Back");
        System.out.println("Select an option:");
    }

    /**
     * Displays a prompt to input the character's name.
     */
    public void displayInputName() {
        System.out.println("Enter your character's name:");
    }

    /**
     * Displays an error message for an invalid character name.
     */
    public void displayInvalidName() {
        System.out.println("Invalid name. Please ensure your name is between 1 and 25 characters long.");
    }

    /**
     * Displays the available job classes for selection.
     *
     * @param jobClasses An array containing the available job classes.
     */
    public void displaySelectJobClass(String[] jobClasses) {
        System.out.println("Select your job class:");
        for (int i = 0; i < jobClasses.length; i++) {
            System.out.printf("%d) %s%n", i + 1, jobClasses[i]);
        }
    }

    /**
     * Displays an error message for an invalid job class selection.
     */
    public void displayInvalidSelection() {
        System.out.println("Invalid selection. Please select a valid job class.");
    }

    /**
     * Displays the base stats for the selected job class.
     *
     * @param jobClassIndex The index of the selected job class.
     * @param model         The character creation model containing the base stats.
     */
    public void displayJobClassStats(int jobClassIndex, CharacterCreationModel model) {
        int[] stats = model.getBaseStats()[jobClassIndex];
        System.out.println("You have selected: " + model.getJobClasses()[jobClassIndex]);
        System.out.println("Base Stats:");
        System.out.println("HP: " + stats[0]);
        System.out.println("Endurance: " + stats[1]);
        System.out.println("Dexterity: " + stats[2]);
        System.out.println("Strength: " + stats[3]);
        System.out.println("Intelligence: " + stats[4]);
        System.out.println("Faith: " + stats[5]);
    }

    /**
     * Displays the confirmed character's details.
     *
     * @param model The character creation model containing the character's details.
     */
    public void displayConfirmCharacter(CharacterCreationModel model) {
        System.out.println("You have created:");
        System.out.println("Name: " + model.getPlayerName());
        System.out.println("Job Class: " + model.getPlayerJobClass());
        System.out.println("Level: " + model.getPlayerLevel());
        System.out.println("HP: " + model.getPlayerHP());
        System.out.println("Endurance: " + model.getPlayerEndurance());
        System.out.println("Dexterity: " + model.getPlayerDexterity());
        System.out.println("Strength: " + model.getPlayerStrength());
        System.out.println("Intelligence: " + model.getPlayerIntelligence());
        System.out.println("Faith: " + model.getPlayerFaith());
        System.out.println("Press Enter to continue...");
    }

    /**
     * Displays an error message for an invalid input.
     */
    public void displayInputError() {
        System.out.println("Invalid input. Please enter a number.");
    }

    /**
     * Displays an error message for an invalid option.
     */
    public void displayInvalidOption() {
        System.out.println("Invalid option. Please select from the available options.");
    }

    /**
     * Displays a message indicating that the character is incomplete and must be completed before confirming.
     */
    public void displayIncompleteCharacter() {
        System.out.println("You must input a name and select a job class before confirming.");
    }
}
