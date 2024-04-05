/**
 * Represents an enemy in the game with attributes such as name, health, attack value, and defenses.
 */
public class EnemyModel {
    private String name;
    private int health;
    private int attackValue;
    private double physicalDefense;
    private double sorceryDefense;
    private double incantationDefense;
    private int areaIndex;

    /**
     * Constructs an EnemyModel with the specified attributes.
     *
     * @param name              The name of the enemy.
     * @param health            The health of the enemy.
     * @param attackValue       The attack value of the enemy.
     * @param physicalDefense   The physical defense of the enemy.
     * @param sorceryDefense    The sorcery defense of the enemy.
     * @param incantationDefense The incantation defense of the enemy.
     * @param areaIndex         The index of the area where the enemy is located.
     */
    public EnemyModel(String name, int health, int attackValue, double physicalDefense, double sorceryDefense, double incantationDefense, int areaIndex) {
        this.name = name;
        this.health = health;
        this.attackValue = attackValue;
        this.physicalDefense = physicalDefense;
        this.sorceryDefense = sorceryDefense;
        this.incantationDefense = incantationDefense;
        this.areaIndex = areaIndex;
    }

    /**
     * Returns an EnemyModel based on the area index.
     *
     * @param areaIndex The index of the area.
     * @return An EnemyModel based on the area index.
     */
    private static EnemyModel getStormveilCastleEnemyModel(int areaIndex) {
        int enemyType = (int) (Math.random() * 3) + 1;
        int attackValue;
        switch (enemyType) {
            case 1:
                attackValue = getRandomInRange(70, 80) * (areaIndex + 1);
                return new EnemyModel("Godrick Soldier", getRandomInRange(20, 30), attackValue, 0.20, 0.15, 0.10, areaIndex);
            case 2:
                attackValue = getRandomInRange(110, 120) * (areaIndex + 1);
                return new EnemyModel("Godrick Archer", getRandomInRange(25, 35), attackValue, 0.50, 0.15, 0.20, areaIndex);
            case 3:
                attackValue = getRandomInRange(120, 130) * (areaIndex + 1);
                return new EnemyModel("Godrick Knight", getRandomInRange(70, 80), attackValue, 0.25, 0.25, 0.20, areaIndex);
            default:
                return null; // Should not happen
        }
    }

    /**
     * Returns an EnemyModel based on the area index.
     *
     * @param areaIndex The index of the area.
     * @return An EnemyModel based on the area index.
     */
    private static EnemyModel getRayaLucariaEnemyModel(int areaIndex) {
        int enemyType = (int) (Math.random() * 3) + 1;
        int attackValue;
        switch (enemyType) {
            case 1:
                attackValue = getRandomInRange(70, 80) * (areaIndex + 1);
                return new EnemyModel("Living Jar", getRandomInRange(20, 30), attackValue, 0.20, 0.15, 0.10, areaIndex);
            case 2:
                attackValue = getRandomInRange(110, 120) * (areaIndex + 1);
                return new EnemyModel("Glintstone Sorcerer", getRandomInRange(25, 35), attackValue, 0.50, 0.15, 0.20, areaIndex);
            case 3:
                attackValue = getRandomInRange(120, 130) * (areaIndex + 1);
                return new EnemyModel("Battlemage", getRandomInRange(70, 80), attackValue, 0.25, 0.25, 0.20, areaIndex);
            default:
                return null; // Should not happen
        }
    }

    /**
     * Returns an EnemyModel based on the area index.
     *
     * @param areaIndex The index of the area.
     * @return An EnemyModel based on the area index.
     */
    public static EnemyModel getEnemyBasedOnArea(int areaIndex) {
        switch (areaIndex) {
            case 0:
                return getStormveilCastleEnemyModel(areaIndex);
            case 1:
                return getRayaLucariaEnemyModel(areaIndex);
            default:
                return null;
        }
    }

    private static int getRandomInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    
    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    /**
     * Returns the name of the enemy.
     *
     * @return The name of the enemy.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the health of the enemy.
     *
     * @return The health of the enemy.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the attack value of the enemy.
     *
     * @return The attack value of the enemy.
     */
    public int getAttackValue() {
        return attackValue;
    }

    /**
     * Returns the physical defense of the enemy.
     *
     * @return The physical defense of the enemy.
     */
    public double getPhysicalDefense() {
        return physicalDefense;
    }

    /**
     * Returns the sorcery defense of the enemy.
     *
     * @return The sorcery defense of the enemy.
     */
    public double getSorceryDefense() {
        return sorceryDefense;
    }

    /**
     * Returns the incantation defense of the enemy.
     *
     * @return The incantation defense of the enemy.
     */
    public double getIncantationDefense() {
        return incantationDefense;
    }

    /**
     * Returns the area index where the enemy is located.
     *
     * @return The area index where the enemy is located.
     */
    public int getAreaIndex() {
        return areaIndex;
    }
}
