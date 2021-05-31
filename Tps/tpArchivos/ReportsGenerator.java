package tpArchivos;

import java.io.*;

public class ReportsGenerator {
    private void generateSalesFile() throws IOException {
        RandomAccessFile raf = null;
        Sales[] sales = new Sales[1000];

        File f = new File("Sales");
        try{
            raf = new RandomAccessFile(f, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Sales sale:sales) {
            raf.writeUTF(sale.destination);
            raf.writeUTF(sale.article);
            raf.writeInt(sale.amount);
            raf.writeInt(sale.priceInUSD);
            raf.writeInt(sale.dayOfPayment);
            raf.writeInt(sale.monthOfPayment);
            raf.writeInt(sale.yearOfPayment);
        }
    }

    private void generateDestinationsFile() throws IOException{
        Destination[] destinations = new Destination[30];
        try {
            FileWriter fileWriter = new FileWriter("Destinations");
            for (Destination des:destinations) {
                fileWriter.write(des.code+""+des.description);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generatePricesFile() throws IOException{
        PriceUSD[] prices = new PriceUSD[12];

        try {
            FileWriter fileWriter = new FileWriter("Prices");
            for (PriceUSD price:prices) {
                fileWriter.write(String.format("%02",price.month)+ price.valueUSD);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
