import java.util.ArrayList;
import java.util.List;

/**
 * The model class representing an area in the game, which consists of multiple floors.
 */
public class AreaModel {
	private String name;
    private List<Floor> floors;
    private PlayerCharacter player;
    private int currentFloorIndex = 0;; 
    private int playerPosX = 0;
    private int playerPosY = 0;
    private int index;
    private GameLobbyModel gameLobbyModel;
    private GameLobbyController gameLobbyController;


    /**
     * Constructs a new Area with the specified name, dimensions, player, index, and game lobby.
     *
     * @param name the name of the area
     * @param width the width of the area's floors
     * @param height the height of the area's floors
     * @param player the player character
     * @param index the index of the area
     * @param gameLobby the game lobby associated with the area
     */
    public AreaModel(String name, PlayerCharacter player, int index, GameLobbyController gameLobbyController) {
        this.name = name;
        this.floors = new ArrayList<>();
        this.player = player;
        this.currentFloorIndex = 0;
        this.playerPosX = 0;  // Starting X position
        this.playerPosY = 0;  // Starting Y position
        this.index = index;
        this.gameLobbyController = gameLobbyController;
        initializeFloors();
    }


    /**
     * Initializes the floors within the area.
     */
    private void initializeFloors() {
    	if (this.index == 2) {
            floors.add(new Floor(3, 9, 0)); // First floor: 3x9
            setupTilesForFirstFloorTheEldenThrone(floors.get(0));

            floors.add(new Floor(7, 7, 1)); // Second floor: 7x7
            setupTilesForSecondFloorTheEldenThrone(floors.get(1));

            floors.add(new Floor(3, 9, 2)); // Third floor: 3x9
            setupTilesForThirdFloorTheEldenThrone(floors.get(2));
        } else if (this.index == 1) { // Raya Lucaria Academy
            floors.add(new Floor(5, 5, 0)); // First floor: 5x5
            setupTilesForFirstFloorRayaLucaria(floors.get(0));

            floors.add(new Floor(3, 7, 1)); // Second floor: 5x5
            setupTilesForSecondFloorRayaLucaria(floors.get(1));

            floors.add(new Floor(5, 7, 2)); // Third floor: 5x5
            setupTilesForThirdFloorRayaLucaria(floors.get(2));

            floors.add(new Floor(6, 3, 3)); // Fourth floor: 5x5
            setupTilesForFourthFloorRayaLucaria(floors.get(3));

            floors.add(new Floor(7, 8, 4)); // Fifth floor: 5x5
            setupTilesForFifthFloorRayaLucaria(floors.get(4));
        } else { // Stormveil Castle
            floors.add(new Floor(3, 7, 0)); // First floor: 3x7
            setupTilesForFirstFloorStormveilCastle(floors.get(0));

            floors.add(new Floor(7, 7, 1)); // Second floor: 7x7
            setupTilesForSecondFloorStormveilCastle(floors.get(1));

            floors.add(new Floor(5, 7, 2)); // Third floor: 5x7
            setupTilesForThirdFloorStormveilCastle(floors.get(2));
        }

    }
    
    /**
     * Sets up tiles for the third floor based on a predefined layout.
     *
     * @param floor the third floor
     */
    private void setupTilesForThirdFloorStormveilCastle(Floor floor) {
        String[][] layout = {
            {" ", " ", "F", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "B", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "D", " ", " "}
        };
        applyLayoutToFloor(floor, layout);
        floor.setTile(2, 6, new DoorTile(this, 1)); // Door leading back to floor 2
        floor.setTile(2, 0, new FastTravelTile(true, 0, this.gameLobbyController));
    }
    
    /**
     * Sets up tiles for the second floor based on a predefined layout.
     *
     * @param floor the second floor
     */
    private void setupTilesForSecondFloorStormveilCastle(Floor floor) {
        String[][] layout = {
            {" ", " ", " ", "D", " ", " ", " "},
            {" ", " ", " ", "?", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {"?", " ", "?", "?", "?", " ", "?"},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "?", " ", "?", " ", " "},
            {" ", " ", " ", "D", " ", " ", " "}
        };
        applyLayoutToFloor(floor, layout);
        
        floor.setTile(3, 0, new DoorTile(this, 2)); // Door at the top leading to floor 3
        floor.setTile(3, 6, new DoorTile(this, 0)); // Door at the bottom leading back to floor 1
    }
    
    /**
     * Sets up tiles for the first floor based on a predefined layout.
     *
     * @param floor the first floor
     */
    private void setupTilesForFirstFloorStormveilCastle(Floor floor) {
    	String[][] layout = {
                {" ", "D", " "},
                {"?", " ", "?"},
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", "F", " "}
            };
            applyLayoutToFloor(floor, layout);
            floor.setTile(1, 6, new FastTravelTile(true, 0, this.gameLobbyController));
        }
    
    /**
     * Sets up tiles for the first floor of "Raya Lucaria".
     *
     * @param floor the floor to set up
     */
    private void setupTilesForFirstFloorRayaLucaria(Floor floor) {
        String[][] layout = {
            {" ", " ", "F", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " "},
            {" ", "?", " ", "?", " "},
            {" ", " ", "D", " ", " "}
        };
        applyLayoutToFloor(floor, layout);
        floor.setTile(2, 0, new FastTravelTile(true, 0, this.gameLobbyController));
    }
    
    /**
     * Sets up tiles for the second floor of "Raya Lucaria".
     *
     * @param floor the floor to set up
     */
    private void setupTilesForSecondFloorRayaLucaria(Floor floor) {
    	String[][] layout = {
    			
    		{" ", "D", " "},
    		{"?", " ", " "},
    		{" ", " ", " "},
    		{"?", " ", "D"},
    		{" ", " ", " "},
    		{"?", " ", " "},
    		{" ", " ", " "}
    };
    	applyLayoutToFloor(floor, layout);
    	floor.setTile(1, 0, new DoorTile(this, 0));
    	floor.setTile(2, 3, new DoorTile(this, 2));
    }
    
    /**
     * Sets up tiles for the third floor of "Raya Lucaria".
     *
     * @param floor the floor to set up
     */
    private void setupTilesForThirdFloorRayaLucaria(Floor floor) {
    	String[][] layout = {
       {"O", " ", "D", " ", "O"},
       {"O", " ", "?", " ", "O"},
       {" ", " ", " ", " ", " "},
       {"D", " ", " ", " ", "D"},
       {" ", " ", " ", " ", " "},
       {"O", " ", "?", " ", "O"},
       {"O", " ", " ", " ", "O"},
    	};
    	applyLayoutToFloor(floor, layout);
    	floor.setTile(0, 3, new DoorTile(this, 1));
    	floor.setTile(4, 3, new DoorTile(this, 3));
    	floor.setTile(2, 0, new DoorTile(this, 4));
    }
    
    /**
     * Sets up tiles for the fourth floor of "Raya Lucaria".
     *
     * @param floor the floor to set up
     */
    private void setupTilesForFourthFloorRayaLucaria(Floor floor) {
    	String[][] layout = {
    		{" ", " ", "?", " ", "?", " "},
    		{"D", " ", " ", " ", " ", " "},
    		{" ", " ", "?", " ", "?", " "}
    	};
    	applyLayoutToFloor(floor, layout);
    	floor.setTile(0, 1, new DoorTile(this, 2));
    	
    }
    
    /**
     * Sets up tiles for the fifth floor of "Raya Lucaria".
     *
     * @param floor the floor to set up
     */
    private void setupTilesForFifthFloorRayaLucaria(Floor floor) {
    	String[][] layout = {
      {"O", "O", " ", "F", " ", "O", "O"},
      {" ", " ", " ", " ", " ", " ", " "},
      {" ", "?", " ", "?", " ", "?", " "},
      {" ", " ", " ", " ", " ", " ", " "},
      {" ", "?", " ", "B", " ", "?", " "},
      {" ", " ", " ", " ", " ", " ", " "},
      {" ", "?", " ", " ", " ", "?", " "},
      {" ", " ", " ", "D", " ", " ", " "},
    		};
    	applyLayoutToFloor(floor, layout);
    	floor.setTile(3, 4, new RayaLucariaBossTile());
    	floor.setTile(3, 7, new DoorTile(this, 2));
    	floor.setTile(3, 0, new FastTravelTile(true, 0, this.gameLobbyController));
    }
    
    /**
     * Sets up tiles for the first floor of "The Elden Throne".
     *
     * @param floor the floor to set up
     */
    private void setupTilesForFirstFloorTheEldenThrone (Floor floor) {
    	String[][] layout = {
    			{" ", "D", " "},
    			{" ", " ", " "},
    			{" ", " ", " "},
    			{" ", " ", " "},
    			{" ", "?", " "},
    			{" ", " ", " "},
    			{" ", " ", " "},
    			{" ", " ", " "},
    			{" ", "F", " "},
    	};
    	applyLayoutToFloor(floor, layout);
    	floor.setTile(1, 0, new DoorTile(this, 1));
    	floor.setTile(1, 8, new FastTravelTile(true, 0, this.gameLobbyController));
    }
    
    /**
     * Sets up tiles for the second floor of "The Elden Throne".
     *
     * @param floor the floor to set up
     */
    private void setupTilesForSecondFloorTheEldenThrone (Floor floor) {
    	String[][] layout = {
    			{"O", " ", " ", "D", " ", " ", "O"},
    			{" ", " ", " ", " ", " ", " ", " "},
    			{" ", " ", " ", " ", " ", " ", " "},
    			{" ", " ", " ", "B", " ", " ", " "},
    			{" ", " ", " ", " ", " ", " ", " "},
    			{" ", " ", " ", " ", " ", " ", " "},
    			{"O", " ", " ", "D", " ", " ", "O"},
    			
    	};
    	applyLayoutToFloor(floor, layout);
    	floor.setTile(3, 3, new EldenThroneBossTile());
    	floor.setTile(3, 6, new DoorTile(this, 0));
        floor.setTile(3, 0, new DoorTile(this, 2));
    }
    
    /**
     * Sets up tiles for the third floor of "The Elden Throne".
     *
     * @param floor the floor to set up
     */
    private void setupTilesForThirdFloorTheEldenThrone (Floor floor) {
    	String[][] layout = {
    			{" ", "C", " "},
    			{"?", " ", "?"},
    			{" ", " ", " "},
    			{"?", " ", "?"},
    			{" ", " ", " "},
    			{"?", " ", "?"},
    			{" ", " ", " "},
    			{"?", " ", "?"},
    			{" ", "D", " "},
    	};
    	applyLayoutToFloor(floor, layout);
    	floor.setTile(1, 8, new DoorTile(this, 1));
    	floor.setTile(1, 0, new CreditsTile());
    }
        
    public void setCurrentFloorIndex(int currentFloorIndex) {
        this.currentFloorIndex = currentFloorIndex;
    }
    /**
     * Resets the player's position to the starting point of the area.
     */
    public void resetPlayerPosition() {
    	this.currentFloorIndex = 0;
        Floor firstFloor = floors.get(0); // Get the first floor
        // Find the coordinates of the Fast Travel tile "F" on the first floor
        for (int i = 0; i < firstFloor.getHeight(); i++) {
            for (int j = 0; j < firstFloor.getWidth(); j++) {
                Tile tile = firstFloor.getTile(j, i);
                if (tile instanceof FastTravelTile) {
                    this.playerPosX = j; // Set the player's X position to the Fast Travel tile's X coordinate
                    this.playerPosY = i; // Set the player's Y position to the Fast Travel tile's Y coordinate
                    return; // Exit the method once the Fast Travel tile is found
                }
            }
        }
    }
    
    /**
     * Resets the tiles of the area.
     */
    public void resetTiles() {
        initializeFloors(); // Call the method that initializes the floors and their tiles
    }
    
    /**
     * Applies a layout to a floor by setting tiles based on the layout's symbols.
     *
     * @param floor the floor to apply the layout to
     * @param layout the layout represented as a 2D array of strings
     */
    private void applyLayoutToFloor(Floor floor, String[][] layout) {
        for (int y = 0; y < layout.length; y++) {
            for (int x = 0; x < layout[y].length; x++) {
                switch (layout[y][x]) {
                    case "F":
                        floor.setTile(x, y, new FastTravelTile(true, floor.getFloorIndex(), this.gameLobbyController));
                        break;
                    case "B":
                    	if (this.index == 0) { // Stormveil Castle
                            floor.setTile(x, y, new BossTile());
                        } else if (this.index == 1) { // Raya Lucaria Academy
                            floor.setTile(x, y, new RayaLucariaBossTile());
                        } else if (this.index == 2) { // The Elden Throne
                            floor.setTile(x, y, new EldenThroneBossTile());
                        }
                        break;
                    case "D":
                        floor.setTile(x, y, new DoorTile(this, floor.getFloorIndex() + 1));
                        break;
                    case "?":
                        floor.setTile(x, y, new SpawnTile(this.index));
                        break;
                    case "O":
                        floor.setTile(x, y, new OutOfBoundsTile());
                        break;
                    default:
                        floor.setTile(x, y, new EmptyTile());
                        break;
                }
            }
        }
    }
    
    /**
     * Moves the player in the specified direction within the current floor.
     *
     * @param direction the direction to move the player ('w', 'a', 's', 'd')
     */
    public void movePlayer(char direction) {
        int newPosX = playerPosX;
        int newPosY = playerPosY;
        switch (direction) {
            case 'w': newPosY--; break; // Move up
            case 's': newPosY++; break; // Move down
            case 'a': newPosX--; break; // Move left
            case 'd': newPosX++; break; // Move right
            default: System.out.println("Invalid direction");
                     return;
        }

        Floor currentFloor = getCurrentFloor();
        if (newPosX >= 0 && newPosX < currentFloor.getWidth() && newPosY >= 0 && newPosY < currentFloor.getHeight()) {
            Tile potentialNewTile = currentFloor.getTile(newPosX, newPosY);
            if (potentialNewTile instanceof OutOfBoundsTile) {
                System.out.println("You can't move in that direction. It's out of bounds.");
            } else {
                playerPosX = newPosX;
                playerPosY = newPosY;
            }
        } else {
            System.out.println("You can't move in that direction.");
        }
    }
    
    /**
     * Interacts with the tile at the player's current position.
     */
    public void interactWithCurrentTile() {
    	Tile currentTile = getCurrentFloor().getTile(playerPosX, playerPosY);
        if (currentTile != null) {
            currentTile.interact(player);
        } else {
            System.out.println("There is no tile to interact with at this position.");
        }
    }
    
    /**
     * Moves the player to a different floor based on the floor index.
     *
     * @param floorIndex the index of the floor to move to
     */  
    public void changeFloor(int floorIndex) {
        if (floorIndex >= 0 && floorIndex < floors.size()) {
            currentFloorIndex = floorIndex;
            System.out.println("Moved to floor " + (currentFloorIndex + 1));

            if (index == 2) { // The Elden Throne
                switch (currentFloorIndex) {
                    case 0: // First floor to second floor
                        playerPosX = 1; // Assuming the door is located centrally in a 7-width floor
                        playerPosY = 0; // The lowest Y position for the door tile on the second floor
                        break;
                    case 1: 
                        if (playerPosY == 8) { // Going up
                            playerPosX = 3; // Central position for the uppermost door tile
                            playerPosY = 0; // The highest Y position for the door tile on the third floor
                        } else { // Going back down to first floor
                            playerPosX = 3; // Central X position, assuming the first floor has a width of 3
                            playerPosY = 6; // The Y position for the door tile on the first floor
                        }
                        break;
                    case 2: // Third floor back to the second floor
                        playerPosX = 1; // Central position for the door tile on the second floor
                        playerPosY = 8; // The uppermost Y position for returning to the second floor
                        break;
                    default:
                        System.out.println("Invalid floor index: " + floorIndex);
                        break;
                }
            } else if (index == 1) { // Raya Lucaria
                switch (currentFloorIndex) {
                case 0:
                    playerPosX = 2;
                    playerPosY = 4;
                    break;
                case 1:
                    if (playerPosY == 4) {
                        playerPosX = 1;
                        playerPosY = 0;
                    } else if (playerPosY == 3) {
                        playerPosX = 2;
                        playerPosY = 3;
                    }
                    break;
                case 2: // Third floor
                    if (playerPosY == 3 && playerPosX == 2) {
                        playerPosX = 0;
                        playerPosY = 3;
                    } else if (playerPosY == 1) {
                        playerPosX = 4;
                        playerPosY = 3;
                    } else if (playerPosY == 7) {
                        playerPosX = 2;
                        playerPosY = 0;
                    }
                    break;
                case 3: // Fourth floor
                    if (playerPosY == 3 && playerPosX == 4) {
                        playerPosX = 0;
                        playerPosY = 1;
                    }
                    break;
                case 4:
                    playerPosX = 3;
                    playerPosY = 7;
                    break;
                default:
                    break;
            }
        } else { // Stormveil Castle
                switch (currentFloorIndex) {
                    case 0:
                        playerPosX = 1;
                        playerPosY = 0;
                        break;
                    case 1:
                        if (playerPosY == 6) {
                            playerPosX = 3;
                            playerPosY = 0;
                        } else {
                            playerPosX = 3;
                            playerPosY = 6;
                        }
                        break;
                    case 2:
                        playerPosX = 2;
                        playerPosY = 6;
                        break;
                    default:
                        break;
                }
            }
        } else {
            System.out.println("There is no floor with index: " + floorIndex);
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }
    
    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
    
    /**
     * Gets the name of the area.
     *
     * @return the name of the area
     */
    public String getName () {
    	return name;	
    }
    
    /**
     * Gets the index of the area.
     *
     * @return the index of the area
     */
    public int getIndex() {
        return index;
    }
    
    /**
     * Gets the player character of the area.
     *
     * @return the player character
     */
    public PlayerCharacter getPlayer() {
        return player;
    }

    /**
     * Sets the player character of the area.
     *
     * @param player the player character to set
     */
    public void setPlayer(PlayerCharacter player) {
        this.player = player;
    }
    
    /**
     * Gets the X position of the player within the area.
     *
     * @return the X position of the player
     */
    public int getPlayerPosX() {
        return playerPosX;
    }

    /**
     * Gets the Y position of the player within the area.
     *
     * @return the Y position of the player
     */
    public int getPlayerPosY() {
        return playerPosY;
    }
    
    /**
     * Gets the current floor of the area.
     *
     * @return the current floor
     */
    public Floor getCurrentFloor() {
        return floors.get(currentFloorIndex);
    }
    
    /**
     * Gets the game lobby model associated with the area.
     *
     * @return the game lobby model
     */
    public GameLobbyModel getGameLobby() {
        return gameLobbyModel;
    }
}
