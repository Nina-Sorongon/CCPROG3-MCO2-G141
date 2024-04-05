
public class PlayerCharacterController {
    private PlayerCharacter model;
    private PlayerCharacterView view;

    public PlayerCharacterController(PlayerCharacter model, PlayerCharacterView view) {
        this.model = model;
        this.view = view;
    }

    public void increaseStat(String stat) {
        model.increaseStat(stat);
        view.printCharacterStats(model);
    }

    public void levelUp(String stat) {
        model.levelUp(stat);
        view.printCharacterStats(model);
    }

    public void addRunes(int amount) {
        model.addRunes(amount);
        view.printCharacterStats(model);
    }

    public void equipWeapon(Weapon weapon) {
        model.equipWeapon(weapon);
        view.printCharacterStats(model);
    }
}
