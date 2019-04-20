import java.util.Scanner;

public class coin {

        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            int amount = in.nextInt();
//            int n = in.nextInt();
//            int[] coins = new int[n];
//            for (int i = 0;i < n;i++) {
//                coins[i] = in.nextInt();
//            }
//            boolean flag = false;
//
//            int min = -1;
//            for (int i = 1;i <= amount;i++) {
//                int least = leastCoin(coins, i);
//                if (least == -1) {
//                    System.out.println("-1");
//                    flag = true;
//                    break;
//                }
//                min = Math.max(min, least);
//            }
//
//            if (!flag) System.out.println(min);
            int[] coins = {1, 2, 5, 10};
            System.out.println(leastCoin(coins, 49));

        }

        static int leastCoin(int[] coins, int amount) {
            if(amount<1) return 0;
            int[] dp = new int[amount+1];
            int sum = 0;

            while(++sum<=amount) {
                int min = -1;
                for(int coin : coins) {
                    if(sum >= coin && dp[sum-coin]!=-1) {
                        int temp = dp[sum-coin]+1;
                        min = min<0 ? temp : (temp < min ? temp : min);
                    }
                }
                dp[sum] = min;
            }
            return dp[amount];
        }

}
