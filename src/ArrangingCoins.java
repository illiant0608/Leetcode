/**
 * public class Solution {
 *     public int arrangeCoins(int n) {
 *         int i=0;
 *         while(n > 0){
 *             i+=1;
 *             n-=i;
 *         }
 *
 *         return n==0 ? i : i-1;
 *
 *     }
 * }
 */

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n == 1)
            return 1;
        int max = n;
        for (int i = 1;i <= 2147483647;i++) {
            n -= i;
            if (n < 0)
                return i - 1;
            else if (n == 0)
                return i;

        }

        return 0;
    }

    public static void main(String[] args) {
        ArrangingCoins test = new ArrangingCoins();
        test.arrangeCoins(2147483647);
    }
}
