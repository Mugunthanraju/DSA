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

    left = mergeSort(items[:mid])
    right = mergeSort(items[mid:])

    lp = 0
    rp = 0
    pos = 0

    while pos < len(items) and lp < len(left) and rp < len(right):
        if left[lp] < right[rp]:
            items[pos] = left[lp]
            lp += 1
        else:
            items[pos] = right[rp]
            rp += 1
        pos += 1
    
    while pos < len(items) and lp < len(left):
        items[pos] = left[lp]
        lp += 1
        pos += 1

    while pos < len(items) and rp < len(right):
        items[pos] = right[rp]
        rp += 1
        pos += 1

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