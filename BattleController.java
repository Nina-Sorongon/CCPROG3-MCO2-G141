import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Controls the flow of a battle between the player and an enemy.
 */
public class BattleController {
    private Battle battle;
    private BattleView view;
    private Scanner scanner;

    /**
     * Constructs a new BattleController with the given Battle and BattleView.
     *
     * @param battle The Battle instance to control.
     * @param view   The BattleView instance to use for displaying the battle.
     */
    public BattleController(Battle battle, BattleView view) {
        this.battle = battle;
        this.view = view;
        this.scanner = new Scanner(System.in);

    }

    /**
     * Starts the battle and controls the flow of turns until the battle is over.
     */
    public void startBattle() {
        battle.start();
        while (!battle.isBattleOver()) {
            playerTurn();
            if (!battle.isBattleOver()) {
                enemyTurn();
            }
        }
        displayBattleOutcome();
    }

    /**
     * Handles the player's turn, allowing the player to choose an action (attack or dodge).
     */
    private void playerTurn() {
        view.displayPlayerTurn();
        int choice = getInputFromUser();

        if (choice == 1) {
            view.displayAttackOptions();
            int attackType = getInputFromUser(); // Get the attack type from the user
            battle.playerTurn(); // Pass the attack type to the playerTurn method
        } else if (choice == 2) {
            battle.playerTurn(); // Pass 0 to indicate a dodge action
        }
    }

    /**
     * Handles the enemy's turn, allowing the enemy to perform an action.
     */
    private void enemyTurn() {
        view.displayEnemyTurn();
        battle.enemyTurn();
    }
    
    /**
     * Displays the outcome of the battle (win/lose) and any rewards gained.
     */
    private void displayBattleOutcome() {
        String resultMessage = battle.getResultMessage();
        int runesGained = battle.getRunesGained();
        view.displayBattleResult(resultMessage, runesGained);
    }
    
    /**
     * Gets user input from the console.
     *
     * @return The user's input as an integer.
     */
    private int getInputFromUser() {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                break; // Exit the loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return choice;
    } 
}
