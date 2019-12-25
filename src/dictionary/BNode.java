package dictionary;
public class BNode<E extends Comparable<E>> {
  final E key;
  BNode<E> left;
  BNode<E> right;

  public BNode(E k) {
    this.key= k;
  }
  
  public int size() {
    return 1 + size(left) + size(right);
  }
  
  int size(BNode<E> n) {
    if (n == null) { return 0; }
    return n.size();
  }
  void add (E k) {
    int rc = k.compareTo(key);
    if (rc <= 0) {
      left = add(left, k);
    } else {
      right = add(right, k);
    }
  }
  
  BNode<E> add(BNode<E> parent, E k) {
    if (parent == null) {
      return new BNode<E>(k);
    }
    parent.add(k);
    return parent;
  }
}