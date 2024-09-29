package solutions;

public class Solution45 {

    public static boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int square(int t) {
        int h = 0, m;

        while (t != 0) {
            m = t % 10;
            h += (m * m);
            t /= 10;
        }
        return h;
    }

    public static void main(String[] args) {
        int n1 = 19;
        System.out.println(isHappy(n1)); // true
        int n2 = 2;
        System.out.println(isHappy(n2)); // false
        int n3 = 7;
        System.out.println(isHappy(n3)); // true
    }
}

/*
 * To solve the Leetcode problem "202. Happy Number," we need to determine if a
 * given number is a happy number. A happy number is defined by the process of
 * replacing the number with the sum of the squares of its digits repeatedly
 * until it either reaches 1 (indicating it is a happy number) or falls into a
 * cycle that does not include 1 (indicating it is not a happy number).
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - An integer `n`.
 * 
 * - **Output**:
 * - A boolean value indicating whether `n` is a happy number.
 * 
 * ### Process:
 * 1. Start with any positive integer.
 * 2. Replace the number with the sum of the squares of its digits.
 * 3. Repeat the process until the number equals 1, or it loops endlessly in a
 * cycle which does not include 1.
 * 
 * ### Example:
 * - **Input**: `n = 19`
 * - **Output**: `true`
 * - **Explanation**:
 * - $$1^2 + 9^2 = 82$$
 * - $$8^2 + 2^2 = 68$$
 * - $$6^2 + 8^2 = 100$$
 * - $$1^2 + 0^2 + 0^2 = 1$$
 * 
 * ## Approach
 * 
 * We can solve this problem using two methods:
 * 1. **Using a HashSet to detect cycles**.
 * 2. **Using the Floyd's Cycle Detection algorithm (Tortoise and Hare)**.
 * 
 * ### Method 1: Using HashSet
 * - Maintain a set to keep track of numbers we've seen.
 * - If we see the same number again, it means we're in a cycle.
 * 
 * ### Method 2: Floyd's Cycle Detection
 * - Use two pointers (slow and fast) to detect cycles without extra space.
 * 
 * ### Time Complexity:
 * - Both methods have a time complexity of $$O(\log n)$$, where $$n$$ is the
 * value of the input number due to the nature of digit manipulation.
 * 
 * ### Space Complexity:
 * - Method 1 uses $$O(n)$$ space for storing seen numbers, while Method 2 uses
 * $$O(1)$$ space.
 * 
 * ## Java Code Implementation
 * 
 * Here’s how you can implement both methods in Java:
 * 
 * ### Method 1: Using HashSet
 * 
 * ```java
 * import java.util.HashSet;
 * 
 * class Solution {
 * public boolean isHappy(int n) {
 * HashSet<Integer> seen = new HashSet<>();
 * 
 * while (n != 1 && !seen.contains(n)) {
 * seen.add(n);
 * n = getNext(n);
 * }
 * 
 * return n == 1;
 * }
 * 
 * private int getNext(int n) {
 * int totalSum = 0;
 * while (n > 0) {
 * int digit = n % 10;
 * n /= 10;
 * totalSum += digit * digit;
 * }
 * return totalSum;
 * }
 * }
 * ```
 * 
 * ### Method 2: Using Floyd's Cycle Detection
 * 
 * ```java
 * class Solution {
 * public boolean isHappy(int n) {
 * int slowRunner = n;
 * int fastRunner = getNext(n);
 * 
 * while (fastRunner != 1 && slowRunner != fastRunner) {
 * slowRunner = getNext(slowRunner);
 * fastRunner = getNext(getNext(fastRunner));
 * }
 * 
 * return fastRunner == 1;
 * }
 * 
 * private int getNext(int n) {
 * int totalSum = 0;
 * while (n > 0) {
 * int digit = n % 10;
 * n /= 10;
 * totalSum += digit * digit;
 * }
 * return totalSum;
 * }
 * }
 * ```
 * 
 * ### Explanation of the Code:
 * 1. **`isHappy` method**: This method checks if `n` is happy using either the
 * HashSet or Floyd's cycle detection algorithm.
 * 2. **`getNext` method**: This helper method calculates the sum of squares of
 * digits for a given number.
 * 
 * Both implementations effectively determine whether a number is happy and pass
 * all relevant test cases on Leetcode. If you have any further questions or
 * need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.interviewbit.com/blog/happy-number/
 * [2] https://www.geeksforgeeks.org/happy-number/
 * [3] https://dev.to/alisabaj/the-happy-number-problem-mn2
 * [4] https://www.javatpoint.com/program-to-check-happy-number
 * [5] https://www.geeksforgeeks.org/happy-numbers/
 * [6]
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-
 * sum-exists-in-array/
 * [7] https://www.youtube.com/watch?v=aYqYMIqZx5s
 * [8] https://www.youtube.com/watch?v=GBKI9VSKdGg
 */