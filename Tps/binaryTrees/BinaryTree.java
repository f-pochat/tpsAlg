package binaryTrees;

import javax.swing.*;

public class BinaryTree<T> {

    public static void main(String[] args) {
        BinaryTree<Integer> br = new BinaryTree<>(5);
        BinaryTree<Integer> bl = new BinaryTree<>(4);
        BinaryTree<Integer> bt = new BinaryTree<>(2,bl,br);
        BinaryTree<Integer> br2 = new BinaryTree<>();
        BinaryTree<Integer> bl2 = new BinaryTree<>();
        BinaryTree<Integer> bt2 = new BinaryTree<>(3,bl2,br2);
        BinaryTree<Integer> bprueba = new BinaryTree<>(1,bt,bt2);
        System.out.println(bprueba.weight());
        System.out.println(bprueba.numberOfLeaves());
        System.out.println(bprueba.appearenceOfElement(1));
        System.out.println(bprueba.elementsPerLevel(2));
        System.out.println(bprueba.height());
    }

    private DoubleNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(T o) {
        root = new DoubleNode <T>(o);
    }

    public BinaryTree(T o, BinaryTree<T> tleft, BinaryTree<T> tright){
        root = new DoubleNode<T>(o,tleft.root, tright.root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public T getRoot(){
        return root.dato;
    }

    public BinaryTree<T> getLeft(){
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.left;
        return t;
    }

    public BinaryTree<T> getRight(){
        BinaryTree<T> t = new BinaryTree<T>();
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
        if (isEmpty()){
            return 0;
        }
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

    public int elementsPerLevel(int level){
        if (isEmpty()){
            return 0;
        }
        if (root == null || level < 0){
            return 0;
        }
        if (level == 0){
            return 1;
        }else {
            return getRight().elementsPerLevel(level - 1) + getLeft().elementsPerLevel(level - 1);
        }
    }

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


}
