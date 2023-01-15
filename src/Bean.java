import java.util.ArrayList;
import java.util.List;

// Bean class describes a single item that is listed on a receipt. It represents a purchase made.

public class Bean {
    private String nameOfProduct;
    private Double cost;
    private List<Gnome> purchasers;
    private int multiplier;

    public Bean(String name, Double cost, List<Gnome>purchasers, int multiplier) {
        // constructor
        this.nameOfProduct = name;
        this.cost = cost;
        this.purchasers = purchasers;
        this.multiplier = multiplier;
    }

    public static Bean makeBeanFromLine(String line) {
        List<Gnome> gnomes = new ArrayList<>();
        String name = null;
        Double cost = null;
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
                    name = beanLine[argIndex];
                    argIndex++;
                    break;
                case 1:
                    String costString = beanLine[argIndex];
                    if (costString.contains("-")) {
                        String[] costValues = costString.split("-");
                        int equationIndex = 0;
                        Double sum = Double.valueOf(costValues[equationIndex]);
                        equationIndex = 1;
                        while (equationIndex < costValues.length) {
                            sum -= Double.valueOf(costValues[equationIndex]);
                            equationIndex++;
                        }
                        cost = sum;
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
                        cost = sum;
                    }
                    else {
                        cost = Double.valueOf(costString);
                    }
                    argIndex++;
                    break;
                case 2: // extra tokens
                case 3:
                    String extra = beanLine[argIndex];
                    if (extra.contains("x")) {
                        multiplier = multiplyBeans(beanLine[argIndex]);
                    }
                    if (extra.contains("a")) {
                        Gnome alvin = new Gnome(Name.moopy);
                        gnomes.add(alvin);
                        splitEven = false;
                    }
                    if (extra.contains("c")) {
                        Gnome chel = new Gnome(Name.chelly);
                        gnomes.add(chel);
                        splitEven =false;
                    }
                    if (extra.contains("k")) {
                        Gnome mel = new Gnome (Name.melly);
                        gnomes.add(mel);
                        splitEven = false;
                    }
                    argIndex++;
                    break;
            }
        }
        if(splitEven == true && gnomes.size() == 0) {
           Gnome mel = new Gnome (Name.melly);
           Gnome chel = new Gnome(Name.chelly);
           Gnome alvin = new Gnome(Name.moopy);
           gnomes.add(mel);
           gnomes.add(chel);
           gnomes.add(alvin);
        }
        Bean newBean = new Bean(name, cost, gnomes, multiplier);

        return newBean;
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
