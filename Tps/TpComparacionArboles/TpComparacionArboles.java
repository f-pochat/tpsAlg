package TpComparacionArboles;

import java.util.Random;

public class TpComparacionArboles {
    static int[] intArray = new int[1000];

    public static void main(String[] args) throws IsEmptyException {
        for(int i = 0; i < 1000;i++){
            Random ran = new Random();
            int x = ran.nextInt(100000)+1;
            intArray[i] = x;
        }

        System.out.println("BST");
        long startTime = System.nanoTime();
        BinarySearchTree<Integer> bst = createBST(intArray);
        long endTime = System.nanoTime();
        System.out.print("Time: ");
        System.out.println((endTime - startTime));

        System.out.println("AVL");
        long startTimeAVL = System.nanoTime();
        AVLTree avl = createAVl(intArray);
        long endTimeAVL = System.nanoTime();
        System.out.print("Time: ");
        System.out.println(endTimeAVL - startTimeAVL);

        System.out.println("Rojinegro");
        long startTimeRN = System.nanoTime();
        RedBlackTree rbt = createRB(intArray);
        long endTimeRN = System.nanoTime();
        System.out.print("Time: ");
        System.out.println(endTimeRN - startTimeRN);

        System.out.println("Binary Search Tree Height: ");
        System.out.println(createBST(intArray).getHeight());

        System.out.println("AVL Tree Height: ");
        System.out.println(createAVl(intArray).getHeight());

        System.out.println("Red Black Tree Height: ");
        System.out.println(createRB(intArray).getHeight());

        int[] tenElements = new int[10];
        for (int i = 0; i < 10; i++) {
            tenElements[i] = intArray[i*100];
        }

        System.out.println();

        System.out.println("Numero a buscar\t\tBST\t\tAVL\t\tRBT");
        System.out.println("-----------------------------------------");
        int numOfCompBst = 0;
        int numOfCompAVL = 0;
        int numOfCompRBT = 0;
        for (int element:tenElements){
            numOfCompBst += bst.getNumberOfComparisons(element);
            numOfCompAVL += avl.getCounterOfSearches(element);
            numOfCompRBT += rbt.getCounterOfSearches(element);
            System.out.println(element + "\t\t\t\t" + bst.getNumberOfComparisons(element) + "\t\t" + avl.getCounterOfSearches(element) + "\t\t" + rbt.getCounterOfSearches(element));
        }
        System.out.println("-----------------------------------------");
        System.out.println("Promedio\t\t\t" + (double)numOfCompBst/10 + "\t\t" + (double)numOfCompAVL/10 + "\t\t" + (double)numOfCompRBT/10);



        long bstConstuctionTimes = 0;
        int totalBSTHeights = 0;
        int numOfBstComps = 0;
        for (int i = 0; i < 10; i++) {
            int[] arr = randomArray();
            bstConstuctionTimes -= System.nanoTime();
            BinarySearchTree<Integer> bstTree = createBST(arr);
            bstConstuctionTimes += System.nanoTime();

            totalBSTHeights += bstTree.getHeight();

            int[] tenElementsBST = new int[10];
            for (int j = 0; j < 10; j++) {
                tenElementsBST[j] = arr[j*100];
            }
            for (int element:tenElementsBST){
                numOfBstComps += bstTree.getNumberOfComparisons(element);
            }

        }

        long avlConstuctionTimes = 0;
        int totalAVLHeights = 0;
        int numOfAVLComps = 0;
        for (int i = 0; i < 10; i++) {
            int[] arr = randomArray();
            avlConstuctionTimes -= System.nanoTime();
            AVLTree avlTree = createAVl(arr);
            avlConstuctionTimes += System.nanoTime();

            totalAVLHeights += avlTree.getHeight();

            int[] tenElementsAVL = new int[10];
            for (int j = 0; j < 10; j++) {
                tenElementsAVL[j] = arr[j*100];
            }
            for (int element:tenElementsAVL){
                numOfAVLComps += avlTree.getCounterOfSearches(element);
            }
        }

        long rbtConstuctionTimes = 0;
        int totalRBTHeights = 0;
        int numOfRBTComps = 0;
        for (int i = 0; i < 10; i++) {
            int[] arr = randomArray();
            rbtConstuctionTimes -= System.nanoTime();
            RedBlackTree rbTree = createRB(arr);
            rbtConstuctionTimes += System.nanoTime();

            totalRBTHeights += rbTree.getHeight();

            int[] tenElementsRBT = new int[10];
            for (int j = 0; j < 10; j++) {
                tenElementsRBT[j] = arr[j*100];
            }
            for (int element:tenElementsRBT){
                numOfRBTComps += rbTree.getCounterOfSearches(element);
            }
        }

        System.out.println("Arboles");
        System.out.println("Tiempo promedio de construccion BST: " + (double)bstConstuctionTimes/10 + " AVL: " + (double)avlConstuctionTimes/10 + " RBT: "+ (double)rbtConstuctionTimes/10);
        System.out.println("Altura promedio BST: " + (double)totalBSTHeights/10 + " AVL: " + (double)totalAVLHeights/10 + " RBT: " + (double)totalRBTHeights/10);
        System.out.println("Promedio de intentos BST: " + (double)numOfBstComps/100 + " AVL: " + (double)numOfAVLComps/100 + " RBT: " + (double)numOfRBTComps/100);

    }

    private static int[] randomArray() {
        int[] randomArray = new int[1000];
        for (int i = 0; i < 1000; i++) {
            Random ran = new Random();
            int x = ran.nextInt(100000) + 1;
            randomArray[i] = x;
        }
        return randomArray;
    }

    private static AVLTree createAVl(int[] arr) {
        AVLTree avl = new AVLTree();
        for(int number : arr){
            avl.insert(number);
        }
        return avl;
    }

    private static RedBlackTree createRB(int[] arr) {
        RedBlackTree rbt = new RedBlackTree();
        for(int number : arr){
            rbt.insert(number);
        }
        return rbt;
    }

    public static BinarySearchTree<Integer> createBST(int[] arr){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for(int number : arr){
            bst.insert(number);
        }
        return bst;
    }

}
