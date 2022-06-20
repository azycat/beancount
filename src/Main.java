import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

// counts beans
public class Main {
    static final int FAILURE = -1;

    static final File input = new File("/Users/struppi/beancount/in");
    static final File output = new File("/Users/struppi/beancount/out/");

    static String columnHeadings = "Item,Cost,Whose";

    static List<Receipt> receiptList = new ArrayList<>();

    public static void main(String[] args){
        if (!input.exists()) {
            System.out.println("Error: Input folder does not exist!");
            System.exit(FAILURE);
        }
        if (!output.exists()) {
            System.out.println("Error: Output folder does not exist!");
            System.exit(FAILURE);
        }

        File[] fileList = input.listFiles();

        for (File f : fileList) {
            readBeans(f);
        }
        for (Receipt r : receiptList) {
            File outputCSV = new File(output + "/" + generateFileName(r) + ".csv");
            printToCSVFile(outputCSV, r);
        }
        printSimpleOutput();
    }

    public static void readBeans(File f) {
        String fileName = f.getName();
        String filePath = f.getPath();

        try {
            Scanner scanner = new Scanner(f);
            Receipt newReceipt = null;
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // first line contains data about the file
                if (lineCount == 0) {
                    newReceipt = Receipt.buildReceipt(line);
                    lineCount++;
                }
                else {
                    Bean b = Bean.makeBeanFromLine(line);
                    newReceipt.addBean(b);
                }
            }

            scanner.close();

            if (newReceipt == null) {
                System.out.println("Error: Invalid or empty file");
                System.out.println(fileName);
                System.out.println(filePath);
                System.exit(FAILURE);
            }

            if (receiptErrorFound(newReceipt)) {
                System.out.println(fileName);
                System.out.println(filePath);
                System.exit(FAILURE);
            }
            for (Bean b : newReceipt.getBeanList()) {
                if (beanErrorFound(b)) {
                    System.out.println(fileName);
                    System.out.println(filePath);
                    System.exit(FAILURE);
                }
            }

            receiptList.add(newReceipt);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            e.printStackTrace();
        }
    }

    public static boolean receiptErrorFound(Receipt r) {
        boolean errorFound = false;
        if (r.getBeanList().size() == 0) {
            System.out.println("Error: Receipt has no beans!");
            errorFound = true;
        }
        else if (r.getTotal() == null) {
            System.out.println("Error: invalid or missing total cost");
            errorFound = true;
        }
        else if (r.getCard() == null) {
            System.out.println("Error: invalid or missing card #");
            errorFound = true;
        }
        else if (r.getDateOfPurchase() == null) {
            System.out.println("Error: invalid or missing Date of purchase");
            errorFound = true;
        }
        else if (r.getStore() == null) {
            System.out.println("Error: invalid or missing store purchased from");
            errorFound = true;
        }
        return errorFound;
    }

    public static boolean beanErrorFound(Bean b) {
        boolean errorFound = false;
        if (b.getNameOfProduct() == null) {
            System.out.println("Error: bean with invalid name!");
            errorFound = true;
        }
        else if (b.getCost() == null) {
            System.out.println("Error: bean with invalid cost!");
            System.out.println(b.getNameOfProduct());
            errorFound = true;
        }
        return errorFound;
    }

    public static void printSimpleOutput() {
        String paysWhom = null;
        int receiptCount = 1;
        Beancounter beancounter;

        for (Receipt r : receiptList) {
            beancounter = new Beancounter(r);
            paysWhom = r.getPaidForBy();
            System.out.println("Receipt #" + receiptCount);
            System.out.println(generateFileName(r));
            System.out.printf("Moop pays %s: $%.2f%n", paysWhom, beancounter.getMoopPays());
            System.out.printf("Chelly pays %s: $%.2f%n", paysWhom, beancounter.getChelPays());
            System.out.printf("Melly pays %s: $%.2f%n", paysWhom, beancounter.getMelPays());
            double sum = beancounter.getChelPays() + beancounter.getMelPays() + beancounter.getMoopPays();
            System.out.printf("Total: $%.2f%n", sum);
            System.out.println("Total after tax: $" + r.getTotal());
            System.out.println("-------------------");
            receiptCount++;
        }
    }

    public static void printToCSVFile(File outputFile, Receipt r) {
        try {
            PrintWriter writer = new PrintWriter(outputFile);
            writer.println(columnHeadings);
            for (Bean b : r.getBeanList()) {
                writer.printf("%s,$%.2f,", b.getNameOfProduct(), b.getCost());
                for (Gnome g : b.getPurchasers()) {
                    if (b.getPurchasers().size() < 3) {
                        writer.printf("%s", g.getName());
                    }
                }
                writer.printf("%n");
            }
            writer.close();
            //System.out.println("Done. CSV file created at " + outputFile.getAbsolutePath());


        } catch (FileNotFoundException e) {
            System.out.println("Error: Output file not found!");
            System.exit(FAILURE);
            e.printStackTrace();
        }
    }

    public static String generateFileName(Receipt r) {
        DateFormat df = new SimpleDateFormat("MMddyyyy");
        Date date = r.getDateOfPurchase();
        return df.format(date) + "_" + r.getStore();
    }
}
