package BinarySearchTree;

public class Genoma implements Comparable<Genoma> {
    String code;
    String type;
    String description;
    int size;

    public Genoma(String code) {
        this.code = code;
    }

    public Genoma(String code, String type, String description, int size) {
        this.code = code;
        this.type = type;
        this.description = description;
        this.size = size;
    }

    @Override
    public int compareTo(Genoma o) {
        return code.compareTo(o.code);
    }
}