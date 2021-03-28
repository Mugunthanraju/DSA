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

/* Time Complexity: O(n), for scanning the list of size n. */
/* Space Complexity: O(1), for creating a temporary variable.*/
```

## Singly Linked List Insertion 

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

**Here, we are given a position where we want to insert the new node. In this case also, we need to modify two next pointers.**

* If we want to add an element at position 3 then we stop at position 2. That means we traverse 2 nodes and insert the new node. For simplicity let us assume that the second node is called position node. The new node points to the next node of the position where we want to add this node.
* Position node’s next pointer now points to the new node.

```cpp
class Node 
{ 
    public:
    int data; 
    Node *next; 
}; 

// Adding a node at front

void front(Node** head_ref, int new_data) 
{ 
    /* 1. allocate node */
    Node* new_node = new Node(); 
  
    /* 2. put in the data */
    new_node->data = new_data; 
  
    /* 3. Make next of new node as head */
    new_node->next = (*head_ref); 
  
    /* 4. move the head to point to the new node */
    (*head_ref) = new_node; 
}

// Adding a node at particular position

void insertAfter(Node* prev_node, int new_data)  
{
    
    // 1. Check if the given prev_node is NULL 
    if (prev_node == NULL)  
    {  
        cout << "the given previous node cannot be NULL";  
        return;  
    } 
    
    // 2. Allocate new node
    Node* new_node = new Node(); 
    
    // 3. Put in the data 
    new_node->data = new_data;  
    
    // 4. Make next of new node as 
    // next of prev_node 
    new_node->next = prev_node->next;  
    
    // 5. move the next of prev_node
    // as new_node 
    prev_node->next = new_node;  
} 

// Adding a node at the back

void tail(Node** head_ref, int new_data)  
{  
    
    // 1. allocate node 
    Node* new_node = new Node(); 
    
    // Used in step 5 
    Node *last = *head_ref; 
    
    // 2. Put in the data 
    new_node->data = new_data;  
    
    // 3. This new node is going to be  
    // the last node, so make next of  
    // it as NULL
    new_node->next = NULL;  
    
    // 4. If the Linked List is empty, 
    // then make the new node as head 
    if (*head_ref == NULL)  
    {  
        *head_ref = new_node;  
        return;  
    }  
    
    // 5. Else traverse till the last node 
    while (last->next != NULL)  
        last = last->next;  
    
    // 6. Change the next of last node 
    last->next = new_node;  
    return;  
}

// Time Complexity : O(n) as adding node at the back.
// Space Complexity : O(1) as adding one data at time.
```

## Singly Linked List Deletion:

**Similar to insertion, deletion also has three types of cases.**

### 1) Deleting the head node in Singly Linked List: 
