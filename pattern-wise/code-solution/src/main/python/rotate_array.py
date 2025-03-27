def rotate(nums, k):
    """
    Rotate an array to the right by k steps.

    Approach:
    1. Normalize k to ensure it is within the bounds of the array length.
    2. Reverse the entire array.
    3. Reverse the first k elements.
    4. Reverse the remaining elements from k to the end.

    Time Complexity: O(n), where n is the length of the array.
    Space Complexity: O(1), as we are using only a constant amount of extra space.

    :param nums: List[int] - The input array to be rotated.
    :param k: int - The number of steps to rotate the array.
    :return: None - The array is modified in-place.
    """
    n = len(nums)
    k %= n  # Normalize k

    def reverse(start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

    # Reverse the entire array
    reverse(0, n - 1)
    # Reverse the first k elements
    reverse(0, k - 1)
    # Reverse the remaining elements
    reverse(k, n - 1)

def main():
    nums1 = [1, 2, 3, 4, 5, 6, 7]
    print("Original array:", nums1)
    rotate(nums1, 3)
    print("Rotated array:", nums1)
    print("--------------------")
    nums2 = [-1,-100,3,99]
    print("Original array:", nums2)
    rotate(nums2, 3)
    print("Rotated array:", nums2)

if __name__ == "__main__":
    main()
