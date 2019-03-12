public class BestTimeToBuyAndSellStock2_122 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1;i < prices.length;i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0)
                max += temp;
        }

        return max;
    }
}
