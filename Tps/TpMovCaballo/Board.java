package TpMovCaballo;

public class Board {
    Square[][] tablero;
    public Board() {
        tablero = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = new Square(i,j);
            }
        }
    }
}
