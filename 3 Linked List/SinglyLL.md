# Singly Linked List :

**Generally Linked List refers to Singly Linked List, this list consist of a number of nodes where each node has a next pointer to the following element. The link of the last node in the list has `NULL` pointer which indicates the end of list.**

### Head :

```cpp
struct ListNode {
    int data;
    struct ListNode *next;
};
```

### Basic Operation on a List
* Traversing the list
* Inserting an item in the list
* Deleting an item from the list

### Traversing the Linked List

**Let us assume that the head points to the first node of the list. To transverse the list we do the following**

* Follow the pointers.
* Display the contents of the node (or count) as they are traversed.
* Stop when the next pointer points to NULL.

### Head

**The ListLength() function takes a linked list as input and count the number of nodes in the list. The function given below can be used for printing the list data with extra print function.**

```cpp
int ListLength(struct ListNode *head) {
    struct ListNode *current = head;
    int count = 0;

    while (current != NULL) {
        count++;
        current = current->next;
    }
    return count;
}

\* Time Complexity: O(n), for scanning the list of size n. */
\* Space Complexity: O(1), for creating a temporary variable.*/
```

### Singly Linked List Insertion 

*Insertion into a singly-linked list has three cases:*
* Insert a new node before the head (at the beginning)
* Inserting a new node after the tail (at the end of the list)
* Inserting a new node at the middle of the list (random location)

`Note :` *`To insert an element in the linked list at some position p, assume that after inserting the element the position of the new node is p.`*

### Inserting a Node in Singly Linked List at the beginning :

**Here, a new node is inserted before the current head node. Only next pointer needs to be modified (new node's next pointer) and it can be done in two steps :**
* Update the next pointer of new node, to point to the current head.
* Update head pointer to point to the new node.

### Inserting a Node in Singly Linked List at the Ending :

**Here, we need to modify two next pointers (last nodes next pointer and new nodes next pointers).**
* New nodes next pointers points to NULL.
* Last nodes next pointers points to the new node.

### Inserting a Node in Singly Linked List at the Middle :
