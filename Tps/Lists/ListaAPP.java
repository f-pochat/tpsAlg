package Lists;

public class ListaAPP {
    /*
    public Lista crearListaEnteros(int tam){
        Lista lst = new ListaE();
        for(int i = 1; i <= tam; i++)
            lst.insertarDespues(new Integer(i));
        return lst;
    }
    public void recorrer(Lista lst){
        lst.irPrimero();
        for (int i = 0; i < lst.longitud(); i ++){
            System.out.println(" " + lst.verActual());
            lst.irSiguiente();
        }
    }
    public void recorrerReves(Lista lst){
        lst.irUltimo();
        for (int i = 0; i < lst.longitud(); i ++){
            System.out.println(" " + lst.verActual());
            lst.irAnterior();
        }
    }
    public void eliminar(Lista lst, int n){
        Integer N = new Integer(n);
        lst.irPrimero();
        while((!lst.finLista()) && !(((Integer) lst.verActual()).equals(N)))
            lst.irSiguiente();
        if(((Integer)lst.verActual()) == n)
            lst.eliminar();
        else
            System.out.println( "Error");
    }
    public Lista invertirLista(Lista lst){
        Lista aux = new ListaE();
        lst.irPrimero();
        for(int cont = 1; cont <= lst.longitud(); cont++){
            aux.insertarAntes(lst.verActual());
            lst.irSiguiente();
        }
        return aux;
    }
    public void concatenar(Lista lst1, Lista lst2) {
        lst1.irUltimo();
        lst2.irPrimero();
        for (int cont = 0; cont < lst2.longitud(); cont++) {
            lst1.insertarDespues(lst2.verActual());
            lst2.irSiguiente();
        }
    }
}
class pruebaLista
{
    public static void main(String[] args) {
        ListaAPP lstAPP = new ListaAPP();
//Construye una lista con los enteros 1, 2, ... ,18
        Lista lst = lstAPP.crearListaEnteros(18);
//Recorre la lista desde el primer elemento al último
        lstAPP.recorrer(lst);
//Recorre la lista desde el último elemento al primero
        lstAPP.recorrerReves(lst);
//Elimina el numero 10 de la lista
        lstAPP.eliminar(lst,10);
//Invierte la lista
        Lista lst1 = lstAPP.invertirLista(lst);
//Concatenar dos listas
        lstAPP.concatenar(lst,lst1);
        lstAPP.recorrer(lst);
    }*/

    /**
     * Imprimir el contenido de una lista de enteros desde el primero al último.
     * Imprimir el contenido de una lista de enteros desde el último al primero.
     * Eliminar un elemento de la lista.
     * Construir una lista invertida a la dada.
     * Concatenar dos listas list1 y list2, dejando el resultado en la primera de ellas.
     */
}
