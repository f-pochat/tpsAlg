package TpMetrovias;

import StacksandQueues.IsEmptyException;
import StacksandQueues.QueueDin;

import java.util.Random;

public class TicketOffice {
    private QueueDin<Person> queue;
    private int totalRevenue;

    public TicketOffice() {
        queue = new QueueDin<>();
        totalRevenue = 0;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void queuePerson(Person person){
        queue.enqueue(person);
    }

    public void attendClient() throws IsEmptyException {
        if (!queue.isEmpty()){

            Random ran = new Random();
            int x = ran.nextInt(2);

            if (x == 0){
                Person person = queue.dequeue();
                person.attentionTime = (Simulacion.cycle - person.entryCycle)*30;
                createsTicket(person.attentionTime);
            }

        }
    }

    private void createsTicket(int time) {
        Ticket ticket = new Ticket(time);
        Simulacion.ticketStack.stack(ticket);
        totalRevenue++;
    }
}
