public class BestTimeToBuyAndSellStock3_123 {
    //最多买卖两次
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price); //购买的花费(负的) + 此时的价格 = 利润1
            buy2 = Math.max(buy2, sell1 - price); // sell1代表此时赚到的利润
            sell2 = Math.max(sell2, buy2 + price); // 此时的利润 + 现在的价格 = 总利润
        }

        return sell2;
    }
}
