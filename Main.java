import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the title screen
        TitleScreenController titleScreenController = new TitleScreenController(new TitleScreenModel(), new TitleScreenView());
        titleScreenController.displayTitleScreen();
        int selection = titleScreenController.getSelection();

        if (selection == 1) {
            // Start the game

            // Character creation
            CharacterCreationController characterCreationController = new CharacterCreationController(new CharacterCreationModel(), new CharacterCreationView());
            boolean goBack = characterCreationController.createCharacter();

            if (!goBack) {
                // Initialize the player character
                CharacterCreationModel characterCreationModel = new CharacterCreationModel();
                PlayerCharacter playerCharacter = new PlayerCharacter(
                        characterCreationModel.getPlayerName(),
                        characterCreationModel.getPlayerJobClass(),
                        characterCreationModel.getPlayerLevel(),
                        characterCreationModel.getPlayerHP(),
                        characterCreationModel.getPlayerEndurance(),
                        characterCreationModel.getPlayerDexterity(),
                        characterCreationModel.getPlayerStrength(),
                        characterCreationModel.getPlayerIntelligence(),
                        characterCreationModel.getPlayerFaith()
                );

                // Game lobby
                GameLobbyController gameLobbyController = new GameLobbyController(null, new GameLobbyView()); // Temporarily set the model to null
                GameLobbyModel gameLobbyModel = new GameLobbyModel(playerCharacter, gameLobbyController); // Create the model
                gameLobbyController.setModel(gameLobbyModel); // Set the model in the controller
                gameLobbyController.enterLobby();
            }
        }
        scanner.close();
        System.out.println("Thank you for playing!");
    }
}
