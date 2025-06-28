
The **Two Pointers: Fixed Separation** pattern, often called the **Nth Node from End** pattern, is a common technique used in linked list problems. It involves using two pointers that are separated by a fixed number of nodes—usually `n`. This technique is particularly useful when you need to find or remove the **nth node from the end** of a linked list in a single traversal.

---

### 🔍 Core Idea:

Use **two pointers** (often called `fast` and `slow`) such that:

* The `fast` pointer is **`n` nodes ahead** of the `slow` pointer.
* Then, move both pointers **together** until the `fast` pointer reaches the end.
* At that point, the `slow` pointer is exactly at the **nth node from the end**.

---

### 📌 When to Use This Pattern:

* Finding the **nth node from the end**.
* Removing the **nth node from the end**.
* Detecting fixed distance relationships in a list or array-like structure.

---

### ✅ Step-by-Step Example:

**Problem:** Remove the `n`th node from the end of a singly linked list.

**Algorithm:**

1. Initialize two pointers: `fast` and `slow`, both at the head.
2. Move `fast` ahead by `n` steps.
3. If `fast` is `null`, that means the node to remove is the head.
4. Otherwise, move both `fast` and `slow` forward **until `fast.next` is null**.
5. Now, `slow.next` is the node to remove.
6. Skip that node by setting `slow.next = slow.next.next`.

---

### 🧠 Code Example (Python):

```python
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def remove_nth_from_end(head, n):
    dummy = ListNode(0, head)
    fast = slow = dummy

    # Step 1: Move fast n steps ahead
    for _ in range(n):
        fast = fast.next

    # Step 2: Move both until fast reaches the end
    while fast.next:
        fast = fast.next
        slow = slow.next

    # Step 3: Remove the nth node from end
    slow.next = slow.next.next

    return dummy.next
```

---

### ⏱ Time and Space Complexity:

* **Time:** `O(L)` — where `L` is the length of the linked list (one pass).
* **Space:** `O(1)` — no extra memory used beyond pointers.

---

### 🔁 Summary:

* The **fixed separation** between two pointers helps to isolate the target node relative to the end.
* It's a powerful way to solve problems in a **single pass**.
* Commonly used in **interview problems** involving linked lists.
