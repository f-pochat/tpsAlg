package StacksandQueues;

public class QueueDin<T> implements QueueInterface<T> {

    Node front;
    Node end;
    private int size;

    public QueueDin() {
        size = 0;
    }

    @Override
    public void enqueue(Object element) {
        Node aux = new Node(element);
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
            Node aux = front;
            front = front.next;
            if (front == null){
                end = null;
            }
            size--;

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
