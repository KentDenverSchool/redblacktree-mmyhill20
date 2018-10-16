import java.util.NoSuchElementException;
import java.util.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    public Node root;     // root of the BST

  
    /**
     * Initializes an empty symbol table.
     */
    public RedBlackBST() {
    }

    /***************************************************************************
     *  Node helper methods.
     ***************************************************************************/
    // is node x red; false if x is null ?
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.COLOR == RED;
    }

    // number of node in subtree rooted at x; 0 if x is null
    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }


    /**
     * Returns the number of key-getValue()ue pairs in this symbol table.
     *
     * @return the number of key-getValue()ue pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    /**
     * Is this symbol table empty?
     *
     * @return {@code true} if this symbol table is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }


    /***************************************************************************
     *  Standard BST search.
     ***************************************************************************/

    /**
     * Returns the getValue()ue associated with the given key.
     *
     * @param key the key
     * @return the getValue()ue associated with the given key if the key is in the symbol table
     * and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    // getValue()ue associated with the given key in subtree rooted at x; null if no such key
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo((Key)(x.key));
            if (cmp < 0) x = x.getSmall();
            else if (cmp > 0) x = x.getBig();
            else return (Value)x.getValue();
        }
        return null;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /***************************************************************************
     *  Red-black tree insertion.
     ***************************************************************************/

    /**
     * Inserts the specified key-getValue()ue pair into the symbol table, overwriting the old
     * getValue()ue with the new getValue()ue if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated getValue()ue) from this symbol table
     * if the specified getValue()ue is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
//    public void put(Key key, Value val) {
//        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
//        if (val == null) {
//            delete(key);
//            return;
//        }
//
//        root = put(root, key, val);
//        root.COLOR = BLACK;
//        // assert check();
//    }
//
//    // insert the key-value pair in the subtree rooted at h
//    private Node put(Node h, Key key, Value val){
//
//    }

    /***************************************************************************
     *  Red-black tree deletion.
     ***************************************************************************/

    /**
     * Removes the getSmall()est key and associated getValue()ue from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.getSmall()) && !isRed(root.getBig()))
            root.COLOR = RED;

        root = deleteMin(root);
        if (!isEmpty()) root.COLOR = BLACK;
        // assert check();
    }

    // delete the key-getValue()ue pair with the minimum key rooted at h
    private Node deleteMin(Node h) {
       /**deleteMin**/
        return balance(h);
    }


    /**
     * Removes the largest key and associated getValue()ue from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.getSmall()) && !isRed(root.getBig()))
            root.COLOR = RED;

        root = deleteMax(root);
        if (!isEmpty()) root.COLOR = BLACK;
        // assert check();
    }

    // delete the key-getValue()ue pair with the maximum key rooted at h
    private Node deleteMax(Node h) {
        /**deleteMax**/

        return balance(h);
    }

    /**
     * Removes the specified key and its associated getValue()ue from this symbol table
     * (if the key is in this symbol table).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // if both children of root are black, set root to red
        if (!isRed(root.getSmall()) && !isRed(root.getBig()))
            root.COLOR = RED;

        root = delete(root, key);
        if (!isEmpty()) root.COLOR = BLACK;
        // assert check();
    }

    // delete the key-getValue()ue pair with the given key rooted at h
    private Node delete(Node h, Key key) {
        // assert get(h, key) != null;
       
        /**delete**/
        
        return balance(h);
    }

    /***************************************************************************
     *  Red-black tree helper functions.
     ***************************************************************************/

    // make a getSmall()-leaning link lean to the getBig()
    public Node rotateDown(Node h) {//rotating node in down the number line
        assert (h != null) && isRed(h.getSmall());
        Node newIn = h.getSmall();
        h.small = newIn.getBig();
        newIn.setBig(h);
        return newIn;
    }

    // make a getBig()-leaning link lean to the getSmall()
    public Node rotateUp(Node h) {
        assert (h != null) && isRed(h.getBig());
        Node newIn = h.getBig();
        h.big = newIn.getSmall();
        newIn.setSmall(h);
        return newIn;
    }

    // flip the COLORs of a node and its two children
    private void flipColors(Node h) {
        // h must have opposite COLOR of its two children
        // assert (h != null) && (h.getSmall() != null) && (h.getBig() != null);
        // assert (!isRed(h) &&  isRed(h.getSmall()) &&  isRed(h.getBig()))
        //    || (isRed(h)  && !isRed(h.getSmall()) && !isRed(h.getBig()));
        
        //HINT: NOT RECURSIVE
    }

    // Assuming that h is red and both h.getSmall() and h.getSmall().getSmall()
    // are black, make h.getSmall() or one of its children red.
    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.getSmall()) && !isRed(h.getSmall().getSmall());


        return h;
    }

    // Assuming that h is red and both h.getBig() and h.getBig().getSmall()
    // are black, make h.getBig() or one of its children red.
    private Node moveRedRight(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.getBig()) && !isRed(h.getBig().getSmall());
        
        return h;
    }

    // restore red-black tree invariant
    private Node balance(Node h) {
        // assert (h != null);

        //rotate getBig() or getSmall() or reCOLOR the nodes appropriately
        //update h's size
        return h;
    }


    /***************************************************************************
     *  Utility functions.
     ***************************************************************************/

    /**
     * Returns the height of the BST (for debugging).
     *
     * @return the height of the BST (a 1-node tree has height 0)
     */
    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.getSmall()), height(x.getBig()));
    }
    public boolean isRBT(){
        if(isBST(root))return isRBT(root);
        else return false;
    }
    
    private boolean isRBT(Node n){
        Boolean toReturn = true;
        Boolean isRoot = false;
            if(n.getBig() == null && n.getSmall() == null)return true;//singular node, is RBT
            else if(n.equals(root)){
                //System.out.println("root loop entered");
                if(n.getSmall() != null) {
                    Node down = n.getSmall().getSmall();
                    if(n.getSmall().COLOR == BLACK && down.getSmall() == null
                            && down.getBig() == null && down.COLOR == RED) isRoot = true;
                }
                if(n.getBig() != null) {
                    Node up = n.getBig().getBig();
                    if(n.getSmall().COLOR == BLACK && up.getBig() == null
                            && up.getSmall() == null && up.COLOR == RED) isRoot = true;
                }
                if(isRoot)return true;
               // System.out.println("root loop exited");
            }
        if(n.getBig() != null) {
            toReturn = n.COLOR != n.getBig().COLOR && isRBT(n.getBig());
            //System.out.println("Big for node " + n.getValue() + "is different color? " + (n.COLOR != n.getBig().COLOR));
        }
        if(n.getSmall() != null) {
            toReturn = toReturn && n.COLOR != n.getSmall().COLOR && isRBT(n.getSmall());
            //System.out.println("Small for node " + n.getValue() + "is different color? " + (n.COLOR != n.getSmall().COLOR));
        }
        //System.out.println("Node: " + n.getValue() + "To return: " + toReturn);
        return toReturn;
        }

    private boolean isBST(Node n){
        if(n == null)return true;//is empty, is BST
        else if(n.getSmall() == null && n.getBig() == null)return true;//is only node, is BST
        else{
            if(n.getBig() == null)return (n.getKey().compareTo(n.getSmall().getKey()) > 0) && isBST(n.getSmall());//left is > current && is right is null, but not both
            else if(n.getSmall() == null)return (n.getKey().compareTo(n.getBig().getKey()) < 0) && isBST(n.getBig());
            else return (n.getKey().compareTo(n.getBig().getKey()) < 0) && isBST(n.getBig()) &&
                        (n.getKey().compareTo(n.getSmall().getKey()) > 0) && isBST(n.getSmall());
        }

    }

    /***************************************************************************
     *  Ordered symbol table methods.
     ***************************************************************************/

    /**
     * Returns the getSmall()est key in the symbol table.
     *
     * @return the getSmall()est key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return (Key)min(root).key;
    }

    // the getSmall()est key in subtree rooted at x; null if no such key
    private Node min(Node x) {
        // assert x != null;
        if (x.getSmall() == null) return x;
        else return min(x.getSmall());
    }

    /**
     * Returns the largest key in the symbol table.
     *
     * @return the largest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return (Key)max(root).key;
    }

    // the largest key in the subtree rooted at x; null if no such key
    private Node max(Node x) {
        // assert x != null;
        if (x.getBig() == null) return x;
        else return max(x.getBig());
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getBig()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getSmall());
    }

}

