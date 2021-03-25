package StacksandQueues;

public class QueueEst<T> implements QueueInterface<T> {

    T[] queue;
    private int size;
    int front;
    int end;

    public QueueEst() {
        queue = (T[]) new Object[10];
        size = 0;
        front = 0;
        end = 0;
    }

    @Override
    public void enqueue(Object element) {
        System.out.println(element);
        if (end < queue.length){
            queue[end] = (T) element;
            end++;
            size++;
        }else {
            if (front > 0){
                end = 0;
                queue[end] = (T) element;
                end++;
                size++;
            }else {
                try {
                    enlargeQueue();
                } catch (IsEmptyException e) {
                    e.printStackTrace();
                }
                enqueue(element);
            }
        }

    }

    private void enlargeQueue() throws IsEmptyException {
        T[] auxQueue = (T[]) new Object[size + 10];
        for (int i = 0; i < queue.length; i++) {
            auxQueue[i] = dequeue();
        }
        size = queue.length;
        front = 0;
        queue = auxQueue;
    }

    @Override
    public T dequeue() throws IsEmptyException {
        if (isEmpty()){
            throw new IsEmptyException();
        }else {
            if (front % 10 == 0){
                front = 0;
            }
            size--;
            front++;
            return queue[front-1];
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
