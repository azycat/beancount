import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Receipt {
    private String store;
    private Date dateOfPurchase;
    private Integer card;
    private Double total;
    private List<Bean> beans = new ArrayList<>();

    static final int MELLY_CARD = 7763;
    static final int MOOP_CARD = 9704;
    static final int MOOP_NEW_CARD = 6025;
    static final int MOOP_OTHER_NEW_CARD = 8307;
    static final int MEEP_CARD = 1684;

    public Receipt(String store, int card, Date date) {
        this.store = store;
        this.card = card;
        this.dateOfPurchase = date;
        total = 0.0;
    }

    public static Receipt buildReceipt(String data) {
        String[] receiptInfo = data.split("\s");
        // [0] -> name of store receipt is from
        // [1] -> date (mmddyy)
        // [2] -> last 4 digits of card used to make the purchase
        // [3] -> total cost of purchase
        String store = null;
        Date date = null;
        Integer card = null;
        Double total = null;

        if (receiptInfo.length == 4) {
            store = receiptInfo[0];
            date = convertStringToDate(receiptInfo[1]);
            card = Integer.parseInt(receiptInfo[2]);
            total = Double.parseDouble(receiptInfo[3]);
        }
        if (card == null) {
            System.out.println("but why");
        }
        Receipt newReceipt = new Receipt(store, card, date);
        newReceipt.setTotal(total);
        return newReceipt;
    }

    public static Date convertStringToDate(String date) {
        try {
            Date dateFormat = new SimpleDateFormat("MMddyy").parse(date);
            System.out.println(dateFormat.toString());
            return dateFormat;
        } catch (ParseException e) {
            System.out.println("Error: could not parse date!");
            e.printStackTrace();
        }
        return null;
    }

    public String getPaidForBy() {
        String name = "Unknown";
        switch (card) {
            case MELLY_CARD:
                name = "Melly";
                break;
            case MOOP_CARD:
                name = "Moop";
                break;
            case MOOP_NEW_CARD:
                name = "Moop";
                break;
            case MOOP_OTHER_NEW_CARD:
                name = "Moop";
                break;
            case MEEP_CARD:
                name = "Meep";
                break;
            default:
                name = "Anonymous";
                break;
        }
        return name;
    }

    public void addBean(Bean b) {
        for (int i = 0; i < b.getMultiplier(); i++) {
            beans.add(b);
        }
    }

    public List<Bean> getBeanList() {
        return beans;
    }

    public void setTotal(Double cost) {
        this.total = cost;
    }

    public Double getTotal() {
        return total;
    }

    public String getStore() {
        return store;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Integer getCard() {
        return card;
    }
}
