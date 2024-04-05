public class PlayerCharacterView {
	/**
     * Prints the current stats of the character.
     */
    public void printCharacterStats(PlayerCharacter character) {
        System.out.println("Character Stats:");
        System.out.println("Name: " + character.getName());
        System.out.println("Job Class: " + character.getJobClass());
        System.out.println("Level: " + character.getLevel());
        System.out.println("Health: " + character.getHealth());
        System.out.println("Endurance: " + character.getEndurance());
        System.out.println("Dexterity: " + character.getDexterity());
        System.out.println("Strength: " + character.getStrength());
        System.out.println("Intelligence: " + character.getIntelligence());
        System.out.println("Faith: " + character.getFaith());
        System.out.println("Runes: " + character.getRunes());
    }
}
