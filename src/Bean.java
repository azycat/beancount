import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

// Bean class describes a single item that is listed on a receipt. It represents a purchase made.

public class Bean {
    private String nameOfProduct;
    private Double cost;
    private List<Gnome> purchasers;
    private int multiplier;

    Hashtable<Name, Boolean> nameTable = new Hashtable<Name, Boolean>();

    public boolean moopy, chelly, melly, rai, libby, guest = false; // TODO evaluate if this is truly the right decision

    public Bean(String nameOfProduct, Double costOfProduct, List<Gnome> purchasers, int multiplier) {
        this.nameOfProduct = nameOfProduct;
        this.cost = costOfProduct;
        this.purchasers = purchasers;
        this.multiplier = multiplier;

        populateTable(purchasers);
    }

    private void populateTable(List<Gnome> purchasers) {
        for (Gnome g : purchasers) {

        }
    }

    public static Bean makeBeanFromLine(String line) {
        List<Gnome> purchasers = new ArrayList<>();
        String nameOfProduct = null;
        Double costOfProduct = null;
        boolean splitEven = true;
        int multiplier = 1;

        String[] beanLine = line.split("\s");
        // [0] -> name of product
        // [1] -> cost of product
        // [2...n] -> extra tokens that specify extra stuff like who purchased this, how many were purchased...etc
        int argIndex = 0;
        while (argIndex < beanLine.length) {
            switch(argIndex) {
                case 0:
                    nameOfProduct = beanLine[argIndex];
                    argIndex++;
                    break;
                case 1:
                    String costString = beanLine[argIndex];
                    costOfProduct = parseCostString(costString);
                    argIndex++;
                    break;
                case 2: // extra tokens
                case 3:
                    String extra = beanLine[argIndex];
                    if (extra.contains("x")) {
                        multiplier = multiplyBeans(beanLine[argIndex]);
                    }
                    if (containsNameToken(extra)) {
                        splitEven = false;
                    }
                    argIndex++;
                    break;
            }
        }
        if(splitEven == true && purchasers.size() == 0) {
           Gnome mel = new Gnome (Name.melly);
           Gnome chel = new Gnome(Name.chelly);
           Gnome alvin = new Gnome(Name.moopy);
           purchasers.add(mel);
           purchasers.add(chel);
           purchasers.add(alvin);
        }
        Bean newBean = new Bean(nameOfProduct, costOfProduct, purchasers, multiplier);

        return newBean;
    }

    private static boolean containsNameToken(String token) {
        boolean containsName = false;
        if (token.contains("a")) {
            containsName = true;
        }
        if (token.contains("c")) {
            Gnome chel = new Gnome(Name.chelly);
            purchasers.add(chel);
            splitEven =false;
        }
        if (extra.contains("k")) {
            Gnome mel = new Gnome (Name.melly);
            purchasers.add(mel);
            splitEven = false;
        }
    }
    private static Double parseCostString(String costString) {
        Double costOfProduct;
        if (costString.contains("-")) {
            String[] costValues = costString.split("-");
            int equationIndex = 0;
            Double sum = Double.valueOf(costValues[equationIndex]);
            equationIndex = 1;
            while (equationIndex < costValues.length) {
                sum -= Double.valueOf(costValues[equationIndex]);
                equationIndex++;
            }
            costOfProduct = sum;
        }
        else if (costString.contains("+")) {
            String[] costValues = costString.split("/+");
            int equationIndex = 0;
            Double sum = Double.valueOf(costValues[equationIndex]);
            equationIndex = 1;
            while (equationIndex < costValues.length) {
                sum += Double.valueOf(costValues[equationIndex]);
                equationIndex++;
            }
            costOfProduct = sum;
        }
        else {
            costOfProduct = Double.valueOf(costString);
        }
        return costOfProduct;
    }

    public static int multiplyBeans(String token) {
        int multiplier = Integer.parseInt((token.substring(1)));
        return multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public List<Gnome> getPurchasers() {
        return purchasers;
    }

    public boolean hasChel() {
        boolean hasChel = false;
        for (Gnome g : purchasers) {
            if (g.getName() == Name.chelly) {
                hasChel = true;
            }
        }
        return hasChel;
    }

    public boolean hasMel() {
        boolean hasMel = false;
        for (Gnome g : purchasers) {
            if (g.getName() == Name.melly) {
                hasMel = true;
            }
        }
        return hasMel;
    }

    public boolean hasMoop() {
        boolean hasMoop = false;
        for (Gnome g : purchasers) {
            if (g.getName() == Name.moopy) {
                hasMoop = true;
            }
        }
        return hasMoop;
    }

    public boolean hasRai() {
        boolean hasRai = false;
        return hasRai;
    }

    public Double getCost() {
        return cost;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }
}
