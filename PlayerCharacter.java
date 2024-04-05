import java.util.List;
import java.util.ArrayList;

/**
 * The PlayerCharacter class represents the player's character in the game,
 * including their name, job class, stats, and runes.
 */
public class PlayerCharacter {
    private String name;
    private String jobClass;
    private int level;
    private int health;
    private int endurance;
    private int dexterity;
    private int strength;
    private int intelligence;
    private int faith;
    private int runes;
    private List<Weapon> ownedWeapons = new ArrayList<>();
    private Weapon equippedWeapon;
    private int maxHealth;


    /**
     * Constructs a new {@code PlayerCharacter} with the specified attributes.
     *
     * @param name the name of the character
     * @param jobClass the job class of the character
     * @param level the level of the character
     * @param health the health stat of the character
     * @param endurance the endurance stat of the character
     * @param dexterity the dexterity stat of the character
     * @param strength the strength stat of the character
     * @param intelligence the intelligence stat of the character
     * @param faith the faith stat of the character
     */
    public PlayerCharacter(String name, String jobClass, int level, int health, int endurance, int dexterity, int strength, int intelligence, int faith) {
        this.name = name;
        this.jobClass = jobClass;
        this.level = level;
        this.health = health;
        this.endurance = endurance;
        this.dexterity = dexterity;
        this.strength = strength;
        this.intelligence = intelligence;
        this.faith = faith;
        this.runes = 0; 
    }

    /**
     * Increases the specified stat of the character if there are enough runes to level up.
     *
     * @param stat the name of the stat to increase
     */
    public void increaseStat(String stat) {
        if (runes < getLevelUpCost()) {
            System.out.println("Not enough runes to level up. You need at least " + getLevelUpCost() + " runes.");
            return;
        }

        switch (stat.toLowerCase()) {
            case "health":
                health++;
                break;
            case "endurance":
                endurance++;
                break;
            case "dexterity":
                dexterity++;
                break;
            case "strength":
                strength++;
                break;
            case "intelligence":
                intelligence++;
                break;
            case "faith":
                faith++;
                break;
            default:
                System.out.println("Invalid stat.");
                return;
        }

        runes -= getLevelUpCost();
        level++; // Increment level after a stat increase as per game design
        System.out.println(stat + " has been increased. New value: " + getStatValue(stat));
    }

    /**
     * Levels up the character by increasing the specified stat and deducting the cost in runes.
     *
     * @param stat the name of the stat to level up
     */
     public void levelUp(String stat) {
    	 
         if (runes >= getLevelUpCost()) {
             boolean statIncreased = false;
             switch (stat.toLowerCase()) {
                 case "health":
                     if (health < 50) {
                         health++;
                         statIncreased = true;
                     }
                     break;
                 case "endurance":
                     if (endurance < 50) {
                         endurance++;
                         statIncreased = true;
                     }
                     break;
                 case "dexterity":
                     if (dexterity < 50) {
                         dexterity++;
                         statIncreased = true;
                     }
                     break;
                 case "strength":
                     if (strength < 50) {
                         strength++;
                         statIncreased = true;
                     }
                     break;
                 case "intelligence":
                     if (intelligence < 50) {
                         intelligence++;
                         statIncreased = true;
                     }
                     break;
                 case "faith":
                     if (faith < 50) {
                         faith++;
                         statIncreased = true;
                     }
                     break;
                 default:
                     System.out.println("Invalid stat.");
                     return;
             }

                if (statIncreased) {
                    runes -= getLevelUpCost();
                    level++; // Increase level by 1
                    System.out.println("You have leveled up! Current level: " + level);
                    System.out.println(stat + " has been increased to " + getStatValue(stat));
                } else {
                    System.out.println("Stat is already at maximum value.");
                }
            } else {
                System.out.println("Not enough runes to level up.");
            }
        }
    
     /**
      * Gets the value of the specified stat.
      *
      * @param stat the name of the stat to get the value of
      * @return the value of the specified stat
      */
    private int getStatValue(String stat) {
        switch (stat.toLowerCase()) {
            case "health":
                return health;
            case "endurance":
                return endurance;
            case "dexterity":
                return dexterity;
            case "strength":
                return strength;
            case "intelligence":
                return intelligence;
            case "faith":
                return faith;
            default:
                return -1; // Invalid stat name
        }
    }

    public void addWeapon(Weapon weapon) {
        this.ownedWeapons.add(weapon);
    }
    
    public List<Weapon> getOwnedWeapons() {
        return ownedWeapons;
    }
    
    public void equipWeapon(Weapon weapon) {
        if (dexterity >= weapon.getDexterityRequirement()) {
            this.equippedWeapon = weapon;
            System.out.println("Equipped " + weapon.getName());
        } else {
            System.out.println("Not enough dexterity to equip this weapon.");
        }
    }
    
    public void addWeaponStats(Weapon weapon) {
        this.health += weapon.getHpBonus();
        this.endurance += weapon.getEnduranceBonus();
        this.strength += weapon.getStrengthBonus();
        this.intelligence += weapon.getIntelligenceBonus();
        this.faith += weapon.getFaithBonus();
    }
    
    public void computeMaxHealth() {
        if (equippedWeapon != null) {
            maxHealth = 100 * ((health + equippedWeapon.getHpBonus()) / 2);
        } else {
            maxHealth = 100 * (health / 2);
        }
    }
    
    public void takeDamage(int damage) {
        health = Math.max(0, maxHealth - damage); // Ensure health doesn't go below 0
        maxHealth = health;
    }
    
    public void replenishHealth() {
        health = maxHealth;
    }

    // Getter for maxHealth
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
    
    /**
     * Gets the cost to level up based on the character's level.
     *
     * @return the cost to level up
     */
    public int getLevelUpCost() {
        return (level * 100) / 2;
    }

    /**
     * Gets the name of the character.
     *
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the job class of the character.
     *
     * @return the job class of the character
     */
    public String getJobClass() {
        return jobClass;
    }

    /**
     * Gets the level of the character.
     *
     * @return the level of the character
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the health stat of the character.
     *
     * @return the health stat of the character
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the endurance stat of the character.
     *
     * @return the endurance stat of the character
     */
    public int getEndurance() {
        return endurance;
    }

    /**
     * Gets the dexterity stat of the character.
     *
     * @return the dexterity stat of the character
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Gets the strength stat of the character.
     *
     * @return the strength stat of the character
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Gets the intelligence stat of the character.
     *
     * @return the intelligence stat of the character
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Gets the faith stat of the character.
     *
     * @return the faith stat of the character
     */
    public int getFaith() {
        return faith;
    }

    /**
     * Gets the number of runes the character has.
     *
     * @return the number of runes the character has
     */
    public int getRunes() {
        return runes;
    }

    /**
     * Adds the specified amount of runes to the character.
     *
     * @param amount the amount of runes to add
     */
    public void addRunes(int amount) {
        this.runes += amount;
    }

    /**
     * Prints the current stats of the character.
     *
    public void printStats() {
        System.out.println("Character Stats:");
        System.out.println("Name: " + name);
        System.out.println("Job Class: " + jobClass);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
        System.out.println("Endurance: " + endurance);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Strength: " + strength);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Faith: " + faith);
        System.out.println("Runes: " + runes);
    }*/
}
