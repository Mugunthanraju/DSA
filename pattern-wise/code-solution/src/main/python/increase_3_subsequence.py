"""
Leetcode Problem 334: Increasing Triplet Subsequence

Problem:
Given an integer array `nums`, return true if there exists a triple of indices (i, j, k) such that:
- i < j < k
- nums[i] < nums[j] < nums[k]
If no such indices exist, return false.

Approach:
We use a greedy approach to solve this problem in O(n) time and O(1) space. 
- Maintain two variables `first` and `second` to represent the smallest and second smallest numbers found so far.
- Traverse the array:
  - If the current number is smaller than or equal to `first`, update `first`.
  - Else if the current number is smaller than or equal to `second`, update `second`.
  - Otherwise, we have found a number greater than both `first` and `second`, which means an increasing triplet exists.

Time Complexity: O(n) - We traverse the array once.
Space Complexity: O(1) - We use only constant extra space.
"""

def increasingTriplet(nums):
    # Initialize the smallest and second smallest numbers
    first = float('inf')
    second = float('inf')
    
    for num in nums:
        if num <= first:
            first = num  # Update the smallest number
        elif num <= second:
            second = num  # Update the second smallest number
        else:
            # Found a number greater than both `first` and `second`
            return True
    
    return False

def main():
    # Input: nums = [1, 2, 3, 4, 5]
    # Output: True
    nums = [1, 2, 3, 4, 5]
    print(f"Is does have increasing Triplet Subsequence in {nums} ? {increasingTriplet(nums)}")

    # Input: nums = [5, 4, 3, 2, 1]
    # Output: False
    nums = [5, 4, 3, 2, 1]
    print(f"Is does have increasing Triplet Subsequence in {nums} ? {increasingTriplet(nums)}")

    # Input: nums = [2, 1, 5, 0, 4, 6]
    # Output: True
    nums = [2, 1, 5, 0, 4, 6]
    print(f"Is does have increasing Triplet Subsequence in {nums} ? {increasingTriplet(nums)}")

if __name__ == "__main__":
    main()