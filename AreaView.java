
public class AreaView {
	private AreaModel areaModel;

	public AreaView(AreaModel areaModel) {
	    this.areaModel = areaModel;
	}
	
	/**
     * Displays the current floor layout with the player's position.
     */
    public void displayCurrentFloor() {
    	PlayerCharacter player = areaModel.getPlayer();
    	System.out.println("Player Level: " + player.getLevel() + " | Runes: " + player.getRunes());
    	Floor currentFloor = areaModel.getCurrentFloor();
   	 	int playerPosX = areaModel.getPlayerPosX();
    	int playerPosY = areaModel.getPlayerPosY();
    	
        for (int i = 0; i < currentFloor.getHeight(); i++) {
            StringBuilder rowDisplay = new StringBuilder();
            for (int j = 0; j < currentFloor.getWidth(); j++) {
                Tile tile = currentFloor.getTile(j, i);
                // If the tile is OutOfBoundsTile, skip it by appending nothing to the StringBuilder
                if (tile instanceof OutOfBoundsTile) {
                    // Append nothing, or append a specific character to indicate out of bounds (e.g., "X ")
                    rowDisplay.append("  "); // Two spaces to keep the grid alignment
                } else if (j == playerPosX && i == playerPosY) {
                    rowDisplay.append("P "); // Represent the player with a "P"
                } else if (tile instanceof EmptyTile) {
                    rowDisplay.append(". "); // Represent an empty tile with a "."
                } else if (tile instanceof BossTile || tile instanceof RayaLucariaBossTile || tile instanceof EldenThroneBossTile) {
                    rowDisplay.append("B "); // Represent a boss tile with a "B"
                } else if (tile instanceof FastTravelTile) {
                    rowDisplay.append("F "); // Represent a fast travel tile with a "F"
                } else if (tile instanceof SpawnTile) {
                    rowDisplay.append("? "); // Represent a spawn tile with a "?"
                } else if (tile instanceof DoorTile) {
                    rowDisplay.append("D "); // Represent a door tile with a "D"
                } else if (tile instanceof CreditsTile) {
                	rowDisplay.append("C ");         // Represent a credits tile with a "C"      
                }
            }
            System.out.println(rowDisplay.toString()); // Print the constructed row string
        }
    }
}
