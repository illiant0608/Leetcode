public class MinDistance_583 {
    // lcs 最长公共子序列
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0;i <= word1.length();i++) {
            for (int j = 0;j <= word2.length();j++) {
                if (i == 0 || j == 0)
                    continue;
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        MinDistance_583 test = new MinDistance_583();
        System.out.println(test.minDistance("aaabaa", "aaaaaa"));
    }
}
