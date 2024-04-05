/**
 * Controller class for managing enemy actions and interactions with the player.
 */
public class EnemyController {
    private EnemyModel enemyModel;
    private EnemyView enemyView;

    /**
     * Constructs an EnemyController with the specified EnemyModel and EnemyView.
     *
     * @param enemyModel The EnemyModel containing the enemy's data.
     * @param enemyView  The EnemyView for displaying enemy-related information.
     */
    public EnemyController(EnemyModel enemyModel, EnemyView enemyView) {
        this.enemyModel = enemyModel;
        this.enemyView = enemyView;
    }

    /**
     * Displays the details of the enemy.
     */
    public void displayEnemyDetails() {
        enemyView.displayEnemyDetails(enemyModel);
    }

    /**
     * Attacks the player with the enemy's attack value.
     *
     * @param player The PlayerCharacter object representing the player.
     */
    public void attackPlayer(PlayerCharacter player) {
        int damage = enemyModel.getAttackValue();
        player.takeDamage(damage);
        enemyView.displayEnemyAttack(damage);
    }

    /**
     * Takes damage from an attack.
     *
     * @param damage The amount of damage taken.
     */
    public void takeDamage(int damage) {
        enemyModel.takeDamage(damage);
        enemyView.displayDamageDealt(damage);
    }

    /**
     * Checks if the enemy is still alive.
     *
     * @return true if the enemy's health is greater than 0, false otherwise.
     */
    public boolean isAlive() {
        return enemyModel.getHealth() > 0;
    }
}
