import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Controller class for managing player interactions in the game lobby.
 */
public class GameLobbyController {
    private GameLobbyModel model;
    private GameLobbyView view;
    private Scanner scanner;

    /**
     * Constructor for GameLobbyController.
     *
     * @param model The GameLobbyModel containing game data.
     * @param view  The GameLobbyView for displaying game information.
     */
    public GameLobbyController(GameLobbyModel model, GameLobbyView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Sets the model for the game lobby.
     *
     * @param model The GameLobbyModel to set.
     */
    public void setModel(GameLobbyModel model) {
        this.model = model;
    }
    
    /**
     * Enters the game lobby, allowing the player to interact with the lobby menu.
     */
    public void enterLobby() {
        boolean gameRunning = true;

        while (gameRunning) {
            view.displayPlayerDetails(model.getPlayerCharacter());
            view.displayGameLobbyMenu();

            int option = getOptionFromUser();

            switch (option) {
                case 1:
                    fastTravel();
                    break;
                case 2:
                    levelUp();
                    break;
                case 3:
                    manageInventory();
                    break;
                case 4:
                    openShop();
                    break;
                case 5:
                    gameRunning = quitGame();
                    break;
                default:
                    view.displayInvalidOption();
                    break;
            }
        }
    }

    /**
     * Gets the player's choice from the user input.
     *
     * @return The user's choice as an integer.
     */
    private int getOptionFromUser() {
        int option = 0;
        boolean valid = false;

        while (!valid) {
            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                valid = option >= 1 && option <= 5;
                if (!valid) {
                    view.displayInvalidOption();
                }
            } catch (InputMismatchException e) {
                view.displayInputError();
                scanner.nextLine(); // Consume the invalid input
            }
        }

        return option;
    }

    /**
     * Allows the player to fast travel to different areas.
     */
    private void fastTravel() {
        view.displayFastTravelOptions(model.getAreas());
        while (true) {
            String input = scanner.nextLine();
            int areaChoice;
            try {
                areaChoice = Integer.parseInt(input);
                if (areaChoice >= 1 && areaChoice <= model.getAreas().size()) {
                    AreaModel selectedArea = model.getAreas().get(areaChoice - 1);
                    view.displayFastTraveling(selectedArea.getName());
                    selectedArea.resetPlayerPosition(); // Reset player position to the starting point of the area
                    selectedArea.resetTiles(); // Reset all tiles in the area
                    
                    AreaController areaController = new AreaController(selectedArea, new AreaView(selectedArea));
                    areaController.exploreArea(scanner);
                    model.getPlayerCharacter().replenishHealth(); // Replenish the player's health
                    break; // Exit the loop after successful fast travel
                } else {
                    view.displayInvalidOption();
                }
            } catch (NumberFormatException e) {
                view.displayInputError();
            }
        }
    }

    /*
     * Allows the player to level up
     */
    private void levelUp() {
        view.displayLevelUpOptions(model.getPlayerCharacter());
        int statChoice = getOptionFromUser();

        if (statChoice >= 1 && statChoice <= 6) {
            if (model.getPlayerCharacter().getRunes() >= model.getPlayerCharacter().getLevelUpCost()) {
                String statName = getStatNameFromChoice(statChoice);
            	model.getPlayerCharacter().levelUp(statName);
                view.displayLevelUpSuccess();
            } else {
                view.displayNotEnoughRunes();
            }
        } else {
            view.displayInvalidOption();
        }
    }

    private String getStatNameFromChoice(int choice) {
        switch (choice) {
            case 1: 
            	return "health";
            case 2: 
            	return "endurance";
            case 3: 
            	return "dexterity";
            case 4: 
            	return "strength";
            case 5: 
            	return "intelligence";
            case 6: 
            	return "faith";
            default: return "";
        }
    }
    
    /*
     * allows player to manage weapons in inventory
     */
    private void manageInventory() {
        view.displayInventoryOptions(model.getPlayerCharacter());
        int choice = getOptionFromUser();

        switch (choice) {
            case 1:
                selectWeapon();
                break;
            case 2:
                // Exit the inventory
                break;
            default:
                view.displayInvalidOption();
                break;
        }
    }

    /*
     * Allows player to select weapons
     */
    private void selectWeapon() {
        view.displaySelectWeapon(model.getPlayerCharacter().getOwnedWeapons(), model.getPlayerCharacter().getEquippedWeapon());
        int weaponChoice = getOptionFromUser();

        if (weaponChoice > 0 && weaponChoice <= model.getPlayerCharacter().getOwnedWeapons().size()) {
            Weapon selectedWeapon = model.getPlayerCharacter().getOwnedWeapons().get(weaponChoice - 1);
            if (model.getPlayerCharacter().getDexterity() >= selectedWeapon.getDexterityRequirement()) {
                model.getPlayerCharacter().equipWeapon(selectedWeapon);
                view.displayWeaponEquipped(selectedWeapon.getName());
            } else {
                view.displayNotEnoughDexterity();
            }
        } else if (weaponChoice == 0) {
            view.displayWeaponSelectionCancelled();
        } else {
            view.displayInvalidOption();
        }
    }

    /*
     * Lets player purchase from shop
     */
    private void openShop() {
        view.displayShopOptions(model.getAvailableWeapons(), model.getPlayerCharacter().getRunes());
        int choice = getOptionFromUser();

        if (choice == -1) {
            // Exit the shop
        } else if (choice >= 1 && choice <= model.getAvailableWeapons().size()) {
            purchaseWeapon(choice - 1);
        } else {
            view.displayInvalidOption();
        }
    }
/*
 * Allows player to purchase weapons in shop
 */
    private void purchaseWeapon(int weaponIndex) {
        Weapon selectedWeapon = model.getAvailableWeapons().get(weaponIndex);
        if (model.getPlayerCharacter().getRunes() >= selectedWeapon.getCost()) {
            model.getPlayerCharacter().addRunes(-selectedWeapon.getCost());
            model.getPlayerCharacter().addWeapon(selectedWeapon);
            view.displayWeaponPurchased(selectedWeapon.getName());
        } else {
            view.displayNotEnoughRunes();
        }
    }

    private boolean quitGame() {
        view.displayQuitMessage();
        model.setShouldQuit(true);
        return false;
    }
}