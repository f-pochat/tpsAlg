package TpMovCaballo;

import java.util.Scanner;

public class Movement {

   static Horse horse;

    public static void main(String[] args) throws IsEmptyException {
        System.out.println("Ingresar casillero inicial");

        //Input of the initial square
        Scanner scanner = new Scanner(System.in);
        System.out.println("Columna:");
        char col = scanner.next().toUpperCase().charAt(0);
        System.out.println("Fila:");
        int fila = scanner.nextInt();

        //Instantiates a horse in the initial square
        horse = new Horse(new Square(col,fila));

        //Runs the menu with the options
        menu();
    }

    private static void menu() throws IsEmptyException {
        //While the horse has made 4 or less jumps
        while (horse.getCounter() <= 4){
            System.out.println("---");
            System.out.println("MENU");
            System.out.println("1: Saltar");
            System.out.println("2: Pilas");
            System.out.println("3: Salir");

            //Input of the option taken by the user
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {

                //Option: "Saltar"
                case 1 -> {
                    System.out.println("---");
                    System.out.println("A donde te queres mover?");

                    //Input of where the new step should be
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Columna:");
                    char moveToCol = scanner.next().toUpperCase().charAt(0);
                    System.out.println("Fila:");
                    int moveToRow = scanner1.nextInt();

                    horse.jump(new Square(moveToCol, moveToRow));
                }

                //Option: "Pilas"
                case 2 -> {
                    System.out.println("---");
                    System.out.println("Opciones:");
                    horse.getPosition().optionsPrinter();
                    menu();
                }

                //Option: "Salir"
                case 3 -> horse.setCounter(5);
                default -> {
                    System.out.println("No se reconoce la opcion");
                    menu();
                }
            }
        }

        System.out.println("Gracias!");

        //Prints every possible path
        Board b = new Board();
        b.everyPathInEverySquare();
    }
}
