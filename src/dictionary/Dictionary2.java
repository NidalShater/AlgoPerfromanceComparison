package dictionary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Dictionary2 {

    /**
     * @param args the command line arguments
     */
       static int numTrials = 100;

    public static void main(String[] args) {
      /*BTree bTree = new BTree();
      for (int i =0;i< 1000;i++){
         bTree.put(i, i); 
      }*/  
    System.out.println("N\tShuffled Stats & Time\tOrdered Stats & Time");
    System.out.println("----\t---------------------\t--------------------");
    for (int n = 128; n <= 2048; n *= 2) {
      int totalShuffledHeight = 0;
      int totalOrderedHeight = 0;
      long totalShuffled = 0;
      long totalOrdered = 0;
      int min = n;
      int max = 0;
      for (int t = 0; t < numTrials; t++) {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for (int i = 1; i < n; i++) {
          vals.add(i);
        }
        Integer[] ordered = vals.toArray(new Integer[]{});
        Collections.shuffle(vals);
        Integer[] shuffled = vals.toArray(new Integer[]{});
        
        BTree<Integer> bst = new BTree<Integer>();
        long now = System.nanoTime();
        for (int i : shuffled) {
          bst.add(i);
        }
        totalShuffled += (System.nanoTime() - now);
        
        int h = bst.height(); 
        if (h < min) { min = h; }
        if (h > max) { max = h; }
        totalShuffledHeight += h;
        
        bst = new BTree<Integer>();
        now = System.nanoTime();
        for (int i : ordered) {
          bst.add(i);
        }
        totalOrdered += (System.nanoTime() - now);
        totalOrderedHeight += bst.height();
      }
      
      System.out.println(n + "\t[" + min + "-" + max + ", avg:" + 
          totalShuffledHeight/numTrials + "] " +
          totalShuffled/numTrials + "\t[avg:" + totalOrderedHeight/numTrials + "] " +
          totalOrdered/numTrials);
    }
      /*long startTime = System.currentTimeMillis();
      Map hashTable = new Hashtable();
      for (int i =0;i< 1000000;i++){
         hashTable.put(i, i); 
      } 
      List keys = new ArrayList(hashTable.keySet());
      Collections.shuffle(keys);
     // for (Object o : keys) {
          // Access keys/values in a random order
       //   System.out.println(hashTable.get(o));
      //}
      long estimatedTime = System.currentTimeMillis() - startTime;
      System.out.println(estimatedTime);*/
      /*long startTime = System.currentTimeMillis();
      Map treeMAP = new TreeMap();  
      for (int i =0;i< 1000000;i++){
         treeMAP.put(i, i); 
      } 
      List keys = new ArrayList(treeMAP.keySet());
      Collections.shuffle(keys);
      for (Object o : keys) {
          Access keys/values in a random order
          System.out.println(treeMAP.get(o));
      }
      long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.println(estimatedTime);*/
    }    
}
