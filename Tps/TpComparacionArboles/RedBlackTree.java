package TpComparacionArboles;

class NodeRN {
    int data; // holds the key
    NodeRN parent; // pointer to the parent
    NodeRN left; // pointer to left child
    NodeRN right; // pointer to right child
    int color; // 1 . Red, 0 . Black
}


// class RedBlackTree implements the operations in Red Black Tree
public class RedBlackTree {
    private NodeRN root;
    private NodeRN TNULL;

    private void preOrderHelper(NodeRN NodeRN) {
        if (NodeRN != TNULL) {
            System.out.print(NodeRN.data + " ");
            preOrderHelper(NodeRN.left);
            preOrderHelper(NodeRN.right);
        }
    }

    private void inOrderHelper(NodeRN NodeRN) {
        if (NodeRN != TNULL) {
            inOrderHelper(NodeRN.left);
            System.out.print(NodeRN.data + " ");
            inOrderHelper(NodeRN.right);
        }
    }

    private void postOrderHelper(NodeRN NodeRN) {
        if (NodeRN != TNULL) {
            postOrderHelper(NodeRN.left);
            postOrderHelper(NodeRN.right);
            System.out.print(NodeRN.data + " ");
        }
    }

    private NodeRN searchTreeHelper(NodeRN NodeRN, int key) {
        if (NodeRN == TNULL || key == NodeRN.data) {
            return NodeRN;
        }

        if (key < NodeRN.data) {
            return searchTreeHelper(NodeRN.left, key);
        }
        return searchTreeHelper(NodeRN.right, key);
    }

    // fix the rb tree modified by the delete operation
    private void fixDelete(NodeRN x) {
        NodeRN s;
        while (x != root && x.color == 0) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == 1) {
                    // case 3.1
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == 0 && s.right.color == 0) {
                    // case 3.2
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) {
                        // case 3.3
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }

                    // case 3.4
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == 1) {
                    // case 3.1
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == 0 && s.right.color == 0) {
                    // case 3.2
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) {
                        // case 3.3
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }

                    // case 3.4
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }


    private void rbTransplant(NodeRN u, NodeRN v){
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left){
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    private void deleteNodeRNHelper(NodeRN NodeRN, int key) {
        // find the NodeRN containing key
        NodeRN z = TNULL;
        NodeRN x, y;
        while (NodeRN != TNULL){
            if (NodeRN.data == key) {
                z = NodeRN;
            }

            if (NodeRN.data <= key) {
                NodeRN = NodeRN.right;
            } else {
                NodeRN = NodeRN.left;
            }
        }

        if (z == TNULL) {
            System.out.println("Couldn't find key in the tree");
            return;
        }

        y = z;
        int yOriginalColor = y.color;
        if (z.left == TNULL) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == 0){
            fixDelete(x);
        }
    }

    // fix the red-black tree
    private void fixInsert(NodeRN k){
        NodeRN u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left; // uncle
                if (u.color == 1) {
                    // case 3.1
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        // case 3.2.2
                        k = k.parent;
                        rightRotate(k);
                    }
                    // case 3.2.1
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // uncle

                if (u.color == 1) {
                    // mirror case 3.1
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        // mirror case 3.2.2
                        k = k.parent;
                        leftRotate(k);
                    }
                    // mirror case 3.2.1
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }

    private void printHelper(NodeRN root, String indent, boolean last) {
        // print the tree structure on the screen
        if (root != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            String sColor = root.color == 1?"RED":"BLACK";
            System.out.println(root.data + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }

    public RedBlackTree() {
        TNULL = new NodeRN();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    // Pre-Order traversal
    // NodeRN.Left Subtree.Right Subtree
    public void preorder() {
        preOrderHelper(this.root);
    }

    // In-Order traversal
    // Left Subtree . NodeRN . Right Subtree
    public void inorder() {
        inOrderHelper(this.root);
    }

    // Post-Order traversal
    // Left Subtree . Right Subtree . NodeRN
    public void postorder() {
        postOrderHelper(this.root);
    }

    // search the tree for the key k
    // and return the corresponding NodeRN
    public NodeRN searchTree(int k) {
        return searchTreeHelper(this.root, k);
    }

    // find the NodeRN with the minimum key
    public NodeRN minimum(NodeRN NodeRN) {
        while (NodeRN.left != TNULL) {
            NodeRN = NodeRN.left;
        }
        return NodeRN;
    }

    // find the NodeRN with the maximum key
    public NodeRN maximum(NodeRN NodeRN) {
        while (NodeRN.right != TNULL) {
            NodeRN = NodeRN.right;
        }
        return NodeRN;
    }

    // find the successor of a given NodeRN
    public NodeRN successor(NodeRN x) {
        // if the right subtree is not null,
        // the successor is the leftmost NodeRN in the
        // right subtree
        if (x.right != TNULL) {
            return minimum(x.right);
        }

        // else it is the lowest ancestor of x whose
        // left child is also an ancestor of x.
        NodeRN y = x.parent;
        while (y != TNULL && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    // find the predecessor of a given NodeRN
    public NodeRN predecessor(NodeRN x) {
        // if the left subtree is not null,
        // the predecessor is the rightmost NodeRN in the
        // left subtree
        if (x.left != TNULL) {
            return maximum(x.left);
        }

        NodeRN y = x.parent;
        while (y != TNULL && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    // rotate left at NodeRN x
    public void leftRotate(NodeRN x) {
        NodeRN y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // rotate right at NodeRN x
    public void rightRotate(NodeRN x) {
        NodeRN y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // insert the key to the tree in its appropriate position
    // and fix the tree
    public void insert(int key) {
        // Ordinary Binary Search Insertion
        NodeRN NodeRN = new NodeRN();
        NodeRN.parent = null;
        NodeRN.data = key;
        NodeRN.left = TNULL;
        NodeRN.right = TNULL;
        NodeRN.color = 1; // new NodeRN must be red

        NodeRN y = null;
        NodeRN x = this.root;

        while (x != TNULL) {
            y = x;
            if (NodeRN.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // y is parent of x
        NodeRN.parent = y;
        if (y == null) {
            root = NodeRN;
        } else if (NodeRN.data < y.data) {
            y.left = NodeRN;
        } else {
            y.right = NodeRN;
        }

        // if new NodeRN is a root NodeRN, simply return
        if (NodeRN.parent == null){
            NodeRN.color = 0;
            return;
        }

        // if the grandparent is null, simply return
        if (NodeRN.parent.parent == null) {
            return;
        }

        // Fix the tree
        fixInsert(NodeRN);
    }

    public NodeRN getRoot(){
        return this.root;
    }

    // delete the NodeRN from the tree
    public void deleteNodeRN(int data) {
        deleteNodeRNHelper(this.root, data);
    }

    // print the tree structure on the screen
    public void prettyPrint() {
        printHelper(this.root, "", true);
    }

    public RedBlackTree getLeft(){
        RedBlackTree t = new RedBlackTree();
        t.root = root.left;
        return t;
    }

    public RedBlackTree getRight(){
        RedBlackTree t = new RedBlackTree();
        t.root = root.right;
        return t;
    }

    private int heightHelper(){
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 0;
        }
        return 1 + Math.max(getLeft().heightHelper(), getRight().heightHelper());
    }
    
    private int getHeight(){
        return heightHelper() - 1;
    }
    

    public static void main(String [] args){
        RedBlackTree bst = new RedBlackTree();
        bst.insert(8);
        bst.insert(18);
        bst.insert(5);
        bst.insert(15);
        bst.insert(17);
        bst.insert(25);
        bst.insert(40);
        bst.insert(80);
        //bst.deleteNodeRN(25);
        bst.prettyPrint();

        System.out.println(bst.getHeight());
    }
}
