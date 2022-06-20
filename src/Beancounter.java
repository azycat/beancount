import java.util.List;

public class Beancounter {
    Receipt receipt;
    double chelPays;
    double melPays;
    double moopPays;

    public Beancounter(Receipt receipt) {
        this.receipt = receipt;
        chelPays = 0.0;
        melPays = 0.0;
        moopPays = 0.0;
        beanCountingAlgorithm();
    }

    public void beanCountingAlgorithm() {
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
