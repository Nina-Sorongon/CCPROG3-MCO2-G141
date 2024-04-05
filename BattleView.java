
/**
 * A view class for displaying battle-related information to the user.
 */
public class BattleView {
    public void displayPlayerTurn() {
        System.out.println("Player's Turn");
        System.out.println("[1] ATTACK");
        System.out.println("[2] DODGE");
        System.out.println("INCOMING ENEMY DAMAGE: ");
    }

    /**
     * Displays a message indicating the start of the player's turn.
     */
    public void displayEnemyTurn() {
        System.out.println("Enemy's Turn");
    }

    /**
     * Displays the available attack options for the player to choose from.
     */
    public void displayAttackOptions() {
        System.out.println("Select attack type:");
        System.out.println("[1] PHYSICAL");
        System.out.println("[2] SORCERY");
        System.out.println("[3] INCANTATION");
    }

    /**
     * Displays a generic message to the user.
     *
     * @param message The message to display.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays the result of the battle, including any messages and runes gained.
     *
     * @param resultMessage The message indicating the outcome of the battle.
     * @param runesGained   The amount of runes gained in the battle.
     */
    public void displayBattleResult(String resultMessage, int runesGained) {
        System.out.println(resultMessage);
        System.out.println("Runes Gained: " + runesGained);
    }
    
    /**
     * Displays the outcome of a dodge attempt by the player.
     *
     * @param dodgeSuccessful True if the dodge attempt was successful, false otherwise.
     */
    public void displayDodgeOutcome(boolean dodgeSuccessful) {
        if (dodgeSuccessful) {
            System.out.println("You successfully dodged the enemy's attack!");
        } else {
            System.out.println("Dodge failed. You will take incoming damage on the enemy's turn.");
        }
    }

    /**
     * Displays the amount of damage dealt by the player to the enemy.
     *
     * @param damage The amount of damage dealt.
     */
    public void displayDamageDealt(int damage) {
        System.out.println("You dealt " + damage + " damage to the enemy.");
    }

    /*
     * Displays the amount of damage dealt by the enemy to the player.
     *
     * @param finalAttackValue The amount of damage dealt by the enemy.
     */
    public void displayEnemyAttack(int finalAttackValue) {
        System.out.println("The enemy attacks you for " + finalAttackValue + " damage.");
    }

    /**
     * Displays the final outcome of the battle, including any messages and runes gained.
     *
     * @param resultMessage The final message indicating the outcome of the battle.
     * @param runesGained   The total amount of runes gained in the battle.
     */
    public void displayBattleOutcome(String resultMessage, int runesGained) {
        System.out.println(resultMessage);
        System.out.println("Runes Gained: " + runesGained);
    }
}
