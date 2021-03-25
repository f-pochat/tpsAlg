package StacksandQueues;

public class QueueDin<T> implements QueueInterface<T>{

    Node front;
    Node end;
    private int size;

    public QueueDin() {
        end = new Node();
        size = 0;
        front.next = end;
    }

    @Override
    public void enqueue(Object element) {
        Node aux = new Node(element);
        aux.next = end;
        front.next = aux;
        size++;
    }

    @Override
    public T dequeue() throws IsEmptyException {
        if (isEmpty()){
            throw new IsEmptyException("Queue is Empty");
        }else {
            try{
                return (T) front.next.data;
            }finally {
                front.next = front.next.next;
                size--;
            }
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
