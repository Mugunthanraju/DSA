"""
Selection sort is a sorting algorithm that selects the biggest element from an unsorted list in each iteration and places that element at the ending of the unsorted list.

Time Complexities:

Worst Case Complexity: O(n2)
If we want to sort in ascending order and the array is in descending order then, the worst case occurs.

Best Case Complexity: O(n2)
It occurs when the array is already sorted

Average Case Complexity: O(n2)
It occurs when the elements of the array are in jumbled order (neither ascending nor descending).

Space Complexity
Space complexity is O(1) because an extra variable is used for swapping.
"""

def selectionSort(items):
    print(len(items), "items =", items)
    for sub in range(len(items), 0, -1):
        max_pos = 0
        for i in range(1, sub):
            # print(items[:sub], max_pos, i)
            if items[max_pos] < items[i]:
                max_pos = i
        
        items[max_pos], items[sub-1] = items[sub-1], items[max_pos]
            
    return items

if __name__ == '__main__':
    nums = [2, 6, 1, 5, 9, 4, 8, 3, 7]
    print(selectionSort(nums))