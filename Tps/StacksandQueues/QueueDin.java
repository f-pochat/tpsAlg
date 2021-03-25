package StacksandQueues;

public class QueueDin<T> implements QueueInterface<T> {

    AlgoritmoYEstructuraDeDatos.Node front;
    AlgoritmoYEstructuraDeDatos.Node end;
    private int size;

    public QueueDin() {
        size = 0;
    }

    @Override
    public void enqueue(Object element) {
        System.out.println(element);
        AlgoritmoYEstructuraDeDatos.Node aux = new AlgoritmoYEstructuraDeDatos.Node(element);
        if (end == null){
            front = end = aux;
        }
        end.next = aux;
        end = aux;
        size++;
    }

    @Override
    public T dequeue() throws IsEmptyException {
        if (isEmpty()){
            throw new IsEmptyException();
        }else {
            AlgoritmoYEstructuraDeDatos.Node aux = front;
            front = front.next;
            if (front == null){
                end = null;
            }
            size--;
            System.out.println(aux.data);
            return (T) aux.data;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
