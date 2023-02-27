import java.util.Iterator;
import java.util.List;

public class GnomeList implements Iterable<Gnome>{
    private List<Gnome> gnomeList;

    public void addGnome(Gnome g) {
        if (!containsGnome(g.getName())) {
            gnomeList.add(g);
        }
    }

    public void addNewGnomeByName(Name name) {
        if (!containsGnome(name)) {
            Gnome g = new Gnome(name);

        }
    }

    public Gnome getGnomeByName(Name name) {
        Gnome target = null;

        for (Gnome g : gnomeList) {
            if (g.getName() == name) {
                g = target;
            }
        }

        return target;
    }

    public void addMoneySpent(Name name, double cost) {
        Gnome g = getGnomeByName(name);
        if (g != null) {
            g.addMoneySpent(cost);
        }
    }

    public boolean containsGnome(Name name) {
        for (Gnome g : gnomeList) {
            if (g.getName() == name) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Gnome> iterator() {
        return gnomeList.iterator();
    }
}
