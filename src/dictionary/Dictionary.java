package dictionary;
import java.text.*;
import java.util.*;
public class Dictionary {
  static int numTrials = 100;
  static double m = 1000000;
  static NumberFormat nf;
  public static void main(String[] args) {
    nf = NumberFormat.getInstance();
    nf.setMinimumFractionDigits(3);    
    System.out.println("N\t\tB_Time\t\tB_Srch\t\tA_Time\t\tA_Srch\t\tH_Time\t\tH_Srch\t\tL_Time\t\tL_Srch\t\tT_Time\t\tT_Srch");
    System.out.println("----\t\t----\t\t-----\t\t------\t\t------\t\t------\t\t-----\t\t------\t\t-----\t\t-----\t\t-----");
    for (int n = 128; n <= 8192; n *= 2) {
      //define variables to calculate the elapsed time for each of the Algoritms
      long totalBSTCreate = 0;
      long totalBSTSearch = 0;
      long totalAVLCreate = 0;
      long totalAVLSearch = 0;
      long totalTreeMapCreate = 0;
      long totalTreeMapSearch = 0;
      long totalHashTableCreate = 0;
      long totalHashTableSearch = 0;
      long totalListCreate = 0;
      long totalListSearch = 0;
      for (int t = 0; t < numTrials; t++) {
        //Create a list of shuufeled elements using ArrayList class and collections.shuffle() function 
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for (int i = 0; i < 2*n; i+=2) {
          vals.add(i);
        }
        Collections.shuffle(vals);
        Integer[] shuffled = vals.toArray(new Integer[]{});
        //calling carbage collector, to clean the memory
        System.gc();
        //AVLBinary Tree Structure
        //1- Create a new AVLBinaryTree structure 
        AVLBinaryTree<Integer>  avlTree = new AVLBinaryTree<Integer>();
        //2- Insert the suffled elements to the AVLBinaryTree structure, and calculate the time of insertion operation
        long now = System.nanoTime();
        for (int i : shuffled) {
          avlTree.add(i);
        }
        totalAVLCreate += (System.nanoTime() - now);
        //calling carbage collector, to clean the memory
        System.gc();
        //3- Search for every element in the AVLBinaryTree structure, and calculate the time of searching operation
        now = System.nanoTime();
        for (int i = 0; i < 2*n; i++) {
          if (avlTree.contains(i) != (i%2 == 0)) {
            System.err.println("Search fails for BST");
          }
        }
        totalAVLSearch += (System.nanoTime()-now);
        //calling carbage collector, to clean the memory
        System.gc();
        //BTree Structure
        //1- Create a new Btree structure 
        BTree<Integer> btree = new BTree<Integer>();
        //2- Insert the suffled elements to the Btree structure, and calculate the time of insertion operation
        now = System.nanoTime();
        for (int i : shuffled) {
          btree.add(i);
        }
        totalBSTCreate += (System.nanoTime() - now);
        
        //calling carbage collector, to clean the memory
        System.gc();
        //3- Search for every element in the Btree structure, and calculate the time of searching operation
        now = System.nanoTime();
        for (int i = 0; i < 2*n; i++) {
          if (btree.contains(i) != (i%2 == 0)) {
            System.err.println("Search fails for BST");
          }
        }
        totalBSTSearch += (System.nanoTime()-now);
        //calling carbage collector, to clean the memory
        System.gc();
        //HashTable Structure
        //1- Create a new HashTable structure 
        Map<Integer,Integer> hashTable = new Hashtable<Integer, Integer>();
        //2- Insert the suffled elements to the HashTable structure, and calculate the time of insertion operation
        now = System.nanoTime();
        for (int i : shuffled) {
          hashTable.put(i, i);
        }
        totalHashTableCreate += (System.nanoTime() - now);
        //calling carbage collector, to clean the memory
        System.gc();
        //3- Search for every element in the HashTable structure, and calculate the time of searching operation
        now = System.nanoTime();
        for (int i = 0; i < 2*n; i++) {
          if (hashTable.containsValue(i) != (i%2 == 0)) {
            System.err.println("Search fails for BST");
          }
        }
        totalHashTableSearch += (System.nanoTime()-now);
        //calling carbage collector, to clean the memory 
        System.gc();
        //List Structure
        //1- Create a new List structure 
        List<Integer> list = new ArrayList<Integer>();
        //2- Insert the suffled elements to the List structure, and calculate the time of insertion operation
        now = System.nanoTime();
        for (int i : shuffled) {
          list.add(i);
        }
        totalListCreate += (System.nanoTime() - now);
        //calling carbage collector, to clean the memory 
        System.gc();
        //3- Search for every element in the List structure, and calculate the time of searching operation
        now = System.nanoTime();
        for (int i = 0; i < 2*n; i++) {
          if (list.contains(i) != (i%2 == 0)) {
            System.err.println("Search fails for BST");
          }
        }
        totalListSearch += (System.nanoTime()-now);
        //calling carbage collector, to clean the memory  
        System.gc();
        //TreeMap Structure
        //1- Create a new TreeMap structure 
        TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
        //2- Insert the suffled elements to the TreeMap structure, and calculate the time of insertion operation
        now = System.nanoTime();
        for (int i : shuffled) {
          tree.put(i, i);
        }
        totalTreeMapCreate += (System.nanoTime() - now);
        //calling carbage collector, to clean the memory 
        System.gc();
        //3- Search for every element in the TreeMap structure, and calculate the time of searching operation
        now = System.nanoTime();
        for (int i = 0; i < 2*n; i++) {
          if (tree.containsValue(i) != (i%2 == 0)) {
            System.err.println("Search fails for BST");
          }
        }
        totalTreeMapSearch += (System.nanoTime()-now);
      }
      //Finally, print all the results for the range [128,8192]
      System.out.println(n + "\t\t" +
          nf.format(totalBSTCreate/numTrials/m) + "\t\t" +
          nf.format(totalBSTSearch/numTrials/m) + "\t\t" +
          nf.format(totalAVLCreate/numTrials/m) + "\t\t" + 
          nf.format(totalAVLSearch/numTrials/m) + "\t\t" + 
          nf.format(totalHashTableCreate/numTrials/m) + "\t\t" + 
          nf.format(totalHashTableSearch/numTrials/m) + "\t\t" +
          nf.format(totalListCreate/numTrials/m) + "\t\t" + 
          nf.format(totalListSearch/numTrials/m) + "\t\t" +
          nf.format(totalTreeMapCreate/numTrials/m) + "\t\t" + 
          nf.format(totalTreeMapSearch/numTrials/m));
    }
  }
}