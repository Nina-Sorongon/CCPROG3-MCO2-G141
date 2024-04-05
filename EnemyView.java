/**
 * Provides methods to display information about enemies in the game.
 */
public class EnemyView {
    /**
     * Displays details about the enemy including name, health, attack value, and defenses.
     *
     * @param enemy The enemy model containing the details to display.
     */
    public void displayEnemyDetails(EnemyModel enemy) {
        System.out.println("Enemy Name: " + enemy.getName());
        System.out.println("Health: " + enemy.getHealth());
        System.out.println("Attack Value: " + enemy.getAttackValue());
        System.out.println("Physical Defense: " + enemy.getPhysicalDefense());
        System.out.println("Sorcery Defense: " + enemy.getSorceryDefense());
        System.out.println("Incantation Defense: " + enemy.getIncantationDefense());
    }

    /**
     * Displays the amount of damage dealt to the enemy.
     *
     * @param damage The amount of damage dealt.
     */
    public void displayDamageDealt(int damage) {
        System.out.println("You dealt " + damage + " damage to the enemy.");
    }

    /**
     * Displays the outcome of a dodge attempt.
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
     * Displays the enemy's attack value.
     *
     * @param finalAttackValue The final attack value of the enemy.
     */
    public void displayEnemyAttack(int finalAttackValue) {
        System.out.println("The enemy attacks you for " + finalAttackValue + " damage.");
    }

    /**
     * Displays the outcome of the battle, including a result message and the runes gained.
     *
     * @param resultMessage The message indicating the result of the battle.
     * @param runesGained   The amount of runes gained in the battle.
     */
    public void displayBattleOutcome(String resultMessage, int runesGained) {
        System.out.println(resultMessage);
        System.out.println("Runes Gained: " + runesGained);
    }
}
