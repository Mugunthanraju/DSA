"""
Quicksort is a sorting algorithm based on the divide and conquer approach where

1) An array is divided into subarrays by selecting a pivot element (element selected from the array).
While dividing the array, the pivot element should be positioned in such a way that elements less than pivot are kept on the left side and elements greater than pivot are on the right side of the pivot.

2) The left and right subarrays are also divided using the same approach. This process continues until each subarray contains a single element.

3) At this point, elements are already sorted. Finally, elements are combined to form a sorted array.

1. Time Complexities:-

Worst Case Complexity [Big-O]: O(n2)

It occurs when the pivot element picked is either the greatest or the smallest element.
This condition leads to the case in which the pivot element lies in an extreme end of the sorted array. One sub-array is always empty and another sub-array contains n - 1 elements. Thus, quicksort is called only on this sub-array.
However, the quicksort algorithm has better performance for scattered pivots.

Best Case Complexity [Big-omega]: O(n*log n)

It occurs when the pivot element is always the middle element or near to the middle element.

Average Case Complexity [Big-theta]: O(n*log n)

It occurs when the above conditions do not occur.

2. Space Complexity:- 

The space complexity for quicksort is O(log n)
"""

# Function to find the partition position
def partition(array, low, high):
 
    # choose the rightmost element as pivot
    pivot = array[high]
 
    # pointer for greater element
    i = low - 1
 
    # traverse through all elements
    # compare each element with pivot
    for j in range(low, high):
        if array[j] <= pivot:
 
            # If element smaller than pivot is found
            # swap it with the greater element pointed by i
            i = i + 1
 
            # Swapping element at i with element at j
            array[i], array[j] = array[j], array[i]
 
    # Swap the pivot element with the greater element specified by i
    (array[i + 1], array[high]) = (array[high], array[i + 1])
 
    # Return the position from where partition is done
    return i + 1
 
# function to perform quicksort
 
 
def quickSort(array, low, high):
    if low < high:
 
        # Find pivot element such that
        # element smaller than pivot are on the left
        # element greater than pivot are on the right
        pi = partition(array, low, high)
 
        # Recursive call on the left of pivot
        quickSort(array, low, pi - 1)
 
        # Recursive call on the right of pivot
        quickSort(array, pi + 1, high)

if __name__ == '__main__':
    array = [9, 1, 8, 2, 7, 3, 5, 6, 4]
    print("The Original Array:", array)

    quickSort(array, 0, len(array)-1)
    print('The Sorted Array:', array)
