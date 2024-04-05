
public class Weapon {
	 private String name;
	    private int dexterityRequirement;
	    private int cost;
	    private int hpBonus;
	    private int enduranceBonus;
	    private int strengthBonus;
	    private int intelligenceBonus;
	    private int faithBonus;

	    public Weapon(String name, int dexterityRequirement, int cost, int hpBonus, int enduranceBonus, int strengthBonus, int intelligenceBonus, int faithBonus) {
	        this.name = name;
	        this.dexterityRequirement = dexterityRequirement;
	        this.cost = cost;
	        this.hpBonus = hpBonus;
	        this.enduranceBonus = enduranceBonus;
	        this.strengthBonus = strengthBonus;
	        this.intelligenceBonus = intelligenceBonus;
	        this.faithBonus = faithBonus;
	    }

    public String getName() {
        return name;
    }

    public int getDexterityRequirement() {
        return dexterityRequirement;
    }
    
    public int getCost() {
        return cost;
    }

    public int getHpBonus() {
        return hpBonus;
    }

    public int getEnduranceBonus() {
        return enduranceBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public int getIntelligenceBonus() {
        return intelligenceBonus;
    }

    public int getFaithBonus() {
        return faithBonus;
    }
    
    @Override
    public String toString() {
        return name + " (Dex Req: " + dexterityRequirement + ")";
    }
}
