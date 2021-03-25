package StacksandQueues;

public class StackEst<T> implements StackInterface{

    Object[] stack;
    int tope;

    public StackEst() {
        stack = new Object[10];
        tope = 0;
    }

    @Override
    public boolean isEmpty() {
        return tope == 0;
    }

    @Override
    public Object peek() {
        return stack[tope];
    }

    @Override
    public void pop() throws IsEmptyException {
        if (!isEmpty()){
            tope--;
        }else {
            throw new IsEmptyException("Stack is empty");
        }

    }

    @Override
    public void stack(Object element) {
        if (size() % 10 == 0){
            enlargeStack();
        }
        stack[tope] = element;
        tope++;
    }

    @Override
    public int size() {
        if (!isEmpty()){
            return tope +1;
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
        stack = stackAux;
    }

}