package TpMovCaballo;

import StacksandQueues.IsEmptyException;

public class Horse{
     private Square position;
     private Square[] path;
     private int counter =0;


     public void jump( Square moveTo) throws IsEmptyException {
         position = moveTo;
         counter++;
         path[counter] = position;
         if (counter == 4){
             Board b = new Board();
        b.everyPathInEverySquare();
         }
     }

    public Horse(Square position) {
        this.position = position;
        path = new Square[5];
        path[0] = position;
    }

    public Square getPosition() {
        return position;
    }
}
