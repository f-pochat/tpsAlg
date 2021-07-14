package TpHash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicios {

    public static TablaHashDispersionAbierta ejercicioA(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner myReader = new Scanner(file);

        TablaHashDispersionAbierta hashTable = new TablaHashDispersionAbierta(7);
        while (myReader.hasNextLine()) {
            Line data = new Line(myReader.nextLine());
            hashTable.insertar(data);
        }

        return hashTable;
    }

}
