package BinarySearchTree;

import java.util.ArrayList;

public class Transfer {
    ArrayList<Genoma> list;

    public Transfer(ArrayList<Genoma> list) {
        this.list = list;
    }

    public BinarySearchTree<Genoma> transferListToBST(){
        BinarySearchTree<Genoma> bst = new BinarySearchTree<Genoma>();
        for(Genoma item : list){
            bst.insert(item);
        }
        return bst;
    }
}
