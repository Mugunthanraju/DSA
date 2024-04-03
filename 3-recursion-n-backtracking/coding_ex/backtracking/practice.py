# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ BACKTRACKING ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


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
reuslt = solveNQueens(4)
print(reuslt[1]) # prints the solutions
print(reuslt[0]) # prints count only

# ************************************************************************************************