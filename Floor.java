/**
 * The Floor class represents a floor in the game, consisting of a grid of tiles.
 */
public class Floor {
    private Tile[][] tiles;
    private int floorIndex;
    
    /**
     * Creates a new Floor with the specified width, height, and floor index.
     *
     * @param width      the width of the floor
     * @param height     the height of the floor
     * @param floorIndex the index of the floor
     */
    public Floor(int width, int height, int floorIndex) {
        this.tiles = new Tile[height][width];
        this.floorIndex = floorIndex;
        initializeTiles();
    }

    /**
     * Initializes all tiles on the floor as EmptyTile.
     */
    private void initializeTiles() {
    	for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = new EmptyTile(); // Initialize all tiles as EmptyTile
            }
        }
    }
    
    /**
     * Gets the tile at the specified coordinates on the floor.
     *
     * @param x the x-coordinate of the tile
     * @param y the y-coordinate of the tile
     * @return the tile at the specified coordinates, or null if the coordinates are out of bounds
     */
    public Tile getTile(int x, int y) {
        if (x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {
            return tiles[y][x];
        }
        return null; // Return null or handle out-of-bounds access appropriately
    }

    /**
     * Sets the tile at the specified coordinates on the floor.
     *
     * @param x    the x-coordinate of the tile
     * @param y    the y-coordinate of the tile
     * @param tile the tile to set
     */
    public void setTile(int x, int y, Tile tile) {
        if (x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {
            tiles[y][x] = tile;
        } else {
            System.out.println("Tile coordinates are out of bounds. x: " + x + ", y: " + y);
        }
    }
    
    /**
     * Gets the width of the floor.
     *
     * @return the width of the floor
     */
    public int getWidth() {
        if (tiles.length > 0) {
            return tiles[0].length;
        }
        return 0; // Return 0 if the tiles array has not been initialized
    }

    /**
     * Gets the height of the floor.
     *
     * @return the height of the floor
     */
    public int getHeight() {
        return tiles.length;
    }
    
    /**
     * Gets the index of the floor.
     *
     * @return the index of the floor
     */
    public int getFloorIndex() {
        return floorIndex;
    }
}
