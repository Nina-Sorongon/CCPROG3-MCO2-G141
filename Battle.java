import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents a battle between the player character and an enemy.
 */
public class Battle {
    private PlayerCharacter player;
    private EnemyModel enemyModel;
    private int incomingEnemyDamage;
    private boolean dodgeSuccessful = false;
    private int areaIndex;
    private String resultMessage;
    private int runesGained;

    /**
     * Constructs a new battle with the given player and enemy.
     *
     * @param player     The player character.
     * @param enemyModel The enemy model.
     */
    public Battle(PlayerCharacter player, EnemyModel enemyModel) {
        this.player = player;
        this.enemyModel = enemyModel;
        this.resultMessage = "";
        this.runesGained = 0;
    }

    /**
     * Starts the battle, alternating between player and enemy turns until the battle is over.
     */
    public void start() {
        while (!isBattleOver()) {
            playerTurn();
            if (!isBattleOver()) {
                enemyTurn();
            }
        }

        handleBattleResult();
    }

    /**
     * Handles the result of the battle, adjusting runes gained and result message accordingly.
     */
    private void handleBattleResult() {
        if (player.getHealth() > 0) {
            int runesGained = 0; // Initialize runes gained
            resultMessage = "";

            // Check if the enemy is a boss and adjust runes and message accordingly
            switch (enemyModel.getName()) {
                case "Godrick the Grafted":
                    runesGained = 200 * 5; // Specific max health for Godrick the Grafted
                    resultMessage = "Great Enemy Felled";
                    break;
                case "Rennala, Queen of the Full Moon":
                    runesGained = 400 * 5; // Specific max health for Rennala
                    resultMessage = "Great Enemy Felled";
                    break;
                case "The Elden Beast":
                    runesGained = 800 * 5; // Specific max health for The Elden Beast
                    resultMessage = "Great Enemy Felled";
                    break;
                // Handle regular enemies based on type
                case "Godrick Soldier":
                case "Living Jar":
                    runesGained = 30 * 2; // Max health for type 1 enemies
                    resultMessage = "Enemy Felled";
                    break;
                case "Godrick Archer":
                case "Glintstone Sorcerer":
                    runesGained = 35 * 2; // Max health for type 2 enemies
                    resultMessage = "Enemy Felled";
                    break;
                case "Godrick Knight":
                case "Battlemage":
                    runesGained = 80 * 2; // Max health for type 3 enemies
                    resultMessage = "Enemy Felled";
                    break;
                default:
                    runesGained = 0; // No runes gained
                    break;
            }

            player.addRunes(runesGained);
            System.out.println("[1] Result Message: " + resultMessage);
            System.out.println("[2] Runes Gained: " + runesGained);
        } else {
            // Player loses
        	resultMessage = "You Died";
            runesGained = 0;
        }
    }

    /**
     * Handles the player's turn, allowing the player to attack or dodge.
     */
    public void playerTurn() {
        System.out.println("Player's Turn");
        System.out.println("[1] ATTACK");
        System.out.println("[2] DODGE");
        System.out.println("INCOMING ENEMY DAMAGE: " + enemyModel.getAttackValue());
        int choice = getInputFromUser();

        switch (choice) {
            case 1:
            	int attackType = selectAttackType();
                int damage = calculateDamage(attackType);
                enemyModel.takeDamage(damage);
                System.out.println("You dealt " + damage + " damage to the enemy.");
                break;
            case 2:
            	if (Math.random() < calculateDodgeRate()) {
                    System.out.println("You successfully dodged the enemy's attack!");
                    dodgeSuccessful = true;
                    incomingEnemyDamage = 0; // Reset incoming damage since the attack was dodged
                } else {
                    System.out.println("Dodge failed. You will take incoming damage on the enemy's turn.");
                }
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    /**
     * Handles the enemy's turn, allowing the enemy to attack the player.
     */
    public void enemyTurn() {
        System.out.println("Enemy's Turn");
        if (dodgeSuccessful) {
            System.out.println("You successfully dodged the enemy's attack!");
            dodgeSuccessful = false; // Reset for the next turn
        } else {
        	 int finalAttackValue = enemyModel.getAttackValue();
        	player.takeDamage(finalAttackValue);
            System.out.println("The enemy attacks you for " + finalAttackValue + " damage.");
        }
    }

    /**
     * Prompts the player to select an attack type.
     *
     * @return The selected attack type.
     */
    private int selectAttackType() {
        System.out.println("Select attack type:");
        System.out.println("[1] PHYSICAL");
        System.out.println("[2] SORCERY");
        System.out.println("[3] INCANTATION");
        int choice = getInputFromUser();
        return choice;
    }

    /**
     * Calculates the damage dealt by the player based on the selected attack type.
     *
     * @param attackType The selected attack type.
     * @return The calculated damage.
     */
    private int calculateDamage(int attackType) {
        double damage = 0;
        switch (attackType) {
            case 1: // Physical
                damage = (player.getStrength() + (player.getEquippedWeapon() != null ? player.getEquippedWeapon().getStrengthBonus() : 0)) * (1 - enemyModel.getPhysicalDefense());
                break;
            case 2: // Sorcery
                damage = (player.getIntelligence() + (player.getEquippedWeapon() != null ? player.getEquippedWeapon().getIntelligenceBonus() : 0)) * (1 - enemyModel.getSorceryDefense());
                break;
            case 3: // Incantation
                damage = (player.getFaith() + (player.getEquippedWeapon() != null ? player.getEquippedWeapon().getFaithBonus() : 0)) * (1 - enemyModel.getIncantationDefense());
                break;
        }
        return (int) damage;
    }
    
    /**
     * Calculates the player's dodge rate based on their total endurance.
     *
     * @return The calculated dodge rate.
     */
    private double calculateDodgeRate() {
        int totalEndurance = player.getEndurance() + (player.getEquippedWeapon() != null ? player.getEquippedWeapon().getEnduranceBonus() : 0);
        double dodgeRate = (20.0 + (totalEndurance / 2.0)) / 100.0;
        return dodgeRate;
    }

    /**
     * Gets user input from the console.
     *
     * @return The user's input as an integer.
     */
    private int getInputFromUser() {
        Scanner scanner = new Scanner(System.in);
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
    
    /**
     * Checks if the battle is over.
     *
     * @return True if the battle is over, false otherwise.
     */
    public boolean isBattleOver() {
        return player.getHealth() <= 0 || enemyModel.getHealth() <= 0;
    }
    
    /**
     * Gets the result message of the battle.
     *
     * @return The result message.
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * Gets the runes gained in the battle.
     *
     * @return The runes gained.
     */
    public int getRunesGained() {
        return runesGained;
    }
}
