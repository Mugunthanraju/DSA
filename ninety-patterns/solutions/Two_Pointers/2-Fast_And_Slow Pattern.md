
The **Two Pointers - Fast and Slow Pattern** (also called the **Tortoise and Hare algorithm**) is a fundamental technique used to **traverse linked lists or arrays**, typically to:

* Detect **cycles**
* Find **middle elements**
* Optimize **space/time** by not using extra memory
* Solve problems in **O(n)** time with **O(1)** space

---

## 🧠 Core Idea

Use two pointers:

* **Slow pointer** moves **one step at a time**
* **Fast pointer** moves **two steps at a time**

This difference in speed helps detect specific conditions (like loops or meeting points) without needing extra data structures.

---

## 🔁 Common Pattern:

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
        // Found a cycle or meeting point
    }
}
```

---

## ✅ Typical Use Cases:

### 1. **Detecting a Cycle in a Linked List**

* Problem: [Leetcode 141 - Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
* Detect if a cycle exists.
* Use fast and slow pointers to determine if they meet (indicating a loop).

---

### 2. **Finding Start of Cycle**

* Problem: [Leetcode 142 - Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
* After detecting the cycle, reset one pointer to the head and move both one step at a time — they’ll meet at the **start of the cycle**.

---

### 3. **Find the Middle of a Linked List**

* Problem: [Leetcode 876 - Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)
* When fast reaches the end, slow is at the middle.

---

### 4. **Happy Number**

* Problem: [Leetcode 202 - Happy Number](https://leetcode.com/problems/happy-number/)
* Use fast and slow to detect loops in repeated digit-square transformations.

---

### 5. **Palindrome Linked List**

* Problem: [Leetcode 234 - Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)
* Use fast-slow to find the middle, reverse second half, compare both halves.

---

## 📈 Time and Space Complexity

* **Time**: `O(n)` — traverse once with fast and slow
* **Space**: `O(1)` — no extra data structures needed

---

## 🖼️ Visual Example (Cycle Detection):

Given:

```
A -> B -> C -> D
          ↑    ↓
          F <- E
```

* `slow` visits: A → B → C → D → E → F
* `fast` visits: A → C → E → D → F → D → F...

Eventually, `fast == slow` → **cycle detected**.
