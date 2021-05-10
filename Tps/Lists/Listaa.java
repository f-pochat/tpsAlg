package Lists;

public interface Listaa<T> {
    void insertarDespues(Object x);
    void insertarAntes(Object x);
    void eliminar();
    void irSiguiente();
    void irAnterior();
    void irA (int n);
    Object verActual();
    int verPosActual();
    int longitud();
    boolean esVacio();
    boolean finLista();
}
