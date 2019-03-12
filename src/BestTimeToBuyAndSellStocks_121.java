public class BestTimeToBuyAndSellStocks_121 {
    public int maxProfit(int[] prices) {
        //每次都后一个数减前一个数，就转化成了子数组最大和问题
        int max_ending_here = 0;
        int max_so_far = 0;
        for (int i = 1;i < prices.length;i++) {
            max_ending_here += prices[i] - prices[i - 1];
            max_ending_here = Math.max(max_ending_here, 0);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }

        return max_so_far;
    }
}
