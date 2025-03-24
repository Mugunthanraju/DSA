def moves_zeros_way1(nums):
    """
    // LC : 283. Move Zeroes
    Moves all zeros in the list to the end while maintaining the relative order of the non-zero elements.

    Args:
        nums (list): A list of integers.

    Returns:
        list: The modified list with all zeros moved to the end.
    
    Time Complexity:
        O(n): Where n is the number of elements in the list. The function iterates through the list once.

    Space Complexity:
        O(1): The function modifies the list in place and does not use any extra space proportional to the input size.

    Approach:
        - Initialize a pointer `i` to track the position of the next non-zero element.
        - Iterate through the list with another pointer `j`.
        - Whenever a non-zero element is encountered at `j`, swap it with the element at `i` and increment `i`.
        - This ensures that all non-zero elements are moved to the front, and zeros are moved to the end.
    """
    i = 0
    for j in range(len(nums)):
        if nums[j] != 0:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
    return nums

def moves_zeros_way2(arr):
    """
    Moves all zeros in the array to the end while maintaining the order of non-zero elements.

    Parameters:
    arr (list): The input list of integers.

    Returns:
    list: The modified list with all zeros moved to the end.

    Example:
    >>> moves_zeros_way2([0, 1, 0, 3, 12])
    [1, 3, 12, 0, 0]
   
     Approach:
    1. Initialize a counter `count` to 0, which will keep track of the position to place the next non-zero element.
    2. Iterate through the list. For each non-zero element, place it at the `count` index and increment `count`.
    3. After all non-zero elements have been placed, fill the remaining positions in the list with zeros.

    Time Complexity: O(n), where n is the length of the input list.
    Space Complexity: O(1), as the operation is done in-place.
    """
    count = 0
    for i in range(len(arr)):
        if arr[i] != 0:
            arr[count] = arr[i]
            count += 1
    while count < len(arr):
        arr[count] = 0
        count += 1
    return arr

def main():
    sample_input1 = [0, 1, 0, 3, 12]
    sample_input2 = [4, 0, 5, 0, 6, 0, 7]

    print(f"After moves_zeros_way1({sample_input1}):", moves_zeros_way1(sample_input1))
    print(f"After moves_zeros_way2({sample_input2}):", moves_zeros_way2(sample_input2))

if __name__ == "__main__":
    main()