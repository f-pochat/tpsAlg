package tpArchivos;

public class Sales {
    String destination;
    String article;
    int amount;
    int priceInUSD;
    int dayOfPayment;
    int monthOfPayment;
    int yearOfPayment;

    public Sales(String destination, String article, int amount, int priceInUSD, int dayOfPayment, int monthOfPayment, int yearOfPayment) {
        this.destination = destination;
        this.article = article;
        this.amount = amount;
        this.priceInUSD = priceInUSD;
        this.dayOfPayment = dayOfPayment;
        this.monthOfPayment = monthOfPayment;
        this.yearOfPayment = yearOfPayment;
    }
}
