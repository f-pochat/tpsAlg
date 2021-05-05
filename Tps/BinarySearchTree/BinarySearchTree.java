package BinarySearchTree;

public class BinarySearchTree <T>{
    // Implementacion de un arbol binario de busqueda no balanceado
    // Autor Alicia Gioia

    private NodoDoble<T> root;

    public BinarySearchTree(){
        root = null;
    }

    // precondicion: elemento a insertar no pertenece al árbol
    public void insert(Comparable <T> x){
        root = insert(root, x);
    }


    // precondicion: elemento a eliminar pertenece al árbol
    public void delete(Comparable <T> x) throws IsEmptyException {
        root = delete(root, x);
    }

    // precondicion: árbol distinto de vacío
    public T getMin() throws IsEmptyException {
        return getMin(root).elem;
    }

    // precondicion: árbol distinto de vacío
    public T getMax() throws IsEmptyException {
        return getMax(root).elem;
    }

    // precondicion: elemnto a buscar pertenece al arbol
    public T search(Comparable<T> x) throws IsEmptyException {
        return search(root, x).elem;
    }

    // precondicion: -
    public boolean exists(Comparable<T> x) throws IsEmptyException {
        return exists(root, x);
    }

    // precondicion: -
    public boolean isEmpty(){
        return (root == null);
    }

    // precondición: árbol distino de vacío
    public T getRoot(){
        return root.elem;
    }

    // precondición: árbol distino de vacío
    public BinarySearchTree<T> getLeft(){
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.izq;
        return t;
    }

    // precondición: árbol distino de vacío
    public BinarySearchTree<T> getRight(){
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.der;
        return t;
    }


    // METODOS PRIVADOS
    private NodoDoble<T> getMax(NodoDoble <T> t) throws IsEmptyException {
        if (isEmpty()){
            throw new IsEmptyException();
        }
        if (t.der == null)
            return t;
        else
            return getMax(t.der);
    }

    private NodoDoble <T> getMin(NodoDoble <T> t) throws IsEmptyException {
        if (isEmpty()){
            throw new IsEmptyException();
        }
        if (t.izq == null)
            return t;
        else
            return getMin(t.izq);
    }

    private NodoDoble <T> search(NodoDoble <T> t, Comparable<T> x) throws IsEmptyException {
        if (isEmpty()){
            throw new IsEmptyException();
        }
        if (x.compareTo(t.elem)== 0)
            return t;
        else if (x.compareTo( t.elem)< 0)
            return search(t.izq, x);
        else
            return search(t.der, x);
    }

    private boolean exists(NodoDoble <T> t, Comparable<T> x) throws IsEmptyException {
        if (isEmpty()){
            throw new IsEmptyException();
        }
        if (t == null)
            return false;
        if (x.compareTo(t.elem) == 0)
            return true;
        else if (x.compareTo( t.elem)< 0)
            return exists(t.izq, x);
        else
            return exists(t.der, x);
    }


    private NodoDoble<T> insert (NodoDoble <T> t, Comparable <T> x) {
        if (t == null){
            t = new NodoDoble<T>();
            t.elem = (T) x;

        }
        else if (x.compareTo(t.elem) < 0)
            t.izq = insert(t.izq, x);
        else
            t.der = insert(t.der, x);
        return t;
    }


    private NodoDoble<T> delete (NodoDoble<T> t, Comparable<T> x) throws IsEmptyException {
        if (isEmpty()){
            throw new IsEmptyException();
        }
        if (x.compareTo(t.elem) < 0)
            t.izq = delete(t.izq, x);
        else if (x.compareTo(t.elem) > 0)
            t.der = delete(t.der, x);
        else
        if (t.izq != null && t.der != null ) {
            t.elem = getMin(t.der).elem;
            t.der = deleteMin(t.der);
        }
        else if (t.izq != null)
            t = t.izq;
        else
            t =t.der;
        return t;
    }

    private NodoDoble<T> deleteMin(NodoDoble<T> t) throws IsEmptyException {
        if (isEmpty()){
            throw new IsEmptyException();
        }
        if (t.izq != null)
            t.izq = deleteMin(t.izq);
        else
            t = t.der;
        return t;
    }

    public void inorden(BinarySearchTree<Genoma>  a){
        if(!a.isEmpty()){
            inorden(a.getLeft());
            System.out.println("Codigo: " + a.getRoot().code);
            System.out.println("Tipo: " + a.getRoot().type);
            System.out.println("Descripcion: " + a.getRoot().description);
            System.out.println("Tamano: " + a.getRoot().size);
            System.out.println();
            inorden(a.getRight());
        }
    }
}

