package TpMovCaballo;

import StacksandQueues.IsEmptyException;

public class Board {
    private static Square[][] tablero;

    public Board() {
        tablero = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = new Square(i + 1,j + 1);
            }
        }
    }

    public void everyPathInEverySquare() throws IsEmptyException {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j].everyPath();
            }
        }
    }
}
