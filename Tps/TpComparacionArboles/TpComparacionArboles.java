package TpComparacionArboles;

import java.util.Random;

public class TpComparacionArboles {
    static int[] intArray = new int[1000];

    public static void main(String[] args) {
        for(int i = 0; i < 1000;i++){
            Random ran = new Random();
            int x = ran.nextInt(100000)+1;
            intArray[i] = x;
        }

        System.out.println("BST");
        long startTime = System.nanoTime();
        BinarySearchTree<Integer> bst = createBST();
        long endTime = System.nanoTime();
        System.out.print("Time: ");
        System.out.println(endTime - startTime);

        System.out.println("AVL");
        long startTimeAVL = System.nanoTime();
        AVLTree avl = createAVl();
        long endTimeAVL = System.nanoTime();
        System.out.print("Time: ");
        System.out.println(endTimeAVL - startTimeAVL);

        System.out.println("Rojinegro");
        long startTimeRN = System.nanoTime();
        RedBlackTree rbt = createRB();
        long endTimeRN = System.nanoTime();
        System.out.print("Time: ");
        System.out.println(endTimeRN - startTimeRN);

        System.out.println("Binary Search Tree Height: ");
        System.out.println(createBST().getHeight());


    }

    private static AVLTree createAVl() {
        AVLTree avl = new AVLTree();
        for(int number : intArray){
            avl.insert(number);
        }
        return avl;
    }

    private static RedBlackTree createRB() {
        RedBlackTree rbt = new RedBlackTree();
        for(int number : intArray){
            rbt.insert(number);
        }
        return rbt;
    }

    public static BinarySearchTree<Integer> createBST(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for(int number : intArray){
            bst.insert(number);
        }
        return bst;
    }

}
