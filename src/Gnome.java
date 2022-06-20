// Class Gnome contains information about a member living in this home

import java.util.Locale;

public class Gnome {
    private String name;
    private int cardID;
    private Double totalSpent;

    public Gnome() {
        totalSpent = 0.0;
    }

    public static Gnome buildGnome(String name) {
        Gnome g = new Gnome();
        switch(name.toLowerCase(Locale.ROOT)) {
            case "melly":
                g.setName("melly");
                break;
            case "mel":
                g.setName("melly");
                break;
            case "kmel":
                g.setName("melly");
                break;
            case "chelly":
                g.setName("chelly");
                break;
            case "meep":
                g.setName("chelly");
                break;
            case "chel":
                g.setName("chelly");
                break;
            case "moop":
                g.setName("alvin");
                break;
            case "alvin":
                g.setName("alvin");
                break;
        }
        return g;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double cost) {
        this.totalSpent += cost;
    }
}
