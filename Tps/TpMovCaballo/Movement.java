package TpMovCaballo;

import StacksandQueues.IsEmptyException;

import java.util.Scanner;

public class Movement {
   static Horse horse;
   static int counter = 0;

    public static void main(String[] args) throws IsEmptyException {
        System.out.println("Ingresar casillero inicial");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Columna:");
        char col = scanner.next().toUpperCase().charAt(0);
        System.out.println("Fila:");
        int fila = scanner.nextInt();

        horse = new Horse(new Square(col,fila));
        menu();
    }

    private static void menu() throws IsEmptyException {
        while (horse.getCounter() < 5){
            System.out.println("MENU");
            System.out.println("1: Saltar");
            System.out.println("2: Pilas");
            System.out.println("3: Salir");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("---");
                    System.out.println("A donde te queres mover?");
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Columna:");
                    char moveToCol = scanner.next().toUpperCase().charAt(0);
                    System.out.println("Fila:");
                    int moveToRow = scanner1.nextInt();
                    horse.jump(new Square(moveToCol, moveToRow));
                }
                case 2 -> {
                    System.out.println("Opciones:");
                    horse.getPosition().optionsPrinter();
                    menu();
                }
                case 3 -> horse.setCounter(5);
                default -> {
                    System.out.println("No se reconoce la opcion");
                    menu();
                }
            }
        }
        System.out.println("Gracias!");
        Board b = new Board();
        b.everyPathInEverySquare();
    }
}
