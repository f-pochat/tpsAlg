package TpComparacionAlgoritmos;

import java.util.ArrayList;

public class Ej3 {

    static <T> T[] Merge(Comparable<T> array1[], Comparable<T> array2[]){
        int a = 0,b = 0 ,c = 0;

        //T[] outputArray =(T[]) new Integer[array1.length + array2.length];
        ArrayList<T> output = new ArrayList<>();

        while (a < array1.length || b < array2.length){

            if (array1[a].compareTo((T) array2[b]) < 0){
                output.add((T) array1[a]);
                a++;
            }else{
                output.add((T) array2[b]);
                b++;
            }
            c++;

            if (a == array1.length){
                for (int i = c; i < array1.length + array2.length; i++){
                    //outputArray[i] = (T) array2[b];
                    output.add((T) array2[b]);
                    b++;
                }
            }else if (b == array2.length){
                for (int i = c; i < array1.length + array2.length; i++){
                    output.add((T) array1[a]);
                    a++;
                }
            }
        }

        return (T[]) output.toArray();
    }

}
