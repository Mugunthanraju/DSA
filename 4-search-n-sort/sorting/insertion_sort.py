"""
Insertion sort is a sorting algorithm that places an unsorted element at its suitable place in each iteration.

Time Complexities

Worst Case Complexity: O(n2)
Suppositione, an array is in ascending order, and you want to sort it in descending order. In this case, worst case complexity occurs.
Each element has to be compared with each of the other elements so, for every nth element, (n-1) number of comparisons are made.
Thus, the total number of comparisons = n*(n-1) ~ n2

Best Case Complexity: O(n)
When the array is already sorted, the outer loop runs for n number of times whereas the inner loop does not run at all. So, there are only n number of comparisons. Thus, complexity is linear.

Average Case Complexity: O(n2)
It occurs when the elements of an array are in jumbled order (neither ascending nor descending).
Space Complexity

Space complexity is O(1) because an extra variable key is used.

"""

def insertionSort(items):
    for sub in range(1, len(items)):
        key = items[sub]
        position = sub
        # print("Before :", items[:sub+1], "key =", key, position)

        while position - 1 > -1 and key < items[position - 1]:
            items[position] = items[position - 1]
            position -= 1
        items[position] = key

        # for i in range(sub, -1, -1):
        #     # Either use this for loop or above while loop as inner loop.
        #     if i-1 > -1 and  key < items[i-1]:
        #         items[i] = items[i-1]
        #         position -=1
        #     else:
        #         items[position] = key
        #         # print("After :", items[:sub+1], "key =", key, position)
        #         break
        
    return items

if __name__ == '__main__':
    nums = [2, 6, 1, 5, 9, 4, 8, 3, 7]
    print(nums)
    print(insertionSort(nums))
    print()
    print(nums[::-1])
    print(insertionSort(nums[::-1]))