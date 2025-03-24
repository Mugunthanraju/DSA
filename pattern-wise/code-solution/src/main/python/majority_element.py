def majority_element(nums):
    """
    // LC : 169. Majority Element
    A majority element is an element that appears more than half the time in the list.

    Finds the majority element in a list of numbers using the Boyer-Moore Voting Algorithm.
    Approach:
    - Initialize a candidate variable to None and a count variable to 0.
    - Iterate through the list of numbers.
    - If the count is 0, set the candidate to the current number.
    - Increment the count if the current number is the candidate, otherwise decrement the count.
    - The candidate at the end of the iteration is the majority element.
    
    Parameters:
    nums (list): A list of integers.
    
    Returns:
    int: The majority element in the list.
    
    Time Complexity: O(n), where n is the number of elements in the list.
    Space Complexity: O(1), as we are using only a constant amount of extra space.
    """
    candidate = None
    count = 0
    for num in nums:
        if count == 0:
            candidate = num
        count += 1 if num == candidate else -1
    return candidate

def main():
    nums1 = [3, 2, 3]
    nums2 = [2, 2, 1, 1, 1, 2, 2]
    print(f"majority_element({nums1}) = {majority_element(nums1)}")
    print(f"majority_element({nums2}) = {majority_element(nums2)}")
if __name__ == '__main__':
    main()
