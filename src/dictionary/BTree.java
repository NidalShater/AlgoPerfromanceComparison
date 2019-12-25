package dictionary;

public class BTree<E extends Comparable<E>> {

  BNode<E> root = null;

  public int size() {
    if (root == null) { return 0; }

    return root.size();
  }

  public void add (E k) {
    if (root == null) {
      root = new BNode<E>(k);
      return;
    }
    root = root.add(root,k);
  }
  public boolean contains (E k) {
    return contains(root, k);
  }

  boolean contains (BNode<E> parent, E k) {
    if (parent == null) { return false; }

    int rc = k.compareTo(parent.key);
    if (rc == 0) { 
      return true; 
    } else if (rc < 0) { 
      return contains(parent.left, k); 
    } else {
      return contains(parent.right, k); 
    }
  }


  public int height () {
    if (root == null) { return 0; }

    return height(root);
  }

  int height (BNode<E> n) {
    if (n == null) { return 0; }

    return 1 + Math.max( height(n.left), height(n.right));
  }
}