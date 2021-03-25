package StacksandQueues;

public class QueueEst<T> implements QueueInterface<T> {

    T[] queue;
    private int arraySize;
    private int size;
    int front;
    int end;

    public QueueEst() {
        queue = (T[]) new Object[10];
        arraySize = 10;
        size = 0;
        front = 0;
        end = 0;
    }

    @Override
    public void enqueue(Object element) {
        if (size < queue.length){
            queue[end] = (T) element;
            end++;
        }else {
            if (front > 0){
                end = 0;
                queue[end] = (T) element;
                end++;
            }else {
                try {
                    enlargeQueue();
                } catch (IsEmptyException e) {
                    e.printStackTrace();
                }
                enqueue(element);
            }
        }
        size++;
    }

    private void enlargeQueue() throws IsEmptyException {
        Object[] auxQueue = new Object[size + 10];
        for (int i = 0; i < size(); i++) {
            auxQueue[i] = dequeue();
        }
        queue = (T[]) auxQueue;
    }

    @Override
    public T dequeue() throws IsEmptyException {
        if (isEmpty()){
            throw new IsEmptyException("Queue is Empty");
        }else {
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
