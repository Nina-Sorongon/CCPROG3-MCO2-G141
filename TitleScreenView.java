
public class TitleScreenView {
    public void displayTitleScreen(TitleScreenModel model) {
        System.out.println(model.getGameTitle());
        String[] options = model.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") " + options[i]);
        }
        System.out.println("Select an option: ");
    }

    public void displayInvalidOption() {
        System.out.println("Invalid option. Please select a valid option.");
    }

    public void displayInputError() {
        System.out.println("Invalid input. Please enter a number.");
    }
}
