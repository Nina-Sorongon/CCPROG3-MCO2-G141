/**
 * The Tile abstract class represents a tile on a floor in the game. It defines an interact method
 * that is implemented by subclasses to provide specific interactions based on the tile type.
 */
public abstract class Tile {
    public abstract void interact(PlayerCharacter player);
}

/**
 * The EmptyTile class represents an empty tile where there is nothing to interact with.
 */
class EmptyTile extends Tile {
    @Override
    public void interact(PlayerCharacter player) {
        System.out.println("There's nothing here.");
    }
}

class OutOfBoundsTile extends Tile {
    @Override
    public void interact(PlayerCharacter player) {
        System.out.println("You cannot go there.");
    }
}

/**
 * The BossTile class represents a tile where a boss enemy is encountered.
 */
class BossTile extends Tile {
	private static final String NAME = "Godrick the Grafted";
    private static final int HEALTH = 200;
    private static final int DAMAGE_MIN = 150;
    private static final int DAMAGE_MAX = 300;
    private static final double PHYSICAL_DEFENSE = 0.35;
    private static final double SORCERY_DEFENSE = 0.20;
    private static final double INCANTATION_DEFENSE = 0.15;

    @Override
    public void interact(PlayerCharacter player) {
        int damage = getRandomInRange(DAMAGE_MIN, DAMAGE_MAX);
        System.out.println("You've encountered the boss: " + NAME);
        System.out.println("Health: " + HEALTH);
        System.out.println("Damage: " + damage + " (randomized)");
        System.out.println("Physical Defense: " + PHYSICAL_DEFENSE);
        System.out.println("Sorcery Defense: " + SORCERY_DEFENSE);
        System.out.println("Incantation Defense: " + INCANTATION_DEFENSE);
        // Placeholder for future boss fight implementation
    }

    private int getRandomInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}

class RayaLucariaBossTile extends Tile {
    private static final String NAME = "Rennala, Queen of the Full Moon";
    private static final int HEALTH = 400;
    private static final int DAMAGE_MIN = 200;
    private static final int DAMAGE_MAX = 300;
    private static final double PHYSICAL_DEFENSE = 0.15;
    private static final double SORCERY_DEFENSE = 0.35;
    private static final double INCANTATION_DEFENSE = 0.25;

    @Override
    public void interact(PlayerCharacter player) {
        int damage = getRandomInRange(DAMAGE_MIN, DAMAGE_MAX);
        System.out.println("You've encountered the boss: " + NAME);
        System.out.println("Health: " + HEALTH);
        System.out.println("Damage: " + damage + " (randomized)");
        System.out.println("Physical Defense: " + PHYSICAL_DEFENSE);
        System.out.println("Sorcery Defense: " + SORCERY_DEFENSE);
        System.out.println("Incantation Defense: " + INCANTATION_DEFENSE);
        // Placeholder for future boss fight implementation
    }

    private int getRandomInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}

class EldenThroneBossTile extends Tile {
    private static final String NAME = "The Elden Beast";
    private static final int HEALTH = 800;
    private static final int DAMAGE_MIN = 250;
    private static final int DAMAGE_MAX = 500;
    private static final double PHYSICAL_DEFENSE = 0.25;
    private static final double SORCERY_DEFENSE = 0.50;
    private static final double INCANTATION_DEFENSE = 0.40;

    @Override
    public void interact(PlayerCharacter player) {
        int damage = getRandomInRange(DAMAGE_MIN, DAMAGE_MAX);
        System.out.println("You've encountered the boss: " + NAME);
        System.out.println("Health: " + HEALTH);
        System.out.println("Damage: " + damage + " (randomized)");
        System.out.println("Physical Defense: " + PHYSICAL_DEFENSE);
        System.out.println("Sorcery Defense: " + SORCERY_DEFENSE);
        System.out.println("Incantation Defense: " + INCANTATION_DEFENSE);
        // Placeholder for future boss fight implementation
    }

    private int getRandomInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}

/**
 * The FastTravelTile class represents a tile that allows the player to fast travel to different areas.
 */
class FastTravelTile extends Tile {
    private boolean isUnlocked;
    private int floorIndex;
    private GameLobbyController gameLobbyController; // Add a reference to the GameLobby

    public FastTravelTile(boolean isUnlocked, int floorIndex, GameLobbyController gameLobbyController) {
        this.isUnlocked = isUnlocked;
        this.floorIndex = floorIndex;
        this.gameLobbyController = gameLobbyController; // Initialize the GameLobby reference
    }

    @Override
    public void interact(PlayerCharacter player) {
        if (isUnlocked) {
            System.out.println("You can fast travel from here.");
            gameLobbyController.enterLobby(); // Bring the player back to the Game Lobby menu
        } else {
            System.out.println("This fast travel point is currently locked.");
        }
    }
}

/**
 * The SpawnTile class represents a tile where an enemy or treasure can spawn.
 */
 class SpawnTile extends Tile {
    private final double CHANCE_TO_SPAWN_TREASURE = 0.25;
    private boolean hasInteracted = false; // Flag to track if the tile has been interacted with
    private int areaIndex; // Add area index to determine spawn behavior
    
    public SpawnTile(int areaIndex) {
        this.areaIndex = areaIndex;
    }
    
    @Override
    public void interact(PlayerCharacter player) {	
        if (!hasInteracted) {
        	player.computeMaxHealth();
        	 if (areaIndex == 2) {
                 // Generate runes instead of spawning enemies
        		 TreasureSpawnTile treasureTile = new TreasureSpawnTile(areaIndex);
                 treasureTile.interact(player);
             } else {
	            if (Math.random() < CHANCE_TO_SPAWN_TREASURE) {
	                // Spawn treasure
	                TreasureSpawnTile treasureTile = new TreasureSpawnTile(1);
	                treasureTile.interact(player);
	            } else {
	                // Spawn enemy
	            	EnemyModel enemyModel = EnemyModel.getEnemyBasedOnArea(areaIndex);
	                EnemyView enemyView = new EnemyView();
	                EnemyController enemyController = new EnemyController(enemyModel, enemyView);

	            	System.out.println("An enemy has appeared! Initiating battle...");
	                System.out.println("[1] PLAYER NAME: " + player.getName());
	                System.out.println("[2] CURRENT PLAYER HEALTH VALUE: " + player.getMaxHealth());
	                System.out.println("[3] PLAYER SPRITE: (To be implemented later in GUI)");
	                enemyController.displayEnemyDetails();
	                Battle battle = new Battle(player, enemyModel);
	                battle.start(); // Start the battle
	            }
             }
            hasInteracted = true; // Set the flag to true after the first interaction
        } else {
            System.out.println("You've already interacted with this tile."); // Optional message
        }
    }  
    
    
    
    private int getRandomInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}

 /**
  * The TreasureSpawnTile class represents a tile where a treasure can spawn.
  */
 class TreasureSpawnTile extends Tile {
	    private int areaIndex;

	    /**
	     * Creates a new TreasureSpawnTile with the specified area index.
	     *
	     * @param areaIndex the area index
	     */
	    public TreasureSpawnTile(int areaIndex) {
	        this.areaIndex = areaIndex;
	    }

	    @Override
	    public void interact(PlayerCharacter player) {
	        // Generate a random amount of RUNES between 50 and 150 and multiply by the AREA INDEX
	        int baseRunes = (int) (Math.random() * (150 - 50 + 1) + 50);
	        int totalRunes = baseRunes * areaIndex;

	        player.addRunes(totalRunes);
	        System.out.println("You found a treasure! " + totalRunes + " runes added.");
	    }
	}


 /**
  * The DoorTile class represents a tile that acts as a door to another area.
  */
class DoorTile extends Tile {
    private AreaModel areaModel;
    private int destinationFloorIndex;

    /**
     * Creates a new DoorTile with the specified area and destination floor index.
     *
     * @param area is the area the door leads to
     * @param destinationFloorIndex the index of the destination floor
     */
    public DoorTile(AreaModel areaModel, int destinationFloorIndex) {
        this.areaModel = areaModel;
        this.destinationFloorIndex = destinationFloorIndex;
    }

    @Override
    public void interact(PlayerCharacter player) {
        areaModel.changeFloor(destinationFloorIndex);
    }
}

class CreditsTile extends Tile {
    @Override
    public void interact(PlayerCharacter player) {
        System.out.println("THANK YOU FOR PLAYING!\nELDEN ROGUE\nDEVELOPERS:\nCHAN, LINC DAELEN\nSORONGON, NINA ANGELENE");
    }
}
