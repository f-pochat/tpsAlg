package TpMetrovias;

import StacksandQueues.IsEmptyException;
import StacksandQueues.StackDin;
import java.util.Random;
import java.util.Scanner;

public class Simulacion {
    private static TicketOffice[] offices;
    private static int ticketOffice;
    public static int cycle = 0;
    public static StackDin<Ticket> ticketStack = new StackDin<>();

    public static void main(String[] args) throws IsEmptyException {
        System.out.println("Cuantas casillas de atencion debe haber? (5-25)");
        Scanner sc = new Scanner(System.in);
        ticketOffice = sc.nextInt();
        if (ticketOffice < 5 || ticketOffice > 25){
            System.out.println("Numero no valid");
            System.exit(0);
        }

        createTicketOffices(ticketOffice);

        menu();
    }

    private static void menu() throws IsEmptyException {
        System.out.println("MENU");
        System.out.println("Presiona 1 para simular 30 segundos y 2 para terminar la simulacion");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if (option == 1){
            //Avanza 30 segundos
            movesForwardInTime();
            menu();
        }else if (option == 2){
            //Termina la simulacion
            showStack();
            System.exit(0);
        }
    }


    private static void movesForwardInTime() throws IsEmptyException {
        for (TicketOffice office : offices){
            office.attendClient();
        }


        for (int i = 0; i < 5; i++) {
            Random ran = new Random();
            int x = ran.nextInt(ticketOffice);

            offices[x].queuePerson(new Person(cycle));
        }

        cycle++;
    }

    private static void createTicketOffices(int number){
         offices = new TicketOffice[number];
        for (int i = 0; i < offices.length; i++) {
            offices[i] = new TicketOffice();
        }
    }

    public static void showStack() throws IsEmptyException {
        int numOfTickets = ticketStack.size();
        int counterOfTotalAttentionTime = 0;
        int counterTotalRevenue = 0;
        System.out.println("---TICKETS---");
        for (int i = 0; i < numOfTickets; i++) {
            System.out.println("Numero: " + String.format("%05d", ticketStack.peek().numero)  + " Tiempo de atencion: " + ticketStack.peek().attentionTime);
            counterOfTotalAttentionTime += ticketStack.peek().attentionTime;
            ticketStack.pop();
        }
        System.out.println("Tiempo medio :" + counterOfTotalAttentionTime/numOfTickets);

        System.out.println("---OFICINAS---");
        for (int i = 0; i < offices.length; i++) {
            System.out.println("Oficina numero: " + i + " Monto recaudado: " + offices[i].getTotalRevenue());
            counterTotalRevenue += offices[i].getTotalRevenue();
        }
        System.out.println("Monto Total: " + counterTotalRevenue);
    }
}
