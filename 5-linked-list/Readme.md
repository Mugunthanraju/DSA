# Introduction of Linked Lists :

**A linked list is a data structure used for storing collections of data. A linked list has the following properties.**

* Successive elements are connected by pointers.
* Last element is always pointed to null.
* Can grow and shrink in size as the element numbers modify.
* Can be made as long as required {until the system memory exhaust}. 
* Doesn't waste memory space {but takes some extra memory for connected pointers}. It allocates as list grows.
***

### Linked List ADT :

**Main Linked List operations :-**
* *`Insert :` Inserts an element into the list.*
* *`Delete :` Deletes an element from the list.*

**Auxiliary Linked List operations :-**
* *`Delete List :` Removes all element from the list.*
* *`Count :` Returns the number of list elements in the list.*
* *`Finding the node :` Searching of a node from the list.*

### Comparison of Linked List, Array & Dynamic Array :

![Comparison](.\img\Comparison.png)
***

## Tricks and Tips
- If something to do with Nth from last in linked list then use fast and slow pointer (not typical one). Usually, the fast should start from Nth (in actual order) node and fast should reach at end (parallely slow is also traversing). If fast reached end, then the slow pointing node will be the target of before node.