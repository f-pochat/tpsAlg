package TpComparacionAlgoritmos;

import java.util.AbstractQueue;
import java.util.Iterator;

public class Ej1 {
  AbstractQueue abstractQueue = new AbstractQueue() {
      @Override
      public Iterator iterator() {
          return null;
      }

      @Override
      public int size() {
          return 0;
      }

      @Override
      public boolean offer(Object o) {
          return false;
      }

      @Override
      public Object poll() {
          return null;
      }

      @Override
      public Object peek() {
          return null;
      }
  };

  //Devuelven la posicion en donde se encuentra el string. En caso de no estar, devuelve -1
    public static int SeqSearch ( int a[], int k) {
        for (int i = 0; i < a.length; i++)
            if (k == a[i])
                return i;
        return -1;
    }

    public static int BinarySearch ( int a[], int k) {
        int min = 0;
        int max = a.length-1;
        int middle = (min+max)/2;
        while(min <= max) {
            if (k == a[middle])
                return middle;
            else if (k < a [middle] )
                max = middle-1;
            else
                min = middle +1;
            middle = (min+max)/2;
        }
        return -1;
    }
}
