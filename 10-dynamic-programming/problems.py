from typing import *

def bestTimeForStock(prices: List[int]) -> int:
        
        """
        LC : 121. Best Time to Buy and Sell Stock

        TC : O(N) | N = lenght of list
        SC : O(1)
        """

        lowest_price = 20000
        profit = 0

        for price in prices:
            lowest_price = min(lowest_price, price)
            profit = max(profit, price - lowest_price)
        
        return profit

def climbStairs(n: int) -> int:
    
    """
    LC : 70. Climbing Stairs
    """

    if n < 4:
        return n 
    
    """
    Optimized of Space

    prev, curr = 1, 2
    for i in range(3, n + 1):
        prev, curr = curr, prev + curr
    return curr
    """
    
    table = [ 0 ] * (n + 1)
    table[1] = 1
    table[2] = 2
    """
    n = 4
    [0, 1, 2, 1+2=3, 2+3=5]
    """

    for i in range(3, n + 1):
        table[i] = table[i-1] + table[i-2]
    
    return table[n]

def wordBreak(s: str, wordDict: List[str]) -> bool:

    """
    LC : 139. Word Break
    """

    # ______________Tabulation______________
    
    table = [ False ] * (len(s) + 1) # adding an extra for empty str at first
    table[0] = True

    _wordDict = set(wordDict) # Just to have O(1) TC in lookup

    for end in range(1, len(s)+1):
        for start in range(end):
            sliced = s[start:end]

            if sliced in _wordDict and table[start]:
                table[end] = True
                break
    
    return table[-1]

    # ______________Memoization______________
    
    # def findit(target, words, memo=None):

    #     if memo is None:
    #         memo = dict()
        
    #     if target in memo:
    #         return memo[target]
        
    #     if len(target) == 0:
    #         return True
        
    #     for word in words:
    #         if target.startswith(word):
    #             suffix = target[len(word):]

    #             if findit(suffix, words, memo):
    #                 memo[target] = True
    #                 return True
        
    #     memo[target] = False
    #     return False
    
    # return findit(s, wordDict)

    # ______________BFs______________

    # _wordDict = set(wordDict)
    # from collections import deque
    # queue = deque()
    # queue.append(0)

    # while len(queue):
    #     start = queue.popleft()
    #     for end in range(start+1, len(s)+1):
    #         word = s[start:end]
    #         if word in _wordDict:
    #             if end == len(s): 
    #                 return True
    #             queue.append(end)
    
    # return False

#---------------------------------------------

def pascalGenerate(numRows: int) -> List[List[int]]:

    """
    LC : 118. Pascal's Triangle

    TC : O(N) 
    SC : O(1) | We're not considering result list.

    """

    result = [ [ 0 for _ in range(n+1)] for n in range(numRows) ]

    for i in range(numRows):
        result[i][0] = 1
        result[i][i] = 1

        for j in range(1, i):
            result[i][j] = result[i-1][j-1] + result[i-1][j]
    
    return result

def maxSubArray(nums: List[int]) -> int:

    """
    LC : 53. Maximum Subarray

    Approach : Kadane's algorithm 

    Usage : Two integer variable (Most Optimised)
    TC : O(N)
    SC : O(1)

    Usage : DP - Tabulation
    TC : O(N)
    SC : O(N)
    """

    # dp = [ -20000 ] * len(nums)
    # dp[0] = nums[0]
    maxi = nums[0]
    current_maxi = nums[0]


    # i = 1 # For index in dp
    for num in nums[1:]:

        # dp[i] = max(num + dp[i - 1], num)
        # maxi = max(maxi, dp[i])
        # i += 1

        current_maxi = max(num, current_maxi + num)
        maxi = max(maxi, current_maxi)
    
    return maxi

def isSubsequence(s: str, t: str) -> bool:

    """
    LC : 392. Is Subsequence
    
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
    """

    sl = len(s)
    tl = len(t)

    """
    In dynamic programming approach

    TC : O(N)
    SC : O(sl * tl)

    s = "abc", 
    [[0, 0, 0, 0, 0, 0, 0], 
    [0, 1, 1, 1, 1, 1, 1], 
    [0, 1, 1, 2, 2, 2, 2], 
    [0, 1, 1, 2, 2, 2, 3]]
    """

    dp = [
        [ 0 for _ in range(tl+ 1)] for l in range(sl + 1)
    ]

    for col in range(1, tl+1):
        for row in range(1, sl+1):
            if s[row-1] == t[col-1]:
                dp[row][col] = dp[row-1][col-1] + 1
            else:
                dp[row][col] = max(dp[row-1][col], dp[row][col-1])
    
    return dp[sl][tl] == sl

    #_______________ Two Pointer Approach (Optimized) _______________________

    """
    TC : O(sl * tl)
    SC : O(1)
    """

    # sp = 0
    # tp = 0

    # while sp < sl and tp < tl:
    #     if s[sp] == t[tp]:
    #         sp += 1
    #     tp += 1
    
    # return sp == sl

# ____________________________________________

def main():
    #   print("The max profit =", bestTimeForStock([7,1,5,3,6,4]))
    # print("Distinct Ways =", climbStairs(4))
    # print("Can be segmented?", wordBreak("leetcode", ["leet","code"]))
    # print("Pascal Triangle :", pascalGenerate(5))
    # print("Largest sum from sub-array :", maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))
    print("Is subsquence :", isSubsequence("abc", "ahbgdc"))
    pass

if __name__ == '__main__':
     main()