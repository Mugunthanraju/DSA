def remove_duplicates(nums):
    """
    LC : 26. Remove Duplicates from Sorted Array.
    Removes duplicates from a sorted array in-place and returns the new length.

    This function uses the two-pointer technique to remove duplicates from a sorted array.
    One pointer (`write_index`) keeps track of the position to write the next unique element,
    while the other pointer (`i`) iterates through the array to find unique elements.
    Approach:
        - Initialize `write_index` to 1.
        - Iterate through the array starting from the second element.
        - If the current element is not equal to the previous element, write it to the `write_index` position.
        - Increment `write_index` for each unique element found.
        - Return `write_index` as the new length of the array.
    
    Time Complexity:
        O(n), where n is the length of the input array. Each element is visited once.
    Space Complexity:
        O(1), as the algorithm uses a constant amount of extra space.

    Args:
        nums (List[int]): A list of sorted integers.
        
    Returns:
        int: The length of the array after removing duplicates.
        
    Example:
        >>> nums = [1, 1, 2]
        >>> length = remove_duplicates(nums)
        >>> length
        2
        >>> nums[:length]
        [1, 2]
    """
    if not nums:
        return 0

    write_index = 1

    for i in range(1, len(nums)):
        if nums[i] != nums[i - 1]:
            nums[write_index] = nums[i]
            write_index += 1

    return write_index

def main():
    nums1 = [1, 1, 2]
    print("Before removing duplicates: ", nums1)
    length1 = remove_duplicates(nums1)
    print("After removing duplicates : ", nums1[:length1])
    nums2 = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    print("Before removing duplicates: ", nums2)
    length2 = remove_duplicates(nums2)
    print("After removing duplicates : ", nums2[:length2])

if __name__ == "__main__":
    main()