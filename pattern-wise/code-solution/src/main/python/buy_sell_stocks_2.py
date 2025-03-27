def max_profit(prices):
    """
    Leetcode Problem 122: Best Time to Buy and Sell Stock II

    Problem Statement:
    You are given an integer array `prices` where `prices[i]` is the price of a given stock on the ith day.
    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
    However, you can buy it then immediately sell it on the same day.
    Find and return the maximum profit you can achieve.

    Approach:
    - The problem boils down to summing up all the positive differences between consecutive days.
    - If the price on day `i` is greater than the price on day `i-1`, we add the difference to the profit.
    - This greedy approach ensures that we capture all profitable transactions.

    Time Complexity:
    - O(n), where `n` is the number of days (length of the `prices` array).
    - We traverse the array once.

    Space Complexity:
    - O(1), as we use only a constant amount of extra space.

    Parameters:
    - prices (List[int]): List of stock prices.

    Returns:
    - int: Maximum profit achievable.

    Example:
    >>> max_profit([7, 1, 5, 3, 6, 4])
    7
    >>> max_profit([1, 2, 3, 4, 5])
    4
    >>> max_profit([7, 6, 4, 3, 1])
    0
    """
    # Initialize profit to 0
    profit = 0

    # Iterate through the prices array
    for i in range(1, len(prices)):
        # Add the positive difference to profit
        if prices[i] > prices[i - 1]:
            profit += prices[i] - prices[i - 1]

    return profit

def main():
    profits1 = [7, 1, 5, 3, 6, 4]
    profits2 = [1, 2, 3, 4, 5]
    profits3 = [7, 6, 4, 3, 1]

    print(f"Max profits from {profits1} is {max_profit(profits1)}")  # Output: 7
    print(f"Max profits from {profits2} is {max_profit(profits2)}")  # Output: 4
    print(f"Max profits from {profits3} is {max_profit(profits3)}")  # Output: 0

if __name__ == "__main__":
    main()