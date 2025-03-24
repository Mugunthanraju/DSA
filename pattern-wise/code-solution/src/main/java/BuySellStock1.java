import java.util.Arrays;

public class BuySellStock1 {
    // 121. Best Time to Buy and Sell Stock
    public static int buySellStock(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int profit = 0;

        for(int price : prices) {
            lowest = Math.min(lowest, price);
            profit = Math.max(profit, price - lowest);
        }
        return profit; // We just need one highest txn profit.
    }

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};

        System.out.println("From stock txn: " + Arrays.toString(prices1) + "\nHighest profit is " + buySellStock(prices1));
        System.out.println("From stock txn: " + Arrays.toString(prices2) + "\nHighest profit is " + buySellStock(prices2));
    }
}
