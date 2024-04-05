import java.util.InputMismatchException;
import java.util.Scanner;

public class TitleScreenController {
    private TitleScreenModel model;
    private TitleScreenView view;
    private Scanner scanner;

    public TitleScreenController(TitleScreenModel model, TitleScreenView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void displayTitleScreen() {
        view.displayTitleScreen(model);
    }

    public int getSelection() {
        int selection = 0;
        while (true) {
            try {
                selection = scanner.nextInt();
                if (selection >= 1 && selection <= model.getOptions().length) {
                    break;
                } else {
                    view.displayInvalidOption();
                }
            } catch (InputMismatchException e) {
                view.displayInputError();
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return selection;
    }
}
