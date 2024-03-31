# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ BACKTRACKING ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

def solveNQueens(n):
    # Helper function to check if placing a queen at (row, col) is valid
    def is_valid(board, row, col):
        # Check if there is a queen in the same column or diagonal
        for i in range(row):
            if board[i] == col or \
                board[i] - i == col - row or \
                board[i] + i == col + row:
                return False
        return True
    
    # Backtracking function to explore all possible queen placements
    def backtrack(board, row):
        # Base case: if all queens are placed, add current arrangement to result
        if row == n:
            solution = []
            for i in range(n):
                row_str = ['.'] * n
                row_str[board[i]] = 'Q'  # Place queen at appropriate column
                solution.append(''.join(row_str))
            result.append(solution)
            return
        # Recursive case: try placing queen in each column of current row
        for col in range(n):
            if is_valid(board, row, col):
                board[row] = col  # Mark the queen placement
                backtrack(board, row + 1)  # Recur for next row
    
    result = []  # List to store all valid arrangements
    board = [-1] * n  # Initialize board with -1 (no queen placed)
    backtrack(board, 0)  # Start backtracking from first row
    return result

# Example usage:
# n = 4
# for result in solveNQueens(n):
#     for row in result:
#         for c, v in enumerate(row):
#             print(v if v == 'Q' else c+1, end=' ')
#         print()
#     print("\n")


# ************************************************************************************************
def SolveNQueens(n):
    board = [['.'] * n for i in range(n)]
    colSet = set()
    posDiag = set()
    negDiag = set()
    output = []
    def backtrack(r):
        if r == n:
            output.append([''.join(row) for row in board])
            return
        
        for col in range(n):
            if col in colSet or (r + col) in posDiag or (r - col) in negDiag:
                continue
            board[r][col] = 'Q'
            colSet.add(col)
            posDiag.add((r + col))
            negDiag.add((r - col))
            backtrack(r + 1)
            colSet.remove(col)
            posDiag.remove((r + col))
            negDiag.remove((r - col))
            board[r][col] = '.'
    
    backtrack(0)
    return output

# def SolveNQueens(n):
#     ans = list()
#     def attacks(col, board, left, uDiagonal, lDiagonal, n):
#         if col >= n:
#             print(board[:], '\n')
#             ans.append(board[:])
#             # print(ans)
#             return

#         for row in range(n):
#             if not left[row] and not lDiagonal[row + col] and not uDiagonal[n - 1 + col - row]:
#                 board[row][col] = 'Q'
#                 # print(row, col, board[row][col])
#                 left[row] = True
#                 lDiagonal[row + col] = True
#                 uDiagonal[n - 1 + col - row] = True
#                 # print(board)
#                 attacks(col+1, board, leftRow, upperDiagonal, lowerDiagonal, n)
#                 board[row][col] = '.'
#                 left[row] = False
#                 lDiagonal[row + col] = False
#                 uDiagonal[n - 1 + col - row] = False

#     board = [['.'] * n] * n
#     leftRow = [False] * (n)
#     upperDiagonal = [False] * (2 * n - 1)
#     lowerDiagonal = [False] * (2 * n - 1)
#     attacks(0, board, leftRow, upperDiagonal, lowerDiagonal, n)
#     return ans
# SolveNQueens(2)
# for i in SolveNQueens(2):
#     print(i)
ans = SolveNQueens(4)
print(len(ans), "\n", ans)
# b = [['.'] * 2] * 2
# print(b)

# ************************************************************************************************
def premute(nums):
    """
    46.LC : Permutations
    """
    # import copy
    # def recursePermute(nums, ds, ans, freq):
    #     """
    #     TC : O(N! x N)
    #     SC : O(N) + O(N) ~ O(2N)
    #     """
    #     if len(ds) == len(nums):
    #         ans.append(copy.deepcopy(ds))
    #         return
    #     for i in range(len(nums)):
    #         if not freq[i]:
    #             freq[i] = True
    #             ds.append(nums[i])
    #             recursePermute(nums, ds, ans, freq)
    #             ds.pop()
    #             freq[i] = False
    # ans = list()
    # ds = list()
    # freq = [False] * len(nums)
    # recursePermute(nums, ds, ans, freq)
    # return ans
    
    ansOpt = list()
    def recurseOptimise(ind, arr):
        """
        *************************** BACKTRACKING *****************************************
        TC : O(N! x N) {Process of recursion x Storing the answer}
        SC : O(1) ~ No extra space for process other than answer and recursion stack trace.
        """
        if ind >= len(arr):
            ansOpt.append(arr[:])
            return
        for i in range(ind, len(arr)):
            # Backtracking is happening in this loop {exactly : using swap process}
            arr[i], arr[ind] = arr[ind], arr[i]
            recurseOptimise(ind+1, arr)
            arr[i], arr[ind] = arr[ind], arr[i]
    recurseOptimise(0, nums)
    return ansOpt
# print(premute([1,2,3]))

# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ RECURSION ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# ************************************************************************************************
def subsetsWithDup(nums):
    nums.sort()
    setList = list()
    import copy
    def findSubSets(ind, ds, nums, setList):
        setList.append(copy.deepcopy(ds)) # setList.append([ x for x in ds])
        for i in range(ind, len(nums)):
            if i != ind and nums[i] == nums[i-1]: continue
            ds.append(nums[i])
            findSubSets(i+1, ds, nums, setList)
            ds.pop()
    findSubSets(0, list(), nums, setList)
    return setList
# print(subsetsWithDup([1,2,2]))
# print(subsetsWithDup([1,2,2,2,3,3]))

# ************************************************************************************************
def sumSubSet(i, subSet, total, arr):
    """
    TC : O(2^N) {Recusrion i.e., 2^N combination} + O(2^Nlog(2^N)) {Sorting}
    SC : O(2^N) {Recursion stack trace}
    """
    if len(arr) <= i:
        subSet.append(total)
        return
    total += arr[i]
    sumSubSet(i+1, subSet, total, arr) 
    total -= arr[i]
    sumSubSet(i+1, subSet, total, arr)
# subSet = list()
# sumSubSet(0, subSet, 0, [3, 1, 2])
# print(sorted(subSet))

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
# print(countSumOfK(0, [1,2,1], 2, 0))

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