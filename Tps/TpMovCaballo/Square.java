package TpMovCaballo;

import StacksandQueues.IsEmptyException;
import StacksandQueues.StackDin;

import javax.xml.xpath.XPathExpressionException;
import java.util.Arrays;

public class Square {
    private int columna;
    private int fila;

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
                stack.peek().printSquare();
            }
            stack.pop();
        }

    }

    /*public StackDin<Square> options() throws IsEmptyException {
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
    }*/

    public void printSquare(){
        Character colChar;
        switch (columna){
            case 1:
                colChar = 'A';
                break;
            case 2:
                colChar = 'B';
                break;
            case 3:
                colChar = 'C';
                break;
            case 4:
                colChar = 'D';
                break;
            case 5:
                colChar = 'E';
                break;
            case 6:
                colChar = 'F';
                break;
            case 7:
                colChar = 'G';
                break;
            case 8:
                colChar = 'H';
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + columna);
        }
        
        System.out.println(colChar + "" + fila);
    }
}
