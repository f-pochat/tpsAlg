package StacksandQueues;

public class QueueEst implements QueueInterface {

    Object[] queue;
    private int arraySize;
    private int size;
    int front;
    int end;

    public QueueEst() {
        queue = new Object[10];
        arraySize = 10;
        size = 0;
        front = 0;
        end = 0;
    }

    @Override
    public void enqueue(Object element) {
        if (end < arraySize){
            queue[end] = element;
            end++;
        }else {
            if (front > 0){
                end = 0;
                queue[end] = element;
                end++;
            }else {
                enlargeQueue();
                enqueue(element);
            }
        }

        size++;
    }

    private void enlargeQueue() {
        Object[] queueAux = new Object[size() + 10];
        for (int i = 0; i < size(); i++) {
            queueAux[i] = queue[i];
        }
        queue = queueAux;
        arraySize += 10;
    }

    @Override
    public Object dequeue() throws IsEmptyException {
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
