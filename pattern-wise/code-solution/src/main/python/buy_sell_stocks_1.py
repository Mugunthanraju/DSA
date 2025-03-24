
def maxProfit(prices):
    """
        LeetCode Problem 121: Best Time to Buy and Sell Stock

        Approach:
        1. Initialize two variables, `min_price` to a very large number and `max_profit` to 0.
        2. Iterate through each price in the list of prices.
        3. For each price, update `min_price` to be the minimum of `min_price` and the current price.
        4. Calculate the potential profit by subtracting `min_price` from the current price.
        5. Update `max_profit` to be the maximum of `max_profit` and the potential profit.
        6. Return `max_profit` after iterating through all prices.

        Time Complexity: O(n), where n is the number of days (length of the prices list).
        Space Complexity: O(1), as we are using only a constant amount of extra space.
    """
    min_price = float('inf')
    max_profit = 0
    
    for price in prices:
        min_price = min(min_price, price)
        profit = price - min_price
        max_profit = max(max_profit, profit)
    
    return max_profit

def main():
    prices1 = [7, 1, 5, 3, 6, 4]
    print("From stock txn:", prices1)
    print("Highest profit is", maxProfit(prices1))

    prices2 = [7, 6, 4, 3, 1]
    print("From stock txn:", prices2)
    print("Highest profit is", maxProfit(prices2))

if __name__ == "__main__":
    main()