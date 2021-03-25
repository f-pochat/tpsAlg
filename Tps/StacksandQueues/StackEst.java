package StacksandQueues;

public class StackEst<T> implements StackInterface<T> {

    T[] stack;
    int tope;

    public StackEst() {
        stack = (T[]) new Object[10];
        tope = 0;
    }

    @Override
    public boolean isEmpty() {
        return tope == 0;
    }

    @Override
    public T peek() {
        return (T) stack[tope-1];
    }

    @Override
    public void pop() throws IsEmptyException {
        if (!isEmpty()){
            tope--;
        }else {
            throw new IsEmptyException();
        }
    }

    @Override
    public void stack(Object element) {
        if (size() % 10 == 0){
            enlargeStack();
        }
        stack[tope] = (T) element;
        tope++;
    }

    @Override
    public int size() {
        if (!isEmpty()){
            return tope;
        }else{
            return 0;
        }

    }

    @Override
    public void empty() {
        tope = 0;
    }

    private void enlargeStack(){
        Object[] stackAux = new Object[size() + 10];
        for (int i = 0; i < size(); i++) {
            stackAux[i] = stack[i];
        }
        stack = (T[]) stackAux;
    }

}
