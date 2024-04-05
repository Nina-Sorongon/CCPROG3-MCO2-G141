/**
 * Model class for character creation, responsible for storing and managing the player's character data.
 */
public class CharacterCreationModel {
    private String playerName;
    private String playerJobClass;
    private int playerLevel;
    private int playerHP;
    private int playerEndurance;
    private int playerDexterity;
    private int playerStrength;
    private int playerIntelligence;
    private int playerFaith;
    private final String[] jobClasses = {"Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet"};
    private final int[][] baseStats = {
        {15, 11, 13, 14, 9, 9}, // Vagabond
        {12, 13, 15, 12, 9, 8}, // Samurai
        {11, 11, 16, 10, 10, 8}, // Warrior
        {14, 12, 9, 16, 7, 8},  // Hero
        {9, 9, 12, 8, 16, 7},   // Astrologer
        {10, 8, 10, 11, 7, 16}  // Prophet
    };

    /**
     * Constructor for the CharacterCreationModel class.
     */
    public CharacterCreationModel() {
        this.playerName = "";
        this.playerJobClass = "";
    }

    /**
     * Gets the player's name.
     *
     * @return The player's name.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets the player's name.
     *
     * @param playerName The player's name.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Gets the player's job class.
     *
     * @return The player's job class.
     */
    public String getPlayerJobClass() {
        return playerJobClass;
    }

    /**
     * Sets the player's job class and updates the player's stats based on the chosen class.
     *
     * @param playerJobClass The player's job class.
     */
    public void setPlayerJobClass(String playerJobClass) {
        this.playerJobClass = playerJobClass;
        setPlayerStats();
    }

    /**
     * Gets the player's level.
     *
     * @return The player's level.
     */
    public int getPlayerLevel() {
        return playerLevel;
    }

    /**
     * Gets the player's HP.
     *
     * @return The player's HP.
     */
    public int getPlayerHP() {
        return playerHP;
    }

    /**
     * Gets the player's endurance.
     *
     * @return The player's endurance.
     */
    public int getPlayerEndurance() {
        return playerEndurance;
    }

    /**
     * Gets the player's dexterity.
     *
     * @return The player's dexterity.
     */
    public int getPlayerDexterity() {
        return playerDexterity;
    }

    /**
     * Gets the player's strength.
     *
     * @return The player's strength.
     */
    public int getPlayerStrength() {
        return playerStrength;
    }


    /**
     * Gets the player's intelligence.
     *
     * @return The player's intelligence.
     */
    public int getPlayerIntelligence() {
        return playerIntelligence;
    }

    /**
     * Gets the player's faith.
     *
     * @return The player's faith.
     */
    public int getPlayerFaith() {
        return playerFaith;
    }

    /**
     * Gets the available job classes.
     *
     * @return An array of available job classes.
     */
    public String[] getJobClasses() {
        return jobClasses;
    }

    /**
     * Gets the base stats for each job class.
     *
     * @return A 2D array containing the base stats for each job class.
     */
    public int[][] getBaseStats() {
        return baseStats;
    }

    /**
     * Sets the player's stats based on the chosen job class.
     */
    private void setPlayerStats() {
        int jobClassIndex = -1;
        for (int i = 0; i < jobClasses.length; i++) {
            if (jobClasses[i].equals(playerJobClass)) {
                jobClassIndex = i;
                break;
            }
        }

        if (jobClassIndex != -1) {
            playerLevel = jobClassIndex + 6; // Simplified level setting for each class
            playerHP = baseStats[jobClassIndex][0];
            playerEndurance = baseStats[jobClassIndex][1];
            playerDexterity = baseStats[jobClassIndex][2];
            playerStrength = baseStats[jobClassIndex][3];
            playerIntelligence = baseStats[jobClassIndex][4];
            playerFaith = baseStats[jobClassIndex][5];
        }
    }
}
