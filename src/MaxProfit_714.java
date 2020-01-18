public class MaxProfit_714 {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0]; // cash 表示不持有
        for (int i = 0; i < prices.length;i++) {
            cash = Math.max(cash, hold + prices[i] - fee); // 在这个点卖出的收益
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
