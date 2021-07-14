package TpHash;

public class Line implements Hashable{
    private String line;

    public Line(String line) {
        this.line = line;
    }

    @Override
    public int hash(int M) {
        char firstLetter = line.toUpperCase().charAt(0);
        switch (firstLetter) {
            case 'B', 'F', 'P', 'V' -> {
                return 1;
            }
            case 'C', 'G', 'J', 'K', 'Q', 'S', 'X', 'Z' -> {
                return 2;
            }
            case 'D', 'T' -> {
                return 3;
            }
            case 'L' -> {
                return 4;
            }
            case 'M', 'N' -> {
                return 5;
            }
            case 'R' -> {
                return 6;
            }
            default -> {
                return 0;
            }
        }
    }

    public String getLine() {
        return line;
    }
}
