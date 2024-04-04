# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ BACKTRACKING ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

# ************************************************************************************************
def kPermute(n, k):
    """
    60.LC : Permutation Sequence

    Brute Solution : Finding all the premutations by using recursion and storing in a Data Structure then Sort it. Now fetch the Kth permuted number.

    Optimal Solution :-

    Here we take help of factorial (since all the permutation of given N is N! ) and N numbers. 

    For permutations of n, the first (n-1)! permutations start with 1, next (n-1)! ones start with 2, ... and so on. And in each group of (n-1)! permutations, the first (n-2)! permutations start with the smallest remaining number, ... take n = 3 as an example, the first 2 (that is, (3-1)! ) permutations start with 1, next 2 start with 2 and last 2 start with 3. For the first 2 permutations (123 and 132), the 1st one (1!) starts with 2, which is the smallest remaining number (2 and 3). So we can use a loop to check the region that the sequence number falls in and get the starting digit. Then we adjust the sequence number and continue.

    Another Detailed explanation :- 

    The approach is mathematical. The idea is to keep selecting a digit and eliminating it from further selection based on value of K.

    For example:

    Given, N = 4, K = 9

    There are 6 numbers starting with 1: 1234, 1243, 1324, 1342, 1423, 1432
    There are 6 numbers starting with 2: 2134, 2143, 2314, 2341, 2413, 2431
    Similarly, there are 6 numbers starting with 3 and 6 numbers starting with 4.

    This is because when we have chosen one place out of 4 places (as N=4), there are 3 places remaining to be filled and those 3 places can be filled in 6 ways or (N-1)! ways.

    So, we have to keep identifying which digit to choose.

    Initially, we have to choose a digit from {1,2,3,4}.

    Since K = 9, meaning it belongs to second set of six numbers and hence, would begin with 2.

    Now, first place is chosen as 2 and output string becomes "2".
    This means we have eliminated 6 choices starting with 1 (1234, 1243, 1324, 1342, 1423, 1432).

    Now, K would be updated as K = 9 - 6 = 3.

    We now have to identify remaining 3 places with the digits {1,3,4} and with K = 3.

    There are 2 numbers starting with 1: 134, 143
    There are 2 numbers starting with 3: 314, 341
    There are 2 numbers starting with 4: 413, 431

    This is because when we have chosen one place out of 3 available places, there are 2 places remaining to be filled and those 2 places can be filled in 2 ways.

    Since, K = 3, meaning it belongs to second set of two numbers and hence, answer would be appended with "3" and output string becomes "23".
    This means we have eliminated 2 choices starting with 1 (134, 143).

    Now, K would be updated as K = 3 - 2 = 1.

    We now have to identify remaining 2 places with the digits {1,4} with K = 1.

    There is 1 number starting with 1: 14
    There is 1 number starting with 4: 41

    This is because when we have chosen one place out of 2 available places, there is only 1 place remaining to be filled and that 1 place can be only be filled in 1 ways.

    Since, K = 1, meaning it belongs to first set of one number and hence, answer would be appended with "14" and output string becomes "2314".

    Therefore, final answer becomes "2314".
    """
    ans = list()
    nlist = list()
    facts = 1

    for u in range(1, n):
        facts *= u
        nlist.append(u)
    nlist.append(n)

    k -= 1 # Decrementing a number because index starts from 0.
    while True:
        # get the index of current digit
        val = nlist[k//facts]
        ans.append(str(val))
        # remove handled number
        nlist.remove(val)

        if not nlist: break

        k = k % facts
        facts = facts // len(nlist)
    
    return "".join(ans)

print(kPermute(4, 9))


# ************************************************************************************************
def maze(sq, matrix):
    """
    Rat in a Maze Problem - I : GFG
    """
    visit = [ [ 0 ] * sq for i in range(sq)]
    result = list()
    path = list()
    rd = [ 1, 0, 0, -1 ]
    cd = [ 0, -1, 1, 0 ]
    direct = "DLRU"

    def findPath(r, c, n, visit, way, ans, m, rd, cd, direct):
        """
        Reduced lines in this method to make it look readable
        """
        if r == n-1 and c == n-1:
            ans.append("".join(way))
            return 
        for i in range(4):
            next_r = r + rd[i]
            next_c = c + cd[i]
            if next_r < n and next_c < n and next_r > -1 and next_c > -1 and visit[next_r][next_c] != 1 and m[next_r][next_c] == 1:
                visit[next_r][next_c] = 1
                way.append(direct[i])
                findPath(next_r, next_c, n, visit, way, ans, m, rd, cd, direct)
                way.pop()
                visit[next_r][next_c] = 0

    if matrix[0][0] == 1: findPath(0, 0, sq, visit, path, result, matrix, rd, cd, direct)
    return result
    
    # def findPath(r, c, n, visit, way, ans, m):
    #     if r == n-1 and c == n-1:
    #         ans.append("".join(way))
    #         return 
        
    #     if r+1 < n and visit[r+1][c] != 1 and m[r+1][c] == 1:
    #         visit[r+1][c] = 1
    #         way.append('D')
    #         findPath(r+1, c, n, visit, way, ans, m)
    #         way.pop()
    #         visit[r+1][c] = 0
    #     if c-1 > -1 and visit[r][c-1] != 1 and m[r][c-1] == 1:
    #         visit[r][c-1] = 1
    #         way.append('L')
    #         findPath(r, c-1, n, visit, way, ans, m)
    #         way.pop()
    #         visit[r][c-1] = 0
    #     if c+1 < n and visit[r][c+1] != 1 and m[r][c+1] == 1:
    #         visit[r][c+1] = 1
    #         way.append('R')
    #         findPath(r, c+1, n, visit, way, ans, m)
    #         way.pop()
    #         visit[r][c+1] = 0
    #     if r-1 > -1 and visit[r-1][c] != 1 and m[r-1][c] == 1:
    #         visit[r-1][c] = 1
    #         way.append('U')
    #         findPath(r-1, c, n, visit, way, ans, m)
    #         way.pop()
    #         visit[r-1][c] = 0

    # findPath(0, 0, sq, visit, path, result, matrix)
    # return result

game = [[1, 0, 0, 0],
        [1, 1, 0, 1], 
        [1, 1, 0, 0],
        [0, 1, 1, 1]]
# game = [[1, 0],
#         [0, 1]]
# print(maze(len(game), game))

# ************************************************************************************************
def partition(string):
    """
    131.LC : Palindrome Partitioning
    """
    def isPalindrome(word):
        return word == word[::-1]
    
    def solve(index, lenght, letter, path, result):
        if index >= lenght:
            result.append(path[:])
            return
        
        for i in range(index, lenght):
            if isPalindrome(letter[index:i+1]):
                path.append(letter[index:i+1])
                solve(i+1, lenght, letter, path, result)
                path.pop()
    
    answer = list()
    parts = list()
    lenght = len(string)
    solve(0, lenght, string, parts, answer)
    return answer
# print(partition("aab"))

# ************************************************************************************************
def suduko(board):
    def isValid(val, row, col, board):
        """
        37.LC : Sudoku Solver
        """
        for i in range(9):
            if board[row][i] == val:
                return False
            if board[i][col] == val:
                return False
            if board[3 * (row//3) + i%3][3 * (col//3) + i//3] == val:
                """
                (3 * (row//3)) and (3 * (col//3) finds the cube in which the operation needs to be done eg. row = 5, col = 7 then ((3 * 1), (3 * 2)) = (3, 6) -> First box in that 3x3 cube. 

                i%3 and i//3 makes one to modifies number in the range(0,3) however i%3 does it fast and later (i.e., i//3) does it slow. We can use it for row and col interchangably.
                 """
                return False
        return True
    
    def solve(board):
        for row in range(9):
            for col in range(9):
                if board[row][col] != '.':
                    continue
                else:
                    for i in range(1,10):
                        value = chr( ord('0') + i )
                        if isValid(value, row, col, board):
                            board[row][col] = value
                            # backTracking starts here
                            if solve(board):
                                return True
                            else:
                               board[row][col] = '.'
                            # backTracking ends here
                    else:
                        return False
        return True
    solve(board)

answerBoard = [
    ["5", "3", ".", ".", "7", ".", ".", ".", "."],
    ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    [".", "9", "8", ".", ".", ".", ".", "6", "."],
    ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    [".", "6", ".", ".", ".", ".", "2", "8", "."],
    [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    [".", ".", ".", ".", "8", ".", ".", "7", "9"]
    ]
# suduko(answerBoard)
# for row in answerBoard:
#     print(row[:])
# print(answerBoard)
"""
['5', '3', '4', '6', '7', '8', '9', '1', '2']
['6', '7', '2', '1', '9', '5', '3', '4', '8']
['1', '9', '8', '3', '4', '2', '5', '6', '7']
['8', '5', '9', '7', '6', '1', '4', '2', '3']
['4', '2', '6', '8', '5', '3', '7', '9', '1']
['7', '1', '3', '9', '2', '4', '8', '5', '6']
['9', '6', '1', '5', '3', '7', '2', '8', '4']
['2', '8', '7', '4', '1', '9', '6', '3', '5']
['3', '4', '5', '2', '8', '6', '1', '7', '9']
"""

# ************************************************************************************************
def solveNQueens(n):
    """
    51.LC : N-Queens, 52.LC : N-Queens II {Similar to 51 however this problems requires only the count of the reuslt}
    """
    def backTracking(row, ans, board, n, left, ud, ld):
        if row > n-1:
            ans.append(["".join(row) for row in board])
            return
        for col in range(n):
            if not left[col] and not ud[n-1+col-row] and not ld[row+col]:
                board[row][col] = 'Q'
                left[col] = True
                ud[n-1+col-row] = True
                ld[row+col] = True
                backTracking(row+1, ans, board, n, left, ud, ld)
                board[row][col] = '.'
                left[col] = False
                ud[n-1+col-row] = False
                ld[row+col] = False

    ans = []
    board = [['.'] * n for _ in range(n)]
    left = [False] * n
    ud = [False] * ((2*n) - 1)
    ld = [False] * ((2*n) - 1)
    backTracking(0, ans, board, n, left, ud, ld)
    ansCount = len(ans)
    return ansCount, ans
# reuslt = solveNQueens(4)
# print(reuslt[1]) # prints the solutions
# print(reuslt[0]) # prints count only

# ************************************************************************************************