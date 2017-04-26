package algorithms.leetcode;

/**
 * Created by wa on 2017/4/20.
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] input = {1, 6, 3, 9};
        System.out.println(maxProfit(input));
    }
}
