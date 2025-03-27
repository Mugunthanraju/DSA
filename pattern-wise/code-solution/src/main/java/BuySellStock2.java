import java.util.Arrays;

public class BuySellStock2 {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            profit += Math.max(prices[i] - prices[i - 1], 0); // Way 1
//             if (prices[i] > prices[i - 1]) // Way 2
//                 profit += (prices[i] - prices[i - 1]);
//            profit += (prices[i] > prices[i - 1]) ? prices[i] - prices[i - 1] : 0; // Way 3
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] profits1 = {1, 2, 3, 4, 5};
        int[] profits2 = {7, 1, 5, 3, 6, 4};
        int[] profits3 = {7, 6, 4, 3, 1};

        System.out.println("Max profits for " + Arrays.toString(profits1) + " is " + maxProfit(profits1));
        System.out.println("Max profits for " + Arrays.toString(profits2) + " is " + maxProfit(profits2));
        System.out.println("Max profits for " + Arrays.toString(profits3) + " is " + maxProfit(profits3));
    }
}
