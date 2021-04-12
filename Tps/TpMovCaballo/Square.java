package TpMovCaballo;

import StacksandQueues.IsEmptyException;
import StacksandQueues.StackDin;

import javax.xml.xpath.XPathExpressionException;
import java.util.Arrays;

public class Square {
    private char colChar;
    private int columna;
    private int fila;

    public Square(char colChar, int fila) {
        this.colChar = colChar;
        columna = charToInt();
        this.fila = fila;
    }
    public Square(int columna, int fila) {
        this.columna = columna;
        this.fila = fila;
    }


    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public int charToInt(){
        return switch (colChar) {
            case 'A' -> 1;
            case 'B' -> 2;
            case 'C' -> 3;
            case 'D' -> 4;
            case 'E' -> 5;
            case 'F' -> 6;
            case 'G' -> 7;
            case 'H' -> 8;
            default -> throw new IllegalStateException("Unexpected value: " + columna);
        };
    }

    public void optionsPrinter() throws IsEmptyException {
        StackDin<Square> stack = new StackDin<>();
        stack.stack(new Square(getColumna() + 1, getFila() + 2));
        stack.stack(new Square(getColumna() + 1, getFila() - 2));
        stack.stack(new Square(getColumna() - 1, getFila() + 2));
        stack.stack(new Square(getColumna() - 1, getFila() - 2));
        stack.stack(new Square(getColumna() + 2, getFila() + 1));
        stack.stack(new Square(getColumna() + 2, getFila() - 1));
        stack.stack(new Square(getColumna() - 2, getFila() + 1));
        stack.stack(new Square(getColumna() - 2, getFila() - 1));
        //return stack;
        for (int i = 0; i < 8; i++) {
            if (stack.peek().columna > 0 && stack.peek().columna < 9 && stack.peek().fila > 0 && stack.peek().fila < 9){
                System.out.println(stack.peek().printSquare());
            }
            stack.pop();
        }

    }

    public StackDin<Square> options() throws IsEmptyException {
        //Add every movement even if its not valid
        StackDin<Square> stack = new StackDin<>();
        stack.stack(new Square(getColumna() + 1, getFila() + 2));
        stack.stack(new Square(getColumna() + 1, getFila() - 2));
        stack.stack(new Square(getColumna() - 1, getFila() + 2));
        stack.stack(new Square(getColumna() - 1, getFila() - 2));
        stack.stack(new Square(getColumna() + 2, getFila() + 1));
        stack.stack(new Square(getColumna() + 2, getFila() - 1));
        stack.stack(new Square(getColumna() - 2, getFila() + 1));
        stack.stack(new Square(getColumna() - 2, getFila() - 1));

        //Filter not valid squares
        StackDin<Square> stack2 = new StackDin<>();
        for (int i = 0; i < 8; i++) {
            if (stack.peek().columna > 0 && stack.peek().columna < 9 && stack.peek().fila > 0 && stack.peek().fila < 9){
                stack2.stack(stack.peek());
            }
            stack.pop();
        }

        return stack2;
    }

    public String printSquare(){
        char colChar = switch (columna) {
            case 1 -> 'A';
            case 2 -> 'B';
            case 3 -> 'C';
            case 4 -> 'D';
            case 5 -> 'E';
            case 6 -> 'F';
            case 7 -> 'G';
            case 8 -> 'H';
            default -> throw new IllegalStateException("Unexpected value: " + columna);
        };

        return colChar + "" + fila;
    }
     public boolean contains(Square square) throws IsEmptyException {
        StackDin<Square> optionsAux = options();
        while (!optionsAux.isEmpty()) {
            if (optionsAux.peek().equals(square))
                return true;
            else {
                optionsAux.pop();
            }
        }

        return false;
    }

    public void everyPath() throws IsEmptyException {
        Square[] paths = new Square[5];
        StackDin<Square> st = options();
        while (!st.isEmpty()){
            StackDin<Square> st1 = st.peek().options();
            while (!st1.isEmpty()){
                StackDin<Square> st2 = st1.peek().options();
                while (!st2.isEmpty()){
                    StackDin<Square> st3 = st2.peek().options();
                    while (!st3.isEmpty()){
                        System.out.println(printSquare() + "-" + st.peek().printSquare() + "-"
                                + st1.peek().printSquare() + "-" + st2.peek().printSquare() + "-"
                                + st3.peek().printSquare());

                        st3.pop();
                    }
                    st2.pop();
                }
                st1.pop();
            }
            st.pop();
        }
    }

    public boolean equals(Square square) {
        return this.getColumna() == square.getColumna() && this.getFila() == square.getFila();
    }
}
