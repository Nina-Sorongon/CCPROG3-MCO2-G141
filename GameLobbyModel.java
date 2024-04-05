import java.util.ArrayList;
import java.util.List;

public class GameLobbyModel {
    private PlayerCharacter playerCharacter;
    private List<AreaModel> areas;
    private List<Weapon> availableWeapons;
    private boolean shouldQuit;
    private GameLobbyController gameLobbyController;

    /**
     * Constructor for GameLobbyModel.
     *
     * @param playerCharacter    The player character.
     * @param gameLobbyController The game lobby controller.
     */
    public GameLobbyModel(PlayerCharacter playerCharacter, GameLobbyController gameLobbyController) {
        this.playerCharacter = playerCharacter;
        this.areas = new ArrayList<>();
        this.gameLobbyController = gameLobbyController;
        this.areas.add(new AreaModel("Stormveil Castle", playerCharacter, 0, gameLobbyController));
        this.areas.add(new AreaModel("Raya Lucaria Academy", playerCharacter, 1, gameLobbyController));
        this.areas.add(new AreaModel("The Elden Throne", playerCharacter, 2, gameLobbyController));
        this.availableWeapons = new ArrayList<>();
        initializeWeapons();
        this.shouldQuit = false;
    }

    /**
     * Initializes the available weapons in the game lobby.
     */
    private void initializeWeapons() {
    	availableWeapons.add(new Weapon("Short Sword", 13, 1000, 0, 15, 15, 15, 15));
        availableWeapons.add(new Weapon("Rogier's Rapier", 18, 2000, 10, 25, 35, 35, 35));
        availableWeapons.add(new Weapon("Coded Sword", 21, 4000, 20, 35, 40, 40, 40));
        availableWeapons.add(new Weapon("Sword of Night and Flame", 25, 8000, 30, 34, 55, 55, 55));
        availableWeapons.add(new Weapon("Uchigatana", 15, 1875, 20, 35, 30, 0, 0));
        availableWeapons.add(new Weapon("Moonveil", 20, 3750, 30, 40, 45, 0, 0));
        availableWeapons.add(new Weapon("Rivers of Blood", 25, 7500,40, 45, 60, 0, 0));
        availableWeapons.add(new Weapon("Hand of Malenia", 30, 15000, 50, 50, 75, 0, 0));
        availableWeapons.add(new Weapon("Whip", 20, 1500, 15, 60, 20, 0, 0));
        availableWeapons.add(new Weapon("Urumi", 25, 3000, 20, 70, 40, 10, 0));
        availableWeapons.add(new Weapon("Thorned Whip", 30, 5000, 30, 80, 50, 0, 40));
        availableWeapons.add(new Weapon("Hoslow's Petal Whip", 35, 10000, 35, 90, 55, 20, 20));
        availableWeapons.add(new Weapon("Claymore", 9, 3000, 15, 10, 20, 0, 0));
        availableWeapons.add(new Weapon("Starscourge Greatsword", 14, 6000, 20, 15, 40, 0, 20));
        availableWeapons.add(new Weapon("Inseperable Sword", 19, 12000, 25, 20, 70, 60, 60));
        availableWeapons.add(new Weapon("Maliketh's Black Blade", 24, 24000, 30, 25, 80, 40, 60));
        availableWeapons.add(new Weapon("Astrologer's Staff", 12, 2000, 5, 20, 5, 25, 15));
        availableWeapons.add(new Weapon("Albinauric Staff", 14, 4000, 10, 30, 10, 45, 35));
        availableWeapons.add(new Weapon("Staff of the Guilty", 16, 8000, 15, 40, 15, 65, 60));
        availableWeapons.add(new Weapon("Carian Regal Scepter", 18, 16000, 25, 50, 20, 85, 75));
        availableWeapons.add(new Weapon("Finger Seal", 10, 2500, 10, 45, 0, 15, 20));
        availableWeapons.add(new Weapon("Godslayer's Seal", 12, 5000, 15, 50, 0, 35, 40));
        availableWeapons.add(new Weapon("Golden Order Seal", 14, 10000, 20, 55, 0, 65, 65));
        availableWeapons.add(new Weapon("Dragon Communion Seal", 18, 15000, 25, 60, 0, 75, 80));
    }

    /**
     * Gets the player character.
     *
     * @return The player character.
     */
    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    /**
     * Gets the list of areas.
     *
     * @return The list of areas.
     */
    public List<AreaModel> getAreas() {
        return areas;
    }
    

    /**
     * Gets the list of available weapons.
     *
     * @return The list of available weapons.
     */
    public List<Weapon> getAvailableWeapons() {
        return availableWeapons;
    }

    /**
     * Checks if the game should quit.
     *
     * @return True if the game should quit, false otherwise.
     */
    public boolean shouldQuit() {
        return shouldQuit;
    }

    /**
     * Sets the flag for quitting the game.
     *
     * @param shouldQuit True to quit the game, false otherwise.
     */
    public void setShouldQuit(boolean shouldQuit) {
        this.shouldQuit = shouldQuit;
    }
}
