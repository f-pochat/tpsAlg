package StacksandQueues;

public class StackDin<T> implements StackInterface<T> {

    Node tope;
    private int size;

    public StackDin() {
        tope = new Node();
        size = 0;
    }


    @Override
    public boolean isEmpty() {
        return tope.next == null;
    }

    @Override
    public T peek() {
        return (T) tope.data;
    }

    @Override
    public void pop() throws IsEmptyException {
        if (!isEmpty()){
            tope = tope.next;
            size--;
        }else{
            throw new IsEmptyException();
        }
    }

    @Override
    public void stack(Object element) {
        Node aux = new Node(element);
        aux.next = tope;
        tope = aux;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void empty() {
        tope.next = null;
        size = 0;
    }

}
