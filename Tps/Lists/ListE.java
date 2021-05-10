package Lists;

public class ListE<T> implements Listaa<T> {
    private int actual;
    private int cantidad;
    private Object dato[];
    private int defaultMax;

    // ListaE crea una lista vacia
    public ListE() {
        defaultMax = 10;
        actual = 0;
        cantidad = 0;
        dato = new Object[defaultMax];
    }

    //Modificadoras
    public void irSiguiente() {
        actual++;
    }

    public void irAnterior() {
        actual--;
    }

    public void irA(int pos) {
        actual = pos;
    }

    public void irPrimero(){
        actual = 1;
    }

    public void irUltimo(){
        actual=cantidad;
    }

    //Analizadoras
    public Object verActual(){
        return dato[actual-1];
    }

    public int verPosActual(){
        return actual;
    }

    public int longitud(){
        return cantidad;
    }

    @Override
    public boolean esVacio() {
        return cantidad==0;
    }

    public boolean esVacia(){
        return cantidad == 0;
    }

    public boolean finLista(){
        return ((actual <1) || (actual>cantidad));
    }

    public void insertarDespues(Object x){
        if (cantidad == defaultMax)
            duplicarArreglo();
        for (int pos = cantidad-1; pos > actual-1; pos--)
            dato[pos+1] = dato[pos];
        dato[actual]=x;
        actual++;
        cantidad++;
    }
    private void duplicarArreglo(){
        defaultMax = defaultMax*2;
        Object[] nuevo = new Object[defaultMax];
        for (int pos = 0; pos < cantidad; pos++)
            nuevo[pos] = dato[pos];
        dato=nuevo;
    }

    public void insertarAntes(Object x){
        if (cantidad == defaultMax)
            duplicarArreglo();
        if (cantidad!=0
        ){
            for (int pos = cantidad-1; pos >= actual-1; pos--)
                dato[pos+1] = dato[pos];
            dato[actual-1]=x;
        }
        else {
            dato[0] = x;
            actual = 1;
        }
        cantidad++;
    }

    public void eliminar(){
        for(int pos = actual-1; pos < cantidad-1; pos++)
            dato[pos] = dato[pos+1];
        cantidad--;
    }
}
