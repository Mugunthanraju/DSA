"""
Leetcode Problem 41: First Missing Positive

Approach:
1. The problem is solved using an in-place swapping technique.
2. Iterate through the array and place each number `nums[i]` at its correct index `nums[i] - 1` if it is within the range [1, n].
3. After rearranging, iterate through the array again to find the first index `i` where `nums[i] != i + 1`. The missing positive is `i + 1`.
4. If all numbers are in their correct positions, the missing positive is `n + 1`.

Time Complexity: O(n)
- The array is traversed twice, making the time complexity linear.

Space Complexity: O(1)
- The rearrangement is done in-place without using extra space.

"""

def first_missing_positive(nums):
    n = len(nums)
    
    # Step 1: Place each number in its correct position
    for i in range(n):
        while 1 <= nums[i] <= n and nums[nums[i] - 1] != nums[i]:
            nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]  # Swap
    
    # Step 2: Find the first missing positive
    for i in range(n):
        if nums[i] != i + 1:
            return i + 1
    
    return n + 1

def main():
    nums = [3, 4, -1, 1] # Output: 2
    print(f"First Missing Positive in {nums} is {first_missing_positive(nums)}")

    nums = [1, 2, 0] # Output: 3
    print(f"First Missing Positive in {nums} is {first_missing_positive(nums)}")

    nums = [7, 8, 9, 11, 12] # Output: 1
    print(f"First Missing Positive in {nums} is {first_missing_positive(nums)}")

    nums = [1] # Output: 2
    print(f"First Missing Positive in {nums} is {first_missing_positive(nums)}")

if __name__ == "__main__":
    main()