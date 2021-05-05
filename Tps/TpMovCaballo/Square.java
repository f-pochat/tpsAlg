package TpMovCaballo;

public class Square {
    private char columnAsIntsChar;
    private int columnAsInt;
    private int row;

    //Constructor with the column as a char. Example: A1
    public Square(char columnAsIntsChar, int row) {
        this.columnAsIntsChar = columnAsIntsChar;
        columnAsInt = charToInt();
        this.row = row;
    }

    //Constructor with a column as an int. Example: 11
    public Square(int columnAsInt, int row) {
        this.columnAsInt = columnAsInt;
        this.row = row;
    }
    
    public int getcolumnAsInt() {
        return columnAsInt;
    }

    public int getrow() {
        return row;
    }

    //Converts the char of the columns to an int
    public int charToInt(){
        return switch (columnAsIntsChar) {
            case 'A' -> 1;
            case 'B' -> 2;
            case 'C' -> 3;
            case 'D' -> 4;
            case 'E' -> 5;
            case 'F' -> 6;
            case 'G' -> 7;
            case 'H' -> 8;
            default -> throw new IllegalStateException("Unexpected value: " + columnAsInt);
        };
    }

    //Returns the square position with the format Column + Row
    public String squareAsString(){
        char columnAsIntsChar = switch (columnAsInt) {
            case 1 -> 'A';
            case 2 -> 'B';
            case 3 -> 'C';
            case 4 -> 'D';
            case 5 -> 'E';
            case 6 -> 'F';
            case 7 -> 'G';
            case 8 -> 'H';
            default -> throw new IllegalStateException("Unexpected value: " + columnAsInt);
        };

        return columnAsIntsChar + "" + row;
    }

    //Prints the stack with the different options a horse can take from a jump in this square
    public void optionsPrinter() throws IsEmptyException {
        StackDin<Square> stack = options();
        for (int i = 0; i < options().size(); i++) {
            System.out.println(stack.peek().squareAsString());
            stack.pop();
        }
    }

    //Returns a stack with all the different options a horse can take from a jump
    public StackDin<Square> options() throws IsEmptyException {
        //Add every movement even if its not valid
        StackDin<Square> stack = new StackDin<>();
        stack.stack(new Square(getcolumnAsInt() + 1, getrow() + 2));
        stack.stack(new Square(getcolumnAsInt() + 1, getrow() - 2));
        stack.stack(new Square(getcolumnAsInt() - 1, getrow() + 2));
        stack.stack(new Square(getcolumnAsInt() - 1, getrow() - 2));
        stack.stack(new Square(getcolumnAsInt() + 2, getrow() + 1));
        stack.stack(new Square(getcolumnAsInt() + 2, getrow() - 1));
        stack.stack(new Square(getcolumnAsInt() - 2, getrow() + 1));
        stack.stack(new Square(getcolumnAsInt() - 2, getrow() - 1));

        //Filter not valid squares
        StackDin<Square> stack2 = new StackDin<>();
        for (int i = 0; i < 8; i++) {
            if (stack.peek().columnAsInt > 0 && stack.peek().columnAsInt < 9 && stack.peek().row > 0 && stack.peek().row < 9){
                stack2.stack(stack.peek());
            }
            stack.pop();
        }

        return stack2;
    }

    //Returns if a stack of options contains a given square
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

    //Prints every path a horse can take from this postion with 4 jumps
    public void everyPath() throws IsEmptyException {
        StackDin<Square> st = options();
        while (!st.isEmpty()){
            StackDin<Square> st1 = st.peek().options();
            while (!st1.isEmpty()){
                StackDin<Square> st2 = st1.peek().options();
                while (!st2.isEmpty()){
                    StackDin<Square> st3 = st2.peek().options();
                    while (!st3.isEmpty()){
                        System.out.println(squareAsString() + "-" + st.peek().squareAsString() + "-"
                                + st1.peek().squareAsString() + "-" + st2.peek().squareAsString() + "-"
                                + st3.peek().squareAsString());

                        st3.pop();
                    }
                    st2.pop();
                }
                st1.pop();
            }
            st.pop();
        }
    }

    //Checks if 2 squares are equal by comparing the column and the row
    public boolean equals(Square square) {
        return this.getcolumnAsInt() == square.getcolumnAsInt() && this.getrow() == square.getrow();
    }
}
