def zero_filled_subarray(nums):
    """
    Calculate the number of zero-filled subarrays in the given list.

    Approach:
    - Traverse the array while maintaining a count of consecutive zeros (`count`).
    - For each zero encountered, increment the `count` and add it to the result (`result`).
    - If a non-zero element is encountered, reset the `count` to 0.

    Time Complexity:
    - O(n): We traverse the array once, where n is the length of the array.

    Space Complexity:
    - O(1): No additional space is used apart from a few variables.

    Parameters:
    - nums (List[int]): The input list of integers.

    Returns:
    - int: The total number of zero-filled subarrays.
    """
    result = 0
    count = 0

    for num in nums:
        if num == 0:
            count += 1
            result += count
        else:
            count = 0

    return result

def main():
    nums1 = [1,3,0,0,2,0,0,4]
    nums2 = [0,0,0,2,0,0]
    nums3 = [2,10,2019]

    print(f"Num of Zero filled sub-array from {nums1} is {zero_filled_subarray(nums1)}")
    print(f"Num of Zero filled sub-array from {nums2} is {zero_filled_subarray(nums2)}")
    print(f"Num of Zero filled sub-array from {nums3} is {zero_filled_subarray(nums3)}")

if __name__ == "__main__":
    main()
