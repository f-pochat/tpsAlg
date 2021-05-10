package Lists;

public class ListaD<T> implements Listaa<T> {
    private Nodo primero;
    private Nodo actual;
    private int cantidad;

    public ListaD() {
        primero = null;
        actual=null;
        cantidad=0;
    }

    public void irSiguiente(){
        actual = actual.sig;
    }
    public void irPrimero(){
        actual = primero;
    }
    public Object verActual(){
        return actual.dato;
    }
    public int longitud(){
        return cantidad;
    }
    public boolean esVacio(){
        return cantidad == 0;
    }

    public boolean finLista(){
        return actual == null;
    }
    public void irUltimo(){
        while (actual.sig != null)
            actual = actual.sig;
    }
    public void irAnterior(){
        Nodo aux, ant;
        ant = null;
        aux = primero;
        while(aux != actual){
            ant = aux;
            aux = aux.sig;
        }
        actual = ant;
    }

    public void irA(int pos){
        actual = primero;
        int posActual = 1;
        while(posActual < pos){
            posActual++;
            actual = actual.sig;
        }
    }

    public int verPosActual(){
        Nodo aux = primero;
        int pos = 1;
        while(aux != actual){
            aux = aux.sig;
            pos++;
        }
        return pos;
    }

    public void insertarDespues(Object x){
        Nodo nuevo = new Nodo(x);
        if (esVacio()){
            primero = nuevo;
        }
        else{
            nuevo.sig = actual.sig;
            actual.sig = nuevo;
        }
        actual = nuevo;
        cantidad++;
    }

    @Override
    public void insertarAntes(Object x) {

    }

    public void eliminar(){
        if(actual.sig != null){
            actual.dato = actual.sig.dato;
            actual.sig = actual.sig.sig;
        }
        else {
            irAnterior();
            actual.sig =null;
        }
        cantidad--;
    }
}
