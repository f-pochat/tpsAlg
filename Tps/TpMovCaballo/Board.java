package TpMovCaballo;

public class Board {
    private Square[][] board;
    
    //Constructor of the board of 8x8
    public Board() {
        board = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(i + 1,j + 1);
            }
        }
    }
    
    //Prints every path a horse can take in every position of the board
    public void everyPathInEverySquare() throws IsEmptyException {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j].everyPath();
            }
        }
    }
}
