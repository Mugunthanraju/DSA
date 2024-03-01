"""
Merge Sort is one of the most popular sorting algorithms that is based on the principle of Divide and Conquer Algorithm.

Time Complexity
Best Case Complexity: O(n*log n)

Worst Case Complexity: O(n*log n)

Average Case Complexity: O(n*log n)

Space Complexity
The space complexity of merge sort is O(n)
"""


def mergeSort(items):
    if len(items) < 2:
        return items
    
    mid = len(items) // 2

    left_half = mergeSort(items[:mid])
    right_half = mergeSort(items[mid:])

    left_pointer = 0
    right_pointer = 0
    position = 0

    while position < len(items) and left_pointer < len(left_half) and right_pointer < len(right_half):
        if left_half[left_pointer] < right_half[right_pointer]:
            items[position] = left_half[left_pointer]
            left_pointer += 1
        else:
            items[position] = right_half[right_pointer]
            right_pointer += 1
        position += 1
    
    while position < len(items) and left_pointer < len(left_half):
        items[position] = left_half[left_pointer]
        left_pointer += 1
        position += 1

    while position < len(items) and right_pointer < len(right_half):
        items[position] = right_half[right_pointer]
        right_pointer += 1
        position += 1

    return items


if __name__ == '__main__':
    data = [9, 8, 1, 3, 7, 5, 6, 4, 1]
    print('Unsorted Array:')
    print(data)
    mergeSort(data)
    print('Sorted Array in Ascending Order:')
    print(data)

    nums = [2, 6, 1, 5, 9, 4, 8, 3, 7]
    print('Unsorted Array:')
    print(nums)
    print('Sorted Array in Ascending Order:')
    print(mergeSort(nums))