package TpMovCaballo;

public class Horse{
     private Square position;
     private int counter = 0;

     //The horse changes its position if the next position is in the Options stack
    //Else the new position is not valid
     public void jump(Square moveTo) throws IsEmptyException {
         if (position.contains(moveTo)) {
             position = moveTo;
             System.out.println("El Caballo se movio a " + moveTo.squareAsString());
             counter++;
         }else
             System.out.println("El Casillero no es valido");
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
