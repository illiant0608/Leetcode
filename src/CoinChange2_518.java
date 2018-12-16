public class CoinChange2_518 {
    public int change(int amount, int[] coins) {
//        int[][] dp = new int[coins.length+1][amount+1];
//        dp[0][0] = 1;
//
//        for (int i = 1;i <= coins.length;i++) {
//            dp[i][0] = 1; //用前i种硬币凑0块钱
//            for (int j = 1;j <= amount;j++) {
//                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0); //用前i-1种硬币凑出j + 用前i种硬币凑出j-i的面额
//            }
//        }
//
//        return dp[coins.length][amount];

        //简化后
        // dp[i] = dp[i - coins[0]] + dp[i - coins[1]] + ... + dp[i - coins[coins.length - 1]] if i - coins[0] >= 0
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int j = 0;j < coins.length;j++) {
            for (int i = 1;i <= amount;i++) {
                if (i - coins[j] >= 0)
                    dp[i] += dp[i - coins[j]];
            }
        }

        return dp[amount];
    }
}
