import java.util.ArrayList;
import java.util.List;

public class Beancounter {
    private Receipt receipt;
    private List<Gnome> gnomes;

    private double chelPays = 0.0;
    private double melPays = 0.0;
    private double moopPays = 0.0;
    private double raiPays = 0.0;
    private double libbyPays = 0.0;
    private double guestPays = 0.0;

    public Beancounter(Receipt receipt) {
        this.receipt = receipt;
        splitTheBill();
    }

    public void splitTheBill() {
        List<Bean> beans = receipt.getBeanList();
        for (Bean b : beans) {
            int divisor = b.getPurchasers().size();
            double costPerPerson = (b.getCost()/(double)divisor);
            if (b.hasChel()) {
                chelPays += costPerPerson;
            }
            if (b.hasMel()) {
                melPays += costPerPerson;
            }
            if (b.hasMoop()) {
                moopPays += costPerPerson;
            }
        }
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public double getChelPays() {
        return chelPays;
    }

    public double getMelPays() {
        return melPays;
    }

    public double getMoopPays() {
        return moopPays;
    }
}
