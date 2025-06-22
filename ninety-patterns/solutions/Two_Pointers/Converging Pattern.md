The **Two Pointers - Converging pattern** is a commonly used technique in LeetCode and algorithm problems where **two pointers start at opposite ends of a sorted array and move toward each other** (i.e., _converge_) to find a solution efficiently.

---

### 🧠 **Concept:**

- **Start** with one pointer at the beginning (`left`) and one at the end (`right`) of the array.
    
- **Move the pointers inward** based on a condition (like sum comparison, difference, etc.).
    
- It’s typically used on **sorted arrays** to reduce time complexity from `O(n^2)` to `O(n)` for certain problems.
    

---

### 📌 **When to Use:**

- You are given a **sorted array**, or you can sort it.
    
- You're asked to find **pairs or triplets** with certain properties (e.g., sum, difference, etc.).
    
- You need to **minimize/maximize** something based on elements at both ends.
    

---

### 🔁 **Typical Structure:**

```java
int left = 0;
int right = arr.length - 1;

while (left < right) {
    int sum = arr[left] + arr[right];

    if (sum == target) {
        // Found the answer
    } else if (sum < target) {
        left++; // Increase sum
    } else {
        right--; // Decrease sum
    }
}
```

---

### ✅ **Common LeetCode Problems Using It:**

|Problem|Description|
|---|---|
|[1. Two Sum (if sorted)](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)|Find two numbers that add up to a target|
|[16. 3Sum Closest](https://leetcode.com/problems/3sum-closest/)|Find the triplet sum closest to a target|
|[15. 3Sum](https://leetcode.com/problems/3sum/)|Find all unique triplets that sum to zero|
|[167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)|Classic converging pattern example|
|[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)|Uses two pointers converging from ends with some variation|
|[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)|Maximize area between two heights using two pointers|

---

### 🖼️ **Visual Example (3Sum Closest):**

For array: `[1, 2, 4, 5, 6]`, and target = `10`  
Start:

- `left = 0` → 1
    
- `right = 4` → 6
    

Try 1 + 2 + 6, adjust pointers based on how close the sum is to the target.

---

### 🧩 Benefits:

- **Time efficient**: Often reduces time complexity from quadratic to linear.
    
- **Space efficient**: Usually no extra space needed.
    
- **Simple logic**: Elegant and intuitive once you understand it.
    

