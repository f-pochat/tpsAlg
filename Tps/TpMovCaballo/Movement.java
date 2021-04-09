package TpMovCaballo;

import StacksandQueues.IsEmptyException;
import StacksandQueues.StackDin;

import java.util.Arrays;
import java.util.Scanner;

public class Movement {
   static Horse horse;
    public static void main(String[] args) throws IsEmptyException {
        System.out.println("Ingresar casillero inicial");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Columna:");
        int col = scanner.nextInt();
        System.out.println("Fila:");
        int fila = scanner.nextInt();
        horse = new Horse(new Square(col,fila));

        System.out.println("Puede ir al: ");
        horse.getPosition().optionsPrinter();
        menu();
    }

    private static void menu() throws IsEmptyException {
        System.out.println("MENU");
        System.out.println("1: Saltar");
        System.out.println("2: Pilas");
        System.out.println("3: Salir");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option){
            case 1:
                System.out.println();

                System.out.println("a donde te queres mover?");
                System.out.println("Columna:");
                 int col = scanner.nextInt();
                 System.out.println("Fila:");
                 int fila = scanner.nextInt();
                horse.jump(new Square(col,fila));
                horse.getPosition().printSquare();
                break;
            case 2:

                break;
            case 3:

                System.exit(0);
                break;
            default:
                System.out.println("No se reconoce la opcion");
                menu();
        }
    }
}
