# ************************************************************************************************
def countSumOfK(index, arr, total, addup):
    if len(arr) == index:
        if total == addup:
            return 1
        return 0
    addup += arr[index]
    left  = countSumOfK(index+1, arr, total, addup) # pickup
    addup -= arr[index]
    right = countSumOfK(index+1, arr, total, addup) # not to pickup
    return left + right
print(countSumOfK(0, [1,2,1], 2, 0))

# ************************************************************************************************
def sumOfK(index, ds, arr, total, addup):
    if len(arr) == index:
        if total == addup:
            print("Answer:", ds)
        return
    ds.append(arr[index])
    addup += arr[index]
    sumOfK(index+1, ds, arr, total, addup) # pickup
    ds.pop()
    addup -= arr[index]
    sumOfK(index+1, ds, arr, total, addup) # not to pickup
# sumOfK(0, [], [1,2,1], 2, 0)

# ************************************************************************************************
def subArray(index , ds, arr, n):
    """
    Subarray here means sub contigious and non sub contigious arrays with same order. 
    TC : O(2^N x N) {2^n = We have couple of options & N = For loop usage}
    SC : O(N) {Everytime stack trace uses N times of space for each option and other option will start if prev option is completed.}
    """
    if n == index:
        if len(ds) < 1: print([])
        else:
            for i in ds:
                print( i, end=" " )
            print()
        return
    
    ds.append(arr[index])
    subArray(index+1, ds, arr, n) # pick 
    ds.pop()
    subArray(index+1, ds, arr, n) # not pick
# subArray(0, [], [3,1,2], 3) # function call

# ************************************************************************************************
def fibanacci(n):
    """
    TC : O(2^N) ~ Exponential
    SC : O(2^N)
    """
    if n < 2:
        return n
    return fibanacci(n-1) + fibanacci(n-2)
# print(fibanacci(20)) # 6795

# ************************************************************************************************
def stringPallindrome(word, start=0):
    """
    TC : O(N/2)
    SC : O(N/2) {due to stack trace of recursion}
    """
    if not word:
        return False
    if start >= len(word)//2:
        return True
    if word[start] != word[len(word) - 1 - start]:
        return False
    else:
        return stringPallindrome(word, start+1)
# print(stringPallindrome("noon"))

# ************************************************************************************************
# def reverseArray(array, start=0, end=0):
#    if not array or len(array) < 2 or start >= end:
def reverseArray(array, start=0):
    """
    TC : O(N/2)
    SC : O(N/2) {due to stack trace of recursion}
    """
    if not array or len(array) < 2 or start >= len(array)//2:
        return array
    # array[start], array[end] = array[end], array[start]
    # return reverseArray(array, start+1, end-1)
    array[start], array[len(array)- 1 - start] = array[len(array)- 1 - start], array[start]
    return reverseArray(array, start+1)
# print(reverseArray([1,2,3,4,5], 0, 4))
# print(reverseArray([1,2,3,4,5]))

# ************************************************************************************************
def sum_list(nums):
    if len(nums) < 1:
        return 0
    return nums[0] + sum_list(nums[1:])
# print(sum_list([1, 2, 3, 4, 5])) # 15

# ************************************************************************************************
def convert_to_base(num, base):
    digits = '0123456789ABCDEF'

    if num < base:
        return digits[num]
    return convert_to_base(num // base, base) \
           + digits[num % base]
# print(convert_to_base(9145, 16)) # 23B9
# print(convert_to_base(9145, 10)) # 9145
# print(convert_to_base(9145, 8)) # 21671
# print(convert_to_base(9145, 2)) # 10001110111001
# ************************************************************************************************