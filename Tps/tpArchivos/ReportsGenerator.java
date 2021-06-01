package tpArchivos;

import java.io.*;

public class ReportsGenerator {
    public void generateSalesFile(Sales[] sales) throws IOException {
        RandomAccessFile raf = null;

        File f = new File("sales.txt");
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

    public void generateDestinationsFile(Destination[] destinations) throws IOException{
        try {
            FileWriter fileWriter = new FileWriter("destinations.txt");
            for (Destination des:destinations) {
                fileWriter.write(des.code+""+des.description+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generatePricesFile(PriceUSD[] prices) throws IOException{

        try {
            FileWriter fileWriter = new FileWriter("prices.txt");
            for (PriceUSD price:prices) {
                fileWriter.write(String.format("%02d",price.month)+ price.valueUSD+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
