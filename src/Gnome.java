// Class Gnome contains information about a member living in this home
// also contains Guests for now until i stop being lazy and add polymorphism for now.
// use isRealGnome() to check if a Gnome is really a gnome (SORRY)

public class Gnome {
    private final Name name;
    private int cardID;
    private double moneySpent;

    public Gnome(Name name) {
        moneySpent = 0.0;
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public boolean isRealGnome() {
        return Name.isGnome(name);
    }

    public Double getMoneySpent() {
        return moneySpent;
    }

    public void addMoneySpent(Double cost) {
        this.moneySpent += cost;
    }
}
