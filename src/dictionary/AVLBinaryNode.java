package dictionary;
public class AVLBinaryNode<E extends Comparable<E>> {
  E key;
  int height;
  
  AVLBinaryNode<E> left;
  AVLBinaryNode<E> right;
  
  public AVLBinaryNode(E k) {
    height = 0;
    key = k;
  }
  
  void computeHeight (AVLBinaryNode<E> n) {
    int height = -1;
    if (n.left != null) {
      height = Math.max(height, n.left.height);
    }
    if (n.right != null) {
      height = Math.max(height, n.right.height);
    }
    
    n.height = height + 1;
  }
  
  int heightDifference(AVLBinaryNode<E> n) {
    if (n == null) { return 0; }

    int leftTarget = 0;
    if (n.left != null) {
      leftTarget = 1 + n.left.height;
    }
    int rightTarget = 0;
    if (n.right != null) {
      rightTarget = 1 + n.right.height;   
    }
    return leftTarget - rightTarget;
  }
  
  AVLBinaryNode<E> rotateRight () {
    AVLBinaryNode<E> newRoot = left;
    AVLBinaryNode<E> grandson  = newRoot.right;
    left = grandson;
    newRoot.right = this;
    
    computeHeight(this);
    return newRoot;
  }
  AVLBinaryNode<E> rotateLeft () {
    AVLBinaryNode<E> newRoot = this.right;
    AVLBinaryNode<E> grandson = newRoot.left;
    this.right = grandson;
    newRoot.left = this;
    
    computeHeight(this);
    return newRoot;
  }
  AVLBinaryNode<E> leftRightRotation () {
    AVLBinaryNode<E> child = left;
    AVLBinaryNode<E> newRoot = child.right;
    AVLBinaryNode<E> grand1  = newRoot.left;
    AVLBinaryNode<E> grand2  = newRoot.right;
    child.right = grand1;
    left = grand2;
    
    newRoot.left = child;
    newRoot.right = this;
    
    computeHeight(child);
    computeHeight(this);
    return newRoot;
  }
  
  AVLBinaryNode<E> rightLeftRotation () {
    AVLBinaryNode<E> child = right;
    AVLBinaryNode<E> newRoot = child.left;
    AVLBinaryNode<E> grand1  = newRoot.left;
    AVLBinaryNode<E> grand2  = newRoot.right;
    child.left = grand2;
    right = grand1;
    
    newRoot.left = this;
    newRoot.right = child;
    
    computeHeight(child);
    computeHeight(this);
    return newRoot;
  }  
  AVLBinaryNode<E> add(AVLBinaryNode<E> parent, E k) {
    if (parent == null) {
      return new AVLBinaryNode<E>(k);
    }
      
    parent = parent.add(k);
    return parent;
  }
  AVLBinaryNode<E> add (E k) {
    int rc = k.compareTo(key);
    AVLBinaryNode<E> newRoot = this;
    if (rc <= 0) {
      left = add(left, k);
      if (heightDifference(this) == 2) {
        if (k.compareTo(left.key) <= 0) {
          newRoot = rotateRight();
        } else {
          newRoot = leftRightRotation(); 
        }
      }
    } else {
      right = add(right, k);
      if (heightDifference(this) == -2) {
        if (k.compareTo(right.key) > 0) {
          newRoot = rotateLeft();
        } else {
          newRoot = rightLeftRotation(); 
        }
      }
    }
    
    computeHeight(newRoot);
    return newRoot;
  }
}