import java.util.List;

public class GameLobbyView {

    public void displayPlayerDetails(PlayerCharacter playerCharacter) {
        System.out.println("Player Details:");
        System.out.println("Name: " + playerCharacter.getName());
        System.out.println("Job Class: " + playerCharacter.getJobClass());
        System.out.println("Level: " + playerCharacter.getLevel());
        System.out.println("Health: " + playerCharacter.getHealth());
        System.out.println("Endurance: " + playerCharacter.getEndurance());
        System.out.println("Dexterity: " + playerCharacter.getDexterity());
        System.out.println("Strength: " + playerCharacter.getStrength());
        System.out.println("Intelligence: " + playerCharacter.getIntelligence());
        System.out.println("Faith: " + playerCharacter.getFaith());
        System.out.println("Runes: " + playerCharacter.getRunes());
    }

    public void displayGameLobbyMenu() {
        System.out.println("\n--- Game Lobby ---");
        System.out.println("1) Fast Travel");
        System.out.println("2) Level Up");
        System.out.println("3) Inventory");
        System.out.println("4) Shop");
        System.out.println("5) Quit Game");
        System.out.print("Select an option: ");
    }

    public void displayInvalidOption() {
        System.out.println("Invalid option. Please try again.");
    }

    public void displayInputError() {
        System.out.println("Invalid input. Please enter a number.");
    }

    public void displayQuitMessage() {
        System.out.println("Quitting game... Thank you for playing!");
    }

    public void displayFastTravelOptions(List<AreaModel> areas) {
        System.out.println("Select an area to fast travel to:");
        for (int i = 0; i < areas.size(); i++) {
            System.out.println((i + 1) + ". " + areas.get(i).getName());
        }
        System.out.print("Enter your choice: ");
    }

    public void displayFastTraveling(String areaName) {
        System.out.println("Fast traveling to " + areaName + "...");
    }

    public void displayLevelUpOptions(PlayerCharacter playerCharacter) {
        System.out.println("Current runes: " + playerCharacter.getRunes());
        System.out.println("Level up cost: " + playerCharacter.getLevelUpCost());
        System.out.println("Which stat do you want to level up?");
        System.out.println("1) Health");
        System.out.println("2) Endurance");
        System.out.println("3) Dexterity");
        System.out.println("4) Strength");
        System.out.println("5) Intelligence");
        System.out.println("6) Faith");
        System.out.println("Enter the number of the stat you want to level up:");
    }

    public void displayLevelUpSuccess() {
        System.out.println("Stat leveled up successfully!");
    }

    public void displayNotEnoughRunes() {
        System.out.println("Not enough runes to level up.");
    }

    public void displayInventoryOptions(PlayerCharacter playerCharacter) {
        System.out.println("--- Inventory ---");
        System.out.println("Current equipped weapon: " + 
            (playerCharacter.getEquippedWeapon() != null ? playerCharacter.getEquippedWeapon().getName() : "None"));
        System.out.println("1) SELECT WEAPON");
        System.out.println("2) BACK");
        System.out.print("Choose an option: ");
    }

    public void displaySelectWeapon(List<Weapon> weapons, Weapon equippedWeapon) {
        System.out.println("Select a weapon to equip, or enter 0 to cancel:");
        for (int i = 0; i < weapons.size(); i++) {
            Weapon weapon = weapons.get(i);
            String equippedMark = weapon.equals(equippedWeapon) ? " (Equipped)" : "";
            System.out.printf("[%d] WEAPON NAME: %s%s\n", (i + 1), weapon.getName(), equippedMark);
            System.out.printf("    WEAPON DEXTERITY: %d\n", weapon.getDexterityRequirement());
            System.out.printf("    WEAPON HEALTH: %d\n", weapon.getHpBonus());
            System.out.printf("    WEAPON ENDURANCE: %d\n", weapon.getEnduranceBonus());
            System.out.printf("    WEAPON STRENGTH: %d\n", weapon.getStrengthBonus());
            System.out.printf("    WEAPON INTELLIGENCE: %d\n", weapon.getIntelligenceBonus());
            System.out.printf("    WEAPON FAITH: %d\n\n", weapon.getFaithBonus());
        }
    }

    public void displayWeaponEquipped(String weaponName) {
        System.out.println("You have equipped " + weaponName + ".");
    }

    public void displayNotEnoughDexterity() {
        System.out.println("You do not have enough dexterity to equip this weapon.");
    }

    public void displayWeaponSelectionCancelled() {
        System.out.println("Weapon selection cancelled.");
    }

    public void displayShopOptions(List<Weapon> availableWeapons, int runes) {
        System.out.println("--- Welcome to the Shop! ---");
        System.out.println("You have " + runes + " RUNES.");
        System.out.println("Available items for purchase:");

        for (int i = 0; i < availableWeapons.size(); i++) {
            Weapon weapon = availableWeapons.get(i);
            System.out.println("[" + (i + 1) + "] RUNE COST: " + weapon.getCost() +
                    ", [2] WEAPON IMAGE (To be implemented later in GUI)" +
                    ", [3] WEAPON NAME: " + weapon.getName() + 
                    ", [4] WEAPON DEXTERITY: " + weapon.getDexterityRequirement() +
                    ", [5] WEAPON HEALTH: " + weapon.getHpBonus() +
                    ", [6] WEAPON ENDURANCE: " + weapon.getEnduranceBonus() +
                    ", [7] WEAPON STRENGTH: " + weapon.getStrengthBonus() +
                    ", [8] WEAPON INTELLIGENCE: " + weapon.getIntelligenceBonus() +
                    ", [9] WEAPON FAITH: " + weapon.getFaithBonus());
        }

        System.out.println("Enter the number of the item to purchase, '0' to continue shopping, or '-1' to exit back to the lobby: ");
    }

    public void displayWeaponPurchased(String weaponName) {
        System.out.println("You have purchased " + weaponName + ".");
    }
}