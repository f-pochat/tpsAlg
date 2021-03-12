package TpComparacionAlgoritmos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Ej3<T> {

    //[1,2,3,4,5] vs [6,7,8]
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

    public static <T> void printArray(T[] array)
    {

        for(int i=0; i<array.length; i++)
        {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

}
