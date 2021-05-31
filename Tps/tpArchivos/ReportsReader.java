package tpArchivos;

import java.io.*;
import java.util.Scanner;

public class ReportsReader {

    public Sales readSalesFile() throws IOException {
        RandomAccessFile raf = null;
        File f = new File("Sales");
        try{
            raf = new RandomAccessFile(f, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Sales(raf.readUTF(),raf.readUTF(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt());
    }

    public PriceUSD[] readPricesFile() throws IOException{
        PriceUSD[] prices = new PriceUSD[12];
        try {
            File file = new File("Prices");
            Scanner myReader = new Scanner(file);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                prices[i] = new PriceUSD(Integer.parseInt(data.substring(0,1)),Integer.parseInt(data.substring(2,data.length()-1)));
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return prices;
    }

    public int converterUSDToARS(Sales sale) throws IOException {
        PriceUSD[] priceUSDS = readPricesFile();
        for (PriceUSD price:priceUSDS) {
            if (price.month == sale.monthOfPayment){
                return sale.amount*price.valueUSD;
            }
        }

        //Error
        return -1;
    }

    public void getFeesByDestination() throws IOException {
        Destination[] destinations = new Destination[30];
        Sales[] sales = new Sales[1000];
        for (Sales sale:sales) {
            sale = readSalesFile();
        }

        for (Destination des:destinations) {
            System.out.println("Destination: " + des.code);
            int totalFee = 0;
            for (Sales sale : sales) {
                if (sale.destination.equals(des.code)) {
                    totalFee += converterUSDToARS(sale);
                }
            }
        }
    }
}
