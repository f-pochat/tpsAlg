package binaryTrees;

import java.util.HashSet;

public class BinaryTreeAnalyzer {
    public static void main(String[] args) {
        IntegerBinaryTree br = new IntegerBinaryTree(6);
        IntegerBinaryTree bl = new IntegerBinaryTree(4);
        IntegerBinaryTree bt = new IntegerBinaryTree(2, bl, br);
        IntegerBinaryTree br2 = new IntegerBinaryTree();
        IntegerBinaryTree bl2 = new IntegerBinaryTree();
        IntegerBinaryTree bt2 = new IntegerBinaryTree(3, bl2, br2);

        IntegerBinaryTree bprueba = new IntegerBinaryTree(1, bt, bt2);
        IntegerBinaryTree bprueba2 = new IntegerBinaryTree(7, bt, bt2);
        IntegerBinaryTree bprueba3 = new IntegerBinaryTree(1,bt2,bt);
        IntegerBinaryTree bprueba4 = new IntegerBinaryTree(1,bt2);
        IntegerBinaryTree bprueba5 = new IntegerBinaryTree(1,bt,bt);


        System.out.println(iguales(bprueba, bprueba2));
        System.out.println(isomorfo(bprueba, bprueba2));
        System.out.println(semejantes(bprueba, bprueba3));

        System.out.println(lleno(bprueba5));
        System.out.println(completo((bprueba4)));

    }



    static boolean iguales(IntegerBinaryTree a1, IntegerBinaryTree a2) {
        if (a1.isEmpty() && a2.isEmpty()) {
            return true;
        }

        if (a1 == null || a2 == null) {
            return false;
        } else {
            if (a1.getRoot() == a2.getRoot()) {
                return iguales(a1.getLeft(), a2.getLeft()) && iguales(a1.getRight(), a2.getRight());
            } else {
                return false;
            }

        }
    }

    static boolean isomorfo(IntegerBinaryTree a1, IntegerBinaryTree a2) {
        if (a1.isEmpty() && a2.isEmpty()) {
            return true;
        }

        if (a1 == null || a2 == null) {
            return false;
        } else {
            return isomorfo(a1.getLeft(), a2.getLeft()) && isomorfo(a1.getRight(), a2.getRight());
        }
    }

    static boolean semejantes(IntegerBinaryTree a1, IntegerBinaryTree a2) {
        if (a1.isEmpty() && a2.isEmpty()) {
            return true;
        }

        HashSet<Integer> set1 = new HashSet<>();
        inorden(a1,set1);

        HashSet<Integer> set2 = new HashSet<>();
        inorden(a2,set2);

        return set1.containsAll(set2);
    }

    static boolean lleno(IntegerBinaryTree a){
        if(a.isEmpty())
            return false;
        if (a.getLeft().isEmpty() && a.getRight().isEmpty())
            return true;
        return lleno(a.getRight()) && lleno(a.getLeft());
    }

    static boolean completo(IntegerBinaryTree a) {
        if(a.isEmpty())
            return false;
        if ((a.getLeft().isEmpty() || a.getRight().isEmpty()) && !(a.getLeft().isEmpty() && a.getRight().isEmpty()))
            return false;
        else
            return true;
    }



    private static void inorden(IntegerBinaryTree a, HashSet<Integer> arr){
        if(!a.isEmpty()){
            inorden(a.getLeft(),arr);
            arr.add(a.getRoot());
            inorden(a.getRight(),arr);
        }
    }

}

    /*static boolean sameNodes(Integer a, Integer b){
        return a.equals(b);
    }*/
