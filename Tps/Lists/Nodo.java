package Lists;

public class Nodo {
    Object dato;
    Nodo sig;

    public Nodo(Object x){
        dato = x;
    }

    public Nodo(Object x, Nodo ref) {
        dato = x;
        sig = ref;
    }
}