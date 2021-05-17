package BinarySearchTree;

import TpComparacionArboles.BinarySearchTree;
import TpComparacionArboles.IsEmptyException;

import java.util.ArrayList;
import java.util.Scanner;

public class ABM {
    static ArrayList<Genoma> list = new ArrayList<>();
    static Transfer transfer = new Transfer(list);
    static BinarySearchTree<Genoma> bst = transfer.transferListToBST();

    public static void main(String[] args) throws IsEmptyException {
        System.out.println("ABM GENOMAS");
        System.out.println("Elija una opcion");
        menu();
    }

    public static void menu() throws IsEmptyException {
        System.out.println("1. Alta");
        System.out.println("2. Baja");
        System.out.println("3. Modificaciones");
        System.out.println("4. Generar Informe y Salir");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch (option) {
            case 1 -> {
                //Alta
                alta();
                menu();
            }
            case 2 -> {
                //Baja
                baja();
                menu();
            }
            case 3 -> {
                //Modificacion
                modificar();
                menu();
            }
            case 4 -> {
                //Informe
                //generarInforme();
                System.exit(0);
            }
            default -> menu();
        }
    }

    private static void alta() {
        System.out.println("-----");
        System.out.println("Agregar Genoma...");

        Scanner sc = new Scanner(System.in);

        System.out.print("Codigo: ");
        String code = sc.nextLine();
        System.out.println();

        System.out.print("Tipo: ");
        String type = sc.nextLine();
        System.out.println();

        System.out.print("Descripcion: ");
        String description = sc.nextLine();
        System.out.println();

        System.out.print("Tamano: ");
        int size = sc.nextInt();
        System.out.println();

        Genoma gen = new Genoma(code,type,description,size);

        bst.insert(gen);

        System.out.println("Registro Insertado!");
        System.out.println();
    }

    private static void baja() throws IsEmptyException {
        System.out.println("-----");
        System.out.println("Eliminar Genoma...");
        Scanner sc = new Scanner(System.in);

        System.out.print("Codigo: ");
        String code = sc.nextLine();
        System.out.println();

        Genoma gen = new Genoma(code);
        bst.delete(gen);

        System.out.println("Registro Eliminado!");
        System.out.println();
    }

    private static void modificar() throws IsEmptyException {
        System.out.println("-----");
        System.out.println("Modificar Genoma...");
        Scanner sc = new Scanner(System.in);

        System.out.print("Codigo: ");
        String code = sc.nextLine();
        System.out.println();

        Genoma gen = new Genoma(code);
        Genoma toModify = bst.search(gen);

        System.out.println("Tipo Previo: " + toModify.type);
        System.out.print("Tipo Nuevo: ");
        String type = sc.nextLine();
        System.out.println();

        System.out.println("Descripcion Previa: " + toModify.description);
        System.out.print("Descricpcion Nueva: ");
        String description = sc.nextLine();
        System.out.println();

        System.out.println("Tamano previo: " + toModify.size);
        System.out.print("Tamano Nuevo: ");
        int size = sc.nextInt();
        System.out.println();

        Genoma newGen = new Genoma(code,type,description,size);
        bst.delete(gen);
        bst.insert(newGen);
        System.out.println("Registro Modificado!");
        System.out.println();
    }

    /*private static void generarInforme(){
        bst.inorden(bst);
    }*/
}
