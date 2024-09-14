package solutions;

public class Solution7 {
    public static int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int profit = 0;

        for (var price : prices) {
            // Update the lowest price by comparing with current price.
            lowest = Math.min(price, lowest);
            // Caluclate the sell and Update the max profit by comparing last max profit.
            profit = Math.max(price - lowest, profit);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 }; // 5
        System.out.println(maxProfit(prices));
    }
}

/*
 * To solve the Leetcode problem "121. Best Time to Buy and Sell Stock," we need
 * to determine the maximum profit that can be achieved by buying and selling a
 * stock on different days, given an array of stock prices.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `prices`: An array of integers where `prices[i]` represents the price of a
 * stock on the `i-th` day.
 * 
 * - **Output**:
 * - The maximum profit that can be achieved from a single buy and sell
 * transaction. If no profit can be made, return `0`.
 * 
 * ## Optimal Approach
 * 
 * The optimal solution involves a single pass through the array, keeping track
 * of the minimum price observed so far and calculating the maximum profit at
 * each step.
 * 
 * ### Steps:
 * 1. Initialize two variables:
 * - `minPrice` to a very high value (infinity) to represent the minimum stock
 * price seen so far.
 * - `maxProfit` to `0` to represent the maximum profit possible.
 * 
 * 2. Iterate through each price in the `prices` array:
 * - Update `minPrice` if the current price is lower than `minPrice`.
 * - Calculate the potential profit by subtracting `minPrice` from the current
 * price.
 * - Update `maxProfit` if the calculated profit is greater than the current
 * `maxProfit`.
 * 
 * 3. After completing the iteration, return `maxProfit`.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space.
 * 
 * ### Explanation of the Code:
 * - The `maxProfit` method initializes `minPrice` to the maximum integer value
 * and `maxProfit` to `0`.
 * - It iterates through each price in the `prices` array:
 * - If the current price is less than `minPrice`, it updates `minPrice`.
 * - It calculates the profit by subtracting `minPrice` from the current price
 * and updates `maxProfit` if this profit is greater than the current
 * `maxProfit`.
 * - Finally, it returns the `maxProfit`, which represents the maximum profit
 * that can be achieved through a single buy and sell transaction.
 * 
 * This solution efficiently determines the best days to buy and sell stock to
 * maximize profit and passes all test cases on Leetcode.
 * 
 * Citations:
 * [1] https://algo.monster/liteproblems/121
 * [2] https://walkccc.me/LeetCode/problems/121/
 * [3]
 * https://github.com/Seanforfun/Algorithm-and-Leetcode/blob/master/leetcode/121
 * .%20Best%20Time%20to%20Buy%20and%20Sell%20Stock.md
 * [4] https://www.youtube.com/watch?v=kJZrMGpyWpk
 * [5] https://www.youtube.com/watch?v=1pkOgXD63yU
 * [6] https://www.geeksforgeeks.org/best-time-to-buy-and-sell-stock/
 * [7] https://www.reddit.com/r/leetcode/comments/uaqln8/
 * 121_best_time_to_buy_and_sell_stock_cant_wrap_my/
 * [8] https://www.youtube.com/watch?v=P1Ic85RarKY
 */

class Solution_7 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Initialize minPrice to a high value
        int maxProfit = 0; // Initialize maxProfit to 0

        // Iterate through each price in the prices array
        for (int price : prices) {
            // Update minPrice if the current price is lower
            if (price < minPrice) {
                minPrice = price;
            } else {
                // Calculate profit if selling at the current price
                int profit = price - minPrice;
                // Update maxProfit if the calculated profit is higher
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit; // Return the maximum profit found
    }
}