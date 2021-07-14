package TpHash;

/*
    a[0] r
    a[1] d
    a[2]

    cap 2
 */

public class TablaHashDispersionCerradaLineal {
    private Object t[];
    private int capacidad;

    //Constructor
    public TablaHashDispersionCerradaLineal(int M) {
        this.capacidad = M;
        t = new Object[M];
    }

    //Modificadoras
    public void insertar (Object x) {
        int k =((Hashable) x).hash(capacidad);
        if (t[k] == null){
            t[k] = x;
        }else{
            for (int i = k+1; i < capacidad; i++) {
                if (t[i] == null) {
                    t[i] = x;
                    return;
                }
            }
        }
    }

    public void eliminar(Object x){
        int k = ((Hashable) x).hash(capacidad);
        if (t[k] == x){
            t[k] = null;
        }else{
            for (int i = k+1; i < capacidad; i++) {
                if (t[i] == x) {
                    t[i] = null;
                    return;
                }
            }
        }
    }

    //Analizadoras
    public Object buscar (Object x) {
        int k = ((Hashable) x).hash(capacidad);
        if (t[k] == x){
            return t[k];
        }else{
            for (int i = k+1; i < capacidad; i++) {
                if (t[i] == x) {
                    return t[i];
                }
            }
        }
        return x;
    }

    public boolean existe(Object x) {
        int k = ((Hashable) x).hash(capacidad);
        if (t[k] == x){
            return true;
        }else{
            for (int i = k+1; i < capacidad; i++) {
                if (t[i] == x) {
                    return true;
                }
            }
        }
        return false;
    }

    public BinarySearchTree<Object> obtenerArBinBus () {
        BinarySearchTree<Object> a = new BinarySearchTree<>();
        for (int i = 0; i < capacidad; i++) {
            a.insert((java.lang.Comparable<Object>) t[i]);
        }
        return a;
    }
}
