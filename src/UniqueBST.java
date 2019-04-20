/**
 * leetcode 96
 * G(n) = F(1, n) + ... + F(n,n)  G(n)代表有几种n元素BST
 * F(i, n) = G(i-1) * G(n-i) F(n)代表以i为root的n元素BST有几种，为左子树情况数 * 右子树情况数
 */

public class UniqueBST {
    public int numTrees(int n) {
        int [] dp = new int[n+1]; // G(n)
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i <= n;i++) {
            for (int j = 1;j <= i;j++)
                dp[i] += dp[j-1] * dp[i-j];
        }

        return dp[n];
    }
}
