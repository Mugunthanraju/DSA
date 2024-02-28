"""
Bubble sort is a sorting algorithm that compares two adjacent elements and swaps them until they are in the intended order.

1. Time Complexities
Worst Case Complexity: O(n2)
If we want to sort in ascending order and the array is in descending order then the worst case occurs.

Best Case Complexity: O(n)
If the array is already sorted, then there is no need for sorting.

Average Case Complexity: O(n2)
It occurs when the elements of the array are in jumbled order (neither ascending nor descending).

2. Space Complexity
Space complexity is O(1) because an extra variable is used for swapping.
In the optimized bubble sort algorithm, two extra variables are used. Hence, the space complexity will be O(2).
"""

def bubbleSort(items):
    for sub in range(len(items)-1, 0 ,-1):
        for i in range(sub):
            if items[i] > items[i+1]:
                items[i], items[i+1] = items[i+1], items[i]
    return items

def bubbleSort_optimised(items):
    for sub in range(len(items)-1, 0 ,-1):
        swapped = False
        for i in range(sub):
            if items[i] > items[i+1]:
                items[i], items[i+1] = items[i+1], items[i]
                swapped = True
        
        if not swapped:
            print(f"With list of length = {len(items)}, breaking the loop at {sub}")
            break
        
                
    return items
                

if __name__ == '__main__':
    nums = [2, 6, 1, 5, 9, 4, 8, 3, 7]
    print(bubbleSort(nums))
    print(bubbleSort_optimised(nums))
    nums = [2, 6, 1, 5, 9, 4, 8, 3, 7]
    print(bubbleSort_optimised(nums))