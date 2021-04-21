package binaryTrees;

import java.util.ArrayList;
import java.util.HashSet;

public class BinaryTreeAnalyzer {
   /* public static void main(String[] args) {
        IntegerBinaryTree br = new IntegerBinaryTree(6);
        IntegerBinaryTree bl = new IntegerBinaryTree(4);
        IntegerBinaryTree bt = new IntegerBinaryTree(9, bl, br);
        IntegerBinaryTree br2 = new IntegerBinaryTree(1);
        IntegerBinaryTree bl2 = new IntegerBinaryTree(2);
        IntegerBinaryTree bt2 = new IntegerBinaryTree(8, bl2, br2);

        IntegerBinaryTree bprueba = new IntegerBinaryTree(10, bt, bt2);
        IntegerBinaryTree bprueba2 = new IntegerBinaryTree(7, bt, bt2);
        IntegerBinaryTree bprueba3 = new IntegerBinaryTree(1, bt2, bt);
        IntegerBinaryTree bprueba4 = new IntegerBinaryTree(1, bt2);
        IntegerBinaryTree bprueba5 = new IntegerBinaryTree(9, bl, br);
        ArrayList<Integer> frontierElements = new ArrayList<>();

        System.out.println(iguales(bprueba, bprueba2));
        System.out.println(isomorfo(bprueba, bprueba2));
        System.out.println(semejantes(bprueba, bprueba3));

        System.out.println(lleno(bprueba5));
        System.out.println(completo((bprueba4)));

        System.out.println(estable(bprueba));
        System.out.println(estable(bprueba5));

        System.out.println(occursBinaryTree(bprueba,bprueba5));

        showFrontier(bprueba);
        frontier(bprueba,frontierElements);
        System.out.println(frontierElements.size());

    }*/
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
        inorden(a1, set1);

        HashSet<Integer> set2 = new HashSet<>();
        inorden(a2, set2);

        return set1.containsAll(set2);
    }

    static boolean lleno(IntegerBinaryTree a) {
        if (a.isEmpty())
            return false;
        if (a.getLeft().isEmpty() && a.getRight().isEmpty())
            return true;
        return lleno(a.getRight()) && lleno(a.getLeft());
    }

    static boolean completo(IntegerBinaryTree a) {
        if (a.isEmpty())
            return false;
        if ((a.getLeft().isEmpty() || a.getRight().isEmpty()) && !(a.getLeft().isEmpty() && a.getRight().isEmpty()))
            return false;
        else
            return true;
    }

    static boolean estable(IntegerBinaryTree a) {
        if (a.isEmpty()) {
            return true;
        } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return true;
        }

        return a.getRoot() > a.getLeft().getRoot() && a.getRoot() > a.getLeft().getRoot() && estable(a.getLeft()) && estable(a.getRight());
    }

    private static void inorden(IntegerBinaryTree a, HashSet<Integer> arr) {
        if (!a.isEmpty()) {
            inorden(a.getLeft(), arr);
            arr.add(a.getRoot());
            inorden(a.getRight(), arr);
        }
    }

    public static boolean occursBinaryTree(IntegerBinaryTree a1, IntegerBinaryTree a2) {//returns true if t2 is included

        if (a2.height() > a1.height()) {

            return false;

        }

        if (a1.getRoot().equals(a2.getRoot())) {

            if (a2.getRight().isEmpty() && a2.getLeft().isEmpty()) {

                return true;

            }

            if (a2.getLeft().isEmpty()) {

                return occursBinaryTree(a1.getRight(), a2.getRight());

            }

            if (a2.getRight().isEmpty()) {

                return occursBinaryTree(a1.getLeft(), a2.getLeft());
            }

            return occursBinaryTree(a1.getLeft(), a2.getLeft()) && occursBinaryTree(a1.getRight(), a2.getRight());


        }

        return occursBinaryTree(a1.getLeft(), a2) || occursBinaryTree(a1.getRight(), a2);

    }

    public static void showFrontier(IntegerBinaryTree a) {

        if (a.isEmpty()) {

            return;

        }

        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            System.out.println(a.getRoot().toString());

        }

        showFrontier(a.getRight());
        showFrontier(a.getLeft());


    }

    public static void frontier(IntegerBinaryTree a, ArrayList frontierElements) {

        if (a.isEmpty()) {
            return;
        }

        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            frontierElements.add(a.getRoot());
        }


        frontier(a.getRight(), frontierElements);
        frontier(a.getLeft(), frontierElements);

    }
}