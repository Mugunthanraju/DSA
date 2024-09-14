package solutions;

public class Solution8 {
    public static int maxProfit(int[] prices) {
        /*
         * The profit is the sum of sub-profits. Each sub-profit is the difference
         * between selling at day j, and buying at day i (with j > i). The range [i, j]
         * should be chosen so that the sub-profit is maximum :
         * 
         * subProfit = prices[j] - prices[i]
         */

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 }; // 7
        System.out.println("Max Profit : " + maxProfit(prices));
    }
}

/*
 * To solve the Leetcode problem "122. Best Time to Buy and Sell Stock II," we
 * need to maximize profit from stock prices given in an array, where we can
 * perform as many transactions as we like (i.e., buy and sell multiple times).
 * The key is to capture every profitable opportunity.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `prices`: An array of integers where `prices[i]` represents the price of a
 * stock on the `i-th` day.
 * 
 * - **Output**:
 * - The maximum profit that can be achieved by buying and selling stocks
 * multiple times.
 * 
 * ## Approach
 * 
 * The optimal approach is to use a greedy algorithm. The idea is to accumulate
 * profit whenever there is an increase in stock price from one day to the next.
 * Specifically, if the price on day `i` is less than the price on day `i + 1`,
 * we can simulate a buy on day `i` and a sell on day `i + 1`.
 * 
 * ### Steps:
 * 1. Initialize a variable `totalProfit` to `0`.
 * 2. Iterate through the `prices` array starting from the second element:
 * - If the current price is greater than the previous price, add the difference
 * to `totalProfit`.
 * 3. Return `totalProfit` after the loop.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space.
 * 
 * 
 * ### Explanation of the Code:
 * - The `maxProfit` method initializes `totalProfit` to zero.
 * - It loops through the `prices` array starting from the second element.
 * Whenever it finds that the current price is higher than the previous day's
 * price, it calculates the profit from that transaction and adds it to
 * `totalProfit`.
 * - Finally, it returns `totalProfit`, which represents the maximum profit that
 * can be achieved through multiple transactions.
 * 
 * This solution efficiently calculates the maximum profit by leveraging every
 * opportunity to buy low and sell high, ensuring it passes all test cases on
 * Leetcode.
 * 
 * Citations:
 * [1] https://algo.monster/liteproblems/122
 * [2] https://algo.monster/liteproblems/121
 * [3] https://walkccc.me/LeetCode/problems/122/
 * [4] https://walkccc.me/LeetCode/problems/121/
 * [5] https://www.youtube.com/watch?v=3SJ3pUkPQMc
 * [6] https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/
 * [7]
 * https://github.com/Seanforfun/Algorithm-and-Leetcode/blob/master/leetcode/121
 * .%20Best%20Time%20to%20Buy%20and%20Sell%20Stock.md
 * [8]
 * https://prepfortech.io/leetcode-solutions/best-time-to-buy-and-sell-stock-ii
 */

class Solution_8 {
    public int maxProfit(int[] prices) {
        int totalProfit = 0; // Initialize total profit to 0

        // Iterate through the price array starting from the second element
        for (int i = 1; i < prices.length; i++) {
            // If the current price is greater than the previous price
            if (prices[i] > prices[i - 1]) {
                // Add the profit from this transaction to totalProfit
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit; // Return the total accumulated profit
    }
}