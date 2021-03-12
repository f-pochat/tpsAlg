package TpComparacionAlgoritmos;

import java.util.Random;

public class Ej2 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[50];
        Random ran = new Random();
        for (int i = 0; i < 50; i++) {
            int x = ran.nextInt(100);
            arr[i] = x;
        }

        printArray(arr);
        System.out.println();
        System.out.println("Bubble");
        long startTime = System.nanoTime();
        Integer[] newArr = BubbleSort(arr);
        long endTime = System.nanoTime();
        System.out.print("Time: ");
        System.out.println(endTime - startTime);
        printArray(newArr);

        System.out.println();
        System.out.println("Insertion");
        long startTime2 = System.nanoTime();
        Integer[] newArr2 = InsertionSort(arr);
        long endTime2 = System.nanoTime();
        System.out.print("Time: ");
        System.out.println(endTime2 - startTime2);
        printArray(newArr2);

        System.out.println();
        System.out.println("Selection");
        long startTime3 = System.nanoTime();
        Integer[] newArr3 = SelectionSort(arr);
        long endTime3 = System.nanoTime();
        System.out.print("Time: ");
        System.out.println(endTime3 - startTime3);
        printArray(newArr3);
        System.out.println();

        System.out.println();
        System.out.println("Recursive Selection");
        long startTime4 = System.nanoTime();
        Integer[] newArr4 = RecursiveSelectionSort(arr);
        long endTime4 = System.nanoTime();
        System.out.print("Time: ");
        System.out.println(endTime4 - startTime4);
        printArray(newArr4);
        System.out.println();
    }

    /*Selection: Encuentra el valor mas chico dentro de un array y lo pone en la primera posicion.
      Despues busca el mas chico entre el segundo y el ultimo y lo pone en la segunda posicion. Y asi se repite hasta ordenarse
    */
    static <T> T[] SelectionSort(Comparable<T> arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex].compareTo((T) arr[j]) > 0) {
                    minIndex = j;
                }
            }
            Comparable<T> temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        return (T[]) arr;
    }

    static <T> int minIndex(Comparable<T> a[], int i, int j)
    {
        if (i == j)
            return i;

        // Find minimum of remaining elements
        int k = minIndex(a, i + 1, j);

        // Return minimum of current and remaining.
        return (a[i].compareTo((T) a[k])< 0)? i : k;
    }

    static <T> void RecursiveSelectionSort(Comparable<T> arr[], int n, int index){
        // Return when starting and size are same
        if (index == n)
            return;

        // calling minimum index function for minimum index
        int k = minIndex(arr, index, n-1);

        // Swapping when index nd minimum index are not same
        if (k != index){
            // swap
            Comparable<T> temp = arr[k];
            arr[k] = arr[index];
            arr[index] = temp;
        }
        // Recursively calling selection sort function
        RecursiveSelectionSort(arr, n, index + 1);
    }

    static <T> T[] RecursiveSelectionSort(Comparable<T> arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex].compareTo((T) arr[j]) > 0) {
                    minIndex = j;
                }
            }
            Comparable<T> temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        return (T[]) arr;
    }

    /*Insetion: Consiste en recorrer el array comenzando desde el segundo elemento hasta el final. Para cada elemento, se trata de colocarlo
    en el lugar correcto entre los elementos anteriores o sea entre los elementos a su izquierda en el array.
    */
    static <T> T[] InsertionSort(Comparable<T> arr[]){
        int p,j;
        Comparable<T> aux;
        for (p = 1; p < arr.length; p++){
            aux = arr[p];
            j = p - 1;
            while ((j >= 0) && (aux.compareTo((T) arr[j]) < 0)){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = aux;
        }
        return (T[]) arr;
    }

    /*Bubble: Consiste en comparar pares de elementos adyacentes en un array y si están desordenanos intercambiarlos
    hasta que estén todos ordenados.
    */
    static <T> T[] BubbleSort(Comparable<T> arr[]) {
        int i, j;
        Comparable<T> aux;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1].compareTo((T) arr[j]) < 0) {
                    aux = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
        return (T[]) arr;
    }


    public static <T> void printArray(T[] array)
    {

        for(int i=0; i<array.length; i++)
        {
            System.out.print(array[i] + ", ");
        }
    }

}
