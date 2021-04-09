package TpMovCaballo;

import StacksandQueues.IsEmptyException;

public class Horse{
     private Square position;

     public void jump( Square moveTo) throws IsEmptyException {
         if(position.contains(moveTo)) {
             position = moveTo;
         }else
             System.out.println("casilla no valida");
     }

    public Horse(Square position) {
        this.position = position;
    }

    public Square getPosition() {
        return position;
    }
}
