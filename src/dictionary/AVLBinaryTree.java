package dictionary;
public class AVLBinaryTree<E extends Comparable<E>> {

  AVLBinaryNode<E> root = null;

  public void add (E k) {
    if (root == null) {
      root = new AVLBinaryNode<E>(k);
      return;
    }

    root = root.add(root, k);
  }

  public boolean contains (E k) {
    return contains(root, k);
  }

  boolean contains (AVLBinaryNode<E> parent, E k) {
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
}