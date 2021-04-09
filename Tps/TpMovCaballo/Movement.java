package TpMovCaballo;

import StacksandQueues.IsEmptyException;
import StacksandQueues.StackDin;

import java.util.Arrays;
import java.util.Scanner;

public class Movement {
    public static void main(String[] args) throws IsEmptyException {
        System.out.println("Ingresar casillero inicial");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Columna:");
        int col = scanner.nextInt();
        System.out.println("Fila:");
        int fila = scanner.nextInt();
        Square initialSquare = new Square(col,fila);
        System.out.println("Puede ir al: ");
        initialSquare.optionsPrinter();
        menu();
    }

    private static void menu(){
        System.out.println("MENU");
        System.out.println("1: Saltar");
        System.out.println("2: Pilas");
        System.out.println("3: Salir");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option){
            case 1:
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
