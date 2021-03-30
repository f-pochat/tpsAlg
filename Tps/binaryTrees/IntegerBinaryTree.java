package binaryTrees;

public class IntegerBinaryTree {

    public static void main(String[] args) {
        IntegerBinaryTree br = new IntegerBinaryTree(6);
        IntegerBinaryTree bl = new IntegerBinaryTree(4);
        IntegerBinaryTree bt = new IntegerBinaryTree(2,bl,br);
        IntegerBinaryTree br2 = new IntegerBinaryTree();
        IntegerBinaryTree bl2 = new IntegerBinaryTree();
        IntegerBinaryTree bt2 = new IntegerBinaryTree(3,bl2,br2);
        IntegerBinaryTree bprueba = new IntegerBinaryTree(1,bt,bt2);
        System.out.println(bprueba.sumOfElements());
        System.out.println(bprueba.sumOfElementsMultipleOf3());
    }

    private DoubleNode<Integer> root;

    public IntegerBinaryTree() {
        this.root = null;
    }

    public IntegerBinaryTree(Integer o) {
        root = new DoubleNode <Integer>(o);
    }

    public IntegerBinaryTree(Integer o, IntegerBinaryTree tleft, IntegerBinaryTree tright){
        root = new DoubleNode<Integer>(o,tleft.root, tright.root);
    }

    public IntegerBinaryTree(Integer o, IntegerBinaryTree tleft){
        root = new DoubleNode<Integer>(o,tleft.root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public Integer getRoot(){
        return root.dato;
    }

    public IntegerBinaryTree getLeft(){
        IntegerBinaryTree t = new IntegerBinaryTree();
        t.root = root.left;
        return t;
    }

    public IntegerBinaryTree getRight(){
        IntegerBinaryTree t = new IntegerBinaryTree();
        t.root = root.right;
        return t;
    }

    public int weight(){
        if (isEmpty()){
            return 0;
        }
        if (root == null){
            return 0;
        }
        return 1 + getRight().weight() + getLeft().weight();
    }

    public int numberOfLeaves(){
        if (isEmpty()){
            return 0;
        }
        if (root.right == null || root.left == null){
            return 1;
        }

        return getLeft().numberOfLeaves() + getRight().numberOfLeaves();
    }
    //0.      1
    //1.   2      3
    //2. 4   5 null   null


    public int appearenceOfElement(Object element){
        if (root == null) {
            return 0;
        }
        if (root.dato == element){
            return 1 + getRight().appearenceOfElement(element) + getLeft().appearenceOfElement(element);
        }else {
            return getRight().appearenceOfElement(element) + getLeft().appearenceOfElement(element);
        }
    }

    //0.      1
    //1.   2      3
    //2. 4   5   null    null

    //0.      1
    //1.   2      3
    //2. 4   5   null    null

    public int height(){
        if (isEmpty()){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 0;
        }
        return 1 + Math.max(getLeft().height(), getRight().height());
    }

    //0.      1
    //1.   2      3
    //2. 4   5   null    null

    public int sumOfElements(){
        if (root.right == null || root.left == null){
            return root.dato;
        }
        return root.dato + getLeft().sumOfElements() + getRight().sumOfElements();
    }

    public int sumOfElementsMultipleOf3(){
        if (root.right == null || root.left == null){
            return root.dato % 3 == 0 ? root.dato : 0;
        }

        if (root.dato % 3 == 0) {
            return root.dato + getLeft().sumOfElementsMultipleOf3() + getRight().sumOfElementsMultipleOf3();
        }else {
            return getLeft().sumOfElementsMultipleOf3() + getRight().sumOfElementsMultipleOf3();
        }
    }
}
