
def product_except_self(nums):
    """
        Leetcode Problem 238: Product of Array Except Self

        Approach:
        1. Use two passes to calculate the product of all elements except the current one.
        2. In the first pass, calculate the prefix product for each element and store it in the result array.
        3. In the second pass, calculate the suffix product while updating the result array.
        4. This avoids using division and ensures O(n) time complexity with O(1) extra space (excluding the output array).

        Time Complexity: O(n)
        Space Complexity: O(1) (excluding the output array)
    """
    n = len(nums)
    result = [1] * n  # Initialize the result array with 1s

    # Calculate prefix products
    prefix = 1
    for i in range(n):
        result[i] = prefix
        prefix *= nums[i]

    # Calculate suffix products and update the result array
    suffix = 1
    for i in range(n - 1, -1, -1):
        result[i] *= suffix
        suffix *= nums[i]

    return result

def main():
    nums1 = [1, 2, 3, 4]
    nums2 = [-1, 1, 0, -3, 3]
    nums3 = [1, 2, 3, 4, 5]

    print(f"Product of Array Except Self for {nums1}: {product_except_self(nums1)}")
    print(f"Product of Array Except Self for {nums2}: {product_except_self(nums2)}")
    print(f"Product of Array Except Self for {nums3}: {product_except_self(nums3)}")


if __name__ == "__main__":
    main()
