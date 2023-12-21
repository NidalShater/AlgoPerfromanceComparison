Back in my college days, We built a program to compare the relative performance of four data structures: Linked-list, Red-Black Tree, Hash-Tables and Binary trees.

# The structure of Our Program:

## Programming Environment:
We have built our program using Java programming language, you can compile and run it using standard JDK programs (javac and java) or by opening it using one of the programming environments (NetBeans, eclipse…).

## General Structure:
We have used the already build-in classes in the Collections package in java to implement the test on Linked-list (From List), Red-Black (Tree-map From SortedMap Interface) and Hash-Tables (From Map Interface):

![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/1.jpg)

The **collections** package doesn’t have an implementation for the Binary trees data structure, so we have built two new classes: BTree (a Naïve Binary trees solution), AVLBinaryTree (An AVL tree named after its inventors, Adelson-Velskii, and Landis is a self-balancing BST first described in 1962) the differences between the two Trees are:

![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Btree%20and%20AVL%20Binary%20tree.PNG)


# Tests
## Theoretical Study
From a theoretical point of view, the time complexity of the studied data structures are shown in the following table:
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Theoretical%20Complexity.PNG)

From the table above we notice:
*	Linked-list and Hash Table are better than Binary trees and Red-Black Trees in insert operations, because to add a new element to a list or to a hash table we just add it to the end of the data structure, while to insert a new element to a tree (any type of tree) we need to put it in its place according to Binary tree rule (smaller numbers on the left and the larger number on the right).
*	In the Worst case Linked-List is better than Hash-tables in insert operations because Hash Tables deal with Keys and values.
*	In the Average case Hash-tables are better than Linked-List in searching operations because Hash Tables deal with Keys and values.
*	Binary trees and Red-Black Tree are better than Linked-list and Hash Table In the searching operations because searching in a tree is better than searching in a sequential order (traverse every element to reach the needed element).
*	We don’t know which tree algorithm is better in the insert or searching operation because the theoretical complexity is equal for each of these trees.
*	As a result we notice that Linked-list and Hash-Tables are better in the problems that need insert without searching (not popular), and Trees are better in the problems that need searching.
## Practical Tests:
We have created dictionary.java file and test all the data structures, the test operation follows the following steps:
For each data structure:
1)	Create a shuffled List (using collections. Shuffle() function) [to ensure randomization].
2)	Insert each element in the data structure and calculate the elapsed time.
3)	Search for each element in the data structure and calculate the elapsed time.
4)	Print the result.

First, we tested our program ten times, and we get these results:
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Test1.PNG)
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Test2.PNG)
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Test3.PNG)
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Test4.PNG)
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Test5.PNG)
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Test6.PNG)
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Test7.PNG)
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Test8.PNG)
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Test9.PNG)
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Test10.PNG)

The symbols stand for:

![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Symbols.PNG)

Then we gathered the output and put it in the Excel file:

![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Results%20in%20Excel%201.PNG)

![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Results%20in%20Excel%202.PNG)

Using the AVERAGE function, we calculate the average of the output in one table:

![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/Results%20in%20Excel%20Average.PNG)

Then we draw the chart of the insert columns of the table:
![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/First%20Insert%20Performance.PNG)

* The order of the data structures in insert operation performance is:
  * __List > Hash Table > TreeMap > BTree > AVLBTree__
* As we said before Theoretically: Linked-list and Hash Tables are better than Binary trees and Red-Black Tree in insert operation, and we approve this practically as shown in the chart above, because to add a new element to a list or a hash table we just add it to the end of the data structure.
*	As shown in the graph we can also see:
* List is better than Hash Table because the Hash Table needs to insert in Keys and values.
* BTree is better than AVLBTree because in the insert operation, we need a balancing operation in AVLBTree that doesn’t exist in BTree.
* Insert operation performance is approximately the same in TreeMap and BTree.

After that, we draw the chart of the Search columns of the table, and because BTree and AVLBTree are way better than others we draw another chart for them:

![alt text](https://raw.githubusercontent.com/NidalShater/DataStructuresPerfromanceComparison/master/tests/First%20Search%20Performance.PNG)

* The order of the data structures in searching performance is:
  * __AVLBTree > BTree> Hash Table> List > TreeMap__
* As we said before Theoretically: BTree is better than Linked-list and Hash Table In the searching operations, and we approve this practically as shown in the chart above, because to search in a tree is better than to search in a sequential order.
* As shown in the graph we can also see:
  * AVLBtree is better than Binary trees, because searching in balanced tree is faster than searching in unbalanced one.
  * Hash Table is better than List, because the Hash Table use the Keys and the values to search.
