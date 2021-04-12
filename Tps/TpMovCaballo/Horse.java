package TpMovCaballo;

import StacksandQueues.IsEmptyException;

public class Horse{
     private Square position;
     private int counter = 0;


     public void jump(Square moveTo) throws IsEmptyException {
         if (position.contains(moveTo)) {
             position = moveTo;
             System.out.println("El caballo se movio a " + moveTo.printSquare());
             counter++;
         }else
             System.out.println("El casillero no es valido");
     }

    public Horse(Square position) {
        this.position = position;
    }

    public Square getPosition() {
        return position;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
