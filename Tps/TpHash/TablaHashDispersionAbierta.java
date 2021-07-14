package TpHash;

public class TablaHashDispersionAbierta {
    private ListaD t[];
    private int capacidad;

    //Constructor
    public TablaHashDispersionAbierta(int M) {
        this.capacidad = M;
        t = new ListaD[M];
        for (int i = 0; i < M; i++) {
            t[i] = new ListaD();
        }
    }

    //Modificadoras
    public void insertar (Object x) {
        int k =((Hashable) x).hash(capacidad);
        t[k].insertarDespues(x);
    }

    public void eliminar(Object x){
        int k = ((Hashable) x).hash(capacidad);
        t[k].irPrimero();
        int l = t[k].longitud();
        for (int i = 0 ; i < l ; i ++ )
            if (((Comparable) x).compareTo(t[k].verActual())== 0)
                t[k].eliminar();
    }

    //Analizadoras
    public Object buscar (Object x) {
        int k = ((Hashable) x).hash(capacidad);
        t[k].irPrimero();
        int l = t[k].longitud();
        for (int i = 0 ; i < l ; i ++ )
            if (((Comparable) x).compareTo(t[k].verActual())== 0)
                return t[k].verActual();
        return x;
    }

    public boolean existe(Object x) {
        int k = ((Hashable) x).hash(capacidad);
        t[k].irPrimero();
        int l = t[k].longitud();
        for (int i = 0 ; i < l ; i ++ )
            if (((Comparable) x).compareTo(t[k].verActual())== 0)
                return true;
        return false;
    }

    public BinarySearchTree<Object> obtenerArBinBus () {
        BinarySearchTree<Object> a = new BinarySearchTree<Object>();
        for (int i = 0; i < capacidad; i++ ) {
            if (!t[i].esVacio()) {
                t[i].irPrimero();
                for (int j = 0; j < t[i].longitud() ; j++) {
                    a.insert((java.lang.Comparable) t[i].verActual());
                    t[i].irSiguiente();
                    j++;
                }
            }
        }
        return a;
    }

    public ListaD[] getT() {
        return t;
    }
}
