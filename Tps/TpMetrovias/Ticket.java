package TpMetrovias;

public class Ticket {
    public static int id = 0;
    public int numero;
    int attentionTime;

    public Ticket(int attentionTime) {
        id++;
        numero = id;
        this.attentionTime = attentionTime;
    }
}
