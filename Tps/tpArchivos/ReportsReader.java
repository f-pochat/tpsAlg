package tpArchivos;

import java.io.*;
import java.util.Scanner;

public class ReportsReader {

    public Sales[] readSalesFile() throws IOException {
        Sales[] sales = new Sales[1000];
        RandomAccessFile raf = null;
        File f = new File("sales.txt");
        try{
            raf = new RandomAccessFile(f, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < sales.length; i++){
            sales[i] = new Sales(raf.readUTF(),raf.readUTF(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt());
        }
        return sales;
    }

    public PriceUSD[] readPricesFile() throws IOException{
        PriceUSD[] prices = new PriceUSD[12];
        try {
            File file = new File("prices.txt");
            Scanner myReader = new Scanner(file);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                prices[i] = new PriceUSD(Integer.parseInt(data.substring(0,2)),Integer.parseInt(data.substring(2)));
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prices;
    }

    public Destination[] readDestinations(){
        Destination[] destinations = new Destination[30];
        try {
            File file = new File("destinations.txt");
            Scanner myReader = new Scanner(file);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                destinations[i] = new Destination(data.substring(0,3),data.substring(3,data.length()-1));
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return destinations;
    }

    public int converterUSDToARS(Sales sale) throws IOException {
        PriceUSD[] priceUSDS = readPricesFile();
        for (PriceUSD price:priceUSDS) {
            if (price.month == sale.monthOfPayment){
                return sale.amount*sale.priceInUSD*price.valueUSD;
            }
        }

        //Error
        return -1;
    }

    public void getFeesByDestination() throws IOException {
        Destination[] destinations = readDestinations();
        Sales[] sales = readSalesFile();

        for (Destination des:destinations) {
            System.out.println("Destino: " + des.code);
            int totalFee = 0;
            for (Sales sale : sales) {
                if (sale.destination.equals(des.code)) {
                    totalFee += converterUSDToARS(sale);
                }
            }
            System.out.println("Monto Total: " + totalFee);
        }
    }

    public void getFeesByMonth() throws IOException {
        Sales[] sales = readSalesFile();

        for (int i = 1; i <= 12; i++) {
            System.out.println("Mes: " + i);
            int totalFee = 0;
            for (Sales sale : sales) {
                if (sale.monthOfPayment == i) {
                    totalFee += converterUSDToARS(sale);
                }
            }
            System.out.println("Monto Total: " + totalFee);
        }
    }
}
